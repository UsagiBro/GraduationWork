package ua.nure.ihor.zhazhkyi.exception.user;

import ua.nure.ihor.zhazhkyi.exception.ServiceException;

public class ValidationException extends ServiceException {

    public ValidationException(String message) {
        super(message);
    }
}
