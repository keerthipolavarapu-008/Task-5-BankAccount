import java.util.*;

public class BankApp {

    /* -------- Account class -------- */
    static class Account {
        private String id;
        private String holder;z
        private double balance;
        private List<String> transactions;

        // Constructor
        public Account(String holder, double initialBalance) {
            this.id = "ACC" + new Random().nextInt(10000);
            this.holder = holder;
            this.balance = initialBalance;
            this.transactions = new ArrayList<>();
            transactions.add("Account created with balance: " + initialBalance);
        }

        // Getters
        public String getId() { return id; }
        public String getHolder() { return holder; }
        public double getBalance() { return balance; }

        // Deposit
        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Invalid deposit amount.");
                return;
            }
            balance += amount;
            transactions.add("Deposited: " + amount);
            System.out.println("✅ Deposited " + amount + " | New Balance: " + balance);
        }

        // Withdraw
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Invalid withdraw amount.");
                return;
            }
            if (amount > balance) {
                System.out.println("❌ Insufficient balance.");
                return;
            }
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            System.out.println("✅ Withdrawn " + amount + " | New Balance: " + balance);
        }

        // Show transactions
        public void showTransactions() {
            System.out.println("📜 Transactions for " + holder + " (" + id + "):");
            for (String t : transactions) {
                System.out.println("- " + t);
            }
        }

        @Override
        public String toString() {
            return "[" + id + "] " + holder + " | Balance: " + balance;
        }
    }

    /* -------- Main (CLI) -------- */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1) Create Account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) View Transactions");
            System.out.println("5) List Accounts");
            System.out.println("0) Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = Double.parseDouble(sc.nextLine());
                    Account acc = new Account(name, bal);
                    accounts.put(acc.getId(), acc);
                    System.out.println("✅ Account created: " + acc);
                }
                case "2" -> {
                    System.out.print("Enter Account ID: ");
                    String id = sc.nextLine();
                    Account acc = accounts.get(id);
                    if (acc == null) {
                        System.out.println("❌ Account not found.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.deposit(amt);
                }
                case "3" -> {
                    System.out.print("Enter Account ID: ");
                    String id = sc.nextLine();
                    Account acc = accounts.get(id);
                    if (acc == null) {
                        System.out.println("❌ Account not found.");
                        break;
                    }
                    System.out.print("Enter withdraw amount: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.withdraw(amt);
                }
                case "4" -> {
                    System.out.print("Enter Account ID: ");
                    String id = sc.nextLine();
                    Account acc = accounts.get(id);
                    if (acc == null) {
                        System.out.println("❌ Account not found.");
                        break;
                    }
                    acc.showTransactions();
                }
                case "5" -> {
                    if (accounts.isEmpty()) {
                        System.out.println("⚠️ No accounts created yet.");
                    } else {
                        System.out.println("🏦 Accounts:");
                        accounts.values().forEach(System.out::println);
                    }
                }
                case "0" -> {
                    System.out.println("👋 Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
