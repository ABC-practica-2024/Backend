package ro.ubb.abc2024.chatroom.service;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.exception.ArtifactServiceException;
import ro.ubb.abc2024.chatroom.domain.ChatRoom;
import ro.ubb.abc2024.chatroom.domain.ChatType;
import ro.ubb.abc2024.chatroom.repository.ChatRoomRepository;
import ro.ubb.abc2024.chatroom.utils.exceptions.ChatRoomServiceException;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.validation.GenericValidator;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    // TODO: get chatroom by id
    // TODO: send message
    // todo: get all unread messages
    // todo: get all messages (ordered by timestamp and filtered by chat type)
    // todo: update bio chatroom

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
    private final GenericValidator<ChatRoom> genericValidator;

    public ChatRoom addChatroomArhPrimeAndArh(ChatRoom chatRoom) {
        // TODO: check ??
        if(chatRoom.getOtherParty().getRole() == Role.ARH_PRIME)
            return null;
        try {
            // ???
            chatRoom.setMainArchaeologist(userRepository.findAllByRole(Role.ARH_PRIME.toString()).get(0));
            chatRoom.setChatType(ChatType.ARCHAE);
            genericValidator.validate(chatRoom);
            return chatRoomRepository.save(chatRoom);
        } catch (ConstraintViolationException ex) {
            throw new ChatRoomServiceException(ex.getMessage());
        }
    }

    public ChatRoom addChatroomArhPrimeAndBio(ChatRoom chatRoom) {
        try {
            genericValidator.validate(chatRoom);
            return chatRoomRepository.save(chatRoom);
        } catch (ConstraintViolationException ex) {
            throw new ChatRoomServiceException(ex.getMessage());
        }
    }

    public ChatRoom updateChatroomBio() {
        return null;
    }
}
