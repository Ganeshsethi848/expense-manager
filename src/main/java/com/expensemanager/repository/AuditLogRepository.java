package com.expensemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expensemanager.entity.AuditLog;
import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByOrganizationId(Long organizationId);
}