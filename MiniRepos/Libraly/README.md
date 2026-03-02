# 📚 Library Management System (Java OOP + Collections Project)

A console-based Library Management System built using Core Java.

This project demonstrates strong understanding of Object-Oriented Programming principles and advanced usage of Java Collections such as HashMap, ArrayList, and LinkedList to model real-world backend logic.

---

## 🚀 Project Overview

This system allows:

- Add books (Fiction / Academic)
- Register members
- Borrow books
- Maintain per-book waiting queues
- Return books with late fee calculation
- FIFO-based reassignment of returned books
- View available books
- View borrowed books

The system supports multiple members waiting for the same book and handles automatic reassignment when a book is returned.

---

## 🧠 Core Concepts Implemented

### 🔹 Encapsulation
- All fields are private.
- Access is controlled via getters and methods.

### 🔹 Abstraction
- `Book` is an abstract class.
- Defines abstract method:

```java
abstract int calculateLateFee(int days);
```

### 🔹 Inheritance
```
Book (Abstract)
   ├── FictionBook
   └── AcademicBook
```

Each subclass defines its own late fee calculation logic.

### 🔹 Polymorphism
Books are stored as:

```java
HashMap<Integer, Book>
```

Late fee is calculated using runtime polymorphism.

### 🔹 Interface
`LibralyInterface` defines the system contract:

- addBook()
- registerMember()
- borrowBook()
- returnBook()
- showAvailableBooks()
- showBorrowedBooks()

Implemented by `Management`.

---

## 📚 Java Collections Used

### 🔹 HashMap
Used for:
- Fast lookup of books by bookId
- Fast lookup of members by memberId
- Maintaining per-book waiting queues

```java
HashMap<Integer, Book> books;
HashMap<Integer, Member> members;
HashMap<Integer, LinkedList<Member>> waitingQueues;
```

Time Complexity:
- O(1) average lookup

---

### 🔹 ArrayList
Used inside `Member`:

```java
ArrayList<Book> borrowedBooks;
```

Stores books currently borrowed by a member.

---

### 🔹 LinkedList
Used as a Queue:

```java
LinkedList<Member>
```

Maintains FIFO waiting order per book.

---

## 🔄 System Workflow

### 1️⃣ Add Book
- Books are added to `HashMap<bookId, Book>`

---

### 2️⃣ Register Member
- Members are added to `HashMap<memberId, Member>`

---

### 3️⃣ Borrow Book

If book is available:
- Book assigned to member
- Book marked unavailable

If book is unavailable:
- Member added to that book's waiting queue
- Queue is maintained per book

---

### 4️⃣ Return Book

When a member returns a book:

1. Book removed from member
2. Late fee calculated using polymorphism
3. If waiting list exists:
   - First member in queue gets the book
   - Book remains unavailable
4. If no waiting list:
   - Book becomes available

The book never becomes available in between reassignment.

---

## 🖥️ Sample CLI Menu

```
1. Add Book
2. Add Member
3. Borrow Book
4. Return Book
5. Show Available Books
6. Show Borrowed Books
7. Exit
```

---

## 📊 Data Structure Design

```
Management
   ├── HashMap<BookId, Book>
   ├── HashMap<MemberId, Member>
   └── HashMap<BookId, LinkedList<Member>> (Waiting Queues)
```

Each book maintains its own waiting queue.

---

## 💰 Late Fee Rules

| Book Type      | Late Fee |
|---------------|----------|
| FictionBook  | ₹10/day  |
| AcademicBook | ₹5/day   |

Late fee is calculated dynamically using polymorphism.

---

## 🎯 Design Highlights

- Clean separation of responsibilities
- No shared mutable state issues
- Proper per-book waiting queue
- Safe validation of IDs
- Snapshot-style book ownership
- No external libraries used
- Pure Core Java implementation

---

## 🧪 Edge Cases Handled

- Invalid member ID
- Invalid book ID
- Returning unborrowed book
- Multiple members waiting
- Queue cleanup when empty

---

## 📈 What This Project Demonstrates

- Strong understanding of HashMap internal usage
- Correct modeling of Queue-based systems
- Real-world backend-style object design
- Practical application of OOP principles
- Clean separation of UI and business logic

---

## 🔧 Technologies Used

- Java (Core)
- Java Collections Framework
- Console-based Interface

---

## 🚀 Possible Improvements

- Persistent storage (File / Database)
- Due date tracking
- Member borrowing limits
- Admin authentication
- Logging system
- GUI version using JavaFX

---

## 👨‍💻 Author

Built as a backend-focused OOP + Collections practice project to strengthen system design and data structure understanding.
