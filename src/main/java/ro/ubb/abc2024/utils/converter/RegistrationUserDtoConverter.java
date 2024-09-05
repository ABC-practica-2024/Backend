package ro.ubb.abc2024.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.utils.dto.RegistrationUserDto;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.User;


import java.util.UUID;

@Component
public class RegistrationUserDtoConverter implements Converter<User, RegistrationUserDto> {

    @Override
    public User createFromDto(RegistrationUserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .role(dto.getRole())
                .uniqueKey(UUID.randomUUID())
                .build();

    }

    @Override
    public RegistrationUserDto createFromEntity(User entity) {
        return null;
    }
}
