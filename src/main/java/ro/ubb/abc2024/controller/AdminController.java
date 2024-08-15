package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.converter.UserAdminDtoConverter;
import ro.ubb.abc2024.utils.converter.UserDtoConverter;
import ro.ubb.abc2024.utils.dto.ChangeRoleDto;
import ro.ubb.abc2024.utils.dto.EnableUserDto;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.dto.UserAdminDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/admin")
@SecurityRequirement(name = "bearerAuth")
public class AdminController {
    private final UserService userService;
    private final UserAdminDtoConverter userAdminDtoConverter;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<List<UserAdminDto>> getAllUsers() {
        var users = this.userAdminDtoConverter.createFromEntities(this.userService.getUsers());
        return new Result<>(true, HttpStatus.OK.value(), "Here is a list of all the users.", users);
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<UserAdminDto> getUser(@PathVariable long id) {
        var user = this.userAdminDtoConverter.createFromEntity(this.userService.getUser(id));
        return new Result<>(true, HttpStatus.OK.value(), String.format("Here is the user with id: %d", id), user);
    }

    @PutMapping("/users/role")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> changeRole(@RequestBody ChangeRoleDto changeRoleDto) {
        this.userService.changeRole(changeRoleDto);
        return new Result<>(true, HttpStatus.OK.value(), String.format("Role for the user %s changed.", changeRoleDto.username()));
    }

    @PutMapping("/users/enable")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> enableUser(@RequestBody EnableUserDto enableUserDto) {
        this.userService.enableUser(enableUserDto);
        return new Result<>(true, HttpStatus.OK.value(), String.format("User %s enabled/disabled.", enableUserDto.username()));
    }
}
