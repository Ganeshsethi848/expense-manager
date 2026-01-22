package com.saiprasadpatro.expense.repository;

import com.saiprasadpatro.expense.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> { }
