# Warranty & Purchase Tracker – Backend (Spring Boot)

This is the **backend REST API** for the Warranty & Purchase Tracker application.  
It exposes CRUD endpoints to store product purchases and warranty details.

---

## 🧱 Tech Stack

- **Java 17 / 21**
- **Spring Boot 3 / 4**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database** (in-memory for now)
- **Maven**

---

## 🗄 Data Model

Entity: `WarrantyItem`

Fields:

- `id` – `Long`, primary key
- `productName` – `String`
- `category` – `String`
- `purchaseDate` – `String` (`yyyy-MM-dd`, easy to bind with `<input type="date">`)
- `warrantyMonths` – `Integer`
- `storeName` – `String`
- `invoiceNumber` – `String`
- `notes` – `String` (up to 1000 chars)
- `createdAt` – `LocalDateTime`
- `updatedAt` – `LocalDateTime`

---

## 🌐 REST API Endpoints
