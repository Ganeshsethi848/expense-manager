package com.saiprasadpatro.expense.repository;

import com.saiprasadpatro.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByOrgId(Long orgId);
    List<Expense> findByOrgIdAndUserId(Long orgId, Long userId);
}
