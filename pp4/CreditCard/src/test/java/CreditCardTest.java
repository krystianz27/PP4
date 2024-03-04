import org.junit.jupiter.api.Test;
import pl.krystian.creditcard.CreditBelowThresholdException;
import pl.krystian.creditcard.CreditCard;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAssignCredit() {
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
    }

    @Test
    void itAssignCredit2() {
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1500));
        //Assert
        assert BigDecimal.valueOf(1500).equals(card.getBalance());
    }


    @Test
    void itDenyCreditBeLowThreshold(){
        var card = new CreditCard();
        try{
            card.assignCredit(BigDecimal.valueOf(50));
        }
        catch (CreditBelowThresholdException e) {
            assert ture;
        }


    }
}
