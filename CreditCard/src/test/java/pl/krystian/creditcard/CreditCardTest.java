package pl.krystian.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAssignCredit() {
        //Arrange
        CreditCard card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
    }

    @Test
    void itAssignCreditV2() {
        //Arrange
        CreditCard card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1500));
        //Assert
        assert BigDecimal.valueOf(1500).equals(card.getBalance());
    }

    @Test
    void itDenyCreditBelowThreshold() {
        CreditCard card = new CreditCard();
        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Throw an exception");

        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itDenyCreditBelowThresholdV2() {
        CreditCard card = new CreditCard();

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10))
        );
    }

    @Test
    void itDenyCreditReassignment() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(
                CreditCantBeReassignedException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1200)
        ));
    }

    @Test
    void itAllowsToPayForSomething() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.pay(BigDecimal.valueOf(900));

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );
    }

    @Test
    void itDenyWhenNotStufficientFounds() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(200))
        )
    }
}
