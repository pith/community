package io.community.rest;

import io.community.domain.Expense;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;

/**
 * @author Pierre Thirouin
 */
public class ExpenseResource extends ResourceSupport {

    @NotNull
    private String user;
    @NotNull
    private Double amount;
    private String dateTime;

    public ExpenseResource() {
    }

    public ExpenseResource(Expense expense) {
        this.user = expense.getUser().getName();
        this.amount = expense.getPrice().getAmount();
        this.dateTime = expense.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
