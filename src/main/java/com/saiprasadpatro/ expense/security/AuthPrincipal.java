package com.saiprasadpatro.expense.security;

public class AuthPrincipal {
    private Long orgId;
    private String email;

    public AuthPrincipal(Long orgId, String email) {
        this.orgId = orgId; this.email = email;
    }

    public Long getOrgId() { return orgId; }
    public String getEmail() { return email; }
}
