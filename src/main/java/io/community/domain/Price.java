package io.community.domain;

import javax.persistence.Embeddable;

/**
 * @author Pierre Thirouin
 */
@Embeddable
public class Price {

    private double amount;

    public Price() {}

    public Price(double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%.2f", amount) + "€";
    }
}
