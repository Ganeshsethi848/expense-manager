package com.saiprasadpatro.expense.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"org_id", "email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "org_id", nullable = false)
    private Long orgId;
    private String email;
    private String passwordHash;
    private String fullName;
    private String role; // ROLE_USER, ROLE_MANAGER, ROLE_ADMIN
    private Instant createdAt = Instant.now();

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrgId() { return orgId; }
    public void setOrgId(Long orgId) { this.orgId = orgId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
