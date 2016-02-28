package io.community.rest;

import io.community.domain.ExpenseRepository;
import io.community.domain.User;
import io.community.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Pierre Thirouin
 */
@RestController
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @ResponseBody
    @RequestMapping(value = "/api/expenses", method = GET)
    public List<ExpenseResource> getAll() {
        return expenseRepository.findAll().stream()
                .map(ExpenseResource::new)
                .collect(toList());
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/api/expenses", method = POST)
    public void create(ExpenseResource expenseDTO) {
        User user = userRepository.findByName(expenseDTO.getUserName());
        user.addExpense(expenseDTO.getPriceAmount());
        userRepository.save(user);
    }

}
