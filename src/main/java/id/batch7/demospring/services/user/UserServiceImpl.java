package id.batch7.demospring.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.batch7.demospring.models.dto.request.UserRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.models.entity.User;
import id.batch7.demospring.repositories.UserRepository;
import id.batch7.demospring.validators.UserValidator;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    private User user;
    private ResponseData responseData;
    private List<User> users;

    @Override
    public ResponseData createUserService(UserRequest userRequest) {
        // TODO Auto-generated method stub
        user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setUsername(userRequest.getUsername());
        user.setPassword(user.getPassword());
        userRepository.save(user);
        responseData = new ResponseData(HttpStatus.CREATED.value(), "success", user);
        return responseData;
    }

    @Override
    public ResponseData readUserService(Boolean status) {
        // TODO Auto-generated method stub
        if (status == null) {
            users = userRepository.findAll();
        } else {
            users = userRepository.findByIsDeleted(status);
        }
        responseData = new ResponseData(200, "success", users);

        return responseData;
    }

    @Override
    public ResponseData readUserService(Integer id) throws Exception {
        // TODO Auto-generated method stub
        Optional<User> userFind = userRepository.findById(id);
        userValidator.validateUserNotFound(userFind);

        user = userFind.get();
        responseData = new ResponseData(200, "success", user);
        return responseData;
    }

    @Override
    public ResponseData updateUserService(Integer id, UserRequest userRequest) throws Exception {
        // TODO Auto-generated method stub
        Optional<User> userFind = userRepository.findById(id);
        userValidator.validateUserNotFound(userFind);

        user = userFind.get();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);

        responseData = new ResponseData(200, "success updated", user);
        return responseData;
    }

    @Override
    public ResponseData deleteUserService(Integer id) throws Exception {
        // TODO Auto-generated method stub
        Optional<User> userFind = userRepository.findById(id);
        userValidator.validateUserNotFound(userFind);
        user = userFind.get();
        userValidator.validateIsAlreadyDeleted(user);
        user.setIsDeleted(true);
        userRepository.save(user);
        responseData = new ResponseData(200, "success", user);
        return responseData;
    }
    
}
