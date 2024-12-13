package main;

import service.ExpenseManager;

public class App {
    public static void main(String[] args) throws Exception {
        // Create and run ExpenseManager instance
        ExpenseManager manager = new ExpenseManager();
        manager.run();
    }
}
