# 🔐 Spring Security using JWT

A secure REST API built using **Spring Boot + Spring Security + JWT** that supports user registration, login authentication, and protected endpoints.

This project demonstrates stateless authentication using JSON Web Tokens (JWT).

---

## 🚀 Features

- ✅ User Registration
- ✅ User Login Authentication
- ✅ Password Encryption (BCrypt)
- ✅ JWT Token Generation
- ✅ JWT Token Validation
- ✅ Role-Based Authorization Ready
- ✅ Protected REST APIs
- ✅ Stateless Session Management

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Security**
- **Spring Data JPA**
- **JWT (io.jsonwebtoken)**
- **MySQL**
- **Maven**

---

## 🏗️ Project Structure

```plaintext
src/main/java/com.SpringSecurity.JWT/
├── controller/    
├── model/          
├── repository/    
├── security/        
└── JwtApplication        
```


---

## ⚙️ Configuration

### application.properties

```properties
spring.application.name=JWT

spring.datasource.url=jdbc:mysql://localhost:3306/jwt_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=mysupersecretkeymysupersecretkey
jwt.expiration=3600000

server.port=8080
```

## 🗄️ Database Setup

Create database manually in MySQL:

```sql
CREATE DATABASE jwt_db;
```

## 🔑 Authentication Flow

1. Register User  
2. Login with Credentials  
3. JWT Token Generated  
4. Send Token in Authorization Header  
5. Access Protected APIs

## API Endpoints

```bash
# Register new user
POST /api/auth/register
Content-Type: application/json

{
  "name": "John Doe",
  "password": "Password123"
}

# Login
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "Password123"
}

```bash
# Get current user profile
GET /api/hello
Authorization: Bearer <token>
```
## 🧪 Testing with Postman

- Register → `/auth/register`
- Login → `/auth/login`
- Copy JWT token
- Call Protected API with Authorization header
