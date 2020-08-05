import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenAccount implements ActionListener {
    JTextField login;
    JTextField password;

    public OpenAccount(JTextField login, JTextField password) {
        this.login = login;
        this.password = password;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (checkAccount()) {
            AccountGui accountGui = new AccountGui();
            accountGui.createAccountGui(login.getText());
        }
    }
    private boolean checkAccount() {
        LoginChecker loginChecker = new LoginChecker();
        PasswordChecker passwordChecker = new PasswordChecker();
        if (!loginChecker.checkLogin(login.getText())){
            System.out.println("login incorrect");
            return false;
        }
        else if (!passwordChecker.checkPassword(login.getText(),password.getText())) {
            System.out.println("password incorrect");
            return false;
        }
        else
            return true;
    }
}
