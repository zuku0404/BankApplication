package gui.account;

import controller.DepositController;
import controller.TransferDetails;
import gui.Gui;

import javax.swing.*;

public class DepositGui implements Gui {
    private static final String TITLE = "payment of money";
    private int userId;

    public DepositGui(int userId) {
        this.userId = userId;
    }

    @Override
    public void show() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel depositCash = new JLabel("amount deposited into the model.account ");
        JTextField depositCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(actionEvent -> {
            DepositController depositController = new DepositController();
            TransferDetails transferDetails = new TransferDetails(depositCashText.getText(), userId, TITLE);
            try {
                depositController.makeTransfer(transferDetails);
                frame.dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
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
