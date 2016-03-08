package io.community.service;

import io.community.domain.Debt;

import java.util.List;

/**
 * @author Pierre Thirouin
 */
public interface DebtCalculationService {
    List<Debt> computeDebts();
}
