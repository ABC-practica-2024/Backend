package ro.ubb.abc2024.chatroom.utils.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.chatroom.domain.Message;
import ro.ubb.abc2024.chatroom.repository.ChatRoomRepository;
import ro.ubb.abc2024.chatroom.utils.dto.MessageDTO;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;

@Component
@RequiredArgsConstructor
public class MessageDTOConverter implements Converter<Message, MessageDTO> {

    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public Message createFromDto(MessageDTO dto) {
        return Message.builder()
                .content(dto.content())
                .seenByRecipient(false)
                .sendTime(dto.sendTime())
                .chatroom(chatRoomRepository.getReferenceById(dto.chatRoomId()))
                .sender(userRepository.getReferenceById(dto.senderId()))
                .recipient(userRepository.getReferenceById(dto.recipientId()))
                .build();
    }

    @Override
    public MessageDTO createFromEntity(Message entity) {
        return null;
    }
}
