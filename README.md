# SMS Student Management System

A Spring Boot-based Student Management System (SMS) for managing student records with CRUD operations. The project is built using Java, Spring Boot, Spring Data JPA, and MySQL.

## Project Overview

This application allows users to:
- Create a new student
- Read all students or a single student by ID
- Update a student's details
- Delete a student
- Store and retrieve records from a MySQL database

The project follows a clean layered architecture with separate packages for:
- Controller
- Service
- Entity
- Repository
- Exception

## Tech Stack

- Java 17+
- Spring Boot 3/4 compatible
- Spring Web
- Spring Data JPA
- MySQL Database
- Lombok
- Gradle

## Project Structure

```text
sms/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── sms/
│   │   │               ├── controller/
│   │   │               │   └── StudentController.java
│   │   │               ├── entity/
│   │   │               │   └── Student.java
│   │   │               ├── exception/
│   │   │               │   └── ResourceNotFoundException.java
│   │   │               ├── repository/
│   │   │               │   └── StudentRepository.java
│   │   │               ├── service/
│   │   │               │   ├── StudentService.java
│   │   │               │   └── StudentServiceImpl.java
│   │   │               └── SmsApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── sms/
│                       └── controller/
│                           └── StudentControllerTest.java
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
├── README.md
└── HELP.md
```

## Application Workflow

### 1. User Request
The client sends an HTTP request to the application, such as:
- Create student
- Get all students
- Get student by ID
- Update student
- Delete student

### 2. Controller Layer
The controller receives the request and maps it to the correct endpoint.

Example endpoints:

```http
GET /api/students
GET /api/students/1
POST /api/students
PUT /api/students/1
DELETE /api/students/1
```

### 3. Service Layer
The service contains business logic. It validates the request and performs operations such as:
- saving a student
- fetching all students
- fetching a single student
- updating details
- deleting a student

### 4. Repository Layer
The repository uses Spring Data JPA to interact with the MySQL database. It extends `JpaRepository`, which provides built-in CRUD methods.

### 5. Database Layer
The `Student` entity is mapped to the `students` table in MySQL.

## Entity Details

The `Student` entity includes:
- `id`
- `firstName`
- `lastName`
- `email`
- `age`

Example:

```java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
```

## Database Configuration

Set up MySQL and configure the database in `src/main/resources/application.properties`:

```properties
spring.application.name=sms

spring.datasource.url=jdbc:mysql://localhost:3306/sms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### MySQL setup steps
1. Install MySQL
2. Create a database named `sms`
3. Update the username and password if needed
4. Run the Spring Boot project

## Running the Project

From the project root, run:

```bash
./gradlew bootRun
```

On Windows:

```bash
gradlew.bat bootRun
```

## Testing

Run tests with:

```bash
./gradlew test
```

On Windows:

```bash
gradlew.bat test
```

## API Example Requests

### Create Student

```http
POST /api/students
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "age": 21
}
```

### Get All Students

```http
GET /api/students
```

### Get Single Student

```http
GET /api/students/1
```

### Update Student

```http
PUT /api/students/1
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Smith",
  "email": "john.smith@example.com",
  "age": 22
}
```

### Delete Student

```http
DELETE /api/students/1
```

## Notes

- The app is designed for a simple student record management use case.
- It can be extended with features like course enrollment, attendance, fees, and authentication.
- The service layer keeps the logic separate from controller and database code.

## Future Enhancements

- Add login and role-based access
- Add student image upload
- Add search and filter features
- Add pagination
- Add validation and exception handling
- Add Swagger documentation

## Contributors

This project is a beginner-friendly Spring Boot CRUD application for learning backend development and database integration.
