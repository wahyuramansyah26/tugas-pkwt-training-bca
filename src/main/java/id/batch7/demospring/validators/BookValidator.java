package id.batch7.demospring.validators;

import java.util.Optional;

import org.springframework.stereotype.Service;

import id.batch7.demospring.exceptions.custom.CustomNotFoundException;
import id.batch7.demospring.models.entity.Book;

@Service
public class BookValidator {
    public void validateBookNotFound(Optional<Book> bookFind) throws Exception {
        if (bookFind.isEmpty()) {
            throw new CustomNotFoundException("Book is not found!");
        }
    }

    public void validateIsAlreadyDeleted(Book book) throws Exception {
        if (book.getIsDeleted()) {
            throw new Exception("Book is already deleted!");
        }
    }
}
