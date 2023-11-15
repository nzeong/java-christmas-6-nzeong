package christmas.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum Drink {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String itemName;
    private final int price;

    Drink(String itemName, int price) {
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
        Optional<Drink> foundDrink =
                Stream.of(Drink.values())
                        .filter(drink -> drink.getItemName().equals(name))
                        .findFirst();

        return foundDrink.map(drink -> drink.getPrice()).orElse(0);
    }
}
