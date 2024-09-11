package ro.ubb.abc2024.chatroom.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.chatroom.service.ChatRoomService;
import ro.ubb.abc2024.chatroom.utils.converter.ChatBiologistDTOConvertor;
import ro.ubb.abc2024.chatroom.utils.dto.CreateChatRoomBioRequestDTO;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/chatroom")
@SecurityRequirement(name = "bearerAuth")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ChatBiologistDTOConvertor convertor;

    @PostMapping("/bioRequest")
    @PreAuthorize("hasAuthority('SCOPE_BIO')")
    public Result<?> requestCreateBioChatRoom(@RequestBody CreateChatRoomBioRequestDTO requestDTO) {
        var chatRoom = chatRoomService.addChatroomArhPrimeAndBio(convertor.createFromDto(requestDTO));
        return new Result<>(true, HttpStatus.CREATED.value(), "Created chatroom", null);
    }

}
