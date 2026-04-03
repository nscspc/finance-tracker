Finance Tracker API

A Spring Boot REST API for managing financial records such as income and expenses.
The application provides endpoints for creating, updating, deleting, and analyzing financial data with role-based access control and interactive API documentation.

Features
Create and manage financial records
Track income and expenses
Filter records by category and type
Dashboard analytics
Total income
Total expenses
Net balance
Category-wise summary
Monthly trends
Role-based access control (ADMIN, ANALYST, VIEWER)
Input validation using Jakarta Validation
Interactive API documentation using Swagger
Containerized deployment using Docker
Tech Stack
Java 17
Spring Boot
Spring Security
Spring Data JPA
H2 In-Memory Database
Swagger (OpenAPI)
Docker
Maven
Project Structure
src/main/java/com/example/finance
│
├── controller       # REST Controllers
├── service          # Business Logic
├── repository       # Data Access Layer
├── entity           # Database Entities
├── dto              # Request/Response DTOs
├── mapper           # DTO ↔ Entity Mapping
├── config           # Security and application configuration
└── enums            # Enum definitions

API Documentation

Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html


After deployment:

https://<your-deployment-url>/swagger-ui/index.html


Swagger allows interactive testing of all API endpoints.

Running the Application Locally
1. Clone the repository
git clone https://github.com/nscspc/finance-tracker.git

2. Navigate to the project
cd finance-tracker

3. Build the project
mvn clean install

4. Run the application
mvn spring-boot:run


The application will start on:

http://localhost:8080

H2 Database Console

The H2 console can be accessed at:

http://localhost:8080/h2-console


Default configuration:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password:

Running with Docker
Build Docker Image
docker build -t finance-tracker .

Run Container
docker run -p 8080:8080 finance-tracker

Example API Endpoints
Create Record
POST /records

Get All Records
GET /records

Update Record
PUT /records/{id}

Delete Record
DELETE /records/{id}

Dashboard Summary
GET /dashboard/summary

Category Summary
GET /dashboard/category-summary

Monthly Trends
GET /dashboard/monthly-trends

Roles
Role	Access
ADMIN	Full access
ANALYST	Analytics and record viewing
VIEWER	Read-only access
Known Limitations
Uses H2 in-memory database, so data resets when the application restarts.
Authentication uses basic role-based security instead of JWT.
Pagination and advanced filtering can be added for large datasets.
Future Improvements
JWT-based authentication
Pagination and sorting
Global exception handling
Integration tests
PostgreSQL or production-grade database
CI/CD pipeline
