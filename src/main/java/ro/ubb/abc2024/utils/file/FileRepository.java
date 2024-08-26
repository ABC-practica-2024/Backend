package ro.ubb.abc2024.utils.file;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<DbFile, Long> {

    DbFile findByName(String name);
}