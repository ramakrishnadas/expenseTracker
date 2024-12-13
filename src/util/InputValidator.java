package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class InputValidator {
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

    public static boolean isValidAmount(double amount) {
        return amount >= 0;
    }
}
