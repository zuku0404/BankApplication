package model.domain.userLog;

import data_base.login.LoginCheckerDB;
import data_base.login.PasswordCheckerDB;


// nie wiem czy tak może być ze zwraca id lub 0 pozniej w drugiej funkcji znowu to sprawdza  !!!!!
public class UserLogPasChecker {
    public static int checkAccount(String login, String password) {
        LoginCheckerDB loginCheckerDB = new LoginCheckerDB();
        PasswordCheckerDB passwordCheckerDB = new PasswordCheckerDB();
        int id = loginCheckerDB.checkLogin(login);
        if (id == 0) {
            System.out.println("login not exist");
            return 0;
        } else if (!passwordCheckerDB.checkPassword(login, password)) {
            System.out.println("password incorrect");
            return 0;
        } else
            return id;
    }
}
