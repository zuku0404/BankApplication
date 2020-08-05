import javax.swing.*;

public class LoginGui {
    public void createGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JLabel loginLabel = new JLabel("Login: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JTextField loginField = new JTextField(20);
        JTextField passwordField = new JTextField(20);

        JButton userCreatorButton = new JButton("Sign up");
        userCreatorButton.addActionListener(actionEvent -> SignUpGui.createGui());

        JButton loginButton = new JButton("Sign in");
        loginButton.addActionListener(new OpenAccount(loginField,passwordField));

        frame.getContentPane().add(mainPanel);
        mainPanel.add(loginLabel);
        mainPanel.add(loginField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(userCreatorButton);
        mainPanel.add(loginButton);
        frame.setVisible(true);
        frame.setSize(1000, 500);
    }
}