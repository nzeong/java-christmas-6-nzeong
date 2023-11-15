package christmas.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum Desert {
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String itemName;
    private final int price;

    Desert(String itemName, int price) {
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
        Optional<Desert> foundDesert =
                Stream.of(Desert.values())
                        .filter(desert -> desert.getItemName().equals(name))
                        .findFirst();

        return foundDesert.map(desert -> desert.getPrice()).orElse(0);
    }

}
