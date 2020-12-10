package gui.register;

import controller.RegisterController;
import controller.RegisterDetails;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class SignUpGui implements Gui {

    @Override
    public void show() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Registration Form: ");
        label.setFont(new Font("", Font.BOLD, 20));

        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordText = new JPasswordField(25);
        passwordText.setEchoChar('*');

        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameText = new JTextField(25);

        JLabel surnameLabel = new JLabel("Surname: ");
        JTextField surnameText = new JTextField(25);

        JLabel pesel = new JLabel("Pesel: ");
        JTextField peselText = new JTextField(25);

        JLabel dateOfBirth = new JLabel("date of birth: ");
        JTextField dateOfBirthText = new JTextField(25);

        JTextArea allErrors = new JTextArea("", 2, 40);
        allErrors.setLineWrap(true);
        allErrors.setWrapStyleWord(true);
        allErrors.setForeground(Color.RED);
        allErrors.setOpaque(false);

        JButton createAccount = new JButton("create");
        createAccount.addActionListener(actionEvent -> {
            RegisterDetails registerDetails = new RegisterDetails(passwordText, peselText, dateOfBirthText, nameText, surnameText);
            RegisterController registerController = new RegisterController();
            try {
                String loginOrError = registerController.createUserAndGetUserId(registerDetails);
                JOptionPane.showMessageDialog(frame, "Account has been created, your login is " + loginOrError);
                frame.dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                allErrors.setText(ex.getMessage());
            }
        });
        panel.setLayout(new GridLayout(0, 1));

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
        fifthPanel.add(createAccount);

        JPanel sixthPanel = new JPanel();
        sixthPanel.add(pesel);
        sixthPanel.add(peselText);

        JPanel seventhPanel = new JPanel();
        seventhPanel.add(dateOfBirth);
        seventhPanel.add(dateOfBirthText);

        JPanel eighth = new JPanel();
        eighth.add(allErrors);

        panel.add(label);
        panel.add(secondPanel);
        panel.add(thirdPanel);
        panel.add(fourthPanel);
        panel.add(seventhPanel);
        panel.add(sixthPanel);
        panel.add(eighth);
        panel.add(fifthPanel);

        frame.getContentPane().add(panel);
        frame.setSize(520, 900);
        frame.setVisible(true);
    }
}

