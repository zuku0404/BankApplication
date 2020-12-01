package gui.login;

import gui.account.AccountGui;
import gui.register.SignUpGui;
import model.domain.userLog.UserLogPasChecker;

import javax.swing.*;

public class LoginGui {

    private LoginGui() {
    }

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
        userCreatorButton.addActionListener(actionEvent -> {
            SignUpGui signUpGui = new SignUpGui();
            signUpGui.show();
        });

        JButton loginButton = new JButton("Sign in");
        loginButton.addActionListener(actionEvent -> {
            try {
                int idUserChecker = UserLogPasChecker.checkAccount(loginField.getText(), String.valueOf(passwordField.getPassword()));
                AccountGui accountGui = new AccountGui(idUserChecker);
                accountGui.show();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
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