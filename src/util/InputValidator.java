package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class InputValidator {
    // Check if input date is a valid date
    public static boolean isValidDate(String date) {

        date = date.trim();
        
        String regex = "^\\d{2}-\\d{2}-\\d{4}$";

        if (!date.matches(regex)) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy").withLocale(Locale.ENGLISH);

        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Check if input amount is valid (greater than zero)
    public static boolean isValidAmount(double amount) {
        return amount >= 0;
    }
}
