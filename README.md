# TaskFlow – Java Task Manager with MySQL

This project is a simple task management system built in Java, using:

- MySQL for data persistence  
- DAO pattern for database operations  
- Vector for in-memory task handling  
- Layered project structure (app, entities, dao, services)

The system allows users to register, log in, and manage tasks stored in a relational database.

---

## Features
- User registration  
- User login  
- Add tasks  
- List tasks by user  
- MySQL integration  
- Clean and organized codebase  

---

## Database Structure

Create the database:

```sql
CREATE DATABASE taskflow;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
Requirements

Java 17+

MySQL installed

MySQL Workbench

IntelliJ IDEA (recommended)

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

private static final String URL = "jdbc:mysql://localhost:3306/taskflow";
private static final String USER = "root";
private static final String PASS = "your_password";
