import javax.swing.*;

public class AccountGui {
    public void createAccountGui(String login) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        HistoryTransferDB hdb = new HistoryTransferDB();
        hdb.checkUserTransferHistory(login);

        JLabel numberAccount = new JLabel("Your number Account: ");
        JLabel cashOnAccount = new JLabel("Cash on your account: ");

        JButton transferButton = new JButton("transfer");
        transferButton.addActionListener(actionEvent -> TransferGui.createTransferGui());
        JButton creditCardButton = new JButton("use card");
        creditCardButton.addActionListener(actionEvent -> CreditCardGui.createCreditCardGui());
        JButton depositButton = new JButton("deposit");
        depositButton.addActionListener(actionEvent -> DepositGui.createDepositGui());
        JButton checkTransferHistoryButton = new JButton("check History");
        checkTransferHistoryButton.addActionListener(new HistoryTransferDB(login));
        JButton logOut = new JButton("log out");

        mainPanel.add(transferButton);
        mainPanel.add(creditCardButton);
        mainPanel.add(depositButton);

        frame.getContentPane().add(mainPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
