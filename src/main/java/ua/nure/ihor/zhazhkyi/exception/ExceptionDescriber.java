package ua.nure.ihor.zhazhkyi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ua.nure.ihor.zhazhkyi.exception.user.NoSuchUserException;

public enum  ExceptionDescriber {

    NO_SUCH_USER(NoSuchUserException.class, 4004, "The requested id does not exists.",
                  HttpStatus.NOT_FOUND),
    VALIDATION_ERROR(ServiceException.class, 4000, "Validation error has been occurred.",
                     HttpStatus.BAD_REQUEST),
    INVALID_URL_ID(MethodArgumentTypeMismatchException.class, 4005, "Order URL id validation error has been occurred.",
                   HttpStatus.BAD_REQUEST),
    INVALID_JSON(HttpMessageNotReadableException.class, 4006, "JSON validation error has been occurred.",
                 HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR(Exception.class, 5000, "Order service internal error has been occurred.",
                   HttpStatus.INTERNAL_SERVER_ERROR);

    private Class exception;
    private int errorCode;
    private String error;
    private HttpStatus httpStatus;

    ExceptionDescriber(Class exception, int errorCode, String error, HttpStatus httpStatus) {
        this.exception = exception;
        this.errorCode = errorCode;
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public Class getException() {
        return exception;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getError() {
        return error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Return the enum with intercepted exception description.
     *
     * @param intercepted intercepted exception
     * @return the enum  with  specified description
     */
    public static ExceptionDescriber getExceptionDescriber(Class intercepted) {
        for (ExceptionDescriber element : values()) {
            if (element.exception.isAssignableFrom(intercepted)) {
                return element;
            }
        }
        return ExceptionDescriber.INTERNAL_ERROR;
    }
}
