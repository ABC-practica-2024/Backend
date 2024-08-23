package ro.ubb.abc2024.utils.dto;

import java.time.LocalDateTime;

public record CreateUserRoleRequestDTO (
    String role,
    LocalDateTime timeSent,
    long userId
){}
