# DevOps Midterm Project: Complete Implementation & Defense Guide

**Student:** Alinur Takhyrov  
**Student ID:** 38110  
**GitHub Username:** [defnotslim34](https://github.com/defnotslim34)  
**Repository Name:** `takhyrov-alinur-student-api`  
**Remote URL:** `https://github.com/defnotslim34/takhyrov-alinur-student-api.git`  
**Docker Image & Tag:** `takhyrov-alinur-student-api:v1.0-takhyrov-alinur`  
**Jenkins Job:** `Takhyrov_Alinur_Student_API`  

---

## 📑 Table of Contents
1. [Part 1 — Linux Administration (Tasks 1.1 - 1.4)](#part-1--linux-administration)
2. [Part 2 — Git & GitHub Workflow (Tasks 2.1 - 2.4)](#part-2--git--github-workflow)
3. [Part 3 — Docker & Docker Compose (Tasks 3.1 - 3.4)](#part-3--docker--docker-compose)
4. [Part 4 — Jenkins CI/CD Pipeline (Tasks 4.1 - 4.4)](#part-4--jenkins-cicd-pipeline)
5. [Part 5 — Comprehensive Defense Q&A (80 Exam Questions)](#part-5--comprehensive-defense-qa)

---

# Part 1 — Linux Administration

### Task 1.1: Project Directory Structure
All directories and files were generated following the individualization rule:
```text
takhyrov-alinur-student-api/
├── scripts/
│   ├── Takhyrov_Alinur_system_report.sh     # System monitoring Bash script
│   └── push_to_github.sh                   # Helper script to sync all branches/tags
├── logs/
│   ├── Takhyrov_Alinur_system_report.log    # Target monitoring output log
│   └── Takhyrov_Alinur_log_analysis.txt     # Extracted log analysis results
├── backups/
│   └── Takhyrov_Alinur_README_backup.md     # Verified backup of project README
├── src/
│   ├── main/
│   │   ├── java/com/alinur/studentapi/
│   │   │   ├── controller/StudentController.java
│   │   │   ├── model/Student.java
│   │   │   ├── repository/StudentRepository.java
│   │   │   ├── service/StudentService.java
│   │   │   ├── exception/GlobalExceptionHandler.java
│   │   │   ├── exception/StudentNotFoundException.java
│   │   │   └── StudentApiApplication.java
│   │   └── resources/application.properties
│   └── test/
│       ├── java/com/alinur/studentapi/StudentApiApplicationTests.java
│       ├── java/com/alinur/studentapi/controller/StudentControllerTest.java
│       └── resources/application.properties
├── gradle/wrapper/
│   └── gradle-wrapper.properties
├── gradlew                                  # Linux Gradle wrapper executable
├── gradlew.bat                              # Windows Gradle wrapper batch script
├── Dockerfile                               # Multi-stage production container build
├── docker-compose.yml                       # Docker Compose specification with PostgreSQL
├── Jenkinsfile                              # Declarative CI/CD pipeline definition
├── build.gradle                             # Gradle dependencies and bootJar config
├── settings.gradle                          # Root project naming
├── .gitignore                               # Git ignore rules for secrets and builds
└── README.md                                # Master project documentation
```

**Commands executed:**
```bash
mkdir -p takhyrov-alinur-student-api/{scripts,logs,backups,src/main/resources,src/test/resources}
touch takhyrov-alinur-student-api/logs/Takhyrov_Alinur_system_report.log
```

---

### Task 1.2: System Monitoring Script
Script file: `scripts/Takhyrov_Alinur_system_report.sh`
- Captures Student Name: **Alinur Takhyrov** and ID: **38110**
- Captures current timestamp, username, kernel, CPU, memory, and disk usage
- Output is displayed on stdout and appended directly to `logs/Takhyrov_Alinur_system_report.log` using `tee -a`.

**Script Execution Command:**
```bash
./scripts/Takhyrov_Alinur_system_report.sh
```

**Sample Output inside `logs/Takhyrov_Alinur_system_report.log`:**
```text
============================================================
               SYSTEM MONITORING REPORT                     
============================================================
Student Full Name : Alinur Takhyrov
Student ID        : 38110
GitHub Nickname   : defnotslim34
Report Generated  : 2026-10-29 23:01:15 UTC
Current Username  : alinur
Hostname          : takhyrov-devops-vm
------------------------------------------------------------
OPERATING SYSTEM & KERNEL:
OS Name           : Ubuntu 22.04.4 LTS (Jammy Jellyfish)
Kernel Version    : 5.15.0-105-generic
Architecture      : x86_64
------------------------------------------------------------
CPU INFORMATION:
Model name        : 12th Gen Intel(R) Core(TM) i7-12700H
CPU(s)            : 16
Thread(s) per core: 2
Core(s) per socket: 14
------------------------------------------------------------
MEMORY INFORMATION:
               total        used        free      shared  buff/cache   available
Mem:            15Gi       3.8Gi       7.2Gi       128Mi       4.0Gi        11Gi
Swap:          4.0Gi          0B       4.0Gi
------------------------------------------------------------
DISK USAGE & AVAILABLE DISK SPACE:
Filesystem      Size  Used Avail Use% Mounted on
/dev/sda1        64G   18G   43G  30% /
Available space on root (/): 43G
============================================================
Report saved to: /home/alinur/takhyrov-alinur-student-api/logs/Takhyrov_Alinur_system_report.log
Status: SUCCESS - Generated by Alinur Takhyrov (ID: 38110)
============================================================
```

---

### Task 1.3: Permissions and Backup
1. **Configuring Permissions:**
   Owner: Read, Write, Execute (`rwx` = 7)  
   Group members: Read-only (`r--` = 4)  
   Others: Read-only (`r--` = 4)  
   ```bash
   chmod 744 scripts/Takhyrov_Alinur_system_report.sh
   # (Or chmod 755 scripts/Takhyrov_Alinur_system_report.sh if group/others need execution permission)
   ls -l scripts/Takhyrov_Alinur_system_report.sh
   # Output: -rwxr--r-- 1 alinur alinur 2640 Oct 29 23:00 scripts/Takhyrov_Alinur_system_report.sh
   ```

2. **Creating Backup:**
   ```bash
   cp README.md backups/Takhyrov_Alinur_README_backup.md
   ls -la backups/
   # Output:
   # -rw-r--r-- 1 alinur alinur 3723 Oct 29 23:00 Takhyrov_Alinur_README_backup.md
   ```

---

### Task 1.4: Process and Log Analysis
1. **Identify Java process:**
   ```bash
   ps aux | grep java
   # OR
   pgrep -fl java
   ```
2. **Display the last 5 lines of personal log:**
   ```bash
   tail -n 5 logs/Takhyrov_Alinur_system_report.log
   ```
3. **Search log for student surname "Takhyrov" and redirect to analysis file:**
   ```bash
   grep "Takhyrov" logs/Takhyrov_Alinur_system_report.log > logs/Takhyrov_Alinur_log_analysis.txt
   cat logs/Takhyrov_Alinur_log_analysis.txt
   ```
   **Output:**
   ```text
   Student Full Name : Alinur Takhyrov
   Hostname          : takhyrov-devops-vm
   Report saved to: /home/alinur/takhyrov-alinur-student-api/logs/Takhyrov_Alinur_system_report.log
   Status: SUCCESS - Generated by Alinur Takhyrov (ID: 38110)
   ```

4. **Difference between `>` and `>>` in Linux:**
   - **`>` (Overwrite Redirection Operator):** Directs standard output to a file. If the destination file already exists, it is **overwritten** (truncated to 0 bytes before writing new data). If it does not exist, it is created.
   - **`>>` (Append Redirection Operator):** Directs standard output to a file and **appends** the output to the end of the file, preserving all existing contents. If the file does not exist, it is created.

---

# Part 2 — Git & GitHub Workflow

### Task 2.1: Repository Initialization
```bash
git init
git config user.name "Alinur Takhyrov"
git config user.email "defnotslim34@users.noreply.github.com"
git branch -M main
git add .
git commit -m "Initial commit: Alinur Takhyrov Student API"
```

---

### Task 2.2: Feature Branching (`feature/takhyrov-alinur-crud`)
1. **Branch creation & checkout:**
   ```bash
   git checkout -b feature/takhyrov-alinur-crud
   ```
2. **Implemented enhanced CRUD operation:** Added `/api/students/honor-roll` endpoint in `StudentRepository.java`, `StudentService.java`, and `StudentController.java` to filter high-achieving students with GPA >= 3.5.
3. **Commit 1:**
   ```bash
   git add src/
   git commit -m "feat(crud): implement honor roll dean list endpoint by Alinur Takhyrov"
   ```
4. **Updated `README.md` and Commit 2:**
   ```bash
   git add README.md
   git commit -m "docs: update README with honor roll documentation by Alinur Takhyrov"
   ```
5. **Merge back to `main`:**
   ```bash
   git checkout main
   git merge --no-ff feature/takhyrov-alinur-crud -m "Merge branch 'feature/takhyrov-alinur-crud' into main by Alinur Takhyrov"
   ```

---

### Task 2.3: Conflict Resolution
1. **Branch creation:**
   ```bash
   git checkout -b feature/takhyrov-alinur-documentation
   ```
2. **Modifying project description line in `README.md` on documentation branch:**
   ```markdown
   `takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application designed by Alinur Takhyrov (Documentation Branch Version - ID: 38110) focusing on detailed API documentation...
   ```
   ```bash
   git add README.md
   git commit -m "docs: enhance project description in documentation branch by Alinur Takhyrov"
   ```
3. **Switch to `main` and modify the identical line:**
   ```bash
   git checkout main
   ```
   ```markdown
   `takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application built by Alinur Takhyrov (Main Branch Production Version - ID: 38110) optimized for high throughput...
   ```
   ```bash
   git add README.md
   git commit -m "docs: update main branch production overview by Alinur Takhyrov"
   ```
4. **Attempt merge to trigger intentional conflict:**
   ```bash
   git merge feature/takhyrov-alinur-documentation
   # Output:
   # Auto-merging README.md
   # CONFLICT (content): Merge conflict in README.md
   # Automatic merge failed; fix conflicts and then commit the result.
   ```
5. **Conflict markers in `README.md`:**
   ```text
   <<<<<<< HEAD
   `takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application built by Alinur Takhyrov (Main Branch Production Version - ID: 38110)...
   =======
   `takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application designed by Alinur Takhyrov (Documentation Branch Version - ID: 38110)...
   >>>>>>> feature/takhyrov-alinur-documentation
   ```
6. **Manual resolution:** Combined both aspects cleanly into a single production summary:
   ```markdown
   `takhyrov-alinur-student-api` is an enterprise-grade RESTful Spring Boot application created by Alinur Takhyrov (Student ID: 38110) combining robust production architecture (PostgreSQL persistence, multi-stage Docker builds, Jenkins CI/CD automation) with comprehensive API documentation and testing standards.
   ```
7. **Staging and committing resolution:**
   ```bash
   git add README.md
   git commit -m "Merge branch 'feature/takhyrov-alinur-documentation' - resolve README conflict by Alinur Takhyrov"
   ```
8. **Final Git History Verification (`git log --graph --oneline --all`):**
   ```text
   * 227199b chore: add automated push helper script by Alinur Takhyrov
   * 6c6fe9f build: add gradle wrapper support by Alinur Takhyrov
   *   601ed28 Merge branch 'feature/takhyrov-alinur-documentation' - resolve README conflict by Alinur Takhyrov
   |\  
   | * 7e49a34 docs: enhance project description in documentation branch by Alinur Takhyrov
   * | 13a93cc docs: update main branch production overview by Alinur Takhyrov
   |/  
   *   b10134b Merge branch 'feature/takhyrov-alinur-crud' into main by Alinur Takhyrov
   |\  
   | * d07d851 docs: update README with honor roll documentation by Alinur Takhyrov
   | * ab5506a feat(crud): implement honor roll dean list endpoint by Alinur Takhyrov
   |/  
   * 543ff74 Initial commit: Alinur Takhyrov Student API
   ```

---

### Task 2.4: Remote Repository, Version Tags & Security
1. **Remote Repository URL:**
   ```bash
   git remote add origin https://github.com/defnotslim34/takhyrov-alinur-student-api.git
   git remote -v
   # Output:
   # origin  https://github.com/defnotslim34/takhyrov-alinur-student-api.git (fetch)
   # origin  https://github.com/defnotslim34/takhyrov-alinur-student-api.git (push)
   ```
2. **Release Tag Creation:**
   ```bash
   git tag -a v1.0-takhyrov-alinur -m "Release v1.0 by Alinur Takhyrov (Student ID: 38110)"
   git tag -l -n
   # Output:
   # v1.0-takhyrov-alinur Release v1.0 by Alinur Takhyrov (Student ID: 38110)
   ```
3. **Pushing code, branches and tags:**
   ```bash
   git push -u origin main
   git push origin feature/takhyrov-alinur-crud
   git push origin feature/takhyrov-alinur-documentation
   git push origin --tags
   ```

4. **Security Justification: Why `.env`, passwords, and DB credentials must NEVER be committed:**
   - **Immutable History & Bot Scraping:** Git tracks every commit historically. Once pushed to GitHub, automated scanners scrape repositories in real-time, stealing exposed database credentials, API keys, and certificates within seconds.
   - **Separation of Code and Configuration:** Violates the 12-Factor App methodology. Code should remain identical across environments, while configurations and secrets vary dynamically between Dev, Staging, and Production.
   - **Best Practice Solution:** Keep sensitive values in `.gitignore`. Inject secrets at runtime using environment variables, Docker secrets, Kubernetes Secrets, or credential stores like HashiCorp Vault or Jenkins Credentials.

---

# Part 3 — Docker & Docker Compose

### Task 3.1: Multi-Stage Dockerfile
- **Build Stage:** `gradle:8.5-jdk17-alpine` compiles `takhyrov-alinur-student-api.jar`.
- **Runtime Stage:** `eclipse-temurin:17-jre-alpine` runs the application as non-root user `takhyrovuser`.
- **Image tag:** `takhyrov-alinur-student-api:v1.0-takhyrov-alinur`.

**Build Command & Size Inspection:**
```bash
docker build -t takhyrov-alinur-student-api:v1.0-takhyrov-alinur .
docker images takhyrov-alinur-student-api:v1.0-takhyrov-alinur
```

---

### Task 3.2 & 3.3: Docker Compose & Container Management
The `docker-compose.yml` configures:
- Service `postgres` with healthcheck `pg_isready -U takhyrov -d studentdb`
- Service `app` depending on `postgres` healthcheck condition
- Dedicated network: `takhyrov-network`
- Persistent volume: `takhyrov-postgres-data`

**Container Operations:**
```bash
# 1. Start services in background
docker compose -p takhyrov-alinur-student-api up -d

# 2. List running containers
docker compose ps

# 3. View application logs
docker compose logs app -f

# 4. Inspect container configuration
docker inspect takhyrov-student-app

# 5. Execute command inside running container
docker exec -it takhyrov-student-app whoami
# Output: takhyrovuser

# 6. Stop and restart application service
docker compose restart app

# 7. Demonstrate database persistence across restarts
docker compose down
docker compose up -d
curl http://localhost:8080/api/students
# Verified: Student records remain intact in takhyrov-postgres-data volume!
```

---

### Task 3.4: Complete CRUD API Verification Suite

#### 1. Developer Verification (`GET /api/students/info`)
```bash
curl -X GET http://localhost:8080/api/students/info
```
**Response (200 OK):**
```json
{
  "studentName": "Alinur Takhyrov",
  "studentId": "38110",
  "github": "defnotslim34",
  "project": "takhyrov-alinur-student-api",
  "version": "1.0.0",
  "status": "ACTIVE"
}
```

#### 2. Create Student with Personal Data (`POST /api/students`)
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "studentIdNumber": "38110",
    "firstName": "Alinur",
    "lastName": "Takhyrov",
    "email": "defnotslim34@student.kz",
    "major": "DevOps & Cloud Engineering",
    "gpa": 3.95
  }'
```
**Response (201 Created):**
```json
{
  "id": 1,
  "studentIdNumber": "38110",
  "firstName": "Alinur",
  "lastName": "Takhyrov",
  "email": "defnotslim34@student.kz",
  "major": "DevOps & Cloud Engineering",
  "gpa": 3.95,
  "createdAt": "2026-10-29T23:05:00",
  "updatedAt": "2026-10-29T23:05:00"
}
```

#### 3. Retrieve All Students (`GET /api/students`)
```bash
curl -X GET http://localhost:8080/api/students
```
**Response (200 OK):**
```json
[
  {
    "id": 1,
    "studentIdNumber": "38110",
    "firstName": "Alinur",
    "lastName": "Takhyrov",
    "email": "defnotslim34@student.kz",
    "major": "DevOps & Cloud Engineering",
    "gpa": 3.95
  }
]
```

#### 4. Retrieve Student by ID (`GET /api/students/1`)
```bash
curl -X GET http://localhost:8080/api/students/1
```
**Response (200 OK):**
```json
{
  "id": 1,
  "studentIdNumber": "38110",
  "firstName": "Alinur",
  "lastName": "Takhyrov",
  "email": "defnotslim34@student.kz",
  "major": "DevOps & Cloud Engineering",
  "gpa": 3.95
}
```

#### 5. Update Student Data (`PUT /api/students/1`)
```bash
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "studentIdNumber": "38110",
    "firstName": "Alinur",
    "lastName": "Takhyrov",
    "email": "defnotslim34@student.kz",
    "major": "Cloud Infrastructure & Platform Engineering",
    "gpa": 4.00
  }'
```
**Response (200 OK):**
```json
{
  "id": 1,
  "studentIdNumber": "38110",
  "firstName": "Alinur",
  "lastName": "Takhyrov",
  "email": "defnotslim34@student.kz",
  "major": "Cloud Infrastructure & Platform Engineering",
  "gpa": 4.00
}
```

#### 6. Request for Nonexistent Student (`GET /api/students/999`)
```bash
curl -i -X GET http://localhost:8080/api/students/999
```
**Response (404 Not Found):**
```json
HTTP/1.1 404 Not Found
Content-Type: application/json

{
  "timestamp": "2026-10-29T23:06:12",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found with ID: 999",
  "author": "Alinur Takhyrov (ID: 38110)"
}
```

#### 7. Delete Student (`DELETE /api/students/1`)
```bash
curl -X DELETE http://localhost:8080/api/students/1
```
**Response (200 OK):**
```json
{
  "message": "Student successfully deleted",
  "id": 1,
  "deletedBy": "Alinur Takhyrov"
}
```

---

# Part 4 — Jenkins CI/CD Pipeline

### Pipeline Architecture & Stages
The declarative `Jenkinsfile` specifies:
1. **Initialize & Banner:** Displays Alinur Takhyrov (ID: 38110) in build logs.
2. **Checkout:** Clones `https://github.com/defnotslim34/takhyrov-alinur-student-api.git`.
3. **Build:** Compiles code via `./gradlew compileJava compileTestJava`.
4. **Test:** Runs unit and MockMvc integration tests via `./gradlew test`. Fails pipeline immediately if any test fails.
5. **Docker Build:** Builds container image `takhyrov-alinur-student-api:v1.0-takhyrov-alinur`.
6. **Verify:** Inspects Docker image metadata and verifies readiness.

### Controlled Error Injection & Troubleshooting (Task 4.3)
1. **Error Injection:** On a test branch, an assertion in `StudentControllerTest.java` was modified from `38110` to `00000`.
2. **Pipeline Failure:** The `Test` stage failed with `AssertionError`. Jenkins stopped execution immediately and marked the build as **FAILED (RED)**, preventing faulty Docker image creation.
3. **Resolution:** Fixed the assertion back to `38110`, pushed to branch, and triggered re-build. The pipeline passed all stages with **SUCCESS (GREEN)**.

### Continuous Integration vs Continuous Delivery vs Continuous Deployment (Task 4.4)
- **Continuous Integration (CI):** Automates code integration, compilation, and testing upon every commit to catch errors early.
- **Continuous Delivery (CD):** Prepares validated code releases automatically and deploys to staging, requiring a manual human sign-off before releasing to production.
- **Continuous Deployment (CD):** Completely eliminates manual approvals; every commit passing the pipeline test suite is deployed directly to production in real-time.

---

# Part 5 — Comprehensive Defense Q&A

Here are the complete answers to all ~80 defense questions:

#### 1. What is Docker, and why is it useful in DevOps?
Docker is an open-source containerization platform that packages applications and all their dependencies, libraries, and runtime configurations into lightweight, standalone units called containers. In DevOps, Docker eliminates the "it works on my machine" problem, guarantees environment consistency across Development, Staging, and Production, accelerates deployment speed, and maximizes server resource efficiency.

#### 2. What does the `git commit` command do?
`git commit` captures a permanent snapshot of the staged changes (staged using `git add`) in the local repository's history, assigning it a unique SHA-1 hash, author metadata, timestamp, and commit message.

#### 3. What is the purpose of the shebang line `#!/bin/bash`?
The shebang (`#!`) tells the Linux kernel which interpreter should execute the script. `#!/bin/bash` instructs the operating system to use the Bash shell located at `/bin/bash` to parse and run the script commands.

#### 4. What is a Jenkinsfile?
A `Jenkinsfile` is a text configuration file written in Groovy syntax (either Declarative or Scripted) stored in the root of a project repository. It defines the entire CI/CD pipeline as code (Pipeline as Code), allowing version control, peer review, and automation of the build, test, and deployment lifecycle.

#### 5. What is the difference between a Docker image and a Docker container?
A **Docker image** is an immutable, read-only template or blueprint containing the OS libraries, runtime, and application code. A **Docker container** is a runnable, live instance of a Docker image with an additional thin read-write layer on top.

#### 6. What is the purpose of the `pwd` command?
`pwd` stands for "Print Working Directory". It outputs the full absolute path of the directory that the terminal session is currently located in.

#### 7. What is Continuous Integration (CI)?
Continuous Integration is a software engineering practice where developers frequently merge their code changes into a central repository. Automated build tools and test suites run on every commit to validate changes, detect regressions early, and maintain a continuously releasable codebase.

#### 8. What is a Git branch, and why do developers use branches?
A Git branch is a lightweight, movable pointer to a specific commit in the repository history. Developers use branches to isolate experimental work, develop new features (`feature/*`), or apply bug fixes without disrupting the stable `main` production codebase.

#### 9. What is the difference between `RUN` and `CMD` in a Dockerfile?
- `RUN` executes during the image build process and commits its results as a new image layer (e.g. installing packages or building code).
- `CMD` specifies the default command executed when a container is started from the image, and can be overridden by docker run arguments.

#### 10. How can you check available disk space in Linux?
Using the `df` command with human-readable formatting: `df -h` or specifically for root: `df -h /`.

#### 11. What is the difference between Git and GitHub?
**Git** is a distributed command-line version control tool installed locally on a computer to track code history. **GitHub** is a cloud-based hosting platform and service built on top of Git that provides remote repository hosting, collaboration tools (Pull Requests, Issue Tracking), and CI/CD automation (GitHub Actions).

#### 12. What is Docker Compose, and why is it useful for this project?
Docker Compose is a tool for defining and orchestrating multi-container Docker applications using a single YAML file (`docker-compose.yml`). In this project, Compose links the Spring Boot REST API service with the PostgreSQL database, configuring environment variables, persistent volumes, dependencies, and networks with a single command (`docker compose up`).

#### 13. What does the `chmod` command do?
`chmod` stands for "change mode". It alters file and directory access permissions (read, write, execute) for the file owner, group members, and others.

#### 14. What is the purpose of the Checkout stage in Jenkins?
The Checkout stage retrieves the latest source code from the configured Version Control System (such as GitHub) into the Jenkins agent's workspace directory so subsequent build and test stages can execute on the updated codebase.

#### 15. What is the difference between `>` and `>>` in Linux?
- `>` is the overwrite redirection operator: it truncates the destination file to 0 bytes and writes new output.
- `>>` is the append redirection operator: it preserves existing contents and appends new lines to the end of the file.

#### 16. What is a merge conflict, and why can it happen?
A merge conflict occurs when Git cannot automatically reconcile differences between two branches being merged. It happens when competing changes are made to the exact same lines of a file or when one branch modifies a file that another branch deleted.

#### 17. What is a Docker volume, and why is it important for PostgreSQL?
A Docker volume is a persistent storage mechanism managed by Docker outside the container's volatile writable layer. It is crucial for databases like PostgreSQL because containers are ephemeral; without a volume, all database records would be permanently lost when the container stops or is recreated.

#### 18. What is the difference between Continuous Delivery and Continuous Deployment?
In **Continuous Delivery**, every validated code change is automatically built, tested, and staged for release, but pushing to production requires a manual human sign-off. In **Continuous Deployment**, every change that passes the automated pipeline tests is deployed directly and automatically to production without manual intervention.

#### 19. How do you make a Bash script executable?
By granting execute permission using `chmod +x script.sh` or `chmod 755 script.sh`.

#### 20. What is the purpose of the `FROM` instruction in a Dockerfile?
`FROM` initializes a new build stage and sets the base image from a public or private container registry upon which all subsequent instructions are built.

#### 21. What is a Jenkins job?
A Jenkins job (or project) is a defined automated process or task configured in Jenkins (such as a Pipeline, Freestyle project, or Multibranch project) that executes a sequence of build, test, and deployment steps.

#### 22. What is the difference between `git fetch` and `git pull`?
`git fetch` downloads commits, files, and refs from the remote repository into your local repository without altering your working directory. `git pull` performs a `git fetch` followed immediately by a `git merge` to integrate the remote changes into your active branch.

#### 23. How can you display the last five lines of a log file?
Using the `tail` command: `tail -n 5 /path/to/logfile.log`.

#### 24. What is a multi-stage Docker build, and what advantage does it provide?
A multi-stage build uses multiple `FROM` instructions in a single `Dockerfile`. It allows copying artifacts (like compiled JAR files) from heavy intermediate build stages into a minimal, lightweight runtime image, drastically reducing the final image size and attack surface.

#### 25. What is the difference between the working directory, staging area, and repository in Git?
- **Working Directory:** The local filesystem where files are actively edited.
- **Staging Area (Index):** The intermediate holding area where changes are prepared and organized using `git add` before committing.
- **Repository (.git):** The permanent database where Git stores snapshots, commit history, and branches.

#### 26. Why should automated tests run before deploying an application?
Running automated tests before deployment verifies application logic, catches regressions, prevents broken builds from reaching staging or production, and ensures system stability and user trust.

#### 27. What information can the `free -h` command provide?
`free -h` displays the total, used, free, shared, buffer/cache, and available physical memory (RAM) and swap memory in human-readable units (GiB, MiB).

#### 28. What is the purpose of the `WORKDIR` instruction in a Dockerfile?
`WORKDIR` sets the active working directory for all subsequent `RUN`, `CMD`, `ENTRYPOINT`, `COPY`, and `ADD` instructions inside the container. If the directory does not exist, Docker creates it automatically.

#### 29. What is the difference between `git merge` and `git rebase`?
`git merge` combines two branches by creating a distinct non-destructive merge commit, preserving the exact chronological history. `git rebase` rewrites history by moving the base of your branch onto the tip of another branch, resulting in a cleaner, linear commit history.

#### 30. How can Jenkins retrieve source code from a private GitHub repository?
By configuring SSH keys or a GitHub Personal Access Token (PAT) inside **Jenkins Credentials** (as Username with Password or Secret Text / SSH Username with private key) and referencing the credential ID in the pipeline checkout stage.

#### 31. What is a Linux process, and how can you list running processes?
A process is an executing instance of a program in memory, managed by the Linux kernel with a unique Process ID (PID). Running processes can be listed with `ps aux`, `ps -ef`, or `top`/`htop`.

#### 32. What is the purpose of the `docker build` command?
`docker build` reads the instructions in a `Dockerfile` and package context to assemble and compile a new Docker image.

#### 33. What is the purpose of a `.gitignore` file?
A `.gitignore` file tells Git which files, file extensions, or directories to deliberately ignore and exclude from tracking (such as compilation outputs, OS temp files, and sensitive `.env` secrets).

#### 34. What is the difference between a Jenkins controller and an agent?
- **Jenkins Controller (Master):** The central server that handles the UI, manages configurations, schedules builds, and orchestrates pipelines.
- **Jenkins Agent (Node):** A worker machine or container that receives job instructions from the controller and executes the actual build and test commands.

#### 35. What is the meaning of the permission mode `755`?
In octal notation:
- Owner = `7` (`rwx`: Read, Write, Execute)
- Group = `5` (`r-x`: Read, Execute)
- Others = `5` (`r-x`: Read, Execute)

#### 36. Why does the Spring Boot container connect to PostgreSQL using the database service name instead of `localhost`?
In Docker, each container has its own isolated network namespace and its own `localhost` (127.0.0.1) loopback interface. When containers share a Docker bridge network, Docker's embedded DNS server automatically resolves service names (like `postgres`) to the database container's internal IP address.

#### 37. What does `git status` display?
`git status` displays the current branch name, whether the branch is up to date with remote, unstaged changes in the working directory, staged changes ready to commit, and untracked files.

#### 38. What is a Jenkins build trigger, and how can a GitHub webhook trigger a pipeline?
A build trigger is a condition or event that starts a Jenkins job. A GitHub webhook is an HTTP POST notification sent by GitHub to Jenkins whenever a repository event (like `git push`) occurs; Jenkins receives the payload and immediately triggers the pipeline.

#### 39. How do you pass arguments to a Bash script?
By typing them after the script name (e.g., `./script.sh arg1 arg2`). Inside the script, arguments are accessed via positional parameters: `$1` for the first argument, `$2` for the second, `$@` for all arguments, and `$#` for the argument count.

#### 40. What is the difference between `COPY` and `ADD` in a Dockerfile?
`COPY` simply duplicates local files and folders from the build context into the container. `ADD` has additional capabilities: it can download files from remote URLs and automatically unpack compressed archives (such as `.tar.gz`). Best practice prefers `COPY` for clarity unless auto-extraction is needed.

#### 41. What is the difference between `docker stop` and `docker rm`?
- `docker stop` sends a `SIGTERM` (and later `SIGKILL`) signal to gracefully stop a running container.
- `docker rm` deletes a stopped container from the host system disk.

#### 42. Why should passwords and `.env` files not be committed to GitHub?
Because Git commit history is permanent and public repositories are crawled by malicious bots. Leaking credentials leads to database compromise, data breaches, unauthorized cloud resource usage, and severe compliance violations.

#### 43. What happens when a Jenkins pipeline stage fails?
By default, the stage throws an error, the pipeline execution aborts immediately, remaining stages are skipped, and the build status is marked as **FAILED** (triggering any `post { failure { ... } }` blocks).

#### 44. How can you list hidden files in a Linux directory?
Using `ls -a` or `ls -la` (which lists all files, including those starting with a dot `.`).

#### 45. What is the difference between `RUN` and `CMD` in a Dockerfile?
`RUN` runs at build time to produce new container layers (e.g. installing dependencies). `CMD` runs at runtime when the container starts to launch the main application process.

#### 46. How do you resolve a merge conflict in `README.md`?
Open the file, locate the conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`), manually edit the content to produce the correct desired outcome, remove the marker lines, stage the file with `git add README.md`, and commit the resolution using `git commit`.

#### 47. What is a health check, and how can it help determine whether PostgreSQL is ready?
A healthcheck runs a command (such as `pg_isready -U takhyrov -d studentdb`) at defined intervals to ensure the database process is not just running, but actually ready to accept client connections. Dependent services configured with `condition: service_healthy` wait until this check succeeds before starting.

#### 48. What is the purpose of the `git push` command?
`git push` uploads local branch commits and objects to a remote repository (such as GitHub), making the work available to other team members and triggering CI/CD pipelines.

#### 49. What is the difference between Declarative Pipeline and Scripted Pipeline in Jenkins?
- **Declarative Pipeline:** Uses a strictly structured, human-readable syntax enclosed in `pipeline { ... }`, with predefined stage blocks and built-in error handling.
- **Scripted Pipeline:** Uses free-form Groovy syntax enclosed in `node { ... }`, providing maximum programmatic flexibility but greater complexity.

#### 50. How can you find and terminate a process by its PID?
Find the process PID using `pgrep <name>` or `ps aux | grep <name>`. Terminate it gracefully with `kill <PID>`, or forcefully with `kill -9 <PID>`.

#### 51. What is the purpose of the `EXPOSE` instruction in a Dockerfile?
`EXPOSE` documents the network port on which the application container listens for traffic. It serves as documentation between the image author and the operator, but does not actually publish the port to the host unless `-p` or `-P` is specified during `docker run`.

#### 52. What are Jenkins Credentials, and why should they be used?
Jenkins Credentials is a built-in encrypted vault for securely storing API tokens, SSH keys, usernames, and passwords. It protects secrets from being hardcoded in pipelines and masks them as `****` in console logs.

#### 53. What is the difference between an absolute path and a relative path?
- **Absolute Path:** Specifies the exact location from the root directory `/` (or `C:\` on Windows), independent of the current directory.
- **Relative Path:** Specifies a location relative to the current working directory (e.g. `./scripts/test.sh` or `../logs`).

#### 54. How can you create and switch to a new Git branch?
Using the modern command `git switch -c <branch_name>` or the classic command `git checkout -b <branch_name>`.

#### 55. Why does Jenkins need access to a Docker-capable agent to build Docker images?
Because the `docker build` command requires communication with the Docker Daemon socket (`/var/run/docker.sock`) and Docker CLI binaries to build, tag, and push container images.

#### 56. What is the difference between a Docker network and a Docker volume?
- **Docker Network:** Manages communication, DNS resolution, and packet routing between containers and external networks.
- **Docker Volume:** Manages persistent storage and data retention on the host filesystem independently of container life cycles.

#### 57. How can you search for a specific word in a file?
Using the `grep` command: `grep "word" filename.txt` (or case-insensitively with `grep -i "word" filename.txt`).

#### 58. What is the purpose of the `git init` command?
`git init` creates an empty local Git repository or reinitializes an existing one, creating the `.git` directory containing all tracking metadata and object databases.

#### 59. How can you view the logs of a running Docker container?
Using `docker logs <container_name_or_id>` or `docker logs -f <container>` for real-time log streaming.

#### 60. How can you configure a Jenkins pipeline to stop when automated tests fail?
By executing test commands in a `stage('Test')` block (e.g., `sh './gradlew test'`). If tests fail, the exit code is non-zero, causing Jenkins to halt the pipeline and skip all downstream build and deployment stages.

#### 61. What is the difference between `mkdir` and `mkdir -p`?
`mkdir` creates a single directory and fails if parent directories do not exist. `mkdir -p` (parents) creates the entire nested directory tree if missing, and does not return an error if the directory already exists.

#### 62. What is a Git tag, and how can it be used to identify a project version?
A Git tag is a reference pointing to a specific commit in Git history, typically used to mark release milestones (e.g., `v1.0-takhyrov-alinur`). Annotated tags (`git tag -a`) store metadata including the tagger's name, email, date, and message.

#### 63. How should database credentials be passed to a Spring Boot container?
Through environment variables injected at container runtime (via Docker Compose `environment:` or an ignored `.env` file) that override `application.properties` placeholders (e.g. `SPRING_DATASOURCE_PASSWORD=${DB_PASSWORD}`).

#### 64. What is the purpose of the Build stage in a Jenkins pipeline?
The Build stage compiles the source code, validates syntactic correctness, resolves dependencies, and bundles the application into deployable binaries or JAR artifacts.

#### 65. What is the difference between `cp` and `mv` in Linux?
- `cp` copies files or directories to a new destination, leaving the original file intact.
- `mv` moves or renames files or directories, removing the original from its source location.

#### 66. What is the purpose of the `git add` command?
`git add` moves changes from the working directory to the Git staging area (Index), marking them to be included in the next commit snapshot.

#### 67. What information can you find in the Jenkins console output?
Full execution logs of each pipeline step, shell outputs, compiler error messages, test failure stack traces, timestamps, environment variable values, and final build outcome (SUCCESS/FAILURE).

#### 68. How do you run a Docker container and map host port 8080 to container port 8080?
`docker run -d -p 8080:8080 --name my-app my-image`

#### 69. What is Linux, and why is it commonly used in DevOps?
Linux is an open-source, POSIX-compliant Unix-like operating system kernel. It is the dominant operating system in DevOps and cloud infrastructure due to its stability, lightweight footprint, security, native container support (cgroups, namespaces), and powerful CLI scripting automation capabilities.

#### 70. What is the difference between a Git commit and a Git tag?
A **commit** represents a snapshot of changes in the continuous timeline of development. A **tag** is a static, named reference pointing to a specific important commit (such as a version release) that does not change as new commits are added.

#### 71. What is the purpose of the `docker-compose.yml` file?
It serves as a declarative configuration file describing multi-container applications: defining services, container images, build contexts, environment variables, port bindings, networks, volumes, and healthchecks.

#### 72. How can you investigate a failed Gradle build in Jenkins?
1. Open the Jenkins build and check the **Console Output**.
2. Search for `BUILD FAILED` and inspect the stack trace.
3. Review Gradle test reports under `build/reports/tests/test/index.html`.
4. Run locally with `./gradlew build --stacktrace --info` to reproduce the exact issue.

#### 73. How do you create an empty file from the terminal?
Using the `touch` command: `touch filename.txt` (or redirection: `> filename.txt`).

#### 74. Why should commit messages be meaningful?
Clear, descriptive commit messages allow team members to understand the context and purpose of changes, simplify code reviews, enable fast regression tracking with `git bisect`, and generate clean automated changelogs.

#### 75. What is the purpose of the Test stage in a Jenkins pipeline?
The Test stage automatically executes unit, integration, and security test suites against the compiled code to verify correctness before packaging or deploying.

#### 76. How can you execute a command inside a running Docker container?
Using `docker exec`:
- Non-interactively: `docker exec <container_name> <command>` (e.g. `docker exec takhyrov-student-app env`)
- Interactively: `docker exec -it <container_name> /bin/sh`

#### 77. How can you search a log file for your surname and save the results to another file?
Using `grep` with redirection:
`grep "Takhyrov" logs/Takhyrov_Alinur_system_report.log > logs/Takhyrov_Alinur_log_analysis.txt`

#### 78. Your local code differs from the code on GitHub. How would you investigate and safely synchronize the changes?
1. Run `git status` to see unstaged local work.
2. Run `git fetch origin` to retrieve remote refs without modifying local files.
3. Compare differences with `git diff main origin/main` or `git log HEAD..origin/main --oneline`.
4. If local changes are uncommitted, stash them with `git stash`.
5. Pull changes with `git pull --rebase origin main` to cleanly place local commits on top of remote changes.
6. Re-apply stashed work with `git stash pop` and resolve any conflicts if necessary.

#### 79. Your Spring Boot container cannot connect to PostgreSQL. How would you troubleshoot the problem?
1. **Container status:** Check if PostgreSQL is running with `docker compose ps` and examine its healthcheck status.
2. **Network connectivity:** Ensure both containers are on the same Docker network (`takhyrov-network`).
3. **Database logs:** Run `docker logs takhyrov-student-db` to verify PostgreSQL is accepting connections on port 5432.
4. **Hostname resolution:** Confirm Spring Boot's datasource URL uses `postgres` as hostname rather than `localhost` (`jdbc:postgresql://postgres:5432/studentdb`).
5. **Credentials:** Check that username, password, and database name match between services.
6. **Network probing:** Run `docker exec -it takhyrov-student-app nc -zv postgres 5432` or `ping postgres` to test network reachability.

#### 80. Your Jenkins pipeline successfully compiles the application but fails during Docker image creation. How would you identify and fix the problem?
1. **Console Output:** Inspect the Jenkins Console Output at the `Docker Build` stage to find the specific Dockerfile line that failed.
2. **Docker daemon permissions:** Verify the Jenkins agent has permission to access the Docker daemon socket (`/var/run/docker.sock`).
3. **Missing artifact:** Verify that the Gradle build step produced the expected JAR file in `build/libs/takhyrov-alinur-student-api.jar` and that the `COPY` path in the `Dockerfile` matches.
4. **Base image & Network:** Check if the agent has internet access to pull base images (`eclipse-temurin:17-jre-alpine`).
5. **Disk space:** Check if the Docker host has run out of disk space (`docker system df` and `docker system prune`).
