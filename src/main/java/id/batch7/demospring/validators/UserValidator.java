package id.batch7.demospring.validators;

import java.util.Optional;

import org.springframework.stereotype.Service;

import id.batch7.demospring.exceptions.custom.CustomNotFoundException;
import id.batch7.demospring.models.entity.User;

@Service
public class UserValidator {
    public void validateUserNotFound(Optional<User> userFind) throws Exception {
        if (userFind.isEmpty()) {
            throw new CustomNotFoundException("User is not found!");
        }
    }

    public void validateIsAlreadyDeleted(User user) throws Exception {
        if (user.getIsDeleted()) {
            throw new Exception("User is already deleted!");
        }
    }
}
