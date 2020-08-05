import javax.swing.*;

public class CreditCardGui {
    public static void createCreditCardGui() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel creditCardCash = new JLabel("how much money do you want to withdraw ");
        JTextField creditCardCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(new Transfer("cash withdrawal at an ATM", creditCardCashText.getText(),
                "-", "credit card"));

        mainPanel.add(creditCardCash);
        mainPanel.add(creditCardCashText);
        mainPanel.add(confirmButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setSize(300, 150);
    }
}

