package christmas.model;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum Appetizer {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String itemName;
    private final int price;

    Appetizer(String itemName, int price) {
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
        Optional<Appetizer> foundAppetizer =
                Stream.of(Appetizer.values())
                        .filter(appetizer -> appetizer.getItemName().equals(name))
                        .findFirst();

        return foundAppetizer.map(appetizer -> appetizer.getPrice()).orElse(0);
    }
}
