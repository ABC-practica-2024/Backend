package ro.ubb.abc2024.chatroom.utils.dto;

public record UpdateChatRoomBioRequestDTO(
        Long chatRoomId,
        Long newBiologistId
) {
}
