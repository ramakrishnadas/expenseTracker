package model;

public class RecurringExpense extends Expense {
    // Declare RecurringExpense class attributes
    private String frequency;
    private String endDate;

    // Define constructor for RecurringExpense class
    public RecurringExpense(int id, double amount, String category, String date, String description, String frequency, String endDate) {
        super(id, amount, category, date, description);
        this.frequency = frequency;
        this.endDate = endDate;
    }

    // Define getters and setters
    public String getFrequency() { return frequency; }
    public String getEndDate() { return endDate; }

    // Turn expense into a string
    @Override
    public String toString() {
        return super.toString() + " [Recurring: " + frequency + " until " + endDate + "]";
    }
}
