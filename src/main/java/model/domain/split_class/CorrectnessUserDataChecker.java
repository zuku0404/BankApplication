package model.domain.split_class;

import java.util.ArrayList;
import java.util.List;

public class CorrectnessUserDataChecker {
    private String password;
    private String pesel;
    private String dateOfBirth;
    private String name;
    private String surname;

    private ConditionsOfValidation cv = new ConditionsOfValidation();
    private List<String> errorMessageText = new ArrayList<>();

    public CorrectnessUserDataChecker(String password, String pesel, String dateOfBirth, String name,
                                      String surname) {

        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
    }

    public List<String> checkValidationData() {
        if (showMessageErrorsInValidation()) {
            UserCreator userCreator = new UserCreator();
            userCreator.createUser(password, name, surname, dateOfBirth, pesel);
        }
        return errorMessageText;
    }

    private boolean showMessageErrorsInValidation() {
        errorMessageText.add(cv.checkPassword(password));
        errorMessageText.add(cv.checkName(name));
        errorMessageText.add(cv.checkSurname(surname));
        errorMessageText.add(cv.checkDate(dateOfBirth));
        errorMessageText.add(cv.checkPesel(pesel, dateOfBirth));

        for (int i = 0; i < errorMessageText.size(); i++) {
            if (!errorMessageText.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}