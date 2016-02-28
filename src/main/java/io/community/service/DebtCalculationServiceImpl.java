package io.community.service;

import io.community.domain.Debt;
import io.community.domain.Price;
import io.community.domain.User;
import io.community.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Thirouin
 */
@Service
class DebtCalculationServiceImpl implements DebtCalculationService {

    private final UserRepository repository;

    @Autowired
    public DebtCalculationServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Debt> computeDebts() {
        List<User> users = repository.findAll();
        int numberOfUsers = users.size();
        List<Debt> debts = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User userI = users.get(i);
            double debtByUserI = getDebtByUser(userI, numberOfUsers);

            for (int j = i + 1; j < users.size(); j++) {
                User userJ = users.get(j);
                double debtByUserJ = getDebtByUser(userJ, numberOfUsers);

                if (debtByUserI < debtByUserJ) {
                    debts.add(new Debt(userJ,userI, new Price(debtByUserJ - debtByUserI)));
                } else if (debtByUserI > debtByUserJ) {
                    debts.add(new Debt(userI,userJ, new Price(debtByUserI - debtByUserJ)));
                }
            }
        }
        return debts;
    }

    private double getDebtByUser(User user, int numberOfUsers) {
        return user.getTotalExpense() / numberOfUsers;
    }
}
