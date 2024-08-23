package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.user.User;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> getSitesByStatus(SiteStatus status);
    Site getSiteById(Long id);
    Site getSiteByTitle(String title);
}
