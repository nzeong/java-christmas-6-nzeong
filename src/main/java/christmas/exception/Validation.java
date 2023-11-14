package christmas.exception;

import christmas.model.Menu;
import christmas.model.MenuGroup;

import java.util.ArrayList;
import java.util.List;

import static christmas.exception.Exception.*;


public class Validation {

    public static int validateDate(String input) {
        checkInt(input);
        int number = Integer.parseInt(input);
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }

        return number;
    }

    public static List<Menu> validateMenu(String input) {
        List<Menu> orders = new ArrayList<>();

        List<String> orderSplit = List.of(input.split(","));
        for (int i = 0; i < orderSplit.size(); i++) {
            validateOrderForm(orderSplit.get(i));
            List<String> order = List.of(orderSplit.get(i).split("-"));

            String name = separateMenu(order.get(0));
            int count = separateCount(order.get(1));
            orders.add(new Menu(name, count));
        }
        return orders;
    }

    private static String separateMenu(String input) {
        if (!MenuGroup.hasMenu(input)) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
        return input;
    }

    private static int separateCount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
        int count = Integer.parseInt(input);
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
        return count;
    }

    private static void checkInt(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT.getMessage());
        }
    }

    public static void validateOrderForm(String input) {
        if (!input.contains("-")) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
    }
}
