package ro.ubb.abc2024.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<UserToken, Long> {
    @Query(value = "select t from UserToken t where t.user.id = :id")
    Optional<UserToken> findByUserId(@Param("id") Long id);
    @Query (value = "select t from UserToken t where t.token = :token")
    Optional<UserToken> findByToken(@Param("token") String token);
}
