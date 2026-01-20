# Clean Fanatics – Booking Lifecycle Management System

## Overview
This project is a booking lifecycle management system built for an on-demand home services marketplace (like Clean Fanatics).
It demonstrates booking creation, provider assignment, lifecycle state transitions, and completion.

The focus is on backend logic and state handling, with a minimal frontend for interaction.

---

## Project Structure

clean-fanatics-booking-system/
├── backend/
│   ├── cleanfanatics/
│   │   ├── BookingApplication.java
│   │   ├── controller/
│   │   │   └── BookingController.java
│   │   ├── model/
│   │   │   ├── Booking.java
│   │   │   └── BookingStatus.java
│   │   ├── repository/
│   │   │   └── BookingRepository.java
│   │   └── service/
│   │       └── BookingService.java
│   └── pom.xml
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── app.js
│
└── README.md

---

## Tech Stack

Backend:
- Java
- Spring Boot
- Maven
- REST APIs
- In-memory storage

Frontend:
- HTML
- CSS
- JavaScript

---

## Booking Lifecycle

PENDING → ASSIGNED → IN_PROGRESS → COMPLETED

Additional State:
- CANCELLED_BY_CUSTOMER

---

## Features

Customer:
- Create booking
- Cancel booking

Provider / System:
- Assign provider
- Start service
- Complete service

Admin / Ops:
- View all bookings

---

## API Endpoints

POST /bookings
POST /bookings/{id}/assign
POST /bookings/{id}/start
POST /bookings/{id}/complete
POST /bookings/{id}/cancel
GET  /bookings

---

## How to Run

Prerequisites:
- Java 17+
- Maven

Run backend:
cd clean-fanatics-booking-system/backend
mvn spring-boot:run

Backend URL:
http://localhost:8080

Run frontend:
Open frontend/index.html in browser

---

## Submission Note
This project was developed as part of the Clean Fanatics Full Stack Engineering assignment.
# clean-fanatics-booking-system
