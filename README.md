# WeeklyTest


## Table of Contents

- [Project Overview](#project-overview)
- [Frameworks and Language Used](#frameworks-and-language-used)
- [Data Flow](#data-flow)
    - [Controller](#controller)
    - [Services](#services)
    - [Repository](#repository)
- [Database Design](#database-design)
- [Data Structures](#data-structures)
- [Project Summary](#project-summary)

## Project Overview

This project is a Spring Boot-based RESTful API that interacts with a MySQL database. It provides CRUD (Create, Read, Update, Delete) operations for managing addresses. The API allows you to create, retrieve, update, and delete address records.

## Frameworks and Language Used

- Framework: Spring Boot
- Language: Java

## Data Flow

### Controller

- The controller classes (`AddressController`) handle HTTP requests and route them to the appropriate service.
- Endpoints include:
  - Create Address (POST): `/addresses`
  - Retrieve Address by ID (GET): `/addresses/{addressId}`
  - Retrieve All Addresses (GET): `/addresses`
  - Update Address by ID (PUT): `/addresses/{addressId}`
  - Delete Address by ID (DELETE): `/addresses/{addressId}`

### Services

- The service classes (`AddressService`) contain the business logic for the application.
- They communicate with the repository to perform database operations.
- Error handling and validation are handled in these services.

### Repository

- The repository (`AddressRepository`) interfaces with the MySQL database.
- It provides CRUD operations through Spring Data JPA.
- Entity classes map to database tables, and JPA annotations define the relationships between entities.

## Database Design

- The project uses a MySQL database with a simple schema.
- The primary entity in this project is the `Address` entity, which represents address information.
- Additional database design details can be found in the entity classes.

## Data Structures

- Data structures used in this project include:
  - Java objects representing entities (e.g., `Address`)
  - Data transfer objects (DTOs) for request and response handling
  - Java collections for managing lists of entities and DTOs

## Project Summary

This Spring Boot application showcases the development of a RESTful API with MySQL database integration. It offers a basic example of a RESTful service that performs CRUD operations on address records. You can use this project as a reference for building more complex APIs or extend it to suit your requirements.
