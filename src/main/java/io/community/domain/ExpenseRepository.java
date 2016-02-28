package io.community.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Pierre Thirouin
 */
@RepositoryRestResource(exported = false)
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
