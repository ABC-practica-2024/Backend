package ro.ubb.abc2024.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.dto.UserDto;

@Component
public class UserDtoConverter implements Converter<User, UserDto> {
    @Override
    public User createFromDto(UserDto dto) {
        return User.builder()
                .id(dto.id())
                .username(dto.username())
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .role(dto.role())
                .build();
    }

    @Override
    public UserDto createFromEntity(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getRole());
    }
}
