package ro.ubb.abc2024.arheo.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.user.User;

import java.beans.Transient;
import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long>, JpaSpecificationExecutor<Site> {
    List<Site> getSitesByStatus(SiteStatus status);
    Site getSiteById(Long id);
    Site getSiteByTitle(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Site s SET s.status = :status WHERE s.id = :id")
    void updateSiteStatus(@Param("id") Long id, @Param("status") String status);

    @Transactional
    @Query(value = "select s from Site s left join fetch s.sections")
    List<Site> getSitesWithSectionsAndArchaeologists();
}
