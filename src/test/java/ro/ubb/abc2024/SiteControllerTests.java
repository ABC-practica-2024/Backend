package ro.ubb.abc2024;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ro.ubb.abc2024.arheo.controller.site.SiteController;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.service.SiteServiceImpl;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(SiteController.class)
public class SiteControllerTests {
    @Mock
    private static SiteRepository siteRepository;
    @MockBean
    private static SiteServiceImpl siteService;
    @Autowired
    private MockMvc mockMvc;
    private static final Site completedSite = new Site();
    private static final Site analysisSite = new Site();
    private static final Site diggingSite = new Site();
    private static final Section firstSection = new Section();

    @BeforeAll
    public static void setUp() {
        // Arrange section
        firstSection.setId(1L);
        firstSection.setName("First section name");
        firstSection.setNorthEast(new GeographicPoint());
        firstSection.setNorthWest(new GeographicPoint());
        firstSection.setSouthWest(new GeographicPoint());
        firstSection.setSouthEast(new GeographicPoint());

        // Arrange sites
        completedSite.setId(1L);
        completedSite.setTitle("Completed Site");

        analysisSite.setId(2L);
        analysisSite.setTitle("Analysis Site");

        diggingSite.setId(3L);
        diggingSite.setTitle("Digging Site");

        // stubs
        when(siteRepository.getSitesWithSectionsAndArchaeologists()).thenReturn(List.of(completedSite, analysisSite, diggingSite));
        when(siteService.getAll()).thenReturn(List.of(completedSite, analysisSite, diggingSite));
        when(siteService.getSite(1L)).thenReturn(completedSite);
        when(siteService.getAllByStatus(SiteStatus.DIGGING)).thenReturn(List.of(diggingSite));
        when(siteService.getAllByStatus(SiteStatus.COMPLETED)).thenReturn(List.of(completedSite));
        when(siteService.getAllByStatus(SiteStatus.ANALYSIS)).thenReturn(List.of(analysisSite));
        when(siteService.getSectionsBySiteId(1L)).thenReturn(List.of(firstSection));
    }

    @Test
    public void SiteController_GetAllSites_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_GetSiteById_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_CreateSite_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_UpdateSite_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_DeleteSite_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_GetDiggingSites_ReturnsTrue() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/digging")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void SiteController_GetAnalysisSites_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_GetCompletedSites_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_GetIncompleteSites_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_GetSectionsById_ReturnsTrue() throws Exception {
    }

    @Test
    public void SiteController_GetIncompleteSectionsBySiteId_ReturnsTrue() throws Exception {
    }

}