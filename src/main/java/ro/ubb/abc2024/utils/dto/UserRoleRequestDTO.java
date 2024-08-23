package ro.ubb.abc2024.utils.dto;

import java.time.LocalDateTime;

public record UserRoleRequestDTO (
        long requestId,
        String role,
        String status,
        LocalDateTime timeSent,
        LocalDateTime timeResolved,
        long userId
){}
