package site.timmyroom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.timmyroom.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String > {

    User findMemberByEmail(String email);
}
