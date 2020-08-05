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

    public UsersCreator(JTextField login, JTextField password, JTextField pesel, JTextField dateOfBirth, JTextField name, JTextField surname) {
        this.login = login;
        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pesel pesel = Pesel.validateAndCreate(this.pesel.getText(),dateOfBirth.getText());
        if(pesel != null)
        {
            AccountCreator newAccount = new AccountCreator();
            Account account = newAccount.createAccount();

            CaesarCipher cipher = new CaesarCipher();
            String encryptedPassword = cipher.encryptPassword(password.getText());

            User user = new User(name.getText(),surname.getText(), account, pesel, login.getText(),encryptedPassword,
                    dateOfBirth.getText());

            AccounDataRecorderDB adr = new AccounDataRecorderDB ();
            adr.sendAccountDateToServer(user);
            UserDataRecorderDB udr = new UserDataRecorderDB();
            udr.sendUserDateToServer(user);
            this.pesel.setText("");
            name.setText("");
            surname.setText("");
            dateOfBirth.setText("");
            login.setText("");
            password.setText("");
            System.out.println("data accept");
        }
        else {
            System.out.println("something wrong with your pesel !!!");
        }
    }
}