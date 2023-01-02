package id.batch7.demospring.services.book;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.batch7.demospring.exceptions.custom.CustomNotFoundException;
import id.batch7.demospring.models.dto.request.BookRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.models.entity.Book;
import id.batch7.demospring.models.entity.Category;
import id.batch7.demospring.repositories.BookRepository;
import id.batch7.demospring.repositories.CategoryRepository;
import id.batch7.demospring.validators.BookValidator;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookValidator bookValidator;

    private Book book;
    private ResponseData responseData;
    private List<Book> books;

    @Override
    public ResponseData createBookService(BookRequest request) throws Exception {
        // TODO Auto-generated method stub

        book = new Book();

        book.setTitle(request.getJudulBuku());
        book.setAuthor(request.getPenulis());
        book.setPublisher(request.getPenerbit());

        Category category = categoryRepository.findByName(request.getCategoryName());
        if(Objects.isNull(category)) {
            throw new CustomNotFoundException("Category is not found");
        }

        book.setCategory(category);

        bookRepository.save(book);

        responseData = new ResponseData(HttpStatus.CREATED.value(), "success", book);

        return responseData;
    }

    @Override
    public ResponseData readBookService(Boolean status) {
        // TODO Auto-generated method stub
        if (status == null) {
            books = bookRepository.findAll();
        } else {
            books = bookRepository.findByIsDeleted(status);
        }
        responseData = new ResponseData(200, "success", books);
        return responseData;
    }

    @Override
    public ResponseData readBookService(Long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(id);
        bookValidator.validateBookNotFound(bookFind);

        book = bookFind.get();
        responseData = new ResponseData(200, "success", book);
        return responseData;
    }

    @Override
    public ResponseData updateBookService(Long id, BookRequest request) throws Exception {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(id);
        bookValidator.validateBookNotFound(bookFind);

        book = bookFind.get();
        book.setAuthor(request.getPenulis());
        book.setPublisher(request.getPenerbit());
        book.setTitle(request.getJudulBuku());

        Category category = categoryRepository.findByName(request.getCategoryName());
        if (Objects.isNull(category)) {
            throw new CustomNotFoundException("Category is not found!");
        }
        book.setCategory(category);

        bookRepository.save(book);

        responseData = new ResponseData(200, "success updated", book);
        return responseData;
    }

    @Override
    public ResponseData deleteBookService(Long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(id);
        bookValidator.validateBookNotFound(bookFind);
        book = bookFind.get();
        bookValidator.validateIsAlreadyDeleted(book);
        book.setIsDeleted(true);
        bookRepository.save(book);
        responseData = new ResponseData(200, "success", book);

        return responseData;
    }

}
