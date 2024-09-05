package ro.ubb.abc2024.utils.file;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileRepository extends JpaRepository<DbFile, UUID> {

}