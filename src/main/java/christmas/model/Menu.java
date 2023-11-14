package christmas.model;

public class Menu {
    private final String name;
    private final int count;

    public Menu(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
