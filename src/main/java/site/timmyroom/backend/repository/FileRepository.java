package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.File;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
    List<File> findAllByUserEmail(String email);
}
