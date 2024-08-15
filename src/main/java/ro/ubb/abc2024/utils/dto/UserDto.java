package ro.ubb.abc2024.utils.dto;

public record UserDto(
        long id,
        String username,
        String email,
        String firstName,
        String lastName,
        String role
) {
}
