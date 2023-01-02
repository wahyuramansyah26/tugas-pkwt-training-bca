package id.batch7.demospring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.batch7.demospring.models.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByIsDeleted(Boolean isDeleted);

  List<Book> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}