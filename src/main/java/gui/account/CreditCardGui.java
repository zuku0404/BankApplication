package gui.account;

import Regex.Regex;
import account.TransactionChecker;
import account.TransactionType;
import account.Transfer;

import javax.swing.*;
import java.math.BigDecimal;

public class CreditCardGui {
    private final static String OPERATION_TYPE = "credit card";
    private final static String TITLE = "cash withdrawal at an ATM";

    public static void createCreditCardGui(BigDecimal allCashOnAccount, int userId, JLabel labelCash) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel creditCardCash = new JLabel("how much money do you want to withdraw ");
        JTextField creditCardCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(actionEvent -> {
            Regex regex = new Regex();
            if (regex.checkCash(creditCardCashText.getText()) == true) {
                BigDecimal cashBigDecimal = TransactionChecker.checkFoundsOnAccount(allCashOnAccount, creditCardCashText.getText());
                Transfer transfer = new Transfer(userId, userId, TransactionType.CREDIT_CARD, cashBigDecimal, TITLE);
                transfer.createTransfer();
                labelCash.setText(AccountGui.getCurrentAccountBalance(userId).toString());
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "the wrong amount was entered");
            }
        });

        mainPanel.add(creditCardCash);
        mainPanel.add(creditCardCashText);
        mainPanel.add(confirmButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setSize(300, 150);
    }


}

