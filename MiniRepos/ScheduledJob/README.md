# Job Scheduler CLI (Java)

A simple CLI-based job scheduler built in Java to understand how real backend systems handle task scheduling, execution, and worker management.

This project simulates how background systems (like cron jobs, queues, async workers) work internally.

---

## 🚀 Features

* Add jobs with scheduled execution time
* Add multiple workers
* Automatic job execution based on time
* Retry mechanism for failed jobs
* CLI-based interaction
* Uses core Java (no frameworks)

---

## 🧠 What I Learned

* How to design systems using OOP principles
* Difference between **storage (HashMap)** and **processing (PriorityQueue)**
* How scheduling systems actually work internally
* Managing state transitions (PENDING → RUNNING → COMPLETED/FAILED)
* Basic system design thinking instead of just writing code

---

## 🛠️ Tech Used

* Java
* OOP (Encapsulation, Separation of Concerns)
* Data Structures:

  * HashMap (job storage)
  * PriorityQueue (time-based scheduling)
  * ArrayList (worker pool)

---

## 💻 CLI Preview

```bash
1. Add Job
2. Add Worker
3. View All Jobs
4. Start Scheduler
5. Exit
```

Example execution:

```bash
[Time 2]
Job backup is READY
Worker W1 executing backup
Job COMPLETED

[Time 5]
Job email is READY
Worker W1 executing email
Job FAILED → retrying

[Time 6]
Job email is READY
Worker W1 executing email
Job COMPLETED
```

---

## ⚙️ How It Works

1. Jobs are stored in a HashMap
2. Jobs are scheduled using a PriorityQueue (sorted by time)
3. Scheduler checks which jobs are ready
4. Dispatcher assigns jobs to workers
5. Workers execute jobs and update status

---

## 📌 Future Improvements

* Add proper worker queue handling
* Add delayed retries instead of immediate retry
* Support job priorities
* Multi-threaded execution
* Logging system

---

## 🎯 Why I Built This

I wanted to move beyond basic CRUD projects and understand how real backend systems work internally.

This project helped me think in terms of **systems, flow, and responsibilities**, not just syntax.

---

## 🧑‍💻 Author

Built by a CS student learning backend and system design.
