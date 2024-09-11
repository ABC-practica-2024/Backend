package ro.ubb.abc2024;

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
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.artifact.ArtifactDimension;
import ro.ubb.abc2024.arheo.domain.artifact.ArtifactPosition;
import ro.ubb.abc2024.arheo.domain.artifact.ArtifactRotation;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.ArtifactRepository;
import ro.ubb.abc2024.arheo.service.ArtifactServiceImpl;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArtifactServiceImplTest {
    @Mock
    private ArtifactRepository artifactRepository;
    @Mock
    private GenericValidator<Artifact> validator;
    @InjectMocks
    private ArtifactServiceImpl artifactService;
    private static Artifact artifact1;
    private static Artifact artifact2;
    private static Site site;
    private static User user;
    private static Section section;

    @BeforeAll
    static void setUp() {
        user = User.builder()
                .id(1L)
                .username("Archaeologist A")
                .email("user1@gmail.com")
                .build();

        site = new Site();
        site.setId(1L);
        site.setTitle("Site A");
        site.setDescription("Description A");
        site.setCenterCoordinates(new GeographicPoint(1.0, 1.0));
        site.setStatus(SiteStatus.DIGGING);
        site.setMainArchaeologist(user);

        section = new Section();
        section.setId(1L);
        section.setName("Section A");
        section.setSouthWest(new GeographicPoint(1.0, 1.0));
        section.setNorthWest(new GeographicPoint(1.0, 2.0));
        section.setNorthEast(new GeographicPoint(2.0, 2.0));
        section.setSouthEast(new GeographicPoint(2.0, 1.0));
        section.setStatus(SectionStatus.DIGGING);
        section.setSite(site);

        artifact1 = Artifact.builder()
                .id(1L)
                .dimension(new ArtifactDimension(1.0, 2.0, 3.0))
                .position(new ArtifactPosition(0.0, 0.0, 0.0))
                .rotation(new ArtifactRotation(0.0, 0.0, 0.0))
                .label("Artifact 1")
                .category("Category A")
                .analysisCompleted(false)
                .thumbnail("thumbnail1.jpg")
                .section(section)
                .archeologist(user)
                .build();

        artifact2 = Artifact.builder()
                .id(2L)
                .dimension(new ArtifactDimension(2.0, 3.0, 4.0))
                .position(new ArtifactPosition(1.0, 1.0, 1.0))
                .rotation(new ArtifactRotation(1.0, 1.0, 1.0))
                .label("Artifact 2")
                .category("Category B")
                .analysisCompleted(false)
                .thumbnail("thumbnail2.jpg")
                .section(section)
                .archeologist(user)
                .build();
    }

    @Test
    void getAllArtifacts_ShouldReturnAllArtifacts() {
        when(artifactRepository.findAll()).thenReturn(Arrays.asList(artifact1, artifact2));

        List<Artifact> artifacts = artifactService.getAllArtifacts();

        assertEquals(2, artifacts.size());
        assertEquals("Artifact 1", artifacts.get(0).getLabel());
        assertEquals("Artifact 2", artifacts.get(1).getLabel());
    }

    @Test
    void getArtifactById_ShouldReturnArtifact_WhenFound() {
        when(artifactRepository.findById(1L)).thenReturn(Optional.of(artifact1));

        Artifact result = artifactService.getArtifactById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Artifact 1", result.getLabel());
    }

    @Test
    void addArtifact_ShouldSetLabScanAndAnalysisCompletedToFalse() {
        artifactService.addArtifact(artifact1);

        assertNull(artifact1.getLabScan());
        assertFalse(artifact1.isAnalysisCompleted());
    }

    @Test
    void deleteArtifact_ShouldInvokeDeleteById() {
        artifactService.deleteArtifact(1L);
    }

    @Test
    void updateArtifact_ShouldUpdateAndReturnArtifact_WhenFound() {
        artifact2.setId(1L);
        when(artifactRepository.findById(1L)).thenReturn(Optional.of(artifact1));
        when(artifactRepository.save(any(Artifact.class))).thenReturn(artifact2);

        Artifact updatedArtifact = artifactService.updateArtifact(artifact2);

        assertEquals("Artifact 2", updatedArtifact.getLabel());
        assertEquals(artifact1.getId(), updatedArtifact.getId());
    }

    @Test
    void getUnanalysedArtifacts_ShouldReturnArtifactsWithNullLabScan() {
        when(artifactRepository.findArtifactsByLabScanIsNull()).thenReturn(Arrays.asList(artifact1, artifact2));

        List<Artifact> artifacts = artifactService.getUnanalysedArtifacts();

        assertEquals(2, artifacts.size());
    }

    @Test
    void getArtifactsByUser_ShouldReturnArtifactsOfUser() {
        User user = artifact1.getArcheologist();

        when(artifactRepository.findArtifactsByArcheologist_Id(user.getId())).thenReturn(Arrays.asList(artifact1, artifact2));

        List<Artifact> artifacts = artifactService.getArtifactsByArcheologistId(user.getId());

        assertEquals(2, artifacts.size());
        assertEquals(user, artifacts.get(0).getArcheologist());
        assertEquals(user, artifacts.get(1).getArcheologist());
    }

    @Test
    void getArtifactsBySectionId_ShouldReturnArtifactsForSection() {
        Long sectionId = artifact1.getSection().getId();

        when(artifactRepository.findArtifactsBySection_Id(sectionId)).thenReturn(Arrays.asList(artifact1, artifact2));

        List<Artifact> artifacts = artifactService.getArtifactsBySectionId(sectionId);

        assertEquals(2, artifacts.size());
        assertEquals(sectionId, artifacts.get(0).getSection().getId());
        assertEquals(sectionId, artifacts.get(1).getSection().getId());
    }

    @Test
    void getArtifactsBySiteId_ShouldReturnArtifactsForSite() {
        Long siteId = artifact1.getSection().getSite().getId();

        when(artifactRepository.findArtifactsBySection_Site_Id(siteId)).thenReturn(Arrays.asList(artifact1, artifact2));

        List<Artifact> artifacts = artifactService.getArtifactsBySiteId(siteId);

        assertEquals(2, artifacts.size());
        assertEquals(siteId, artifacts.get(0).getSection().getSite().getId());
        assertEquals(siteId, artifacts.get(1).getSection().getSite().getId());
    }

    @Test
    void getArtifactsBySiteIdAndArcheologistId_ShouldReturnArtifactsForSiteAndArcheologist() {
        Long siteId = artifact1.getSection().getSite().getId();
        Long archaeologistId = artifact1.getArcheologist().getId();

        when(artifactRepository.findArtifactsBySection_Site_IdAndArcheologist_Id(siteId, archaeologistId)).thenReturn(Arrays.asList(artifact1, artifact2));

        List<Artifact> artifacts = artifactService.getArtifactsBySiteIdAndArcheologistId(siteId, archaeologistId);

        assertEquals(2, artifacts.size());
    }

    @Test
    void getArtifactsByCategory_ShouldReturnArtifactsForCategory() {
        String category = artifact1.getCategory();

        when(artifactRepository.findArtifactsByCategory(category)).thenReturn(Collections.singletonList(artifact1));

        List<Artifact> artifacts = artifactService.getArtifactsByCategory(category);

        assertEquals(1, artifacts.size());
    }

    @Test
    void artifactService_GetMainArchaeologistIdFromArtifactId_ReturnsTrue() {
        // stub
        when(artifactRepository.findMainArcheologistIdByArtifactId(1L)).thenReturn(user.getId());

        // Act
        var result = artifactService.getMainArchaeologistIdFromArtifactId(1L);

        // Assert
        assertEquals(result, user.getId());
    }

    @Test
    void artifactService_GetAssignedArchaeologistIdsBySectionId_ReturnsTrue() {
        // stub
        when(artifactRepository.findAssignedArchaeologistIdsBySectionId(1L)).thenReturn(List.of(user));

        // Act
        var result = artifactService.getAssignedArchaeologistIdsBySectionId(1L);

        // Assert
        assertEquals(result, List.of(user.getId()));
    }

    @Test
    void artifactService_GetMainArchaeologistIdFromSectionId_ReturnsTrue() {
        // stub
        when(artifactRepository.findMainArcheologistIdBySectionId(1L)).thenReturn(user.getId());

        // Act
        var result = artifactService.getMainArchaeologistIdFromSectionId(1L);

        // Assert
        assertEquals(result, user.getId());
    }

    @Test
    void artifactService_GetAllPaginatedByCriteria_ReturnsTrue() {
        // stub
        Pageable paging = PageRequest.of(0, 10);
        when(artifactRepository.findAll((Specification<Artifact>) ArgumentMatchers.any(), eq(paging))).thenReturn(new
                PageImpl<>(List.of(artifact1)));

        // Act
        var result = artifactService.getAllPaginatedByCriteria(1L, 1L, 1L, "Artifact 1", "Category 1", false, paging);

        // Assert
        assertEquals(result, new PageImpl<>(List.of(artifact1)));
    }
}

