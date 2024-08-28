package ro.ubb.abc2024;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.service.SiteServiceImpl;
import ro.ubb.abc2024.arheo.utils.converter.GeographicPointConverterDto;
import ro.ubb.abc2024.arheo.utils.converter.SiteConverterDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SiteServiceImplTests {
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
}
