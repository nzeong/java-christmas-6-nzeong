package christmas.controller;

import christmas.model.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class ChristmasController {

    private int date;
    private List<Menu> orders;

    public void run() {
        readDate();
        readMenu();
        printMenu(orders);
    }

    private void readDate() {
        try {
            date = InputView.readDate();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            readDate();
        }
    }

    private void readMenu() {
        try {
            orders = InputView.readMenu();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            readMenu();
        }
    }

    private void printMenu(List<Menu> orders){
        OutputView.printMenu(orders);
    }

}
