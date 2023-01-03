package id.batch7.demospring.validators;

import java.util.Optional;

import org.springframework.stereotype.Service;

import id.batch7.demospring.exceptions.custom.CustomNotFoundException;
import id.batch7.demospring.models.entity.Borrow;

@Service
public class BorrowValidator {
    public void validateBorrowNotFound(Optional<Borrow> borrowFind) throws Exception {
        if (borrowFind.isEmpty()) {
            throw new CustomNotFoundException("Borrow is not found!");
        }
    }
}
