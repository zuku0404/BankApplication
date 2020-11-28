package gui.account;

import controller.TransferController;
import controller.TransferDetails;
import gui.Gui;
import model.domain.account.CurrentAccountBalance;

import javax.swing.*;
import java.math.BigDecimal;

public class TransferGui implements Gui {
    private BigDecimal balance;
    private int userId;
    private JLabel cashLabel;

    public TransferGui(BigDecimal balance, int userId, JLabel cashLabel) {
        this.balance = balance;
        this.userId = userId;
        this.cashLabel = cashLabel;
    }

    @Override
    public void show() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel title = new JLabel("title: ");
        JTextField titleText = new JTextField(20);

        JLabel idRecipient = new JLabel("id user recipient: ");
        JTextField idRecipientText = new JTextField(20);

        JLabel cash = new JLabel("cash: ");
        JTextField cashText = new JTextField(20);

        JButton transferButton = new JButton("make a transfer");

        transferButton.addActionListener(actionEvent -> {
            TransferController transferController = new TransferController();
            TransferDetails transferDetails = new TransferDetails(userId, idRecipientText.getText(),
                    titleText.getText(), cashText.getText(), balance);
            try {
                transferController.makeTransfer(transferDetails);
                CurrentAccountBalance currentAccountBalance = new CurrentAccountBalance();
                cashLabel.setText(currentAccountBalance.getCurrentAccountBalance(userId).toString());
                frame.dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        JPanel firstPanel = new JPanel();
        firstPanel.add(title);
        firstPanel.add(titleText);

        JPanel secondPanel = new JPanel();
        secondPanel.add(idRecipient);
        secondPanel.add(idRecipientText);

        JPanel thirdPanel = new JPanel();
        thirdPanel.add(cash);
        thirdPanel.add(cashText);

        JPanel fourthPanel = new JPanel();
        fourthPanel.add(transferButton);

        frame.getContentPane().add(mainPanel);
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        frame.setVisible(true);
        frame.setSize(300, 300);
    }
}
