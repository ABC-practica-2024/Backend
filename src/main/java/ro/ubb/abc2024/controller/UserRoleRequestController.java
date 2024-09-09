package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;
import ro.ubb.abc2024.user.userRoleRequest.UserRoleRequestDtoConverter;
import ro.ubb.abc2024.user.userRoleRequest.UserRoleRequestService;
import ro.ubb.abc2024.utils.dto.CreateUserRoleRequestDTO;
import ro.ubb.abc2024.utils.dto.Result;
import ro.ubb.abc2024.utils.dto.SolveRoleRequestDTO;
import ro.ubb.abc2024.utils.dto.UserRoleRequestDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.endpoint.base-url}/request_role")
@SecurityRequirement(name = "bearerAuth")
public class UserRoleRequestController {

    private final UserRoleRequestService userRoleRequestService;
    private final UserRoleRequestDtoConverter userRoleRequestDtoConverter;

    @PostMapping()
    @PreAuthorize("hasAuthority('SCOPE_GUEST')")
    public Result<?> addUserRoleRequest(@RequestBody CreateUserRoleRequestDTO userRoleRequestDTO) {
        var userRoleRequest = userRoleRequestDtoConverter.createFromDto(userRoleRequestDTO);
        userRoleRequestService.addUserRoleRequest(userRoleRequest);
        return new Result<>(true, HttpStatus.OK.value(), "Role request added successfully", "");
    }

    @GetMapping("/get_all")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<List<UserRoleRequestDTO>> getUserRoleRequests() {
        var userRoleRequests = userRoleRequestDtoConverter.createFromEntities(userRoleRequestService.getUserRoleRequests());
        return new Result<>(true, HttpStatus.OK.value(), "Here is a list with all the requests", userRoleRequests);
    }

    @GetMapping("/get_pending")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<List<UserRoleRequestDTO>> getPendingUserRoleRequests() {
        var pendingUserRoleRequests = userRoleRequestDtoConverter.createFromEntities(userRoleRequestService.getPendingUserRoleRequests());
        return new Result<>(true, HttpStatus.OK.value(), "Here is a list with all the pending requests", pendingUserRoleRequests);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<UserRoleRequestDTO> getUserRoleRequestById(@PathVariable("id") Long id) {
        var userRoleRequest = userRoleRequestDtoConverter.createFromEntity(userRoleRequestService.getUserRoleRequest(id));
        return new Result<>(true, HttpStatus.OK.value(), String.format("Here is the request with id: %d", id), userRoleRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> deleteUserRoleRequest(@PathVariable("id") Long id) {
        userRoleRequestService.deleteUserRoleRequest(id);
        return new Result<>(true, HttpStatus.OK.value(), "Role request deleted successfully", "");
    }

    @PutMapping("/resolve")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> resolveUserRoleRequest(@RequestBody SolveRoleRequestDTO roleRequestDTO) {
        userRoleRequestService.resolvePendingUserRoleRequest(roleRequestDTO.id(), RequestStatus.valueOf(roleRequestDTO.status()));
        return new Result<>(true, HttpStatus.OK.value(), "Role request resolved successfully (" + roleRequestDTO.status() + ")", "");
    }
}
