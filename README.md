# Student Management API (DevOps Midterm Project)

**Author:** Alinur Takhyrov  
**Student ID:** 38110  
**GitHub:** [defnotslim34](https://github.com/defnotslim34)  
**Repository:** `takhyrov-alinur-student-api`  

---

## рџ“Њ Project Overview
`takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application created by Alinur Takhyrov (Student ID: 38110) combining robust production architecture (PostgreSQL persistence, multi-stage Docker builds, Jenkins CI/CD automation) with comprehensive API documentation and testing standards.

---

## рџЏ— Project Architecture & Structure

```text
takhyrov-alinur-student-api/
в”њв”Ђв”Ђ scripts/
в”‚   в””в”Ђв”Ђ Takhyrov_Alinur_system_report.sh    # System monitoring & audit script
в”њв”Ђв”Ђ logs/
в”‚   в”њв”Ђв”Ђ Takhyrov_Alinur_system_report.log   # System monitoring output logs
в”‚   в””в”Ђв”Ђ Takhyrov_Alinur_log_analysis.txt    # Log search & analysis output
в”њв”Ђв”Ђ backups/
в”‚   в””в”Ђв”Ђ Takhyrov_Alinur_README_backup.md    # Backup archive of documentation
в”њв”Ђв”Ђ src/
в”‚   в”њв”Ђв”Ђ main/
в”‚   в”‚   в”њв”Ђв”Ђ java/com/alinur/studentapi/
в”‚   в”‚   в”‚   в”њв”Ђв”Ђ controller/                 # REST Controller endpoints
в”‚   в”‚   в”‚   в”њв”Ђв”Ђ model/                      # JPA Entities & DTOs
в”‚   в”‚   в”‚   в”њв”Ђв”Ђ repository/                 # Spring Data JPA Repository
в”‚   в”‚   в”‚   в”њв”Ђв”Ђ service/                    # Business logic layer
в”‚   в”‚   в”‚   в”њв”Ђв”Ђ exception/                  # Error handling & custom exceptions
в”‚   в”‚   в”‚   в””в”Ђв”Ђ StudentApiApplication.java  # Main application entry point
в”‚   в”‚   в””в”Ђв”Ђ resources/
в”‚   в”‚       в””в”Ђв”Ђ application.properties      # PostgreSQL datasource & JPA configs
в”‚   в””в”Ђв”Ђ test/                               # JUnit 5 & MockMvc automated tests
в”њв”Ђв”Ђ Dockerfile                              # Multi-stage production container build
в”њв”Ђв”Ђ docker-compose.yml                      # App + PostgreSQL container orchestration
в”њв”Ђв”Ђ Jenkinsfile                             # Multi-stage Declarative CI/CD pipeline
в”њв”Ђв”Ђ build.gradle                            # Gradle dependencies & build plugins
в”њв”Ђв”Ђ settings.gradle                         # Gradle project definitions
в”њв”Ђв”Ђ .gitignore                              # Git exclusion rules
в””в”Ђв”Ђ README.md                               # Project documentation
```

---

## рџљЂ REST API Endpoints

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

## рџ›  Prerequisites & Technologies
- **Java:** JDK 17 (Eclipse Temurin / OpenJDK)
- **Build Tool:** Gradle 8.x
- **Framework:** Spring Boot 3.2.x (Spring Web, Spring Data JPA, Validation)
- **Database:** PostgreSQL 16 (Alpine)
- **Containerization:** Docker & Docker Compose
- **CI/CD Automation:** Jenkins (Declarative Pipeline)
- **Scripting & VCS:** Bash, Git, GitHub

---

## рџЊџ Feature Highlight (Branch: `feature/takhyrov-alinur-crud`)
- **Developer:** Alinur Takhyrov (ID: 38110)
- **Implemented Feature:** Added `/api/students/honor-roll` endpoint with filtering query parameter (`minGpa`, default `3.5`). Automatically filters students who qualified for Dean's List and orders them in descending order of GPA.

