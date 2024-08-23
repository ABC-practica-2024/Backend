package ro.ubb.abc2024.user.userRoleRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRequestRepository extends JpaRepository<UserRoleRequest, Long> {
    @Query(value = "SELECT urr FROM UserRoleRequest urr WHERE urr.requestStatus = 'PENDING'")
    List<UserRoleRequest> findPending();
}
