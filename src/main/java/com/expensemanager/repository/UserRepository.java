package com.expensemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expensemanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for User entity
}