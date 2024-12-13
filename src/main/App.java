package main;

import service.ExpenseManager;

public class App {
    public static void main(String[] args) throws Exception {
        
        ExpenseManager manager = new ExpenseManager();
        manager.run();
    }
}
