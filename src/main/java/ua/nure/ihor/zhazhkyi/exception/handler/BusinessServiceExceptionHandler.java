package ua.nure.ihor.zhazhkyi.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.ihor.zhazhkyi.exception.ExceptionResponseBody;

@ControllerAdvice
public class BusinessServiceExceptionHandler {

    /**
     * Versatile handle method
     */
    @ExceptionHandler({Exception.class})
    public ModelAndView handleAll(Exception exception) {
        ExceptionDescriber exceptionDescriber = ExceptionDescriber.getExceptionDescriber(exception.getClass());
        ExceptionResponseBody response = new ExceptionResponseBody(
                exceptionDescriber, exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", response);
        modelAndView.setViewName("errors/error");
        return modelAndView;
    }
}
