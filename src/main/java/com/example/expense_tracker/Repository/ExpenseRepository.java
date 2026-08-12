package com.example.expense_tracker.Repository;

import com.example.expense_tracker.Models.CategorySummary;
import com.example.expense_tracker.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query(value = "SELECT * FROM Expense WHERE amount > :amount", nativeQuery = true)
    List<Expense> findExpenseByAmount(BigDecimal amount);

    @Query(value = "SELECT c.name AS categoryName, SUM(e.amount) AS total " +
            "FROM expense e JOIN category c ON e.category_id = c.id " +
            "GROUP BY c.name", nativeQuery = true)
    List<CategorySummary> getSummaryByCategory();
}
