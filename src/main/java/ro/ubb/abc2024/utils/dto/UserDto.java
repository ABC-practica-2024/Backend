package ro.ubb.abc2024.utils.dto;

import ro.ubb.abc2024.user.Role;

public record UserDto(
        long id,
        String username,
        String email,
        String firstName,
        String lastName,
        Role role
) {
}
