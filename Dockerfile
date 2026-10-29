# ==============================================================================
# DevOps Midterm Project - Multi-Stage Dockerfile
# Student: Alinur Takhyrov
# Student ID: 38110
# Target Image: takhyrov-alinur-student-api:v1.0-takhyrov-alinur
# ==============================================================================

# ------------------------------------------------------------------------------
# Stage 1: Build Application with Gradle
# ------------------------------------------------------------------------------
FROM gradle:8.5-jdk17-alpine AS builder

LABEL maintainer="Alinur Takhyrov <defnotslim34@student.kz>"
LABEL student_id="38110"

WORKDIR /app

# Copy dependency configuration files first for Docker layer caching
COPY build.gradle settings.gradle /app/

# Download dependencies (offline mode cache)
RUN gradle dependencies --no-daemon || true

# Copy source code
COPY src /app/src

# Build production executable bootJar without running tests (tests run in CI/CD pipeline stage)
RUN gradle bootJar --no-daemon -x test

# ------------------------------------------------------------------------------
# Stage 2: Minimal Production JRE Runtime
# ------------------------------------------------------------------------------
FROM eclipse-temurin:17-jre-alpine

LABEL maintainer="Alinur Takhyrov <defnotslim34@student.kz>"
LABEL student_id="38110"

# Install curl for health checking inside container
RUN apk add --no-cache curl tzdata && \
    addgroup -S takhyrovgroup && adduser -S takhyrovuser -G takhyrovgroup

WORKDIR /app

# Copy executable jar from builder stage
COPY --from=builder /app/build/libs/takhyrov-alinur-student-api.jar app.jar

# Adjust ownership for non-root execution
RUN chown -R takhyrovuser:takhyrovgroup /app

USER takhyrovuser

# Expose Spring Boot port
EXPOSE 8080

# Configure JVM options and entry point
ENV JAVA_OPTS="-Xms256m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
