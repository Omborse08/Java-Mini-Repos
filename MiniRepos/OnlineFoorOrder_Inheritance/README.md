# 🍔 Online Food Order System (Java Mini Project)

This is a simple Java mini project built to understand **constructor-based inheritance**, **access modifiers**, and **basic OOP principles** in Java.

The project simulates a basic food ordering system with two types of orders:
- Online Order
- Dine-In Order

---

## 🚀 Concepts Used

- Object-Oriented Programming (OOP)
- Inheritance
- Constructor chaining using `super()`
- Access modifiers (`private`, `protected`)
- Method separation (business logic vs display logic)

---

## 🧠 Project Structure

### 1️⃣ Order (Parent Class)
The `Order` class stores common order details like:
- Order ID
- Customer Name
- Price per item
- Quantity

It uses a **parameterized constructor** to initialize data and applies **encapsulation** by keeping the order ID private.

---

### 2️⃣ OnlineOrder (Child Class)
This class represents an online food order.
- Inherits from `Order`
- Adds an extra delivery charge
- Calculates the final bill including delivery charges

---

### 3️⃣ DineInOrder (Child Class)
This class represents a dine-in order.
- Inherits from `Order`
- Adds a service charge
- Calculates the final bill including service charges

---

## 🔁 How Inheritance Works Here

- The parent class (`Order`) initializes common order data using its constructor.
- Child classes (`OnlineOrder` and `DineInOrder`) call the parent constructor using `super()`.
- Each child class calculates its bill differently by adding specific charges.
