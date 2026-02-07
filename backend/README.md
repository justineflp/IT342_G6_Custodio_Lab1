# Backend – Spring Boot

## Requirements

- Java 17+
- Maven 3.6+
- MySQL 8 (or 5.7)

## Setup

1. Create a MySQL database (optional – app can create `it342_auth` if allowed):
   ```sql
   CREATE DATABASE IF NOT EXISTS it342_auth;
   ```

2. Set DB credentials in `src/main/resources/application.properties`:
   - `spring.datasource.username`
   - `spring.datasource.password`

## Run

From the `backend` folder:

```bash
# Windows
mvnw.cmd spring-boot:run

# Or if Maven is installed
mvn spring-boot:run
```

From project root:

```bash
cd backend && mvn spring-boot:run
```

Server: **http://localhost:8080**

## API

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register (body: email, fullName, password) |
| POST | /api/auth/login | Login (body: email, password) → returns JWT |
| GET | /api/user/me | Current user (header: `Authorization: Bearer <token>`) |

Passwords are hashed with **BCrypt**.
