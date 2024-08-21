package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.user.User;

public interface SiteRequestRepository extends JpaRepository<CreateArchaeologicalSiteRequest, Long> {
}
