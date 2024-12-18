package service;

import model.Expense;
import model.RecurringExpense;
import util.InputValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseManager {
    // Declare and define ExpenseManager class attributes
    private ArrayList<Expense> expenses = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Start program loop and display options menu
    public void run() {
                
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

    // Display Expense Tracker menu with numbered options
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

    // Take user input to create a new Expense object and add it to the expenses ArrayList
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

    // Take user input to create a new RecurringExpense object and add it to the expenses ArrayList
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

    // Display all of the Expenses and RecurringExpenses in the expenses ArrayList
    private void handleViewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n==== Your Expenses ====");
            viewExpenses();
            System.out.println("========================");
        }
    }

    // Take user input of the expense id to be deletes and remove it from the expenses ArrayList
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

    // Display Expense summary
    private void handleSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n==== Expense Summary ====");
            getSummary();
            System.out.println("==============================");
        }
    }

    // Add expense to expenses ArrayList and display success message
    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    // Delete expense from expenses ArrayList and display success message
    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
        System.out.println("Expense deleted successfully!");
    }

    // Print list of expenses in expenses ArrayList
    public void viewExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Calculate expense category totals and overall total and display the summary
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

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.printf("%-20s: $%.2f%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nTotal Expenses: $" + String.format("%.2f", totalAmount));
    }
}
