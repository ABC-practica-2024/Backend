package ro.ubb.abc2024.utils.dto;

public record ChangePasswordDto(
        String oldPassword,
        String newPassword,
        String username
) {
}
