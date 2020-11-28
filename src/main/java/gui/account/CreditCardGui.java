package gui.account;

import controller.CreditCardController;
import controller.TransferDetails;
import gui.Gui;
import model.domain.account.CurrentAccountBalance;

import javax.swing.*;
import java.math.BigDecimal;

import static javax.swing.JOptionPane.showMessageDialog;

public class CreditCardGui implements Gui {
    private static final String TITLE = "cash withdrawal at an ATM";
    private int userId;
    private BigDecimal balance;
    private JLabel cashLabel;

    public CreditCardGui(BigDecimal balance, int userId, JLabel cashLabel) {
        this.userId = userId;
        this.balance = balance;
        this.cashLabel = cashLabel;
    }

    @Override
    public void show() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel creditCardCash = new JLabel("how much money do you want to withdraw ");
        JTextField creditCardCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(actionEvent -> {
            CreditCardController creditCardController = new CreditCardController();
            TransferDetails transferDetails = new TransferDetails(creditCardCashText.getText(), userId, TITLE, balance);
            try {
                creditCardController.makeTransfer(transferDetails);
                    CurrentAccountBalance currentAccountBalance = new CurrentAccountBalance();
                cashLabel.setText(currentAccountBalance.getCurrentAccountBalance(userId).toString());
                    frame.dispose();
            } catch (IllegalArgumentException ex) {
                showMessageDialog(null, ex.getMessage());
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

