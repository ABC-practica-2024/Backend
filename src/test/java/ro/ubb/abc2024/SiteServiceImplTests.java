package ro.ubb.abc2024;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.repository.SiteRequestRepository;
import ro.ubb.abc2024.arheo.service.SiteServiceImpl;
import ro.ubb.abc2024.arheo.utils.converter.GeographicPointConverterDto;
import ro.ubb.abc2024.arheo.utils.converter.SiteConverterDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SiteServiceImplTests {
    @Mock
    private SiteRequestRepository siteRequestRepository;
    @Mock
    private SiteRepository siteRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private SiteServiceImpl siteService;
    private final SiteConverterDto converter = new SiteConverterDto(new GeographicPointConverterDto(), userRepository);
    private static Section completedSection;
    private static Section diggingSection;
    private static Site completedSite;
    private static User user;
    private static CreateArchaeologicalSiteRequest pendingRequest;
    private static CreateArchaeologicalSiteRequest acceptedRequest;

    @BeforeAll
    static void setUp() {
        // Arrange
        // creating the main archaeologist
        user = User.builder()
                .id(1L)
                .username("Main Archaeologist")
                .email("user1@gmail.com")
                .build();

        // creating the sections belonging to this site
        completedSection = new Section();
        completedSection.setId(1L);
        completedSection.setName("Section 1");
        completedSection.setStatus(SectionStatus.COMPLETED);

        diggingSection = new Section();
        diggingSection.setId(2L);
        diggingSection.setName("Section 2");
        diggingSection.setStatus(SectionStatus.DIGGING);

        // creating the site itself, status is completed
        completedSite = Site.builder()
                .id(1L)
                .title("Site Title")
                .centerCoordinates(new GeographicPoint(1D, 1D))
                .mainArchaeologist(user)
                .status(SiteStatus.COMPLETED)
                .sections(List.of(completedSection, diggingSection))
                .build();

        // creating an archaeological site request
        pendingRequest = CreateArchaeologicalSiteRequest.builder()
                .id(1L)
                .archeologist(user)
                .status(RequestStatus.PENDING)
                .build();


        acceptedRequest = CreateArchaeologicalSiteRequest.builder()
                .id(1L)
                .status(RequestStatus.ACCEPTED)
                .build();

    }

    @Test
    void siteService_getAllSites_ReturnsTrue() {
        // stub
        when(siteRepository.getSitesWithSectionsAndArchaeologists()).thenReturn(List.of(completedSite));

        // Act
        List<Site> resultList = siteService.getAll();

        // Assert
        assertEquals(resultList, List.of(completedSite));
    }

    @Test
    void siteService_getAllByStatusCompleted_ReturnsTrue() {
        // stub
        when(siteRepository.getSitesByStatus(SiteStatus.COMPLETED)).thenReturn(List.of(completedSite));

        // Act
        List<Site> resultList = siteService.getAllByStatus(SiteStatus.COMPLETED);

        // Assert
        assertEquals(resultList, List.of(completedSite));
    }

    @Test
    void siteService_getSiteByTitle_ReturnsTrue() {
        // stub
        when(siteRepository.getSiteByTitle("Site Title")).thenReturn(completedSite);

        // Act
        Site result = siteService.getSiteByTitle("Site Title");

        // Assert
        assertEquals(result, completedSite);
    }

    @Test
    void siteService_AddSite_ReturnsTrue() {
        // stub
        when(siteRepository.save(completedSite)).thenReturn(completedSite);

        // Act
        Site addedSite = siteService.addSite(completedSite);

        // Assert
        assertEquals(addedSite, completedSite);
    }

    @Test
    void siteService_DeleteSite_ReturnsTrue() {
        // Act
        siteService.addSite(completedSite);
        siteService.deleteSite(completedSite.getId());

        // Assert
        assertEquals(0, siteService.getAll().size());
    }

    @Test
    void siteService_GetSiteById_ReturnsTrue() {
        // stub
        when(siteRepository.getSiteById(1L)).thenReturn(completedSite);

        // Act
        Site result = siteService.getSite(1L);

        // Assert
        assertEquals(result, completedSite);
    }

    @Test
    void siteService_UpdateSite_ReturnsTrue() {
        // Arrange
        Site newSite = Site.builder()
                .id(10L)
                .title("New Site Title")
                .centerCoordinates(new GeographicPoint(1D, 1D))
                .mainArchaeologist(user)
                .status(SiteStatus.COMPLETED)
                .sections(List.of(completedSection, diggingSection))
                .archaeologists(List.of())
                .build();


        // stub
        when(siteRepository.findById(1L)).thenReturn(Optional.of(completedSite));
        when(siteRepository.save(ArgumentMatchers.any(Site.class))).thenReturn(newSite);

        // Act
        Site result = siteService.updateSite(1L, converter.createFromEntity(newSite));

        // Assert
        assertEquals(result, newSite);
    }

    @Test
    void siteService_UpdateSite_ThrowsEntityNotFoundException() {
        // Arrange
        Site newSite = Site.builder()
                .id(10L)
                .title("New Site Title")
                .centerCoordinates(new GeographicPoint(1D, 1D))
                .mainArchaeologist(user)
                .status(SiteStatus.COMPLETED)
                .sections(List.of(completedSection, diggingSection))
                .archaeologists(List.of())
                .build();


        // Act
        try {
            siteService.updateSite(2L, converter.createFromEntity(newSite));
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Site with id 2, does not exist.");
        }
    }

    @Test
    void siteService_GetSectionsBySiteId_ReturnsTrue() {
        // stub
        when(siteRepository.getSiteById(1L)).thenReturn(completedSite);

        // Act
        List<Section> sectionsInTheSite = siteService.getSectionsBySiteId(1L);

        // Assert
        assertEquals(sectionsInTheSite, List.of(completedSection, diggingSection));
    }

    @Test
    void siteService_GetAllPaginatedByCriteria_ReturnsTrue() {
        // stub
        Pageable paging = PageRequest.of(0, 10);
        when(siteRepository.findAll((Specification<Site>) ArgumentMatchers.any(), eq(paging))).thenReturn(new
                PageImpl<>(List.of(completedSite)));

        // Act
        var result = siteService.getAllPaginatedByCriteria(SiteStatus.COMPLETED.name(), paging);

        // Assert
        assertEquals(result, new PageImpl<>(List.of(completedSite)));
    }

    @Test
    void siteService_GetCreateArchaeologicalSiteRequest_ReturnsTrue() {
        // stub
        when(siteRequestRepository.findById(1L)).thenReturn(Optional.ofNullable(pendingRequest));

        // Act
        var result = siteService.getCreateArchaeologicalSiteRequest(1L);

        // Assert
        assertEquals(result, pendingRequest);
    }

    @Test
    void siteService_GetCreateArchaeologicalSiteRequest_ThrowsException() {
        try {
            // Act
            siteService.getCreateArchaeologicalSiteRequest(2L);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Create Archaeological Site Request with id 2, not found");
        }
    }

    @Test
    void siteService_DeleteCreateArchaeologicalSiteRequest_ReturnsTrue() {
        // Act
        siteService.deleteCreateArchaeologicalSiteRequest(1L);

        // Assert
        verify(siteRequestRepository, times(1)).deleteById(1L);
    }

    @Test
    void siteService_GetAllSiteRequests_ReturnsTrue() {
        // stub
        when(siteRequestRepository.findAll()).thenReturn(List.of(pendingRequest));

        // Act
        var result = siteService.getAllSiteRequests();

        // Assert
        assertEquals(result, List.of(pendingRequest));
    }

    @Test
    void siteService_GetPendingSiteRequests_ReturnsTrue() {
        // stub
        when(siteRequestRepository.findByStatus(RequestStatus.PENDING)).thenReturn(List.of(pendingRequest));

        // Act
        var result = siteService.getPendingSiteRequests();

        // Assert
        assertEquals(result, List.of(pendingRequest));
    }

    @Test
    void siteService_SolveCreateSiteRequest_ReturnsTrue() {
        // stub
        when(siteRequestRepository.findById(1L)).thenReturn(Optional.ofNullable(pendingRequest));
        when(siteRepository.save(ArgumentMatchers.any())).thenReturn(completedSite);
        when(siteRequestRepository.save(ArgumentMatchers.any())).thenReturn(pendingRequest);

        // Act
        var result = siteService.solveCreateSiteRequest(1L);

        // Assert
        assertEquals(result, pendingRequest);
    }

    @Test
    void siteService_SolveCreateSiteRequest_ThrowsExceptionRequestNotPending() {
        // stub
        when(siteRequestRepository.findById(1L)).thenReturn(Optional.ofNullable(acceptedRequest));

        try {
            // Act
            siteService.solveCreateSiteRequest(1L);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
            assertEquals(e.getMessage(), "Request is not in PENDING and cannot be solved.");
        }
    }

    @Test
    void siteService_SolveCreateSiteRequest_ThrowsExceptionRequestNotFound() {
        try {
            // Act
            siteRequestRepository.findById(2L);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Create Archaeological Site Request with id 2, not found");
        }
    }

    @Test
    void siteService_RequestCreateArchaeologicalSite_ReturnsTrue() {
        // stub
        when(userRepository.findById(pendingRequest.getArcheologist().getId())).thenReturn(Optional.ofNullable(pendingRequest.getArcheologist()));
        when(siteRequestRepository.save(pendingRequest)).thenReturn(pendingRequest);

        // Act
        var result = siteService.requestCreateArchaeologicalSite(pendingRequest);

        // Assert
        assertEquals(result, pendingRequest);
    }

    @Test
    void siteService_RequestCreateArchaeologicalSite_ThrowsExceptionRequestNotFound() {
        try {
            siteService.requestCreateArchaeologicalSite(pendingRequest);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "User with id 1 not found");
        }
    }
}
