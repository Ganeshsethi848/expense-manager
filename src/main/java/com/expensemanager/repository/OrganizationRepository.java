package com.expensemanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.expensemanager.entity.Organization;
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}