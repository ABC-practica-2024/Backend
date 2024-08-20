package ro.ubb.abc2024.security.recovery;

import ro.ubb.abc2024.utils.dto.PasswordResetDto;

public interface RecoveryService {
    void recoveryRequest(String email);
    void resetPassword(String token);
    void resetPassword(PasswordResetDto passwordResetDto);

}
