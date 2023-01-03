package id.batch7.demospring.services.borrow;

import id.batch7.demospring.models.dto.request.BorrowRequest;
import id.batch7.demospring.models.dto.response.ResponseData;

public interface BorrowService {
    ResponseData createBorrowService(BorrowRequest borrowRequest) throws Exception;
    ResponseData createReturnService(Long id) throws Exception;
    ResponseData getBorrowByUserIdService(Integer userId) throws Exception;
}
