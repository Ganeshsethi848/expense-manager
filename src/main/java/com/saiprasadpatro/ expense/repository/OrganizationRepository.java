package com.saiprasadpatro.expense.repository;

import com.saiprasadpatro.expense.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> { }
