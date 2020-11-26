package model.domain.split_class;

import data_base.register.AccountDataRecorderDB;
import data_base.register.UserDataRecorderDB;
import model.cipher.CaesarCipher;
import model.domain.account.Account;
import model.domain.account.AccountCreator;
import model.domain.pesel.Pesel;
import model.domain.userLog.User;

public class UserCreator {
    public void createUser(String login, String password,String name,String surname,String dateOfBirth, String pesel){
        Pesel peselNumber = new Pesel(pesel);

        AccountCreator newAccount = new AccountCreator();
        Account account = newAccount.createAccount();

        CaesarCipher cipher = new CaesarCipher();
        String encryptedPassword = cipher.encryptPassword(password);

        User newUser = new User(name, surname, account, peselNumber, login, encryptedPassword, dateOfBirth);

        UserDataRecorderDB udr = new UserDataRecorderDB();
        udr.sendUserDateToServer(newUser);

        AccountDataRecorderDB adr = new AccountDataRecorderDB();
        adr.sendAccountDateToServer(newUser);


    }
}
