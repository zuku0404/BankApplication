import javax.swing.*;

public class TransferGui {
    public static void createTransferGui(){
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel title = new JLabel("title: ");
        JTextField titleText = new JTextField(20);

        JLabel peselRecipient = new JLabel("pesel user recipient: ");
        JTextField peselRecipientText = new JTextField(20);

        JLabel cash = new JLabel("cash: ");
        JTextField cashText = new JTextField(20);

        JButton makeTransferButton = new JButton("make a transfer");
        makeTransferButton.addActionListener(new Transfer(titleText.getText(), peselRecipientText.getText(),
                cashText.getText(),"transfer"));

        JPanel firstPanel = new JPanel();
        firstPanel.add(title);
        firstPanel.add(titleText);

        JPanel secondPanel = new JPanel();
        secondPanel.add(peselRecipient);
        secondPanel.add(peselRecipientText);

        JPanel thirdPanel = new JPanel();
        thirdPanel.add(cash);
        thirdPanel.add(cashText);

        JPanel fourthPanel = new JPanel();
        fourthPanel.add(makeTransferButton);

        frame.getContentPane().add(mainPanel);
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        frame.setVisible(true);
        frame.setSize(300,300);
    }
}
