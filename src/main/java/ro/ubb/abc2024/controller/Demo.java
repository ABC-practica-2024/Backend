package ro.ubb.abc2024.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${api.endpoint.base-url}/demo")
@SecurityRequirement(name = "bearerAuth")
public class Demo {

    @GetMapping("/guest")
    @PreAuthorize("hasAuthority('SCOPE_GUEST')")
    public String hello() {
        return "Hello Guest!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String helloAdmin(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("Hello %s. You have admin rights.", username);
    }

    @GetMapping("/arheo")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ARH_PRIME')")
    public String helloArheo(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("Hello %s. You have archeology rights.", username);
    }

    @GetMapping("/bio")
    @PreAuthorize("hasAnyAuthority('SCOPE_BIO', 'SCOPE_BIO_PRIME')")
    public String helloBio(){
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("Hello %s. You have biology rights.", username);
    }

}
