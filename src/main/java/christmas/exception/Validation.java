package christmas.exception;

import static christmas.exception.Exception.INVALID_DATE;
import static christmas.exception.Exception.NOT_NUMBER_INPUT;

public class Validation {

    public static int validateDate(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT.getMessage());
        }

        int number = Integer.parseInt(input);
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }

        return number;
    }
}
