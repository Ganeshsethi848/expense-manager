package com.saiprasadpatro.expense.controller;

import com.saiprasadpatro.expense.security.AuthPrincipal;
import com.saiprasadpatro.expense.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ExpenseService expenseService;

    public ReportController(ExpenseService expenseService) { this.expenseService = expenseService; }

    @GetMapping("/monthly")
    public ResponseEntity<List<Map<String,Object>>> monthly(Authentication auth, @RequestParam int month, @RequestParam int year) {
        AuthPrincipal p = (AuthPrincipal) auth.getPrincipal();
        // For brevity return a simple aggregation placeholder
        return ResponseEntity.ok(List.of(Map.of("month", month, "year", year)));
    }
}
