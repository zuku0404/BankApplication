package account;

import Regex.Regex;
import account.cipher.CaesarCipher;
import data_base.register.AccountDataRecorderDB;
import data_base.register.UserDataRecorderDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsersCreator implements ActionListener {
    private JTextField login;
    private JTextField password;
    private JTextField pesel;
    private JTextField dateOfBirth;
    private JTextField name;
    private JTextField surname;
    private JLabel errorLogin;
    private JTextArea errorPassword;
    private JLabel errorName;
    private JLabel errorSurname;
    private JLabel errorDateOfBirth;
    private JLabel errorPesel;
    private Regex regex = new Regex();

    public UsersCreator(JTextField login, JTextField password, JTextField pesel, JTextField dateOfBirth, JTextField name,
                        JTextField surname, JLabel errorLogin, JTextArea errorPassword, JLabel errorName, JLabel errorSurname,
                        JLabel errorDateOfBirth, JLabel errorPesel) {
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!regex.checkLogin(login.getText())) {
            errorLogin.setText("login is too short, must be at least 8 characters long or does not contain uppercase");
        } else if (!regex.checkPassword(password.getText())) {
            errorLogin.setText("");
            errorPassword.setText("Your password must contain an uppercase letter, a lowercase letter, a special character " +
                    "and must be at least 8 characters long ");
        } else if (!regex.checkNameSurname(name.getText())) {
            errorLogin.setText("");
            errorPassword.setText("");
            errorName.setText("Name is too short or does not contain uppercase");
        } else if (!regex.checkNameSurname(surname.getText())) {
            errorLogin.setText("");
            errorPassword.setText("");
            errorName.setText("");
            errorSurname.setText("surname is too short or does not contain uppercase");
        } else if (!regex.checkDataOfBirth(dateOfBirth.getText())) {
            errorLogin.setText("");
            errorPassword.setText("");
            errorName.setText("");
            errorSurname.setText("");
            errorDateOfBirth.setText("format of data is not correct [XX-XX-XXXX]");

        } else if (!regex.checkPesel(pesel.getText())) {
            errorPesel.setText("it has to contain 11 digits");
            errorDateOfBirth.setText("");
            errorLogin.setText("");
            errorPassword.setText("");
            errorName.setText("");
            errorSurname.setText("");
        } else {
            errorPesel.setText("");
            errorDateOfBirth.setText("");
            errorLogin.setText("");
            errorPassword.setText("");
            errorName.setText("");
            errorSurname.setText("");

            Pesel pesel = Pesel.validateAndCreate(this.pesel.getText(), dateOfBirth.getText());
            AccountCreator newAccount = new AccountCreator();
            Account account = newAccount.createAccount();

            CaesarCipher cipher = new CaesarCipher();
            String encryptedPassword = cipher.encryptPassword(password.getText());

            User user = new User(name.getText(), surname.getText(), account, pesel, login.getText(), encryptedPassword,
                    dateOfBirth.getText());

            AccountDataRecorderDB adr = new AccountDataRecorderDB();
            adr.sendAccountDateToServer(user);
            UserDataRecorderDB udr = new UserDataRecorderDB();
            udr.sendUserDateToServer(user);
            this.pesel.setText("");
            name.setText("");
            surname.setText("");
            dateOfBirth.setText("");
            login.setText("");
            password.setText("");
        }
    }
}