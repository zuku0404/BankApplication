package controller;

import javax.swing.*;

public class RegisterDetails {
    private String password;
    private String pesel;
    private String dateOfBirth;
    private String name;
    private String surname;

    public RegisterDetails(String password, String pesel, String dateOfBirth, String name,
                           String surname) {

        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
    }

    public RegisterDetails(JPasswordField password, JTextField pesel, JTextField dateOfBirth, JTextField name,
                           JTextField surname) {

        this.password = String.valueOf(password.getPassword());
        this.pesel = pesel.getText();
        this.dateOfBirth = dateOfBirth.getText();
        this.name = name.getText();
        this.surname = surname.getText();
    }

    public String getPassword() {
        return password;
    }

    public String getPesel() {
        return pesel;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
