package ua.nure.ihor.zhazhkyi.exception;

import ua.nure.ihor.zhazhkyi.exception.handler.ExceptionDescriber;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExceptionResponseBody {

    private LocalDateTime timestamp;
    private int statusCode;
    private String errorMsg;
    private String description;

    public ExceptionResponseBody(ExceptionDescriber describer, String exceptionMessage) {
        timestamp = LocalDateTime.now();
        this.statusCode = describer.getErrorCode();
        this.errorMsg = describer.getError();
        this.description = exceptionMessage;
    }

    public ExceptionResponseBody(int statusCode, String errorMsg, String description) {
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
        this.description = description;
    }

    public ExceptionResponseBody(int statusCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ExceptionResponseBody that = (ExceptionResponseBody) object;
        return Objects.equals(getStatusCode(), that.getStatusCode()) &&
                Objects.equals(getErrorMsg(), that.getErrorMsg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusCode(), getErrorMsg());
    }
}
