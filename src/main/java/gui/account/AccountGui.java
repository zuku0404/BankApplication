package gui.account;

import data_base.account_information.AccountInformationFetcher;
import model.domain.account.CurrentAccountBalance;

import javax.swing.*;

public class AccountGui {
    public void openYourAccount(int id) {

        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        CurrentAccountBalance currentAccountBalance = new CurrentAccountBalance();
        JLabel cash = new JLabel(currentAccountBalance.getCurrentAccountBalance(id).toString());
        JLabel numberAccount = new JLabel("Your account number : ");

        AccountInformationFetcher accountInformationFetcher = new AccountInformationFetcher();
        JLabel accountNumber = new JLabel(accountInformationFetcher.getUserAccountNumber(id));
        JLabel cashOnAccount = new JLabel("Cash on your account: ");

        JButton transferButton = new JButton("transfer");

        transferButton.addActionListener(actionEvent -> TransferGui.createTransferGui(currentAccountBalance.getCurrentAccountBalance(id), id, cash));

        JButton creditCardButton = new JButton("use card");
        creditCardButton.addActionListener(actionEvent -> CreditCardGui.createCreditCardGui(currentAccountBalance.getCurrentAccountBalance(id), id, cash));

        JButton depositButton = new JButton("deposit");
        depositButton.addActionListener(actionEvent -> DepositGui.createDepositGui(id, cash));

        JButton checkTransferHistoryButton = new JButton("check History");
        checkTransferHistoryButton.addActionListener(actionEvent -> {
            HistoryGui gui = new HistoryGui(id);
            gui.createTable();
        });

        mainPanel.add(cashOnAccount);
        mainPanel.add(cash);
        mainPanel.add(numberAccount);
        mainPanel.add(accountNumber);
        mainPanel.add(transferButton);
        mainPanel.add(creditCardButton);
        mainPanel.add(depositButton);
        mainPanel.add(checkTransferHistoryButton);

        frame.getContentPane().add(mainPanel);
        frame.setSize(280, 300);
        frame.setVisible(true);
    }
}