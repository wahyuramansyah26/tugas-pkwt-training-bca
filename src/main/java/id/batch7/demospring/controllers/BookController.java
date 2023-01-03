package id.batch7.demospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.batch7.demospring.models.dto.request.BookRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.services.book.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    private ResponseData responseData;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody @Valid BookRequest request) throws Exception{
        responseData = bookService.createBookService(request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
        
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(value = "status", defaultValue = "") Boolean status) {
        try {
            responseData = bookService.readBookService(status);
            return ResponseEntity.ok().body(responseData);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseData = new ResponseData(500, e.getMessage(), null);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        }
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<?> getBookById(@PathVariable("idBook") Long id) throws Exception{
        responseData = bookService.readBookService(id);
        return ResponseEntity.ok().body(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id, @RequestBody @Valid BookRequest request) throws Exception{
        responseData = bookService.updateBookService(id, request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) throws Exception{
        responseData = bookService.deleteBookService(id);
        return ResponseEntity.ok().body(responseData);
    }

}
