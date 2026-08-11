package com.example.expense_tracker.Service;

import com.example.expense_tracker.Models.Expense;
import com.example.expense_tracker.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense){
       return expenseRepository.save(expense);
    }

    public Expense getExpense(Long id){
        Optional<Expense> optional = expenseRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        } else {
            return null;
        }
    }

    public List<Expense> getExpenseByAmount(BigDecimal amount){
        return expenseRepository.findExpenseByAmount(amount);
    }
}
