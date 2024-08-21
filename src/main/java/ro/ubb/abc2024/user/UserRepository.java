package ro.ubb.abc2024.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "Select u from User u where u.username= :username")
    Optional<User> findByUsername(String username);

    @Query(value = "select u from User u where u.email = :email")
    Optional<User> findByEmail(String email);

    @Query(value = "select u from User u where u.role = :role")
    List<User> findAllByRole(String role);
}
