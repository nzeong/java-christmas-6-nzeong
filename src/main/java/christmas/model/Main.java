package christmas.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum Main {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIB("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String itemName;
    private final int price;

    Main(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public static int getPriceByName(String name) {
        Optional<Main> foundMain =
                Stream.of(Main.values())
                        .filter(main -> main.getItemName().equals(name))
                        .findFirst();

        return foundMain.map(main -> main.getPrice()).orElse(0);
    }

}
