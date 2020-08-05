import java.util.ArrayList;
import java.util.List;

public class PeselChecker {

    public boolean checkPesel (String numberPesel, String dateOfBirth) {
        String[] psn = numberPesel.split("");
        if (!isNumberOfDigitsCorrect(numberPesel))
            return false;
        else if (!isFirstSixNumberCorrect(psn, dateOfBirth))
            return false;
        else if (!isRestOfNumbersCorrect(psn))
            return false;
        else {
            System.out.println ("the verification of pesel included success");
            return true;
        }
    }
    private List<String> modificationDateOfBirth(String dateOfBirth) {
        List<String> listOfChangedBirthDigit = new ArrayList<>();
        int[] positionDigit = {6, 7, 0, 1, 2, 3};
        String[] nobString = dateOfBirth.split("-");
        String txt = "";
        for (String a : nobString) {
            txt += a;
        }
        String[] nobArray = txt.split("");
        for (int value : positionDigit) {
            listOfChangedBirthDigit.add(nobArray[value]);
        }
        return listOfChangedBirthDigit;
    }
    private boolean isNumberOfDigitsCorrect(String pesel) {
        if (pesel.length() != 11) {
            System.out.println("incorrect number of digit");
            return false;
        }
        return true;
    }
    private boolean isFirstSixNumberCorrect(String[] psn, String dateOfBirth) {
        List<String> newList = modificationDateOfBirth(dateOfBirth);
        for (int i = 0; i < newList.size(); i++) {
            if (!psn[i].equals(newList.get(i))) {
                System.out.println("number of pesel and date not much");
                return false;
            }
        }
        return true;
    }
    private boolean isRestOfNumbersCorrect(String[] psn) {
        int sum = 0;
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        for (int i = 0; i <= psn.length - 2; i++) {
            sum = sum + (weights[i] * (Integer.parseInt(psn[i])));
        }
        if (!(10 - (sum % 10) == Integer.parseInt(psn[10]))) {
            System.out.println("pesel verification failed");
            return false;
        }
        return true;
    }
}
