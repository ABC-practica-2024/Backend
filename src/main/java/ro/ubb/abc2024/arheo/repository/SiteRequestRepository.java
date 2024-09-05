package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.arheo.domain.site.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;

import java.util.List;

public interface SiteRequestRepository extends JpaRepository<CreateArchaeologicalSiteRequest, Long> {
    List<CreateArchaeologicalSiteRequest> findByStatus(RequestStatus status);
}