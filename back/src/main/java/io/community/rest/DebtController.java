package io.community.rest;

import io.community.domain.Debt;
import io.community.service.DebtCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Pierre Thirouin
 */
@RestController
public class DebtController {

    @Autowired
    private DebtCalculationService debtCalculationServiceImpl;

    @Transactional(readOnly = true)
    @RequestMapping(value = "/api/debts", method = GET)
    public List<Debt> getDebts() {
        return debtCalculationServiceImpl.computeDebts();
    }
}
