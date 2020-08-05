import javax.swing.*;

public class DepositGui {
    public static void createDepositGui() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel depositCash = new JLabel("amount deposited into the account ");
        JTextField depositCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(new Transfer("deposit on your own account", depositCashText.getText(),
                "-", "deposit"));

        mainPanel.add(depositCash);
        mainPanel.add(depositCashText);
        mainPanel.add(confirmButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setSize(300, 150);
    }
}
