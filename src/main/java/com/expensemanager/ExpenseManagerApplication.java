package com.expensemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.expensemanager"})
public class ExpenseManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExpenseManagerApplication.class, args);
    }
}