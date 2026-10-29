# Student Management API (DevOps Midterm Project)

**Author:** Alinur Takhyrov  
**Student ID:** 38110  
**GitHub:** [defnotslim34](https://github.com/defnotslim34)  
**Repository:** `takhyrov-alinur-student-api`  

---

## 📌 Project Overview
`takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application built with Java 17, Gradle, PostgreSQL, Docker, Docker Compose, and Jenkins CI/CD pipeline automation. It implements comprehensive CRUD operations for student entities, health checks, centralized exception handling, automated unit/integration tests, and Linux administrative monitoring utilities.

---

## 🏗 Project Architecture & Structure

```text
takhyrov-alinur-student-api/
├── scripts/
│   └── Takhyrov_Alinur_system_report.sh    # System monitoring & audit script
├── logs/
│   ├── Takhyrov_Alinur_system_report.log   # System monitoring output logs
│   └── Takhyrov_Alinur_log_analysis.txt    # Log search & analysis output
├── backups/
│   └── Takhyrov_Alinur_README_backup.md    # Backup archive of documentation
├── src/
│   ├── main/
│   │   ├── java/com/alinur/studentapi/
│   │   │   ├── controller/                 # REST Controller endpoints
│   │   │   ├── model/                      # JPA Entities & DTOs
│   │   │   ├── repository/                 # Spring Data JPA Repository
│   │   │   ├── service/                    # Business logic layer
│   │   │   ├── exception/                  # Error handling & custom exceptions
│   │   │   └── StudentApiApplication.java  # Main application entry point
│   │   └── resources/
│   │       └── application.properties      # PostgreSQL datasource & JPA configs
│   └── test/                               # JUnit 5 & MockMvc automated tests
├── Dockerfile                              # Multi-stage production container build
├── docker-compose.yml                      # App + PostgreSQL container orchestration
├── Jenkinsfile                             # Multi-stage Declarative CI/CD pipeline
├── build.gradle                            # Gradle dependencies & build plugins
├── settings.gradle                         # Gradle project definitions
├── .gitignore                              # Git exclusion rules
└── README.md                               # Project documentation
```

---

## 🚀 REST API Endpoints

Base URL: `http://localhost:8080/api/students`

| Method | Endpoint | Description | Status Code |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/students` | Create a new student record | `201 Created` |
| `GET` | `/api/students` | Retrieve all student records | `200 OK` |
| `GET` | `/api/students/{id}` | Retrieve single student by ID | `200 OK` / `404 Not Found` |
| `PUT` | `/api/students/{id}` | Update existing student record | `200 OK` / `404 Not Found` |
| `DELETE` | `/api/students/{id}` | Delete student record | `204 No Content` / `404 Not Found` |
| `GET` | `/api/students/search` | Search students by email or major | `200 OK` |
| `GET` | `/api/students/honor-roll` | Retrieve honor roll students (GPA >= 3.5) by Alinur Takhyrov | `200 OK` |
| `GET` | `/api/students/info` | Developer & student verification metadata | `200 OK` |
| `GET` | `/api/students/health` | Service health status check | `200 OK` |

---

## 🛠 Prerequisites & Technologies
- **Java:** JDK 17 (Eclipse Temurin / OpenJDK)
- **Build Tool:** Gradle 8.x
- **Framework:** Spring Boot 3.2.x (Spring Web, Spring Data JPA, Validation)
- **Database:** PostgreSQL 16 (Alpine)
- **Containerization:** Docker & Docker Compose
- **CI/CD Automation:** Jenkins (Declarative Pipeline)
- **Scripting & VCS:** Bash, Git, GitHub

---

## 🌟 Feature Highlight (Branch: `feature/takhyrov-alinur-crud`)
- **Developer:** Alinur Takhyrov (ID: 38110)
- **Implemented Feature:** Added `/api/students/honor-roll` endpoint with filtering query parameter (`minGpa`, default `3.5`). Automatically filters students who qualified for Dean's List and orders them in descending order of GPA.

