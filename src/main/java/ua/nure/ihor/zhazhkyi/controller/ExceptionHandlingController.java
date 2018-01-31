package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.nure.ihor.zhazhkyi.exception.DatabaseException;

@Controller
public class ExceptionHandlingController {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(DatabaseException.class)
    public String serverError() {
        return "errors/databaseException";
    }
}
