# Zomato CLI - A Backend Simulation System 🍔

A robust Command Line Interface (CLI) application built with Java that simulates the core backend operations of a food delivery platform. This project focuses on **Low-Level Design (LLD)**, **Object-Oriented Programming (OOP)**, and efficient **Data Management**.

## 🚀 Overview
The Zomato CLI allows users to manage multiple restaurant stores, handle product inventories, and simulate a real-time order delivery flow. The project demonstrates the transition from basic coding to building modular, scalable systems.

## ✨ Key Features
- **Store & Inventory Management:** - Dynamic store creation with unique IDs using `HashMap`.
  - Inventory tracking with `LinkedList` to manage product availability.
- **Advanced Ordering System:**
  - Integrated `Cart` class to manage user selections.
  - Automatic total price calculation and quantity updates.
- **Simulated Real-Time Tracking:**
  - Implementation of **Java Threads (`Thread.sleep`)** to simulate order status transitions: `PENDING` -> `ONROAD` -> `ARRIVE`.
- **User Interface:**
  - A clean, switch-case driven CLI for seamless user interaction.

## 🛠 Technical Stack & Concepts
- **Language:** Java 8+
- **Data Structures:** - `HashMap`: For O(1) time complexity in store lookups.
  - `ArrayList` & `LinkedList`: For dynamic product and cart management.
- **OOPs Principles:**
  - **Encapsulation:** Private fields with public getters/setters in `Product` and `Store` classes.
  - **Abstraction:** Modular logic separation between the UI and the Manager.
- **Enums:** Used for type-safe delivery status tracking (`Live.java`).

## 📂 Project Structure
- `User_Interface.java`: The entry point of the application.
- `Zomato_Stores_Manager.java`: Handles the business logic of stores and products.
- `Cart.java`: Manages the checkout and delivery simulation.
- `Store.java` & `Product.java`: Data models for the system.

---
