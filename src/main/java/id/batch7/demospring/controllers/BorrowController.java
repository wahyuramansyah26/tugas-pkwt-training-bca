package id.batch7.demospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.batch7.demospring.models.dto.request.BorrowRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.services.borrow.BorrowService;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    private ResponseData responseData;

    @PostMapping
    public ResponseEntity<?> borrowBook(@RequestBody BorrowRequest request) {
        try {
            responseData = borrowService.createBorrowService(request);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseData = new ResponseData(500, e.getMessage(), null);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        }
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id) throws Exception {
        responseData = borrowService.createReturnService(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
