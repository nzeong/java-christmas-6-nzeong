package christmas.exception;

public enum Exception {
    NOT_NUMBER_INPUT("숫자만 입력할 수 있습니다."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_NOT_FOUND("메뉴 목록에 없는 메뉴입니다.");


    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
