package io.community.domain;

/**
 * @author Pierre Thirouin
 */
public class Debt {

    private final User creditor;
    private final User debtor;
    private final Price price;

    public Debt(User creditor, User debtor, Price price) {
        this.creditor = creditor;
        this.debtor = debtor;
        this.price = price;
    }

    public User getCreditor() {
        return creditor;
    }

    public User getDebtor() {
        return debtor;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return debtor + " owe " + price + " to " + creditor;
    }
}
