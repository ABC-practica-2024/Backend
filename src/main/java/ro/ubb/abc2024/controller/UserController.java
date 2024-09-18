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
            summary = "Get user endpoint",
            description = "Retrieves details about the current user, based on the JWT token."
    )
    @GetMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER', 'SCOPE_GUEST')")
    public Result<UserDto> getUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userDtoConverter.createFromEntity(this.userService.getUser(username));
        return new Result<>(true, HttpStatus.OK.value(), "Details about user served.", user);
    }

    @Operation(
            summary = "Get user by id endpoint",
            description = "Retrieves details about a given user, based on their id."
    )
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER')")
    public Result<UserDto> getUserById(@PathVariable long id) {
        var user = userService.getUser(id);
        var userDTO = userDtoConverter.createFromEntity(user);
        return new Result<>(true, HttpStatus.OK.value(), "Details about user served.", userDTO);
    }

    @Operation(
            summary = "Get profile picture endpoint; returns an image",
            description = "Retrieves the profile picture of the current user, based on the JWT token; returns the image itself."
    )
    @GetMapping("/profile_picture")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER', 'SCOPE_GUEST')")
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

    @Operation(
            summary = "Modify user endpoint; returns the user",
            description = "Updates a given user's fields (first/last name and email) based on the username; returns the updated user."
    )
    @PutMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER', 'SCOPE_GUEST')")
    public Result<UserDto> modifyUser(@RequestBody UserDto userDto){
        var user = this.userDtoConverter.createFromEntity(this.userService.updateUser(this.userDtoConverter.createFromDto(userDto)));
        return new Result<>(true, HttpStatus.OK.value(), "User updated successfully.", user);
    }

    @Operation(
            summary = "Change user password endpoint; returns message",
            description = "Updates a given user's password based on the username; requires old password for security and new password."
    )
    @PutMapping("/password")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO', 'SCOPE_LABWORKER', 'SCOPE_GUEST')")
    public Result<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        this.userService.changePassword(changePasswordDto);
        return new Result<>(true, HttpStatus.OK.value(), "Password changed.");
    }
}
