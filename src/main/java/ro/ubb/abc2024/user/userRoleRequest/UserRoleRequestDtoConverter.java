package ro.ubb.abc2024.user.userRoleRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.dto.CreateUserRoleRequestDTO;
import ro.ubb.abc2024.utils.dto.UserRoleRequestDTO;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UserRoleRequestDtoConverter {
    private final UserService userService;

    public UserRoleRequest createFromDto(CreateUserRoleRequestDTO dto) {
        return UserRoleRequest.builder()
                .role(Role.valueOf(dto.role()))
                .requestStatus(RequestStatus.PENDING)
                .timeSent(dto.timeSent())
                .user(userService.getUser(dto.userId()))
                .build();
    }

    public UserRoleRequestDTO createFromEntity(UserRoleRequest entity) {
        return new UserRoleRequestDTO(
                entity.getId(),
                entity.getRole().name(),
                entity.getRequestStatus().name(),
                entity.getTimeSent(),
                entity.getTimeResolved(),
                entity.getUser().getId(),
                entity.getUser().getUsername(),
                entity.getUser().getEmail(),
                entity.getUser().getFirstName() + " " + entity.getUser().getLastName()
        );
    }

    public List<UserRoleRequestDTO> createFromEntities(final Collection<UserRoleRequest> userRoleRequests) {
        return userRoleRequests.stream().map(this::createFromEntity).toList();
    }
}
