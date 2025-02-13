# Online Course Management Platform - Java Challenge
## Overview
This project is a Java-based application designed to manage an online course platform. The application uses Hibernate for Object-Relational Mapping (ORM) to interact with a database containing three main tables: Student, Course, and Enrollment. The application is built using Spring MVC to expose RESTful endpoints for managing students, courses, and enrollments.

## Database Schema
The application uses the following database schema:

1. Table: Student
id (Primary Key, Auto-generated)
name (String)
email (String)
registrationDate (Date)
2. Table: Course
id (Primary Key, Auto-generated)
name (String)
descricao (String)
registrationDate (Date)
3. Table: Enrollment
id (Primary Key, Auto-generated)
student_id (Foreign Key referencing Aluno)
course_id (Foreign Key referencing Curso)
registrationDate (Date)
Relationships
Student and Course have a many-to-many relationship, which is mapped using the Inscricao table.

## Implementation Requirements
1. Controllers and Endpoints
Implement Spring MVC controllers to expose RESTful endpoints that allow:
Registering students and courses.
Enrolling a student in a course.
Listing all courses a student is enrolled in.
Listing all students enrolled in a specific course.

2. Populator and DTO
Create an EnrollmentPopulator to convert Student and Course entities into DTOs (StudentDTO, CourseDTO).
Use DTOs in the Controller to avoid exposing entities directly.

3. Database
Use the H2 database configured with Hibernate for development and testing purposes.
