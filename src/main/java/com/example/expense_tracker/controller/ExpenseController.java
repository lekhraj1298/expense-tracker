package com.example.expense_tracker.controller;

import com.example.expense_tracker.Models.Expense;
import com.example.expense_tracker.Service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService= expenseService;
    }
    @PostMapping("/save")
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.saveExpense(expense));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable ("id") Long id){
        return  ResponseEntity.ok().body(expenseService.getExpense(id));
    }

    @GetMapping("/sql")
    public ResponseEntity<List<Expense>> getExpenseByAmount(@RequestParam("amount")BigDecimal amount){
        List<Expense> expenseList = expenseService.getExpenseByAmount(amount);
        return ResponseEntity.ok().body(expenseList);
    }
}
