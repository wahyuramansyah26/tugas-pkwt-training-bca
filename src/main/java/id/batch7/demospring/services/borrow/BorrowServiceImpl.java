package id.batch7.demospring.services.borrow;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.batch7.demospring.models.dto.request.BorrowRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.models.entity.Book;
import id.batch7.demospring.models.entity.Borrow;
import id.batch7.demospring.models.entity.User;
import id.batch7.demospring.repositories.BookRepository;
import id.batch7.demospring.repositories.BorrowRepository;
import id.batch7.demospring.repositories.UserRepository;
import id.batch7.demospring.validators.BookValidator;
import id.batch7.demospring.validators.BorrowValidator;
import id.batch7.demospring.validators.UserValidator;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowValidator borrowValidator;

    @Autowired
    private BookValidator bookValidator;

    @Autowired
    private UserValidator userValidator;

    private Borrow borrow;
    private ResponseData responseData;

    @Override
    public ResponseData createBorrowService(BorrowRequest borrowRequest) throws Exception {
        // TODO Auto-generated method stub
        borrow = new Borrow();
        Optional<User> userFind = userRepository.findById(borrowRequest.getUserId());
        userValidator.validateUserNotFound(userFind);
        User user = userFind.get();

        Optional<Book> bookFind = bookRepository.findByIdAndIsDeleted(borrowRequest.getBookId(), false);
        bookValidator.validateBookNotFound(bookFind);
        Book book = bookFind.get();
        Optional<Borrow> bookIsBorrow = borrowRepository.findByBookIdAndIsReturned(borrowRequest.getBookId(), false);
        if (bookIsBorrow.isEmpty()) {
            borrow.setUser(user);
            borrow.setBook(book);
            borrowRepository.save(borrow);
            responseData = new ResponseData(HttpStatus.CREATED.value(), "success", borrow);
        } else {
            responseData = new ResponseData(HttpStatus.BAD_REQUEST.value(), "failed, book is already borrowed", null);
        }
        

        return responseData;
    }

    @Override
    public ResponseData createReturnService(Long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Borrow> borrowFind = borrowRepository.findById(id); 
        borrowValidator.validateBorrowNotFound(borrowFind);
        borrow = borrowFind.get();
        if (borrow.getIsReturned()) {
            responseData = new ResponseData(500, "book is already returned", null);
        } else {
            borrow.setIsReturned(true);
            borrowRepository.save(borrow);
            responseData = new ResponseData(200, "success returned book", borrow);
        }
        
        return responseData;
    }
    
}
