package id.batch7.demospring.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.batch7.demospring.models.entity.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
    Optional<Borrow> findByBookIdAndIsReturned(Long bookId, Boolean isReturned);
    List<Borrow> findByUserId(Integer userId);
}
