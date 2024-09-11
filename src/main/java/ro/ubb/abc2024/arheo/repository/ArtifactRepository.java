package ro.ubb.abc2024.arheo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long>, JpaSpecificationExecutor<Artifact> {
    @Query("SELECT a.section.site.mainArchaeologist.id FROM Artifact a WHERE a.id = :id")
    Long findMainArcheologistIdByArtifactId(@Param("id") Long id);
    @Query("SELECT a.section.site.mainArchaeologist.id FROM Artifact a WHERE a.section.id = :id")
    Long findMainArcheologistIdBySectionId(@Param("id") Long id);
    @Query("SELECT a.section.site.archaeologists FROM Artifact a WHERE a.section.id = :id")
    List<User> findAssignedArchaeologistIdsBySectionId(@Param("id") Long id);
    @Query("SELECT a FROM Artifact a LEFT JOIN FETCH a.images WHERE a.id = :id")
    public Optional<Artifact> getArtifactsByIdWithImages(@Param("id") Long id);
    @EntityGraph(attributePaths = {"images"})
    Optional<Artifact> findById(Long id);
    @EntityGraph(attributePaths = {"images"})
    Page<Artifact> findAll(Specification<Artifact> spec, Pageable pageable);

}
