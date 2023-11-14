package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public void run() {
        readDate();
        readMenu();
    }

    private void readDate() {
        try {
            InputView.readDate();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            readDate();
        }
    }

    private void readMenu() {
        try {
            InputView.readMenu();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            readMenu();
        }
    }


}
