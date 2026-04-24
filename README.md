Project Overview
This project is a role-based Inventory and Billing Management System developed to streamline product management, user administration, invoice generation, and stock monitoring for retail/business operations. The system is designed using Java, Servlets, JSP, JDBC, and MySQL following the MVC architecture.
It supports three different user roles — Admin, Staff, and Manager — each with specific access permissions to ensure secure and organized workflow management.
The project focuses on maintaining data consistency during billing operations using JDBC transaction management and rollback mechanisms. It also includes stock logging for tracking inventory changes and supports efficient product handling through pagination and search functionality.

Key Features
Admin Module
  - Add, update, and manage products
  - Manage system users (Admin, Staff, Manager)
  - Control user roles and account status
Staff Module
  - View available products
  - Create invoices for customers
  - Automatic stock reduction during billing
  - Stock log creation for every transaction
  - View personal invoice history
Manager Module
  - View sales reports
  - Monitor inventory status
  - Track stock movement logs
  - Read-only access to invoices and analytics

Technical Highlights
  - Role-Based Access Control (RBAC)
  - Session-based Authentication
  - JDBC Transaction Management
  - Rollback Handling for Billing Operations
  - Optimized Relational Database Design (3NF)
  - Stock Audit Logging
  - Pagination and Search Functionality
  - MVC Architecture Implementation

Tech Stack
Backend
  - Java
  - Servlets
  - JDBC
Frontend
  - JSP
  - HTML
  - CSS
  - Bootstrap
Database
  - MySQL
Server & Tools
  - Apache Tomcat
  - Eclipse IDE
  - Git & GitHub

Database Design
The database is designed using normalized relational tables to ensure consistency and scalability.
Main tables include:
  - Users
  - Roles
  - Products
  - Customers
  - Invoices
  - Invoice Items
  - Stock Logs
The system stores current stock in the products table while maintaining complete stock movement history in the stock_log table for auditing and reporting purposes.

Transaction Workflow
During invoice creation:
  - Invoice is created
  - Invoice items are inserted
  - Product stock is reduced
  - Stock log is generated
If any step fails, the transaction is rolled back to maintain database consistency.
This ensures reliable and safe billing operations.

Learning Outcomes
This project helped in gaining practical experience with:
  - Real-world database design
  - Servlet-JSP based web development
  - JDBC transactions and rollback handling
  - Session management and authentication
  - Role-based authorization
  - Inventory and billing workflow design

Conclusion
This project is designed as a mini ERP-style retail management system that goes beyond basic CRUD operations by implementing real business workflows such as transactional billing, stock auditing, and role-based operational control. It provides strong practical exposure to full-stack Java web application development and database-driven system design.
