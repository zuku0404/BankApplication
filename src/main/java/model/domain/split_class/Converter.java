package model.domain.split_class;

import javax.swing.*;
import java.util.List;

public class Converter {
    private String password;
    private String pesel;
    private String dateOfBirth;
    private String name;
    private String surname;

    private JTextArea errorPassword;
    private JTextArea errorName;
    private JTextArea errorSurname;
    private JTextArea errorDateOfBirth;
    private JTextArea errorPesel;


    public Converter(JPasswordField password, JTextField pesel, JTextField dateOfBirth, JTextField name,
                     JTextField surname, JTextArea errorPassword, JTextArea errorName,
                     JTextArea errorSurname, JTextArea errorDateOfBirth, JTextArea errorPesel) {

        this.password = String.valueOf(password.getPassword());
        this.pesel = pesel.getText();
        this.dateOfBirth = dateOfBirth.getText();
        this.name = name.getText();
        this.surname = surname.getText();

        this.errorPassword = errorPassword;
        this.errorName = errorName;
        this.errorSurname = errorSurname;
        this.errorDateOfBirth = errorDateOfBirth;
        this.errorPesel = errorPesel;
    }

    public boolean createAccountOrShowErrors() {
        CorrectnessUserDataChecker user = new CorrectnessUserDataChecker(password, pesel, dateOfBirth,
                name, surname);
        List<String> textSetter = user.checkValidationData();

        errorPassword.setText(textSetter.get(0));
        errorName.setText(textSetter.get(1));
        errorSurname.setText(textSetter.get(2));
        errorDateOfBirth.setText(textSetter.get(3));
        errorPesel.setText(textSetter.get(4));

        for (String s : textSetter) {
            if (!s.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}