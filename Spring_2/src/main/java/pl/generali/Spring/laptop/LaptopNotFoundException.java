package pl.generali.Spring.laptop;

public class LaptopNotFoundException extends RuntimeException {

    public LaptopNotFoundException(String message) {
        super(message);
    }

    //  if extends Exception -> method throws Exception / Try/Catch
//  if extends RuntimeException -> not required



}
