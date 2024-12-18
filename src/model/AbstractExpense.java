package model;

public abstract class AbstractExpense {
    private int id;
    private double amount;
    private String category;
    private String date;
    private String description;

    // Define onstructor for AbstractExpense class
    public AbstractExpense(int id, double amount, String category, String date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Define abstract method to be implemented by subclasses
    public abstract String getExpenseType();

    // Define common toString method for all subclasses
    @Override
    public String toString() {
        return String.format("ID: %d, Amount: %.2f, Category: %s, Date: %s, Description: %s",
                id, amount, category, date, description);
    }
}
