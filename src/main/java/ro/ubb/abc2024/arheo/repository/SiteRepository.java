package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.site.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {

}
