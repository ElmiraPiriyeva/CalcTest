package ada.wm2.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(Exception.class)
    public ModelAndView handle405Error(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/error");
        mv.addObject("exception", ex.getMessage());
        return mv;
    }
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handle400Error(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/error");
        mv.addObject("exception", ex.getMessage());
        return mv;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView handleError400(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/error");
        mv.addObject("exception", ex.getMessage());
        return mv;
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(HttpClientErrorException.UnprocessableEntity.class)
    public ModelAndView handle422Error(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/error");
        mv.addObject("exception", ex.getMessage());
        return mv;
    }

}


