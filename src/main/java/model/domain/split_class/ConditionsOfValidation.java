package model.domain.split_class;

import model.domain.pesel.PeselChecker;
import model.validation.Validator;

public class ConditionsOfValidation {
    private Validator validator = new Validator();

    public String checkPassword(String password) {
        if (!validator.checkPassword(password)) {
            return ("Your password must contain an uppercase letter, a lowercase letter, a special character " +
                    "and must be at least 8 characters long ");
        }
        return "";
    }
    public String checkName (String name) {
        if (!validator.checkNameSurname(name)) {
            return ("Name is too short or does not contain uppercase");
        }
        return "";
    }
    public String checkSurname (String surname) {
        if (!validator.checkNameSurname(surname)) {
            return ("surname is too short or does not contain uppercase");
        }
        return "";
    }
    public String checkDate(String date) {
        if (!validator.checkDataOfBirth(date)) {
            return ("format of data is not correct [XX-XX-XXXX]");
        }
        return "";
    }

    public String checkPesel(String pesel, String dateOfBirth) {
        if (!validator.checkPesel(pesel)) {
            return ("number of count is incorrect");
        } else {
            PeselChecker peselChecker = new PeselChecker(pesel, dateOfBirth);
            return peselChecker.checkPesel();
        }
    }
}