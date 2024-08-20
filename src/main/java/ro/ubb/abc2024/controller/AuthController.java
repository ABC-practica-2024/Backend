package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.security.auth.AuthenticationService;
import ro.ubb.abc2024.security.recovery.RecoveryService;
import ro.ubb.abc2024.security.registration.RegistrationService;
import ro.ubb.abc2024.utils.converter.RegistrationUserDtoConverter;
import ro.ubb.abc2024.utils.dto.LoginRequest;
import ro.ubb.abc2024.utils.dto.PasswordResetDto;
import ro.ubb.abc2024.utils.dto.RegistrationUserDto;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final RegistrationUserDtoConverter registrationUserDtoConverter;
    private final RegistrationService registrationService;
    private final RecoveryService recoveryService;

    @Operation(
            description = "Login endpoint.",
            summary = "Login endpoint. Generates the JWT needed for further operations."
    )
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginRequest loginRequest) {

        var token = this.authenticationService.authenticate(loginRequest);
        return new Result<>(true, HttpStatus.OK.value(), "Login successful.", token);
    }

    @Operation(
            description = "REGISTER",
            summary = "Registration endpoint. After registering it sends an email with confirmation token."
    )
    @PostMapping("/register")
    public Result<?> register(@RequestBody RegistrationUserDto registrationUserDto) {
        this.registrationService.addUser(this.registrationUserDtoConverter.createFromDto(registrationUserDto));
        return new Result<>(true, HttpStatus.CREATED.value(), "User created successfully");
    }
    @Operation(
            description = "ENABLE USER",
            summary = "To enable the user the token received in the email must be passed to the endpoint."
    )
    @PutMapping("/enable/{token}")
    public Result<?> enableUser(@PathVariable String token) {
        this.registrationService.enableUser(token);
        return new Result<>(true, HttpStatus.OK.value(), "User enabled successfully.");
    }

    @Operation(
            description = "RESET PASSWORD REQUEST",
            summary = "Forgot password. It will send an email with a token/link for password reset."
    )
    @PostMapping("/reset-password")
    public Result<?> resetPasswordRequest(@RequestBody String email) {
        this.recoveryService.recoveryRequest(email);
        return new Result<>(true, HttpStatus.OK.value(), "Email with token sent. Please check your email.");
    }
    @Operation(
            description = "RESET PASSWORD",
            summary = "Token from the email must be passed as a path variable to reset the password. Random password is generated"
    )
    @PostMapping("/reset-password-email/{token}")
    public Result<?> sendPassword(@PathVariable String token) {
        this.recoveryService.resetPassword(token);
        return new Result<>(true, HttpStatus.OK.value(), "Password sent to email.");
    }

    @Operation(
            description = "RESET PASSWORD WITH LINK",
            summary = "Input new password along with the token provided in email."
    )
    @PutMapping("/reset-password")
    public Result<?> resetPassword(@RequestBody PasswordResetDto passwordResetDto) {
        this.recoveryService.resetPassword(passwordResetDto);
        return new Result<>(true, HttpStatus.OK.value(), "Password reset successfully");
    }

}
