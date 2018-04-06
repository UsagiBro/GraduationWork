package ua.nure.ihor.zhazhkyi.exception.user;

import ua.nure.ihor.zhazhkyi.exception.ServiceException;

public class UserAlreadyExistsException extends ServiceException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
