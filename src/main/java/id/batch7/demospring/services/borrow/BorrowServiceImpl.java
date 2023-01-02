package id.batch7.demospring.services.borrow;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.batch7.demospring.exceptions.custom.CustomNotFoundException;
import id.batch7.demospring.models.dto.request.BorrowRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.models.entity.Book;
import id.batch7.demospring.models.entity.Borrow;
import id.batch7.demospring.models.entity.User;
import id.batch7.demospring.repositories.BookRepository;
import id.batch7.demospring.repositories.BorrowRepository;
import id.batch7.demospring.repositories.UserRepository;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    private Borrow borrow;
    private ResponseData responseData;


    @Override
    public ResponseData createBorrowService(BorrowRequest borrowRequest) throws Exception {
        // TODO Auto-generated method stub
        borrow = new Borrow();
        Optional<User> userFind = userRepository.findById(borrowRequest.getUserId());
        User user = userFind.get();
        if (Objects.isNull(user)) {
            throw new CustomNotFoundException("User is not found!");
        }
        borrow.setUser(user);

        Optional<Book> bookFind = bookRepository.findById(borrowRequest.getBookId());
        Book book = bookFind.get();
        if (Objects.isNull(book)) {
            throw new CustomNotFoundException("Book is not found!");
        }

        
        borrow.setBook(book);
        borrowRepository.save(borrow);
        responseData = new ResponseData(HttpStatus.CREATED.value(), "success", borrow);

        return responseData;
    }

    @Override
    public ResponseData createReturnService(Long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Borrow> borrowFind = borrowRepository.findById(id);
        Borrow borrow = borrowFind.get();
        if (Objects.isNull(borrow)) {
            throw new CustomNotFoundException("Borrow is not found!");
        }

        borrow.setIsReturned(true);
        borrowRepository.save(borrow);
        responseData = new ResponseData(200, "success updated", borrow);
        return responseData;
    }
    
}
