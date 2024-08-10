package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.Image;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<Image, String> {
//    List<Image> findAllByUserEmail(String email);
}
