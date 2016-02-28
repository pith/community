package io.community.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Thirouin
 */
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String name;
    @Column(unique=true)
    private String email;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Expense> expenses = new ArrayList<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User addExpense(Double price) {
        expenses.add(new Expense(this, new Price(price), LocalDateTime.now()));
        return this;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public double getTotalExpense() {
        return expenses.stream()
                .map(expense -> expense.getPrice().getAmount())
                .reduce((e1, e2) -> e1 + e2)
                .orElse(0d);
    }

    @Override
    public String toString() {
        return name;
    }
}
