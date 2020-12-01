package model.domain.login;

import data_base.login.LoginCheckerDB;

import java.util.Random;

public class LoginCreator {
    private String name;
    private String surname;
    private Random random = new Random();

    public LoginCreator(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String setLogin() {
        String login = null;
        int attemptNumber = 0;
        boolean correctLogin = false;

        while (!correctLogin) {
            login = createLogin();
            correctLogin = checkLoginAlreadyExist(login);
            attemptNumber++;
            if (attemptNumber > 30) {
                throw new IllegalArgumentException("too many unsuccessful attempts");
            }
        }
        return login;
    }

    private boolean checkLoginAlreadyExist(String login) {
        LoginCheckerDB loginChecker = new LoginCheckerDB();
        return loginChecker.checkLogin(login) == 0;
    }

    private String createLogin() {
        StringBuilder loginCreator = new StringBuilder();
        loginCreator.append(name);
        loginCreator.append(surname);
        for (int i = 0; i < 4; i++) {
            loginCreator.append(random.nextInt(10));
        }
        return loginCreator.toString();
    }
}
