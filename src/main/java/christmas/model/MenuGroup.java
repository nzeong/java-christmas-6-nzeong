package christmas.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MenuGroup {
    APPETIZER(Arrays.asList("양송이수프", "타파스", "시저샐러드")),
    MAIN(Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타")),
    DESERT(Arrays.asList("초코케이크", "아이스크림")),
    DRINK(Arrays.asList("제로콜라", "레드와인", "샴페인")),
    EMPTY(Collections.EMPTY_LIST);

    MenuGroup(List<String> menuList) {
        this.menuList = menuList;
    }

    public List<String> getMenuList() {
        return menuList;
    }


    public static MenuGroup findByName(String name){
        return Arrays.stream(MenuGroup.values())
                .filter(menuGroup -> menuGroup.hasMenu(name))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasMenu(String name){
        return menuList.stream()
                .anyMatch(menu -> menu.equals(name));
    }
    private List<String> menuList;
}
