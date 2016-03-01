package io.community.service;

import com.google.common.collect.Lists;
import io.community.domain.Debt;
import io.community.domain.User;
import io.community.domain.UserRepository;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Thirouin
 */
@RunWith(JMockit.class)
public class DebtCalculationServiceImplTest {

    private DebtCalculationService debtCalculationServiceImpl;

    @Mocked
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        debtCalculationServiceImpl = new DebtCalculationServiceImpl(repository);
    }

    @Test
    public void testComputeNotNull() {
        List<Debt> debts = debtCalculationServiceImpl.computeDebts();
        Assertions.assertThat(debts).isNotNull();
    }

    @Test
    public void testCompute() {
        givenUsers(Lists.newArrayList(
                new User("Alice").addExpense(3d),
                new User("Bob").addExpense(6d),
                new User("Charlie").addExpense(9d)
        ));

        List<Debt> debts = debtCalculationServiceImpl.computeDebts();

        Assertions.assertThat(debts).hasSize(3);
        assertDebt(debts.get(0), "Alice", 1d, "Bob");
        assertDebt(debts.get(1), "Alice", 2d, "Charlie");
        assertDebt(debts.get(2), "Bob", 1d, "Charlie");
    }

    private void givenUsers(final List<User> users) {
        new Expectations() {{
           repository.findAll(); result = users;
        }};
    }

    private void assertDebt(Debt debt, String debtor, double amount, String creditor) {
        Assertions.assertThat(debt.getDebtor()).isEqualTo(debtor);
        Assertions.assertThat(debt.getCreditor()).isEqualTo(creditor);
        Assertions.assertThat(debt.getAmount()).isEqualTo(amount);
    }

    @Test
    public void testComputeWithZeroExpense() {
        givenUsers(Lists.newArrayList(
                new User("Alice").addExpense(3d),
                new User("Bob").addExpense(0d),
                new User("Charlie").addExpense(9d)
        ));

        List<Debt> debts = debtCalculationServiceImpl.computeDebts();

        Assertions.assertThat(debts).hasSize(3);
        assertDebt(debts.get(0), "Bob", 1d, "Alice");
        assertDebt(debts.get(1), "Alice", 2d, "Charlie");
        assertDebt(debts.get(2), "Bob", 3d, "Charlie");
    }

    @Test
    public void testComputeWithNoUser() {
        givenUsers(new ArrayList<>());

        List<Debt> debts = debtCalculationServiceImpl.computeDebts();

        Assertions.assertThat(debts).hasSize(0);
    }

    @Test
    public void testComputeWithNoExpense() {
        givenUsers(Lists.newArrayList(
                new User("Alice"),
                new User("Bob"),
                new User("Charlie")
        ));

        List<Debt> debts = debtCalculationServiceImpl.computeDebts();

        Assertions.assertThat(debts).hasSize(0);
    }


}
