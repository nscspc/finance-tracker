# Finance Tracker API

A **Spring Boot REST API** for managing financial records such as income and expenses.  
The application provides endpoints for creating, updating, deleting, and analyzing financial data with **role-based access control** and **interactive API documentation**.

---

# Features

- Create and manage financial records
- Track **income and expenses**
- Filter records by **category and type**
- Dashboard analytics
  - Total income
  - Total expenses
  - Net balance
  - Category-wise summary
  - Monthly trends
- Role-based access control (**ADMIN, ANALYST, VIEWER**)
- Input validation using **Jakarta Validation**
- Interactive API documentation using **Swagger**
- Containerized deployment using **Docker**

---

# Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 In-Memory Database
- Swagger (OpenAPI)
- Docker
- Maven

---

# Project Structure
```bash
src/main/java/com/example/finance
│
├── controller # REST Controllers
├── service # Business Logic
├── repository # Data Access Layer
├── entity # Database Entities
├── dto # Request/Response DTOs
├── mapper # DTO ↔ Entity Mapping
├── config # Security and application configuration
└── enums # Enum definitions
```

---

# API Documentation

Swagger UI is available at:
https://finance-tracker-backend-mre3.onrender.com/swagger-ui/index.html


Swagger allows interactive testing of all API endpoints.

---

# Running the Application Locally

### 1. Clone the repository
```bash
git clone https://github.com/nscspc/finance-tracker.git
```

### 2. Navigate to the project
```bash
cd finance-tracker
```

### 3. Build the project
```bash
mvn clean install
```

### 4. Run the application
```bash
mvn spring-boot:run
```

The application will start on:

http://localhost:8087

### Use below username and password to access the api's :-
- username : admin
- password : admin123

# Known Limitations
- Uses H2 in-memory database, so data resets when the application restarts.
- Authentication uses basic role-based security instead of JWT.
- Pagination and advanced filtering can be added for large datasets.

# Future Improvements
- JWT-based authentication
- Pagination and sorting
- Global exception handling
- Integration tests
- PostgreSQL or production-grade database
- CI/CD pipeline
