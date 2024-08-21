package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.converter.UserDtoConverter;
import ro.ubb.abc2024.utils.dto.ChangePasswordDto;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.dto.UserDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;
    private final UserDtoConverter userDtoConverter;

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO')")
    public Result<UserDto> getUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userDtoConverter.createFromEntity(this.userService.getUser(username));
        return new Result<>(true, HttpStatus.OK.value(), "Details about user served.", user);
    }

    @PutMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO')")
    public Result<UserDto> modifyUser(@RequestBody UserDto userDto){
        var user = this.userDtoConverter.createFromEntity(this.userService.updateUser(this.userDtoConverter.createFromDto(userDto)));
        return new Result<>(true, HttpStatus.OK.value(), "User updated successfully.", user);
    }

    @PutMapping("/password")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO')")
    public Result<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        this.userService.changePassword(changePasswordDto);
        return new Result<>(true, HttpStatus.OK.value(), "Password changed.");
    }
}
