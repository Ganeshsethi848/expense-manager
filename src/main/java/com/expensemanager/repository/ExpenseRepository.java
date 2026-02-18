package com.expensemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expensemanager.entity.Expense;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
    List<Expense> findByOrganizationId(Long organizationId);
}