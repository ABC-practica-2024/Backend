package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.converter.UserDtoConverter;
import ro.ubb.abc2024.utils.dto.ChangePasswordDto;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.dto.UserDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "User Management")
public class UserController {
    private final UserService userService;
    private final UserDtoConverter userDtoConverter;

    @Operation(
            description = "Get user endpoint",
            summary = "Retrieves details about the current user, based on the JWT token."
    )
    @GetMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO', 'SCOPE_GUEST')")
    public Result<UserDto> getUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userDtoConverter.createFromEntity(this.userService.getUser(username));
        return new Result<>(true, HttpStatus.OK.value(), "Details about user served.", user);
    }

    @Operation(
            description = "Get profile picture endpoint; returns an image",
            summary = "Retrieves the profile picture of the current user, based on the JWT token; returns the image itself."
    )
    @GetMapping("/profile_picture")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO', 'SCOPE_GUEST')")
    public ResponseEntity<?> getUserProfilePicture() throws IOException {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = this.userService.getUser(username);

        if(user.getImagePath() == null)
            return ResponseEntity.noContent().build();

        Path imagePath = Paths.get(user.getImagePath());
        Resource resource = new FileSystemResource(imagePath.toFile());
        String contentType = Files.probeContentType(imagePath);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                        .body(resource);
    }

    @PutMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO', 'SCOPE_GUEST')")
    public Result<UserDto> modifyUser(@RequestBody UserDto userDto){
        var user = this.userDtoConverter.createFromEntity(this.userService.updateUser(this.userDtoConverter.createFromDto(userDto)));
        return new Result<>(true, HttpStatus.OK.value(), "User updated successfully.", user);
    }

    @PutMapping("/password")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARH_PRIME', 'SCOPE_ARH', 'SCOPE_BIO_PRIME', 'SCOPE_BIO', 'SCOPE_GUEST')")
    public Result<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        this.userService.changePassword(changePasswordDto);
        return new Result<>(true, HttpStatus.OK.value(), "Password changed.");
    }
}
