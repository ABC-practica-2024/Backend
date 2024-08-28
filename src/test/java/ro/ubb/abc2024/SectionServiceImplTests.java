package ro.ubb.abc2024;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.repository.SectionRepository;
import ro.ubb.abc2024.arheo.service.SectionServiceImpl;
import ro.ubb.abc2024.utils.validation.GenericValidator;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectionServiceImplTests {

    @Mock
    private SectionRepository sectionRepository;

    @Mock
    private GenericValidator<Section> validator;

    @InjectMocks
    private SectionServiceImpl sectionService;

    @Test
    void testAddSection() {

        // create site
        Site site = new Site();
        site.setTitle("Test Site");

        // Arrange
        Section section = new Section();
        section.setName("Test Section");
        // set site
        section.setSite(site);

        when(sectionRepository.save(any(Section.class))).thenReturn(section);

        // Act
        Section result = sectionService.addSection(section);

        // Assert
        assertEquals("Test Section", result.getName());
        assertEquals("Test Site", result.getSite().getTitle());

    }

    @Test
    void testRemoveSection() {

        // Arrange
        Section section = new Section();
        section.setName("Test Section");

        // setup add section
        when(sectionRepository.save(any(Section.class))).thenReturn(section);
        Section result = sectionService.addSection(section);

        // Act
        sectionService.deleteSection(result.getId());

        // Assert
        assertEquals(0, sectionService.getSections().size());
    }

    @Test
    void testUpdateSection() {
        // Arrange
        Section section = new Section();
        section.setId(1L);
        section.setName("Test Section");

        Site site = new Site();
        site.setTitle("Test Site");
        section.setSite(site);

        Section updatedSection = new Section();
        updatedSection.setId(1L);
        updatedSection.setName("Updated Section");
        updatedSection.setSite(site);

        // setup
        when(sectionRepository.findById(1L)).thenReturn(Optional.of(section));
        when(sectionRepository.save(any(Section.class))).thenReturn(updatedSection);

        // Act
        Section result = sectionService.updateSection(updatedSection);

        // Assert
        assertEquals("Updated Section", result.getName());
        assertEquals("Test Site", result.getSite().getTitle());
    }
    @Test
    void testGetSection() {
        // Arrange
        Site site = new Site();
        site.setTitle("Test Site");

        Section section = new Section();
        section.setId(1L); // Ensure the ID is set
        section.setName("Test Section");
        section.setSite(site);

        when(sectionRepository.save(any(Section.class))).thenReturn(section);
        when(sectionRepository.findById(1L)).thenReturn(Optional.of(section)); // Mock findById

        // Act
        Section result = sectionService.addSection(section);
        Section foundSection = sectionService.getSection(result.getId());

        // Assert
        assertEquals("Test Section", foundSection.getName());
        assertEquals("Test Site", foundSection.getSite().getTitle());
    }

    @Test
    void testGetSections() {
        // Arrange
        Section section = new Section();
        section.setName("Test Section");

        Section section2 = new Section();
        section2.setName("Test Section 2");


        // add section
        sectionService.addSection(section);
        sectionService.addSection(section2);

        // setup
        when(sectionRepository.findAll()).thenReturn(java.util.List.of(section, section2));

        // get sections
        assertEquals(2, sectionService.getSections().size());
    }
}