package pl.krystian.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AssertjTest {
    @Test
    void moreExpensiveAssertions() {
        var hello = "Hello";
        assertThat(hello).contains("Hello");
        assertThat(new ArrayList<>()).hasSize(0);
    }

}
