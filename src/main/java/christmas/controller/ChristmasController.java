package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

import static christmas.model.MenuGroup.*;
import static christmas.view.OutputView.printTotalOrderPrice;

public class ChristmasController {

    private int date;
    private List<Menu> orders;
    private int totalOrderPrice = 0;

    public void run() {
        readDate();
        readMenu();
        printMenu(orders);
        calculateTotalOrderPrice(orders);
        printTotalOrderPrice(totalOrderPrice);
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

    private void calculateTotalOrderPrice(List<Menu> orders){
        for(int i = 0; i< orders.size(); i++){
            String name = orders.get(i).getName();
            int count = orders.get(i).getCount();
            int price = getOrderPrice(name);

            int temp = count * price;
            totalOrderPrice += temp;
        }
    }

    private int getOrderPrice(String name){
        if(MenuGroup.findByName(name) == APPETIZER){
            return Appetizer.getPriceByName(name);
        }
        if(MenuGroup.findByName(name) == DESERT){
            return Desert.getPriceByName(name);
        }
        if(MenuGroup.findByName(name) == DRINK){
            return Drink.getPriceByName(name);
        }
        if(MenuGroup.findByName(name) == MAIN){
            return Main.getPriceByName(name);
        }
        return 0;
    }
}
