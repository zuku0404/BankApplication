package model.domain.split_class;

import java.util.ArrayList;

public class CorrectnessUserDataChecker {
    private String login;
    private String password;
    private String pesel;
    private String dateOfBirth;
    private String name;
    private String surname;
    private String errorLogin;
    private String errorPassword;
    private String errorName;
    private String errorSurname;
    private String errorDateOfBirth;
    private String errorPesel;
    private ConditionsOfValidation cv = new ConditionsOfValidation();
    private ArrayList<String> text = new ArrayList<>();

    public CorrectnessUserDataChecker(String login, String password, String pesel, String dateOfBirth, String name,
                                      String surname, String errorLogin, String errorPassword, String errorName, String errorSurname,
                                      String errorDateOfBirth, String errorPesel) {

        this.login = login;
        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
        this.errorLogin = errorLogin;
        this.errorPassword = errorPassword;
        this.errorName = errorName;
        this.errorSurname = errorSurname;
        this.errorDateOfBirth = errorDateOfBirth;
        this.errorPesel = errorPesel;
    }
    public ArrayList<String> checkValidationData() {
        if (areAllConditionCorrect()) {
            UserCreator userCreator = new UserCreator();
            userCreator.createUser(login,password,name,surname,dateOfBirth,pesel);
        }
        return text;
    }

    private boolean areAllConditionCorrect() {
        text.add(cv.checkLogin(login));
        text.add(errorPassword = cv.checkPassword(password));
        text.add(cv.checkName(name));
        text.add(cv.checkSurname(surname));
        text.add(cv.checkDate(dateOfBirth));
        text.add(cv.checkPesel(pesel));

        return text.get(0).isEmpty() && text.get(1).isEmpty() && text.get(2).isEmpty() && text.get(3).isEmpty() &&
                text.get(4).isEmpty() && text.get(5).isEmpty(); //TODO lambda
    }
}