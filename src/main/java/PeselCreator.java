public class PeselCreator {
    public Pesel createPesel (String pesel, String birthDate){
        PeselChecker peselChecker = new PeselChecker();
        if(peselChecker.checkPesel(pesel, birthDate)){
            return new Pesel(Long.parseLong(pesel));
        }
        return null;
    }
}
