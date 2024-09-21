package ro.ubb.abc2024.arheo.controller.site;
import jakarta.persistence.EntityNotFoundException;
import ro.ubb.abc2024.arheo.utils.dto.ArheologicalSiteRequestDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.utils.converter.ArheologicalSiteRequestDtoConverter;
import ro.ubb.abc2024.arheo.domain.site.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.service.SiteService;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/request_site")
@SecurityRequirement(name = "bearerAuth")
public class SiteRequestController {

    private final SiteService siteService;
    private final ArheologicalSiteRequestDtoConverter converter;
    //TODO: implement the functions here and in service
    @PostMapping("/request")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_ARHEO')")
    public Result<?> requestCreateArchaeologicalSite(@RequestBody ArheologicalSiteRequestDto requestDto)  {

        CreateArchaeologicalSiteRequest siteRequest = converter.createFromDto(requestDto);
        CreateArchaeologicalSiteRequest savedRequest = siteService.requestCreateArchaeologicalSite(siteRequest);
        return new Result<>(true, HttpStatus.CREATED.value(),
                String.format("Archaeological site request created with ID %d", savedRequest.getId()), converter.createFromEntity(savedRequest));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> getListCreateSiteRequests() {
        List<ArheologicalSiteRequestDto> siteRequests = siteService.getAllSiteRequests().stream().map(converter::createFromEntity).toList();
        return new Result<>(true, HttpStatus.OK.value(), "List of all site creation requests", siteRequests);
    }

    @GetMapping("/pending")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> getListCreateSiteRequestsPending() {
        List<ArheologicalSiteRequestDto> pendingRequests = siteService.getPendingSiteRequests().stream().map(converter::createFromEntity).toList();
        return new Result<>(true, HttpStatus.OK.value(), "List of pending site creation requests", pendingRequests);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<ArheologicalSiteRequestDto> getCreateSiteRequestById(@PathVariable long id) {
        var createArchaeologicalSiteRequest = converter.createFromEntity(this.siteService.getCreateArchaeologicalSiteRequest(id));
        return new Result<>(true, HttpStatus.OK.value(),String.format("Here is the create archaeological site request with id %d", id),createArchaeologicalSiteRequest);
    }

    @PostMapping("/solve/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> solveCreateSiteRequest(@PathVariable long id, @RequestBody Map<String, String> status) {
        try {
            CreateArchaeologicalSiteRequest solvedRequest = siteService.solveCreateSiteRequest(id, RequestStatus.valueOf(status.get("status")));
            return new Result<>(true, HttpStatus.OK.value(),
                    String.format("Create Archaeological Site Request with ID %d has been solved and site created.", id), converter.createFromEntity(solvedRequest));
        } catch (EntityNotFoundException ex) {
            return new Result<>(false, HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        } catch (IllegalStateException ex) {
            return new Result<>(false, HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        } catch (Exception ex) {
            return new Result<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred.", null);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> deleteCreateSiteRequest(@PathVariable long id){
        this.siteService.deleteCreateArchaeologicalSiteRequest(id);
        return new Result<>(true, HttpStatus.OK.value(), String.format("Request with id %d was deleted", id), "");
    }



}