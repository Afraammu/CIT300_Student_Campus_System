# University Student Record and Campus Route Management System

## CIT300 – Data Structures and Algorithms

### Project Overview

This project is a Java console-based application developed for the CIT300 Data Structures and Algorithms practical assignment.

The system manages university student records and campus routes using different data structures and algorithms.

## Main Features

* Add, update, delete and display student records
* Manage student service requests using a Queue
* Track recent system actions using a Stack
* Store and display students using a Binary Search Tree (BST)
* Search students efficiently using Hashing
* Add and remove campus locations
* Add and remove campus connections
* Display campus connections using an Adjacency List
* Traverse campus locations using Breadth-First Search (BFS)
* Input validation and error handling
* Menu-driven console interface

## Data Structures Used

| Data Structure     | Purpose                                    |
| ------------------ | ------------------------------------------ |
| Linked List        | Store and manage student records           |
| Stack              | Store recent system actions                |
| Queue              | Manage student service requests            |
| Binary Search Tree | Store and display students by Student ID   |
| Hash Table         | Fast student ID searching                  |
| Graph              | Represent campus locations and connections |
| Adjacency List     | Represent graph connections                |
| BFS                | Traverse connected campus locations        |

## Project Structure

```text
CIT300_Student_Campus_System
│
├── src
│   ├── ActionStack.java
│   ├── CampusGraph.java
│   ├── Main.java
│   ├── ServiceQueue.java
│   ├── Student.java
│   ├── StudentBST.java
│   ├── StudentHashTable.java
│   └── StudentLinkedList.java
│
└── README.md
```

## Group Members

| Member | Student ID |
| ------ | ---------- |
| Afra   | 23DA2-0992 |
| Aslam  | 23DA2-0771 |
| Nuha   | 23DA2-0988 |
| Aksha  | 23DA2-1103 |

## How to Run

### Step 1 – Open the project

Open the project folder in Visual Studio Code.

### Step 2 – Open Terminal

Open the VS Code terminal and navigate to the `src` folder:

```text
cd src
```

### Step 3 – Compile the Java files

```text
javac *.java
```

### Step 4 – Run the application

```text
java Main
```

## Menu Options

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS
16. Exit

## Input Validation

The system validates:

* Empty student IDs
* Duplicate student IDs
* Empty student names
* Empty programme names
* Marks outside the range 0–100
* Invalid menu input
* Missing student records
* Duplicate campus locations
* Missing campus locations
* Invalid or duplicate campus connections

## Algorithms

### Binary Search Tree

Students are inserted into the BST according to their Student ID.

The system supports:

* Insertion
* Searching
* In-order traversal
* Deletion

### Hashing

A Java HashMap is used to provide efficient student ID-based searching.

### Graph

Campus locations are represented as vertices and campus connections are represented as edges.

The graph uses an adjacency list representation.

### Breadth-First Search

BFS is used to traverse connected campus locations starting from a selected location.

## Technologies Used

* Java
* Object-Oriented Programming
* Data Structures and Algorithms
* Visual Studio Code
* Git and GitHub

## Conclusion

The system demonstrates the practical application of linear data structures, trees, hashing and graphs in a university management scenario. It provides a menu-driven interface for managing student records, service requests and campus routes.
