package ro.ubb.abc2024.arheo.controller.utils;

import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import ro.ubb.abc2024.arheo.service.ArtifactService;
import ro.ubb.abc2024.arheo.service.SectionService;
import ro.ubb.abc2024.arheo.service.SiteService;
import ro.ubb.abc2024.user.UserService;
import ro.ubb.abc2024.utils.converter.Converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperMethods {

    public static <E, D> Map<String, Object> makeResponse(Page<E> page, Converter<E, D> converter) {
        List<E> objects = page.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("items", objects.stream()
                .map(converter::createFromEntity)
                .toList());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());

        return response;
    }

    public static Long getCurrentUserId(UserService userService) {
        var currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUser(currentUser).getId();
    }

    public static Long getMainArchaeologistIdByArtifactId(ArtifactService artifactService, Long artifactId) {
        return artifactService.getMainArchaeologistIdFromArtifactId(artifactId);
    }

    public static Long getMainArchaeologistIdBySectionId(ArtifactService artifactService, Long sectionId) {
        return artifactService.getMainArchaeologistIdFromSectionId(sectionId);
    }

    public static List<Long> getAssignedArchaeologists(ArtifactService artifactService, Long sectionId) {
        return artifactService.getAssignedArchaeologistIdsBySectionId(sectionId);
    }

    public static boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("SCOPE_ADMIN"));
    }

    public static boolean isMainArchaeologistBySectionId(UserService userService, SectionService sectionService, Long sectionId) {
        // is current user the main archaeologist of the section?
        return sectionService.getMainArchaeologistIdFromSectionId(sectionId).equals(getCurrentUserId(userService));
    }

    public static boolean isMainArchaeologistBySiteId(UserService userService, SiteService siteService, Long siteId) {
        // compare the main archaeologist of the site with the current user
        return siteService.getSite(siteId).getMainArchaeologist().getId().equals(getCurrentUserId(userService));
    }
    
}
