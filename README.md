# Car Management System

The **Car Management System** is a Spring Boot application designed to manage a car inventory system. It supports functionalities like viewing available cars, adding, editing, deleting cars, and sorting through various parameters. This guide includes instructions for deploying the backend and frontend on [Railway](https://railway.app/) without Docker.

---

## Features

- **Car Inventory Management**:
  - Add, update, and delete car entries.
- **Search and Sorting**:
  - Search cars by name or other attributes.
  - Sort cars by price, model, year, and more.
- **Pagination**:
  - Easily navigate through large datasets.
- **RESTful API**:
  - Backend exposes APIs for CRUD operations.

---

## Technologies Used

- **Backend**: Spring Boot, Spring MVC, Spring Data JPA, H2 Database
- **Frontend**: Thymeleaf, Bootstrap
- **Build Tool**: Maven
- **Deployment**: Railway

---

# API Endpoints

The Car Management System provides the following endpoints to manage cars:

| **Method** | **Endpoint**        | **Description**               |
|------------|---------------------|-------------------------------|
| `GET`      | `/available_cars`   | Get all available cars        |
| `POST`     | `/car_register`     | Add a new car                 |
| `PUT`      | `/editCar/{id}`     | Update an existing car        |
| `DELETE`   | `/deleteCar/{id}`   | Delete a car by ID            |


---

## Prerequisites

Before running the application, ensure you have the following installed:

- [Java 21](https://openjdk.org/projects/jdk/21/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/Sankhajit3/car_management.git
cd car_management
 
