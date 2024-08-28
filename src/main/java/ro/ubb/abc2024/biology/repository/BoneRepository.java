package ro.ubb.abc2024.biology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.Bone;

public interface BoneRepository extends JpaRepository<Bone, Long> {
}
