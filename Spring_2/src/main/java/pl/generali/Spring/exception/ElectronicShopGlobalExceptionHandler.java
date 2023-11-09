package pl.generali.Spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.generali.Spring.order.product.laptop.LaptopNotFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ElectronicShopGlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LaptopNotFoundException.class)
    String LaptopNotFoundExceptionHandler(LaptopNotFoundException laptopNotFoundException) {
        return laptopNotFoundException.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    String UsernameNotFoundExceptionHandler(UsernameNotFoundException usernameNotFoundException) {
        return usernameNotFoundException.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    ErrorResponse BindExceptionHandler(BindException bindException) {
        List<FieldError> errors = bindException.getBindingResult().getFieldErrors();
        List<ErrorDetails> errorDetails = new ArrayList<>();
        for (FieldError fieldError : errors) {
            ErrorDetails error = new ErrorDetails();
            error.setFieldName(fieldError.getField());
            error.setMessage(fieldError.getDefaultMessage());
            errorDetails.add(error);
        }
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrors(errorDetails);

        return errorResponse;
    }
}


