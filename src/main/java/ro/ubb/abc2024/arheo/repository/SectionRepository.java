package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long> {

    // get Section by name
    public Optional<Section> getSectionsByNameIs(String name);

    // get Section by partial name
    public List<Section> getSectionsByNameContainingIgnoreCase(String name);

    // get Sections by site id
    public List<Section> getSectionsBySiteId(Long siteId); // not sure if this works

    // get Sections by site title
    public List<Section> getSectionsBySiteTitle(String siteTitle);

    // get Sections created later than a certain datetime
    public List<Section> getSectionsByCreatedAtAfter(LocalDateTime dateTime);

    // get Sections created earlier than a certain datetime
    public List<Section> getSectionsByCreatedAtBefore(LocalDateTime dateTime);

    // get Sections with given status and given siteId
    public List<Section> getSectionsByStatusIsAndSiteId(SectionStatus status, Long site_id);


    public Optional<Section> getSectionByNameIs(String testSection);
}
