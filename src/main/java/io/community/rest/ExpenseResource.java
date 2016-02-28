package io.community.rest;

import io.community.domain.Expense;
import org.springframework.hateoas.ResourceSupport;

import java.time.format.DateTimeFormatter;

/**
 * @author Pierre Thirouin
 */
public class ExpenseResource extends ResourceSupport {

    private String userName;
    private double priceAmount;
    private String dateTime;

    public ExpenseResource() {
    }

    public ExpenseResource(Expense expense) {
        this.userName = expense.getUser().getName();
        this.priceAmount = expense.getPrice().getAmount();
        this.dateTime = expense.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(double priceAmount) {
        this.priceAmount = priceAmount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
