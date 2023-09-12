package pl.generali.Spring;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {


    @Test
    void testInitBigDecimal() {

        BigDecimal bigDecimal = new BigDecimal("3.123456789019876321");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(3.123456789019876321);


        System.out.println(bigDecimal);
        System.out.println(bigDecimalValueOf);

    }


}
