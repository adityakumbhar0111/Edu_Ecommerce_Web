<h3># Education E‑commerce (Courses)</h3>

A full‑stack education e‑commerce web application for selling courses, built with **Java (Servlets + JSP)** and **MySQL**. This README explains project structure, setup, database schema, and how to run the app on a local Tomcat server.

---

## Table of Contents

* [Project Overview](#project-overview)
* [Features](#features)
* [Pages](#pages)
* [Tech Stack](#tech-stack)
* [Prerequisites](#prerequisites)
* [Database Schema](#database-schema)
* [Installation & Setup](#installation--setup)
* [Project Structure](#project-structure)
* [Key Servlets / JSPs / Endpoints](#key-servlets--jsps--endpoints)
* [Usage Flow](#usage-flow)
* [Troubleshooting](#troubleshooting)

---

## Project Overview

This project is an online marketplace for educational courses. Admins can add and manage courses; users can browse courses, register/login, add courses to cart, checkout with payment options, and track their orders. The app demonstrates CRUD operations, authentication, session handling, and order management using Servlets and JSP.

## Features

* User registration & login (sessions)
* Admin panel to add/edit/remove courses
* Course catalog with categories and search
* Cart: add/remove courses, view selected list
* Secure checkout (Credit/Debit card, UPI simulation)
* Orders page to view past orders
* MySQL-based persistence

## Pages

* **Home** – Landing page with highlights of courses.
* **About** – Information about the platform/institution.
* **Courses** – List of all courses with categories and details.
* **Teachers** – Profiles of instructors/teachers.
* **Contact** – Contact form and info.
* **Blogs** – Blog/news articles related to education.
* **Sign In / Sign Up** – Authentication pages.
* **Cart** – Shows selected courses with remove button.
* **Payment** – Accessible after login and course selection, includes Credit/Debit Card and UPI options.
* **Order Success** – Confirmation page after checkout.
* **My Orders** – Displays list of completed orders for the logged‑in user.

## Tech Stack

* Java 11+ (or 8+)
* Jakarta Servlet API (Servlets)
* JSP for views
* MySQL 5.7+ / 8.0+
* Apache Tomcat 9/10 (or compatible servlet container)
* Maven (recommended) or WAR build

## Prerequisites

* Java JDK installed
* Apache Tomcat installed
* MySQL server installed
* Maven (optional, recommended)

## Database Schema

*(Same as before, including users, categories, courses, carts, orders)*

## Installation & Setup

*(Same steps: clone repo, create DB, configure DB properties, build & deploy on Tomcat)*

## Project Structure (suggested)

```
edu-ecommerce/
├─ src/
│  ├─ main/
│  │  ├─ java/com/example/controller/  # Servlets
│  │  ├─ java/com/example/dao/         # DAO classes for DB access
│  │  ├─ java/com/example/model/       # Model/POJOs
│  │  ├─ webapp/
│  │  │  ├─ WEB-INF/
│  │  │  │  ├─ web.xml
│  │  │  ├─ views/
│  │  │  │  ├─ home.jsp
│  │  │  │  ├─ about.jsp
│  │  │  │  ├─ courses.jsp
│  │  │  │  ├─ teachers.jsp
│  │  │  │  ├─ contact.jsp
│  │  │  │  ├─ blogs.jsp
│  │  │  │  ├─ login.jsp / signup.jsp
│  │  │  │  ├─ cart.jsp
│  │  │  │  ├─ payment.jsp
│  │  │  │  ├─ order-success.jsp
│  │  │  │  ├─ my-orders.jsp
│  │  │  └─ assets/
│  └─ resources/
├─ pom.xml
└─ README.md
```

## Key Servlets / JSPs / Endpoints

* `RegisterServlet` — `POST /register` — registers a user
* `LoginServlet` — `POST /login` — authenticates and creates a session
* `LogoutServlet` — `GET /logout` — invalidates session
* `CourseListServlet` — `GET /courses` — lists available courses
* `CourseDetailServlet` — `GET /course?id={id}` — course details
* `AdminCourseServlet` — `GET/POST /admin/course` — manage courses (admin)
* `CartServlet` — `GET/POST /cart` — manage cart items
* `PaymentServlet` — `POST /payment` — simulate payment (Credit/Debit/UPI)
* `CheckoutServlet` — `POST /checkout` — finalizes order
* `OrderServlet` — `GET /orders` — list user orders

## Usage Flow

1. User visits **Home** → browses **Courses**.
2. To add a course to cart, user must **Login/Sign Up** first.
3. Selected courses appear in **Cart** with option to remove.
4. Proceed to **Payment** page (choose Credit/Debit or UPI).
5. On success, redirected to **Order Success** page.
6. User can view past purchases in **My Orders**.

## Troubleshooting

* **JDBC driver not found:** add `mysql-connector-java` to `WEB-INF/lib` or as Maven dependency.
* **Login redirect issues:** ensure session management is implemented correctly in filters/servlets.
* **Payment simulation errors:** confirm form inputs are mapped correctly in `PaymentServlet`.

