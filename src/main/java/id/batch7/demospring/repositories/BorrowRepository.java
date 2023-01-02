package id.batch7.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.batch7.demospring.models.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long>{
    
}
