package id.batch7.demospring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.batch7.demospring.models.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    Category findByName(String categoryName);
    List<Category> findByIsDeleted(boolean isDeleted);
}
