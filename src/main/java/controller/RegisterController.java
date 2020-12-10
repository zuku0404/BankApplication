package controller;

import model.domain.split_class.ConditionsOfValidation;
import model.domain.split_class.UserCreator;

import java.util.ArrayList;
import java.util.List;

public class RegisterController {

    public String createUserAndGetUserId(RegisterDetails registerDetails) {
        String errorString = getMessageErrors(registerDetails);
        if (errorString.isEmpty()) {
            UserCreator userCreator = new UserCreator();
            return userCreator.createUser(registerDetails.getPassword(), registerDetails.getName(), registerDetails.getSurname(),
                    registerDetails.getDateOfBirth(), registerDetails.getPesel());
        }
        throw new IllegalArgumentException(errorString);
    }

    public String getMessageErrors(RegisterDetails registerDetails) {
        List<String> errorMessageText = new ArrayList<>();
        ConditionsOfValidation cv = new ConditionsOfValidation();
        StringBuilder errors = new StringBuilder();

        errorMessageText.add(cv.checkPassword(registerDetails.getPassword()));
        errorMessageText.add(cv.checkName(registerDetails.getName()));
        errorMessageText.add(cv.checkSurname(registerDetails.getSurname()));
        errorMessageText.add(cv.checkDate(registerDetails.getDateOfBirth()));
        errorMessageText.add(cv.checkPesel(registerDetails.getPesel(), registerDetails.getDateOfBirth()));

        for (String s : errorMessageText) {
            if (!s.isEmpty())
                errors.append("-" + s + "\n");
        }
        return errors.toString();
    }
}
