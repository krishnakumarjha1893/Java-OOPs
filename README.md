# 🏦 Bank of Banaras

A beginner-friendly Java Banking System created to practice **Object-Oriented Programming (OOP)** and Java Collections.

## 📌 Features  

- Customer registration
- Employee registration
- Automatic unique ID generation
- Customer ID generation using `CUS` prefix
- Employee ID generation using `EMP` prefix
- Store Customer objects using `HashMap`
- Store Employee objects using `HashMap`
- Search Customer/Employee using Unique ID
- Retrieve the complete object using its ID
- Basic input handling using `Scanner`

## 🧠 Concepts Practiced

This project is mainly built to understand:

- Classes and Objects
- Encapsulation
- Methods
- Constructors
- `static`
- Object references
- `HashMap`
- `Map<Key, Value>`
- Object-to-ID mapping
- Searching objects using keys
- Multiple classes interacting with each other
- `Scanner` and `System.in`

## 🗺️ Basic Architecture

```text
                    Bank
                     |
          ┌──────────┴──────────┐
          ↓                     ↓
    Customer Map           Employee Map
          ↓                     ↓
  CUS5001 → Customer     EMP1001 → Employee
  CUS5002 → Customer     EMP1002 → Employee
  CUS5003 → Customer     EMP1003 → Employee




  🔍 ID Based Search

When a Customer or Employee is created, a unique ID is generated automatically.

Example:

Customer → CUS5001
Employee → EMP1001

The object is then stored in a HashMap:

customers.put(customer.getId(), customer);

Later, the object can be retrieved using its ID:

Customer customer = customers.get("CUS5001");

If the ID does not exist, Map.get() returns null.




Possible future additions:

Bank Account class
Deposit and withdrawal functionality
Transaction history
Multiple bank branches
Employee roles
Customer login
File/database storage
Better input validation
Exception handling
Interfaces and inheritance
