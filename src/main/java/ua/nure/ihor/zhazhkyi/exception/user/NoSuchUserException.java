package ua.nure.ihor.zhazhkyi.exception.user;

import ua.nure.ihor.zhazhkyi.exception.ServiceException;

public class NoSuchUserException extends ServiceException {

    public NoSuchUserException(String message) {
        super(message);
    }
}
