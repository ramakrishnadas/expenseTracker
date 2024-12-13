package service;

import model.Expense;
import model.RecurringExpense;
import util.InputValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // Core program logic: Display menu, handle user input, and add, delete, view expenses
        System.out.println("This is my app");
        boolean running = true;

        while (running) {
            displayMenu();

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleAddExpense();
                    break;
                case "2":
                    handleAddRecurringExpense();
                    break;
                case "3":
                    handleViewExpenses();
                    break;
                case "4":
                    handleDeleteExpense();
                    break;
                case "5":
                    handleSummary();
                    break;
                case "6":
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n======= Expense Tracker Menu ======");
        System.out.println("1. Add Expense");
        System.out.println("2. Add Recurring Expense");
        System.out.println("3. View Expenses");
        System.out.println("4. Delete Expense");
        System.out.println("5. View Expense Summary");
        System.out.println("6. Exit");
        System.out.println("==================================");
    }

    private void handleAddExpense() {
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (!InputValidator.isValidAmount(amount)) {
            System.out.println("Invalid amount. Please try again.");
            return;
        }

        System.out.print("Enter category (e. g., Housing, Groceries): ");
        String category = scanner.nextLine();

        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        if (!InputValidator.isValidDate(date)) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(expenses.size() + 1, amount, category, date, description);
        addExpense(expense);
    }

    private void handleAddRecurringExpense() {
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (!InputValidator.isValidAmount(amount)) {
            System.out.println("Invalid amount. Please try again.");
            return;
        }

        System.out.print("Enter category (e. g., Housing, Groceries): ");
        String category = scanner.nextLine();

        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        if (!InputValidator.isValidDate(date)) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter frequency (Weekly, Monthly, Yearly): ");
        String frequency = scanner.nextLine();

        System.out.print("Enter end date (DD-MM-YYYY, or leave blank if indefinite): ");
        String endDate = scanner.nextLine();

        if (!endDate.isEmpty() && !InputValidator.isValidDate(endDate)) {
            System.out.println("Invalid end date format. Please try again.");
            return;
        }

        RecurringExpense recurringExpense = new RecurringExpense(expenses.size() + 1, amount, category, date, description, frequency, endDate);
        
        addExpense(recurringExpense);
    }

    private void handleViewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n==== Your Expenses ====");
            viewExpenses();
            System.out.println("========================");
        }
    }

    private void handleDeleteExpense() {
        System.out.print("Enter the ID of the expense you wish to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean found = expenses.stream().anyMatch(expense -> expense.getId() == id);
        if (!found) {
            System.out.println("Expense ID not found.");
            return;
        }

        deleteExpense(id);
    }

    private void handleSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n==== Expense Summary ====");
            getSummary();
            System.out.println("==============================");
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
        System.out.println("Expense deleted successfully!");
    }

    public void viewExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void getSummary() {
        
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
            return;
        }

        Map<String, Double> categoryTotals = new HashMap<>();
        double totalAmount = 0;

        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();

            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);  
            totalAmount += amount;
        }

        System.out.println("\n==== Expense Summary ====");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.printf("%-20s: $%.2f%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nTotal Expenses: $" + String.format("%.2f", totalAmount));
    }
}
