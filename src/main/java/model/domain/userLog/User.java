package model.domain.userLog;

import model.domain.account.Account;
import model.domain.pesel.Pesel;

public class User {
    private String name;
    private String surname;
    private Account account;
    private Pesel pesel;
    private String login;
    private String password;
    private String dateOfBirth;
    private int userId;

    public User(String name, String surname, Account account, Pesel pesel, String login, String password, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.pesel = pesel;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Account getAccount() {
        return account;
    }

    public Pesel getPesel() { return pesel; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getUserId() {
        return userId;
    }

}
