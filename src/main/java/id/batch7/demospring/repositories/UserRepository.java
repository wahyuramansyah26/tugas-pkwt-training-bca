package id.batch7.demospring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.batch7.demospring.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
    List<User> findByIsDeleted(Boolean isDeleted);
}
