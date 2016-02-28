package io.community.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Pierre Thirouin
 */
public class UserTest {

    @Test
    public void testTotalExpense() {
        User john = new User("John");
        john.addExpense(42d).addExpense(-42d).addExpense(3.14);
        Assertions.assertThat(john.getTotalExpense()).isEqualTo(3.14);

        User bob = new User("Bob");
        Assertions.assertThat(bob.getTotalExpense()).isEqualTo(0);
    }
}
