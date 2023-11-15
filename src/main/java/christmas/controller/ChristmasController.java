package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

import static christmas.model.MenuGroup.*;
import static christmas.view.OutputView.*;

public class ChristmasController {

    private int date;
    private List<Menu> orders;
    private int totalOrderPrice = 0;
    private int totalSales = 0;
    private boolean checkGift = false;
    private String eventBadge = "없음";

    public void run() {
        readDate();
        readMenu();
        printMenu(orders);
        calculateTotalOrderPrice(orders);
        printTotalOrderPrice(totalOrderPrice);
        printGift(checkGift());
        getSales();
        printPurchasePrice(totalOrderPrice, totalSales, checkGift);
        giveEventBadge();
        printEventBadge(eventBadge);
    }

    private void getSales(){
        int christmasSales = getChristmasSales();
        int weekdaysSales = getWeekdaysSales();
        int weekendSales = getWeekendSales();
        int starSales = getStarSales();

        totalSales = christmasSales + weekdaysSales + weekendSales + starSales;
        if (checkGift){
            totalSales += 25000;
        }

        printSales(christmasSales, weekdaysSales, weekendSales, starSales, checkGift);
        printTotalSales(totalSales);
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

    private void printMenu(List<Menu> orders) {
        OutputView.printMenu(date, orders);
    }

    private void calculateTotalOrderPrice(List<Menu> orders) {
        for (int i = 0; i < orders.size(); i++) {
            String name = orders.get(i).getName();
            int count = orders.get(i).getCount();
            int price = getOrderPrice(name);

            int temp = count * price;
            totalOrderPrice += temp;
        }
    }

    private int getOrderPrice(String name) {
        if (MenuGroup.findByName(name) == APPETIZER) {
            return Appetizer.getPriceByName(name);
        }
        if (MenuGroup.findByName(name) == DESERT) {
            return Desert.getPriceByName(name);
        }
        if (MenuGroup.findByName(name) == DRINK) {
            return Drink.getPriceByName(name);
        }
        if (MenuGroup.findByName(name) == MAIN) {
            return Main.getPriceByName(name);
        }
        return 0;
    }

    private boolean checkGift() {
        if (totalOrderPrice > 120000) {
            checkGift = true;
        }
        return checkGift;
    }

    private int getChristmasSales() {
        int sales = 0;
        if (date < 26) {
            sales = 1000 + (date - 1) * 100;
        }
        return sales;
    }

    private int getWeekdaysSales() {
        int sales = 0;
        if (date % 7 == 3 || date % 7 == 4 || date % 7 == 5 || date % 7 == 6 || date % 7 == 0) {
            sales = calculateWeekdaysSales(sales);
        }
        return sales;
    }

    private int calculateWeekdaysSales(int sales) {
        for (Menu order : orders) {
            String name = order.getName();
            int count = order.getCount();
            if (MenuGroup.findByName(name) == DESERT)
                sales = 2023 * count;
        }
        return sales;
    }

    private int getWeekendSales() {
        int sales = 0;
        if (date % 7 == 1 || date % 7 == 2) {
            sales = calculateWeekendSales(sales);
        }
        return sales;
    }

    private int calculateWeekendSales(int sales) {
        for (Menu order : orders) {
            String name = order.getName();
            int count = order.getCount();
            if (MenuGroup.findByName(name) == MAIN)
                sales = 2023 * count;
        }
        return sales;
    }

    private int getStarSales() {
        int sales = 0;
        if (date % 7 == 3 || date == 25) {
            sales += 1000;
        }
        return sales;
    }

    private void giveEventBadge(){
        if(totalSales>=5000){
            eventBadge = "별";
        }
        if(totalSales>=10000){
            eventBadge = "트리";
        }
        if(totalSales>=20000){
            eventBadge = "산타";
        }
    }

}
