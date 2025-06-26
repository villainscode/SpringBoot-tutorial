package cc.subnote.springboot.tutorial.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author CodeVillains
 */
@ControllerAdvice
public class MyNoteNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MyNoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(MyNoteNotFoundException ex) {
        return ex.getMessage();
    }
}