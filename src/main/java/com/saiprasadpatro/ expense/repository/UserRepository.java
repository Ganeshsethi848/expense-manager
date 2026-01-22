package com.saiprasadpatro.expense.repository;

import com.saiprasadpatro.expense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByOrgIdAndEmail(Long orgId, String email);
}
