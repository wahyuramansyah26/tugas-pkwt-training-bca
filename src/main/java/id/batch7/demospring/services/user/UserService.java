package id.batch7.demospring.services.user;

import id.batch7.demospring.models.dto.request.UserRequest;
import id.batch7.demospring.models.dto.response.ResponseData;

public interface UserService {
    ResponseData createUserService(UserRequest userRequest);

    ResponseData readUserService(Boolean status);

    ResponseData readUserService(Integer id) throws Exception;

    ResponseData updateUserService(Integer id, UserRequest userRequest) throws Exception;

    ResponseData deleteUserService(Integer id) throws Exception;
}
