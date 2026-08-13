package com.example.expense_tracker.Service;

import com.example.expense_tracker.Exception.ResourceNotFoundException;
import com.example.expense_tracker.Models.CategorySummary;
import com.example.expense_tracker.Models.Expense;
import com.example.expense_tracker.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

//    public Expense getExpense(Long id) {
//        Optional<Expense> optional = expenseRepository.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            return null;
//        }
//    }

    public Expense getExpense(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
    }

    public List<Expense> getExpenseByAmount(BigDecimal amount) {
        return expenseRepository.findExpenseByAmount(amount);
    }

    public Expense putExpense(Long id, Expense expense) {
        Optional<Expense> optional = expenseRepository.findById(id);
        if (optional.isPresent()) {
            Expense existing = optional.get();
            existing.setAmount(expense.getAmount());
            existing.setDate(expense.getDate());
            existing.setDescription(expense.getDescription());
            existing.setCategory(expense.getCategory());
            return expenseRepository.save(existing);
        } else {
            return null;
        }
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
        System.out.println("Deleted expense " + id);
    }

    public List<CategorySummary> getSummary() {
        return expenseRepository.getSummaryByCategory();
    }


}
