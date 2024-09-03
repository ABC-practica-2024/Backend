package ro.ubb.abc2024.arheo.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.user.User;

import java.beans.Transient;
import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long>, JpaSpecificationExecutor<Site> {
    List<Site> getSitesByStatus(SiteStatus status);
    Site getSiteById(Long id);
    Site getSiteByTitle(String title);

    @Transactional
    @Query(value = "select s from Site s left join fetch s.sections")
    List<Site> getSitesWithSectionsAndArchaeologists();
}
