# Mini Hospital Emergency Management System

A Java-based Mini Hospital Emergency Management System developed using Data Structures and Algorithms.

## Project Description

This system manages patient records, emergency patients, treatment history, and patient visit history using different data structures.

## Data Structures Used

1. **Binary Search Tree (BST)**
   - Add patient
   - Search patient by Patient ID
   - Delete patient
   - Display patients in ascending Patient ID order

2. **Queue**
   - Add emergency patient
   - Treat next patient using FIFO
   - Display emergency queue
   - Handle empty queue

3. **Stack**
   - Add completed treatment
   - Remove latest treatment using LIFO
   - Display treatment history
   - Handle empty stack

4. **Singly Linked List**
   - Add patient visit
   - Remove patient visit
   - Search patient visit
   - Display visit history

## Technologies Used

- Java
- Eclipse IDE
- GitHub
- Data Structures and Algorithms

## Project Structure

```text
src/
└── hospital/
    ├── Main.java
    ├── Patient.java
    ├── PatientBST.java
    ├── EmergencyQueue.java
    ├── TreatmentStack.java
    ├── Visit.java
    └── VisitHistory.java
