package ua.nure.ihor.zhazhkyi.exception.user;

import ua.nure.ihor.zhazhkyi.exception.ServiceException;

public class UserValidationException extends ServiceException {

    public UserValidationException(String message) {
        super(message);
    }
}
