package ro.ubb.abc2024.arheo.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.service.SiteService;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/request_site")
@SecurityRequirement(name = "bearerAuth")
public class SiteController {

    private final SiteService siteService;
    //TODO: implement the functions here and in service
    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ARH')")
    public Result<?> requestCreateArcheologicalSite(@PathVariable long id) {
        return null;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> getListCreateSiteRequests() {
        return null;
    }

    @GetMapping("/pending")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> getListCreateSiteRequestsPending() {
        return null;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Result<?> getCreateSiteRequestById(@PathVariable long id) {
        return null;
    }

    //TODO: the rest.....

}
