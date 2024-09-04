package ro.ubb.abc2024.chatroom.utils.dto;


import java.time.LocalDateTime;

public record MessageDTO(
        String content,
        LocalDateTime sendTime,
        Long chatRoomId,
        Long senderId,
        Long recipientId
) {
}
