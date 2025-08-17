# 🏦 Task 5 – Bank Account Simulation (OOP in Java)

## 🚀 Objective
Simulate basic **bank operations** using **Object-Oriented Programming** in Java.  
The system supports deposit, withdraw, and transaction history management.

---

## 🛠 Features
1. **Create Account** → Open a new account with initial balance.  
2. **Deposit** → Add money to account.  
3. **Withdraw** → Deduct money (with balance check).  
4. **Transaction History** → View all transactions for the account.  

---

## 📂 Files
- `BankApp.java` → Main Java program (with Account class and menu system).  

---

## ▶️ How to Run
```bash
# Compile
javac BankApp.java
--- Bank Menu ---
1) Create Account
2) Deposit
3) Withdraw
4) View Transactions
0) Exit

Choice: 1
Enter account holder: Alice
Initial balance: 1000
✅ Account created: [ACC123] Alice | Balance: 1000.0

Choice: 2
Account ID: ACC123
Amount: 500
✅ Deposited 500.0 | New Balance: 1500.0

Choice: 3
Account ID: ACC123
Amount: 200
✅ Withdrawn 200.0 | New Balance: 1300.0

Choice: 4
Transactions:
- Deposited 500.0
- Withdrawn 200.0


# Run
java BankApp
