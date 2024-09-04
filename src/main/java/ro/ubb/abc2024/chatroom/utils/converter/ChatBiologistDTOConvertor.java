package ro.ubb.abc2024.chatroom.utils.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.repository.ArtifactRepository;
import ro.ubb.abc2024.chatroom.domain.ChatRoom;
import ro.ubb.abc2024.chatroom.domain.ChatType;
import ro.ubb.abc2024.chatroom.utils.dto.CreateChatRoomBioRequestDTO;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;

@RequiredArgsConstructor
@Component
public class ChatBiologistDTOConvertor implements Converter<ChatRoom, CreateChatRoomBioRequestDTO> {

    private final UserRepository userRepository;
    private final ArtifactRepository artifactRepository;
    @Override
    public ChatRoom createFromDto(CreateChatRoomBioRequestDTO dto) {
        return ChatRoom.builder()
                .chatType(ChatType.BIO)
                .mainArchaeologist(userRepository.findAllByRole(Role.ARH_PRIME.toString()).getFirst())
                .otherParty(userRepository.getReferenceById(dto.getBiologistId()))
                .artifact(artifactRepository.getReferenceById(dto.getArtifactId()))
                .build();
    }

    @Override
    public CreateChatRoomBioRequestDTO createFromEntity(ChatRoom entity) {
        return null;
    }
}
