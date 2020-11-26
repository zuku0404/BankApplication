package model.domain.pesel;

public class Pesel {
    private long number;

    public Pesel(String number) {
        this.number = Long.parseLong(number);
    }

    public long getNumber() {
        return number;
    }

}