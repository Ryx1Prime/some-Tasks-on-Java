package model;

public enum DealStatus {
    //TODO тут важно понимать что у нас у каждого статуса получается есть индивидуальный номер, именно по нему можем позже сортировку пустить
    NEW("Сделка создана"),
    IN_PROGRESS("Сделка в процессе"),
    CLOSE_PLUS("Сделка закрыта успешно");
    //CLOSE_MINUS("Сделка не была закрыта успешно");

    private final String russianName;

    DealStatus(String russianName) {this.russianName = russianName;
    }

    public String getRussianName(){return russianName;
    }

}
