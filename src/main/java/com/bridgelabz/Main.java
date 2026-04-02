package com.bridgelabz;

import com.bridgelabz.component.EmployeeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Starting BridgeLabz Spring Boot Application");

        ApplicationContext context = SpringApplication.run(Main.class, args);

        logger.debug("Application context loaded successfully");

        // --- Assignment 1: Dependency Injection Demo ---
        logger.debug("\n*** Dependency Injection Demo ***");

        EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
        employeeBean.setEid(101);
        employeeBean.setEname("Sparsh");
        employeeBean.showEmployeeDetails();

        logger.debug("Dependency Injection Demo complete");
        logger.debug("App is running. Visit http://localhost:8080/hello");
    }
}