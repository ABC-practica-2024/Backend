package ro.ubb.abc2024;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.repository.SectionRepository;
import ro.ubb.abc2024.arheo.service.SectionServiceImpl;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectionServiceImplTests {
    @Mock
    private GenericValidator<Section> validator;
    @Mock
    private static SectionRepository sectionRepository;
    @InjectMocks
    private SectionServiceImpl sectionService;
    private static Section diggingSection;
    private static Section completedSection;
    private static Artifact firstArtifact;
    private static Artifact secondArtifact;
    private static final double circleRadius = 2.0;
    private static final double circleLatitude = 0.5;
    private static final double circleLongitude = 0.5;


    @BeforeAll
    public static void setUp() {
        // Arrange
        Site site = new Site();
        site.setId(1L);

        User archeologist = new User();
        archeologist.setId(1L);

        firstArtifact = new Artifact();
        firstArtifact.setSection(diggingSection);
        firstArtifact.setArcheologist(archeologist);

        secondArtifact = new Artifact();
        secondArtifact.setSection(diggingSection);
        secondArtifact.setArcheologist(archeologist);

        diggingSection = new Section();
        diggingSection.setId(1L);
        diggingSection.setName("digging section");
        diggingSection.setSouthEast(new GeographicPoint(0.0, 1.0));
        diggingSection.setSouthWest(new GeographicPoint(0.0, 0.0));
        diggingSection.setNorthWest(new GeographicPoint(0.0, 1.0));
        diggingSection.setNorthEast(new GeographicPoint(1.1, 1.1));
        diggingSection.setArtifactsList(List.of(firstArtifact, secondArtifact));
        diggingSection.setStatus(SectionStatus.DIGGING);
        diggingSection.setSite(site);


        completedSection = new Section();
        completedSection.setId(2L);
        completedSection.setName("completed section");
        completedSection.setSouthEast(new GeographicPoint(0.0, 10.0));
        completedSection.setSouthWest(new GeographicPoint(0.0, 0.0));
        completedSection.setNorthWest(new GeographicPoint(0.0, 10.0));
        completedSection.setNorthEast(new GeographicPoint(10.0, 10.0));
        completedSection.setStatus(SectionStatus.COMPLETED);
        completedSection.setSite(site);
    }

    @Test
    public void SectionServiceImpl_AddSection_AssertTrue() {
        // Stub
        when(sectionRepository.save(diggingSection)).thenReturn(diggingSection);

        // Act
        Section addedSection = sectionService.addSection(diggingSection);

        // Assert
        assertEquals(addedSection, diggingSection);
    }

    @Test
    public void SectionServiceImpl_UpdateSection_AssertTrue() {
        // Stub
        when(sectionRepository.findById(1L)).thenReturn(Optional.of(diggingSection));
        when(sectionRepository.save(ArgumentMatchers.any(Section.class))).thenReturn(completedSection);

        // Act
        Section result = sectionService.updateSection(diggingSection);

        // Assert
        assertEquals(result, completedSection);
    }

    @Test
    public void SectionServiceImpl_UpdateSection_ThrowsException() {
        // Assert
        try {
            sectionService.updateSection(diggingSection);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Section with id 1, does not exist.");
        }
    }

    @Test
    public void SectionServiceImpl_DeleteSection_AssertTrue() {
        // Act
        sectionService.addSection(diggingSection);
        sectionService.deleteSection(diggingSection.getId());

        // Assert
        assertEquals(0, sectionService.getSections().size());
    }

    @Test
    public void SectionServiceImpl_GetSectionByName_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionsByNameIs(diggingSection.getName())).thenReturn(Optional.of(diggingSection));

        // Act
        Section result = sectionService.getSection(diggingSection.getName());

        // Assert
        assertEquals(result, diggingSection);
    }

    @Test
    public void SectionServiceImpl_GetSectionByName_ThrowsException() {
        // Assert
        try {
            sectionService.getSection("Random name");
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Section with name Random name, does not exist.");
        }
    }

    @Test
    public void SectionServiceImpl_GetSectionById_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionByIdWithArtifacts(diggingSection.getId())).thenReturn(Optional.of(diggingSection));

        // Act
        Section result = sectionService.getSection(diggingSection.getId());

        // Assert
        assertEquals(result, diggingSection);
    }

    @Test
    public void SectionServiceImpl_GetSectionById_ThrowsException() {
        // Assert
        try {
            sectionService.getSection(22L);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Section with id 22, does not exist.");
        }
    }

    @Test
    public void SectionServiceImpl_GetSectionsAroundPoint_AssertTrue() {
        // Stub
        when(sectionRepository.findAll()).thenReturn(new LinkedList<>(Arrays.asList(diggingSection,
                completedSection)));

        // Act
        List<Section> result = sectionService.getSectionsAroundPoint(circleLatitude, circleLongitude, circleRadius);

        // Assert
        assertEquals(result, List.of(diggingSection));
    }

    @Test
    public void SectionServiceImpl_GetSectionsNorthOf_AssertTrue() {
        // Stub
        when(sectionRepository.findAll()).thenReturn(new LinkedList<>(Arrays.asList(diggingSection,
                completedSection)));

        // Act
        List<Section> result = sectionService.getSectionsNorthOf(-1.0);

        // Assert
        assertEquals(result, List.of(diggingSection, completedSection));
    }

    @Test
    public void SectionServiceImpl_GetSectionsSouthOf_AssertTrue() {
        // Stub
        when(sectionRepository.findAll()).thenReturn(new LinkedList<>(Arrays.asList(diggingSection,
                completedSection)));

        // Act
        List<Section> result = sectionService.getSectionsSouthOf(-1.0);

        // Assert
        assertEquals(result, List.of());
    }

    @Test
    public void SectionServiceImpl_GetSectionsWestOf_AssertTrue() {
        // Stub
        when(sectionRepository.findAll()).thenReturn(new LinkedList<>(Arrays.asList(diggingSection,
                completedSection)));

        // Act
        List<Section> result = sectionService.getSectionsWestOf(-1.0);

        // Assert
        assertEquals(result, List.of());
    }

    @Test
    public void SectionServiceImpl_GetSectionsEastOf_AssertTrue() {
        // Stub
        when(sectionRepository.findAll()).thenReturn(new LinkedList<>(Arrays.asList(diggingSection,
                completedSection)));

        // Act
        List<Section> result = sectionService.getSectionsEastOf(-1.0);

        // Assert
        assertEquals(result, List.of(diggingSection, completedSection));
    }

    @Test
    public void SectionServiceImpl_GetSectionsWithArtifacts_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionsWithArtifacts()).thenReturn(List.of(diggingSection));

        // Act
        List<Section> result = sectionService.getSections();

        // Assert
        assertEquals(result, List.of(diggingSection));
    }

    @Test
    public void SectionServiceImpl_GetIncompleteSections_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionsByStatusIsNot(SectionStatus.COMPLETED)).thenReturn(List.of(diggingSection));

        // Act
        List<Section> result = sectionService.getIncompleteSections();

        // Assert
        assertEquals(result, List.of(diggingSection));
    }

    @Test
    public void SectionServiceImpl_GetSectionsBySiteId_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionsBySiteId(1L)).thenReturn(List.of(diggingSection, completedSection));

        // Act
        List<Section> result = sectionService.getSectionsBySite(1L);

        // Assert
        assertEquals(result, List.of(diggingSection, completedSection));
    }

    @Test
    public void SectionServiceImpl_GetSectionsByStatusIsAndSiteId_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionsByStatusIsAndSiteId(SectionStatus.DIGGING, 1L)).thenReturn(List.of(diggingSection));

        // Act
        List<Section> result = sectionService.getSectionsByStatusIsAndSiteId(SectionStatus.DIGGING.name(), 1L);

        // Assert
        assertEquals(result, List.of(diggingSection));
    }

    @Test
    public void SectionServiceImpl_GetArtifactsFromSection_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionByIdWithArtifacts(1L)).thenReturn(Optional.ofNullable(diggingSection));

        // Act
        List<Artifact> result = sectionService.getArtifactsFromSection(1L);

        // Assert
        assertEquals(result, List.of(firstArtifact, secondArtifact));
    }

    @Test
    public void SectionServiceImpl_GetArtifactsFromSection_ThrowsException() {
        // Assert
        try {
            sectionService.getArtifactsFromSection(10L);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Section with id 10, does not exist.");
        }
    }

    @Test
    public void SectionServiceImpl_GetArtifactsFromSectionByArchaeologist_AssertTrue() {
        // Stub
        when(sectionRepository.getSectionByIdWithArtifacts(1L)).thenReturn(Optional.ofNullable(diggingSection));

        // Act
        List<Artifact> result = sectionService.getArtifactsFromSectionByArchaeologist(1L, 1L);

        // Assert
        assertEquals(result, List.of(firstArtifact, secondArtifact));
    }

    @Test
    public void SectionServiceImpl_GetArtifactsFromSectionByArchaeologist_ThrowsException() {
        // Assert
        try {
            sectionService.getArtifactsFromSectionByArchaeologist(10L, 1L);
        } catch (Exception e) {
            assertTrue(e instanceof EntityNotFoundException);
            assertEquals(e.getMessage(), "Section with id 10, does not exist.");
        }
    }
}