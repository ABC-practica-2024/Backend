package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.Status;

import java.util.List;

public interface SiteRequestRepository extends JpaRepository<CreateArchaeologicalSiteRequest, Long> {
    List<CreateArchaeologicalSiteRequest> findByStatus(Status status);
}