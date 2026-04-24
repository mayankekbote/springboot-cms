# Customer Management System (CMS)

A simple RESTful web service built with Spring Boot for managing customer information.

## Overview

This application provides a basic Customer Management System with CRUD operations for customer entities. It uses an in-memory H2 database for data persistence and exposes REST APIs for client interactions.

## Technologies Used

- **Java 21**
- **Spring Boot 3.5.14**
- **Spring Data JPA** for ORM
- **Spring Web** for REST APIs
- **H2 Database** (in-memory)
- **Maven** for build management

## Features

- Create, Read, Update, and Delete customer records
- Unique email constraint for customers
- RESTful API endpoints
- H2 database console for data inspection

## Prerequisites

- Java 21 or higher
- Maven 3.6+ (or use the included Maven wrapper)

## Getting Started

### Clone the Repository

```bash
git clone <repository-url>
cd cms
```

### Run the Application

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or with Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/customers` | Retrieve all customers |
| GET | `/api/customers/{id}` | Retrieve a customer by ID |
| POST | `/api/customers` | Create a new customer |
| PUT | `/api/customers/{id}` | Update an existing customer |
| DELETE | `/api/customers/{id}` | Delete a customer by ID |

### Sample Customer JSON

```json
{
  "firstName": "Rahul",
  "lastName": "Sharma",
  "email": "rahul.sharma@example.com",
  "phoneNumber": "+919876543210"
}
```

## Database

The application uses an in-memory H2 database. You can access the H2 console at:

`http://localhost:8080/h2-console`

- **JDBC URL**: `jdbc:h2:mem:cms_db`
- **Username**: sa
- **Password**: (leave blank)

**Note**: The database is reset on every application restart. Dummy customer data will be re-inserted each time if you have a `data.sql` file.

## Project Structure

```
src/
├── main/
│   ├── java/com/bank/app/
│   │   ├── CmsApplication.java          # Main application class
│   │   ├── controllers/
│   │   │   └── CustomerController.java  # REST API endpoints
│   │   ├── models/
│   │   │   └── Customer.java            # Customer entity
│   │   ├── repository/
│   │   │   └── CustomerRepository.java  # Data access layer
│   │   └── services/
│   │       ├── CustomerService.java     # Service interface
│   │       └── CustomerServiceImpl.java # Service implementation
│   └── resources/
│       ├── application.properties       # Application configuration
│       |-- data.sql                          # Optional: SQL script to initialize the database with dummy data
└── test/
    └── java/com/bank/app/
        └── CmsApplicationTests.java     # Unit tests
```
