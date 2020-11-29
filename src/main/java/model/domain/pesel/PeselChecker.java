package model.domain.pesel;

public class PeselChecker {
    private String[] dataSplitter;
    private String[] peselSplitter;

    public PeselChecker(String numberPesel, String dateOfBirth) {
        this.peselSplitter = numberPesel.split("");
        this.dataSplitter = modificationDateOfBirth(dateOfBirth);
    }

    public String checkPesel() {
        if (!isFirstSixNumberEquals())
            return "number of pesel and date do not fit";
        else if (!isRestOfNumbersCorrect())
            return "pesel verification failed";
        else
            return "";
    }

    String[] modificationDateOfBirth(String dateOfBirth) {
        int[] positionDigit = {8, 9, 3, 4, 0, 1};
        String[] dateConvert = new String[6];
        int i = 0;
        for (int position : positionDigit) {
            dateConvert[i] = String.valueOf(dateOfBirth.charAt(position));
            i++;
        }
        return dateConvert;
    }

    private boolean isFirstSixNumberEquals() {
        for (int i = 0; i < dataSplitter.length; i++) {
            if (!peselSplitter[i].equals(dataSplitter[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isRestOfNumbersCorrect() {
        int sum = 0;
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        for (int i = 0; i <= peselSplitter.length - 2; i++) {
            sum = sum + (weights[i] * (Integer.parseInt(peselSplitter[i])));
        }
        return 10 - (sum % 10) == Integer.parseInt(peselSplitter[10]);
    }
}
