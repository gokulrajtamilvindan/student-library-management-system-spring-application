# Student Library Management System - Spring Boot Application

This project is a **backend application** built using **Spring Boot** for managing a student library system. It handles core functionalities like student management, book management, transactions (issue/return), and more. This backend can be connected to any frontend (like React, Angular, etc.) or used as a REST API service.

## 📌 Features

* Add/update/delete student details
* Add/update/delete books
* Issue and return books
* Track student-book transactions
* Layered architecture using Controller, Service, Repository
* REST APIs using Spring MVC

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL / H2 Database (configurable)
* Lombok
* Maven

## 🗂️ Project Structure

```
student-library-management-system
├── src
│   └── main
│       ├── java
│       │   └── com.example.library
│       │       ├── controller
│       │       ├── service
│       │       ├── repository
│       │       ├── model
│       │       └── StudentLibraryManagementSystemApplication.java
│       └── resources
│           ├── application.properties
│           └── data.sql (if seed data used)
└── pom.xml
```

## ⚙️ Getting Started

### Prerequisites

* Java 17+ (or Java 11+ if your Spring Boot version allows)
* Maven
* MySQL (or use embedded H2)

### Steps to Run

1. Clone the repo:

```bash
git clone https://github.com/gokulrajtamilvindan/student-library-management-system-spring-application.git
cd student-library-management-system-spring-application
```

2. Configure database in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Run the application:

```bash
mvn spring-boot:run
```

4. Access APIs using Postman or connect your frontend to `http://localhost:8080`.

## 🔌 API Endpoints Sample

| Method | Endpoint     | Description      |
| ------ | ------------ | ---------------- |
| GET    | /students    | Get all students |
| POST   | /students    | Add a student    |
| POST   | /books       | Add a book       |
| PUT    | /issue-book  | Issue a book     |
| PUT    | /return-book | Return a book    |

*(Note: Actual endpoints might differ. Check controller classes for exact mappings.)*

## 🙋‍♂️ Author

**Gokulraj Tamilvindan**
📧 Feel free to connect or give suggestions via GitHub!

---

⭐ If you like this project, give it a star!

📌 *This is part of my learning journey in Java Full Stack Development.*
