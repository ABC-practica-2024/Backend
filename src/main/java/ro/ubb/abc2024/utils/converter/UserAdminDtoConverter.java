package ro.ubb.abc2024.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.dto.UserAdminDto;

@Component
public class UserAdminDtoConverter implements Converter<User, UserAdminDto> {
    @Override
    public User createFromDto(UserAdminDto dto) {
        return User.builder()
                .id(dto.id())
                .username(dto.username())
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .isEnabled(dto.isEnabled())
                .role(dto.role())
                .build();
    }

    @Override
    public UserAdminDto createFromEntity(User entity) {
        return new UserAdminDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getRole(),
                entity.isEnabled());
    }
}
