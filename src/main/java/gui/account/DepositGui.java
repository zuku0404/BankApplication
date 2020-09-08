package gui.account;

import Regex.Regex;
import account.Transfer;

import javax.swing.*;
import java.math.BigDecimal;

import static account.TransactionType.DEPOSIT;

public class DepositGui {
    private final static String TITLE = "payment of money";

    public static void createDepositGui(int userId, JLabel labelCash) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel depositCash = new JLabel("amount deposited into the account ");
        JTextField depositCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(actionEvent -> {
            Regex regex = new Regex();
            if (regex.checkCash(depositCashText.getText()) == true) {
                BigDecimal depositCashDecimal = new BigDecimal(depositCashText.getText());
                Transfer transfer = new Transfer(userId, userId, DEPOSIT, depositCashDecimal, TITLE);
                transfer.createTransfer();
                labelCash.setText(AccountGui.getCurrentAccountBalance(userId).toString());
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "the wrong amount was entered");
            }
        });

        mainPanel.add(depositCash);
        mainPanel.add(depositCashText);
        mainPanel.add(confirmButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setSize(300, 150);
    }
}
