package io.community.domain;

/**
 * @author Pierre Thirouin
 */
public class Debt {

    private final String creditor;
    private final String debtor;
    private final double amount;

    public Debt(User creditor, User debtor, Price price) {
        this.creditor = creditor.getName();
        this.debtor = debtor.getName();
        this.amount = price.getAmount();
    }

    public String getCreditor() {
        return creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return debtor + " owe " + amount + " to " + creditor;
    }
}
