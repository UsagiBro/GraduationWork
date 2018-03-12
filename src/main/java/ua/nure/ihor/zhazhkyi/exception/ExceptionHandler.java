package ua.nure.ihor.zhazhkyi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice(assignableTypes = {CustomerOrderResourceV1.class, DriverOrderResourceV1.class})
public class ExceptionHandler {

    /**
     * Intercepts HttpMessageNotReadableException
     **/
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(
//            Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return handleAll(exception);
//    }

    /**
     * Build response entity with status HttpStatus#BAD_REQUEST
     **/
//    private ResponseEntity<Object> buildResponseEntity(OrderServiceExceptionResponseBody response, HttpStatus httpStatus) {
//        return new ResponseEntity<>(response, httpStatus);
//    }

    /**
     * Universal interceptor
     **/
//    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
//    protected ResponseEntity<Object> handleAll(Exception exception) {
//        ExceptionDescriber exceptionDescriber = ExceptionDescriber.getExceptionDescriber(exception.getClass());
//        OrderServiceExceptionResponseBody response = new OrderServiceExceptionResponseBody(
//                exceptionDescriber, exception.getMessage());
//        return buildResponseEntity(response, exceptionDescriber.getHttpStatus());
//    }
}
