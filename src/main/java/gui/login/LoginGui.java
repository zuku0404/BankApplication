package gui.login;

import gui.account.AccountGui;
import gui.register.SignUpGui;
import model.domain.userLog.UserLogPasChecker;

import javax.swing.*;

public class LoginGui {

    private LoginGui(){}
    public static void createLoginGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JLabel loginLabel = new JLabel("Login: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JTextField loginField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        JButton userCreatorButton = new JButton("Sign up");
        userCreatorButton.addActionListener(actionEvent -> SignUpGui.createGui());

        JButton loginButton = new JButton("Sign in");
        loginButton.addActionListener(actionEvent -> {
            int idUserChecker = UserLogPasChecker.checkAccount(loginField.getText(), passwordField.getText());
            if (idUserChecker != 0) {
                AccountGui accountGui = new AccountGui();
                accountGui.createAccountGui(idUserChecker);
            }
        });
        frame.getContentPane().add(mainPanel);
        mainPanel.add(loginLabel);
        mainPanel.add(loginField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(userCreatorButton);
        frame.setVisible(true);
        frame.setSize(1000, 500);
    }
}