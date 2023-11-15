package christmas.view;

import christmas.model.Menu;

import java.util.List;

public class OutputView {

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printMenu(int date, List<Menu> orders) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");

        for (Menu order : orders) {
            System.out.println(order.getName() + " " + order.getCount() + "개");
        }
    }

    public static void printTotalOrderPrice(int price) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(price + "원");
    }

    public static void printGift(boolean checkGift) {
        System.out.println("\n<증정 메뉴>");
        if (checkGift) {
            System.out.println("샴페인 1개");
        }
        if (!checkGift) {
            System.out.println("없음");
        }
    }

    public static void printSales(int christmasSales, int weekdaysSales, int weekendSales, int starSales, boolean giftSales) {
        System.out.println("\n<혜택 내역>");
        if (christmasSales == 0 && weekdaysSales == 0 && weekendSales == 0 && starSales == 0 && giftSales == false) {
            System.out.println("없음");
        }

        printChristmasSales(christmasSales);
        printWeekdaysSales(weekdaysSales);
        printWeekendSales(weekendSales);
        printStarSales(starSales);
        printGiftSales(giftSales);
    }

    public static void printChristmasSales(int sales) {
        if (sales != 0) {
            System.out.println("크리스마스 디데이 할인: -" + sales + "원");
        }
    }

    public static void printWeekdaysSales(int sales) {
        if (sales != 0) {
            System.out.println("평일 할인: -" + sales + "원");
        }
    }

    public static void printWeekendSales(int sales) {
        if (sales != 0) {
            System.out.println("주말 할인: -" + sales + "원");
        }
    }

    public static void printStarSales(int sales) {
        if (sales != 0) {
            System.out.println("특별 할인: -" + sales + "원");
        }
    }

    public static void printGiftSales(boolean checkGift) {
        if (checkGift) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    public static void printTotalSales(int sales) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(sales + "원");
    }

    public static void printPurchasePrice(int totalOrderPrice, int totalSales, boolean checkGift){
        System.out.println("\n<할인 후 예상 결제 금액>");
        if (checkGift){
            totalSales -= 25000;
        }
        System.out.println((totalOrderPrice - totalSales) + "원");
    }


}