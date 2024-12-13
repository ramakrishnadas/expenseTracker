package model;

public class Expense {
    private int id;
    private double amount;
    private String category;
    private String date;
    private String description;

    // Define the constructor
    public Expense (int id, double amount, String category, String date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Define getters and setters
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return id + ": " + category + " - $" + amount + " on " + date + " (" + description + ")";
    }
}
