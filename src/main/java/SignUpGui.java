import javax.swing.*;
import java.awt.*;

public class SignUpGui  {

    public static void createGui() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Registration Form: ");
        label.setFont(new Font("", Font.BOLD, 20));

        JLabel loginLabel = new JLabel("Login: ");
        JTextField loginText = new JTextField(25);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField passwordText = new JTextField(25);

        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameText = new JTextField(25);

        JLabel surnameLabel = new JLabel("Surname: ");
        JTextField surnameText = new JTextField(25);

        JLabel pesel = new JLabel("Pesel: ");
        JTextField peselText = new JTextField(25);
        JLabel dateOfBirth = new JLabel("date of birth:");
        JTextField dateOfBirthText = new JTextField(25);

        JButton createAccount = new JButton("create");
        createAccount.addActionListener(new UsersCreator(loginText, passwordText, peselText, dateOfBirthText, nameText, surnameText));
       // stworzenie lambdy  - ewentualnie mape

        JButton backToLoginWindow = new JButton("back");
//        backToLoginWindow.addActionListener(new );


        panel.setLayout(new GridLayout(0, 1));

        JPanel firstPanel = new JPanel();
        firstPanel.add(loginLabel);
        firstPanel.add(loginText);

        JPanel secondPanel = new JPanel();
        secondPanel.add(passwordLabel);
        secondPanel.add(passwordText);

        JPanel thirdPanel = new JPanel();
        thirdPanel.add(nameLabel);
        thirdPanel.add(nameText);

        JPanel fourthPanel = new JPanel();
        fourthPanel.add(surnameLabel);
        fourthPanel.add(surnameText);

        JPanel fifthPanel = new JPanel();
//        fifthPanel.add(backToLoginWingow);
        fifthPanel.add(createAccount);

        JPanel sixthPanel = new JPanel();
        sixthPanel.add(pesel);
        sixthPanel.add(peselText);

        JPanel seventhPanel = new JPanel();
        seventhPanel.add(dateOfBirth);
        seventhPanel.add(dateOfBirthText);

        panel.add(label);
        panel.add(firstPanel);
        panel.add(secondPanel);
        panel.add(thirdPanel);
        panel.add(fourthPanel);
        panel.add(seventhPanel);
        panel.add(sixthPanel);
        panel.add(fifthPanel);


        frame.getContentPane().add(panel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
}

