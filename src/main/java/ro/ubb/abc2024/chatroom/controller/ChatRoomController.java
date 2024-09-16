package ro.ubb.abc2024.chatroom.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.chatroom.repository.ChatRoomRepository;
import ro.ubb.abc2024.chatroom.repository.MessageRepository;
import ro.ubb.abc2024.chatroom.service.ChatRoomService;
import ro.ubb.abc2024.chatroom.utils.converter.ChatBiologistDTOConvertor;
import ro.ubb.abc2024.chatroom.utils.dto.CreateChatRoomBioRequestDTO;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.chatroom.domain.ChatRoom;
import ro.ubb.abc2024.chatroom.domain.Message;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/chatroom")
@SecurityRequirement(name = "bearerAuth")
public class ChatRoomController {

    @Autowired
    private final ChatRoomService chatRoomService;
    @Autowired
    private final ChatBiologistDTOConvertor convertor;
    @Autowired
    private final ChatRoomRepository chatroomRepository;
    @Autowired
    private final MessageRepository messageRepository;

    @PostMapping("/bioRequest")
    @PreAuthorize("hasAuthority('SCOPE_BIO')")
    public Result<?> requestCreateBioChatRoom(@RequestBody CreateChatRoomBioRequestDTO requestDTO) {
        var chatRoom = chatRoomService.addChatroomArhPrimeAndBio(convertor.createFromDto(requestDTO));
        return new Result<>(true, HttpStatus.CREATED.value(), "Created chatroom", null);
    }

    @MessageMapping("/chat")
    public void sendMessage(Message chatMessage) {

        Optional<ChatRoom> chatroom = chatroomRepository.findChatRoomByMainArchaeologistAndOtherParty(chatMessage.getSender().getId(), chatMessage.getRecipient().getId());

        if (chatroom.isEmpty()) {
            throw new RuntimeException("Chatroom does not exist between sender " + chatMessage.getSender().getId() + " and recipient " + chatMessage.getRecipient().getId());
        }

        chatMessage.setChatroom(chatroom.get());
        chatMessage.setSendTime(LocalDateTime.now());
        chatMessage.setSeenByRecipient(false);

        try {
            messageRepository.save(chatMessage);
        } catch (Exception ex) {
            throw new RuntimeException("Cannot create new message in chatroomId " + chatroom.get().getId());
        }
    }


}
