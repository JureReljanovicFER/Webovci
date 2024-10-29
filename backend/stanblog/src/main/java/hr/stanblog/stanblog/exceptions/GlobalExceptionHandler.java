package hr.stanblog.stanblog.exceptions;
// Class to handle exceptions globally

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchAdminExistsException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchAdminExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(NoSuchAdminExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}


