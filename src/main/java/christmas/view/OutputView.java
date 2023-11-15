package christmas.view;

import christmas.model.Menu;

import java.util.List;

public class OutputView {

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printMenu(List<Menu> orders) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getName() + " " + orders.get(i).getCount() + "개");
        }
    }

    public static void printTotalOrderPrice(int price) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(price + "원");
    }

    public static void printGift(boolean checkGift){
        System.out.println("\n<증정 메뉴>");
        if(checkGift == true){
            System.out.println("샴페인 1개");
        }
        if(checkGift == false){
            System.out.println("없음");
        }
    }

}