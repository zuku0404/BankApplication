package model.domain.pesel;

public class Pesel {
    private long number;

    public Pesel (long number){
        this.number = number;
    }

    public long getNumber() {
        return number;
    }
    public static Pesel validateAndCreate (String pesel, String birthDate){
        PeselChecker peselChecker = new PeselChecker();
        if(peselChecker.checkPesel(pesel, birthDate)){
           return new Pesel(Long.parseLong(pesel));
        }
        return  null;
    }
}