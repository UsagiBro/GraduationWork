package ua.nure.ihor.zhazhkyi.exception.user;

import ua.nure.ihor.zhazhkyi.exception.ServiceException;

public class NoItemExistsException extends ServiceException {

    public NoItemExistsException(String message) {
        super(message);
    }
}
