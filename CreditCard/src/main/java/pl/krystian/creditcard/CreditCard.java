package pl.krystian.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;
    private BigDecimal balance;


    public BigDecimal getBalance() {return balance;}


    private boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }


    public void assignCredit(BigDecimal creditLimit) {
        if(isCreditAlreadyAssigned()) {
            throw new CreditCantBeReassignedException();
        }

        if (isCreditBelowThreshold(creditLimit)){
            throw new CreditBelowThresholdException();
        }
        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }


    public void pay(BigDecimal money) {
        if (canAfford(money)) {
            throw new NotEnoughMoneyException();
        }
        this.balance = this.balance.subtract(money);
    }

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) < 0;
    }
}
