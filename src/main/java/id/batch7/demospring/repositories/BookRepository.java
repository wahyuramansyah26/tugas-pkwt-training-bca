package id.batch7.demospring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.batch7.demospring.models.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByIsDeleted(Boolean isDeleted);
  Optional<Book> findByIdAndIsDeleted(Long id, Boolean isDeleted);
}