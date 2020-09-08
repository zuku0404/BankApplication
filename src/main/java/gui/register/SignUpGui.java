package gui.register;

import account.UsersCreator;

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
        JLabel errorLogin = new JLabel("");
        errorLogin.setForeground(Color.RED);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField passwordText = new JTextField(25);
        JTextArea errorPassword = new JTextArea("",2,40);
        errorPassword.setLineWrap(true);
        errorPassword.setWrapStyleWord(true);
        errorPassword.setForeground(Color.RED);
        errorPassword.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        errorPassword.setOpaque(false);


        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameText = new JTextField(25);
        JLabel errorName = new JLabel("");
        errorName.setForeground(Color.RED);

        JLabel surnameLabel = new JLabel("Surname: ");
        JTextField surnameText = new JTextField(25);
        JLabel errorSurname = new JLabel("");
        errorSurname.setForeground(Color.RED);

        JLabel pesel = new JLabel("Pesel: ");
        JTextField peselText = new JTextField(25);
        JLabel errorPesel = new JLabel("");
        errorPesel.setForeground(Color.RED);

        JLabel dateOfBirth = new JLabel("date of birth:");
        JTextField dateOfBirthText = new JTextField(25);
        JLabel errorDateOfBirth = new JLabel("");
        errorDateOfBirth.setForeground(Color.RED);

        JButton createAccount = new JButton("create");
        createAccount.addActionListener(new UsersCreator(loginText, passwordText, peselText, dateOfBirthText, nameText, surnameText,
                errorLogin,errorPassword,errorName,errorSurname,errorDateOfBirth,errorPesel));

        panel.setLayout(new GridLayout(0, 1));

        JPanel firstPanel = new JPanel();
        firstPanel.add(loginLabel);
        firstPanel.add(loginText);
        firstPanel.add(errorLogin);

        JPanel secondPanel = new JPanel();
        secondPanel.add(passwordLabel);
        secondPanel.add(passwordText);
        secondPanel.add(errorPassword);

        JPanel thirdPanel = new JPanel();
        thirdPanel.add(nameLabel);
        thirdPanel.add(nameText);
        thirdPanel.add(errorName);

        JPanel fourthPanel = new JPanel();
        fourthPanel.add(surnameLabel);
        fourthPanel.add(surnameText);
        fourthPanel.add(errorSurname);

        JPanel fifthPanel = new JPanel();
        fifthPanel.add(createAccount);

        JPanel sixthPanel = new JPanel();
        sixthPanel.add(pesel);
        sixthPanel.add(peselText);
        sixthPanel.add(errorPesel);

        JPanel seventhPanel = new JPanel();
        seventhPanel.add(dateOfBirth);
        seventhPanel.add(dateOfBirthText);
        seventhPanel.add(errorDateOfBirth);

        panel.add(label);
        panel.add(firstPanel);
        panel.add(secondPanel);
        panel.add(thirdPanel);
        panel.add(fourthPanel);
        panel.add(seventhPanel);
        panel.add(sixthPanel);
        panel.add(fifthPanel);

        frame.getContentPane().add(panel);
        frame.setSize(520, 600);
        frame.setVisible(true);
    }
}

