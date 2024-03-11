package pl.krystian.creditcard;

import org.junit.jupiter.api.Test;

public class NumberRepresentation {

    @Test
    void doubleTest() {
        double a = 0.02;
        double b = 0.03;
        System.out.println("Dobule");
        System.out.println(a - b);
    }

    @Test
    void bigDecimalest() {
        float a = 0.002f;
        float b = 0.003f;
        System.out.println("Float");
        System.out.println(a - b);
    }
}
