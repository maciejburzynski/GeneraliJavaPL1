package pl.generali.Spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.generali.Spring.laptop.LaptopNotFoundException;

@ControllerAdvice
public class ElectronicShopGlobalExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LaptopNotFoundException.class)
    String LaptopNotFoundExceptionHandler(LaptopNotFoundException laptopNotFoundException){
        return laptopNotFoundException.getMessage();
    }

}
