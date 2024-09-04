package ro.ubb.abc2024.chatroom.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateChatRoomBioRequestDTO {
    private Long biologistId;
    private Long artifactId;
}
