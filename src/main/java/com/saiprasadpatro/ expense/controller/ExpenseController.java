package com.saiprasadpatro.expense.controller;

import com.saiprasadpatro.expense.model.Expense;
import com.saiprasadpatro.expense.model.Approval;
import com.saiprasadpatro.expense.security.AuthPrincipal;
import com.saiprasadpatro.expense.service.ExpenseService;
import com.saiprasadpatro.expense.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final NotificationService notificationService;

    public ExpenseController(ExpenseService expenseService, NotificationService notificationService) {
        this.expenseService = expenseService; this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody Expense expense, Authentication auth) {
        AuthPrincipal p = (AuthPrincipal) auth.getPrincipal();
        expense.setOrgId(p.getOrgId());
        // In a real app ensure userId matches authenticated user
        Expense created = expenseService.create(expense);
        return ResponseEntity.created(URI.create("/api/expenses/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> list(Authentication auth) {
        AuthPrincipal p = (AuthPrincipal) auth.getPrincipal();
        return ResponseEntity.ok(expenseService.findByOrg(p.getOrgId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> get(@PathVariable Long id, Authentication auth) {
        return expenseService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<Expense> submit(@PathVariable Long id, Authentication auth) {
        Expense e = expenseService.submit(id);
        return ResponseEntity.ok(e);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Approval> approve(@PathVariable Long id, @RequestBody(required=false) Map<String,String> body, Authentication auth) {
        AuthPrincipal p = (AuthPrincipal) auth.getPrincipal();
        String note = body != null ? body.get("note") : null;
        Approval a = expenseService.approve(id, /*approverId*/0L, note);
        // send notification (email/webhook) - simplified
        notificationService.sendApprovalEmail(null, "Expense approved", "Expense "+id+" approved");
        return ResponseEntity.ok(a);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importCsv(@RequestParam("file") MultipartFile file, Authentication auth) {
        // simple synchronous CSV parser: each line -> Expense
        // for brevity not fully implemented
        return ResponseEntity.ok("imported");
    }
}
