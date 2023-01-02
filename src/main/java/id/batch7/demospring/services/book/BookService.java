package id.batch7.demospring.services.book;

import id.batch7.demospring.models.dto.request.BookRequest;
import id.batch7.demospring.models.dto.response.ResponseData;

public interface BookService {
    ResponseData createBookService(BookRequest request);

    // Read all books
    ResponseData readBookService(Boolean status);

    // Read by id
    ResponseData readBookService(Long id) throws Exception;

    ResponseData updateBookService(Long id, BookRequest request) throws Exception;

    ResponseData deleteBookService(Long id) throws Exception;
    
}
