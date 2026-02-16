# 🏦 Mini Banking System (Java OOP Project)

A CLI-based Banking System built using core Java concepts.

This project demonstrates strong understanding of:

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Interfaces (Strategy Pattern)
- Clean Responsibility Separation

---

## 🚀 Features

- Create different account types:
  - Savings Account
  - Current Account
  - Premium Account

- Deposit Money
- Transfer Money using different Payment Methods:
  - UPI
  - Credit Card
  - Net Banking
- Cashback calculation based on account type
- Transaction history tracking
- Encapsulated balance protection

---

## 🧠 Architecture Overview

### 1️⃣ Abstract Class: `Account`

Defines:
- accountNumber
- accountHolderName
- balance (private)
- deposit()
- withdraw()
- abstract calculateCashback()

Child classes override cashback logic.

---

### 2️⃣ Account Types

- SavingsAccount → No cashback
- CurrentAccount → 2% cashback
- PremiumAccount → 5% cashback

Polymorphism ensures correct cashback calculation at runtime.

---

### 3️⃣ Interface: `PaymentMethods`

Defines:

boolean pay(Account from, Account to, int amount);

yaml
Copy code

Implementations:
- UPI
- CreditCard
- NetBanking

Each payment type applies its own transaction fee logic.

---

### 4️⃣ BankManager

Responsible for:
- Managing accounts
- Finding accounts
- Processing transfers
- Orchestrating payment flow

Does NOT directly modify balance (Encapsulation preserved).

---

## 💡 Key Design Decisions

- No use of instanceof (Clean Polymorphism)
- No direct balance modification outside Account
- Strategy pattern used for payment handling
- Open for extension (new account types can be added without modifying existing logic)

---

## 📚 Learning Outcome

This project helped solidify:

- Real-world use of OOP principles
- Strategy design pattern
- Clean architecture thinking
- Runtime polymorphism
- Separation of concerns

---

## 🔮 Future Improvements

- Replace arrays with ArrayList
- Add transaction class
- Improve validation handling
- Add persistence layer
- Convert into REST API (Spring Boot)

---

Built as part of deepening Java backend fundamentals.
