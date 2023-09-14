package pl.generali.Spring.apiconsuming;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.generali.Spring.laptop.LaptopNotFoundException;

import java.io.IOException;

@ControllerAdvice
public class ApiGlobalExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LaptopNotFoundException.class)
    String IOExceptionHandler(LaptopNotFoundException laptopNotFoundException){
        return laptopNotFoundException.getMessage();
    }

}
