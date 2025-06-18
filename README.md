# Real Estate Cart Microservice

## Overview
This microservice manages a real estate cart system, allowing users to add, update, delete, and view properties in their cart.

## Features
✅ Add property to cart  
✅ Update property details  
✅ Delete property from cart  
✅ View all properties in cart  

## 🏗️ Project Structure (Key Components)
```plaintext
src/
├── main/
│   ├── java/com/example/RealEstate/
│   │   ├── controllers/
│   │   │   └── RealEstateController.java
│   │   ├── dto/
│   │   │   └── RealEstateCartRequest.java
│   │   ├── entities/
│   │   │   └── RealEstateCart.java
│   │   ├── repo/
│   │   │   └── RealEstateRepo.java
│   │   ├── services/
│   │   │   ├── RealEstateService.java
│   │   │   └── RealEstateServiceImpl.java
│   ├── resources/
│   │   └── application.properties

---

## 🚀 Core Endpoints

| Endpoint           | Method | Request Body             | Response           | Description                  |
|--------------------|--------|-------------------------|--------------------|------------------------------|
| `/cart/addItem`    | POST   | `RealEstateCartRequest` | String message     | Add a new property to cart    |
| `/cart/{id}`       | PUT    | `RealEstateCartRequest` | String message     | Update property by ID         |
| `/cart/{id}`       | DELETE | None                    | String message     | Delete property by ID         |
| `/cart/all`        | GET    | None                    | List of properties | Get all properties in cart    |

---

## 🔧 Service Layer
- `addProperty` to add new properties  
- `updateProperty` to modify existing properties  
- `deleteProperty` to remove properties  
- `allProperties` to list all properties  

---

## ⚙️ Tech Stack
- **Backend:** Spring Boot  
- **Database:** MySQL with JPA/Hibernate  
- **Build Tool:** Maven  

---

## 🛠️ Setup Instructions

1. **Configure MySQL database** in `src/main/resources/application.properties`:
```properties
spring.application.name=RealEstate

spring.datasource.url=jdbc:mysql://localhost:3306/realestate_db
spring.datasource.username=root
spring.datasource.password=Yugen@1998
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

2. **Start the application**:
```bash
mvn spring-boot:run
```


## API Endpoints & Postman Test Details

### 1. Add Item to Cart  
- **Method:** POST  
- **URL:** `http://localhost:8080/cart/addItem`  
- **Headers:**  
  - Content-Type: application/json
- **Expected Response: "Item added in cart"
- **Body (raw JSON):**
```json
{
  "property_id": 101,
  "customer_id": 201,
  "propertyName": "Sunset Villa",
  "address": "123 Palm Street",
  "location": "Miami, FL",
  "price": 500000.00
}
```

### 2. Update Item by ID 
- **Method:** PUT  
- **URL:** `http://localhost:8080/cart/{id}`  (replace {id} with actual item id)
- **Headers:**  
  - Content-Type: application/json
- **Expected Response: "Card record updated"
- **Body (raw JSON):**
```json
{
  "property_id": 101,
  "customer_id": 1001,
  "propertyName": "Skyview Residency",
  "address": "Sector 21, Palm Beach Road",
  "location": "Navi Mumbai",
  "price": 
}
```
### 3. Delete Item by ID
- **Method:** DELETE  
- **URL:** `http://localhost:8080/cart/{id}`  (replace {id} with actual item id)
- **Headers:**  
  - Content-Type: application/json  
- **Expected Response: "Deleted Successfully"

### 3.  Get All Items in Cart
- **Method:** GET  
- **URL:** `http://localhost:8080/cart/all` 
- **Headers:**  
  - Content-Type: application/json  
- **Expected Response: JSON array of all properties in cart, example:
- - **Body (raw JSON):**
```json
[
  {
    "id": 1,
    "property_id": 101,
    "customer_id": 201,
    "propertyName": "Sunset Villa",
    "address": "123 Palm Street",
    "location": "Miami, FL",
    "price": 500000.0
  }
]
```
