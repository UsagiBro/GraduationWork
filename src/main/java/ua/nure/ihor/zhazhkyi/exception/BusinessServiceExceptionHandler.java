package ua.nure.ihor.zhazhkyi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BusinessServiceExceptionHandler {

//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(
//            Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return handleAll(exception);
//    }

    /**
     * Versatile handle method
     */
    @ExceptionHandler({Exception.class})
    public ModelAndView handleAll(Exception exception) {
        ExceptionDescriber exceptionDescriber = ExceptionDescriber.getExceptionDescriber(exception.getClass());
        ExceptionResponseBody response = new ExceptionResponseBody(
                exceptionDescriber, exception.getMessage());
//        return buildResponseEntity(response, exceptionDescriber.getHttpStatus());
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", response);
        mav.setViewName("errors/error");
        return mav;
    }


    private ResponseEntity<Object> buildResponseEntity(ExceptionResponseBody response, HttpStatus httpStatus) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
