package io.community.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Pierre Thirouin
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    private LocalDateTime dateTime;
    @NotNull
    @Embedded
    private Price price;

    public Expense() {
    }

    Expense(User user, Price price, LocalDateTime dateTime) {
        this.user = user;
        this.dateTime = dateTime;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Price getPrice() {
        return price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
