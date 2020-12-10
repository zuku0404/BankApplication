package gui.account;

import data_base.account_information.AccountInformationFetcher;
import gui.Gui;
import model.domain.account.CurrentAccountBalance;

import javax.swing.*;

public class AccountGui implements Gui {
    private int id;

    public AccountGui(int id) {
        this.id = id;
    }

    @Override
    public void show() {
        CurrentAccountBalance currentAccountBalance = new CurrentAccountBalance();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();

        JLabel cash = new JLabel(currentAccountBalance.getCurrentAccountBalance(id).toString());
        JLabel numberAccount = new JLabel("Your account number : ");
        AccountInformationFetcher accountInformationFetcher = new AccountInformationFetcher();
        JLabel accountNumber = new JLabel(accountInformationFetcher.getUserAccountNumber(id));
        JLabel cashOnAccount = new JLabel("Cash on your account: ");

        JButton transferButton = new JButton("transfer");
        transferButton.addActionListener(actionEvent -> {
            TransferGui transferGui = new TransferGui(currentAccountBalance.getCurrentAccountBalance(id), id, cash);
            transferGui.show();
        });

        JButton creditCardButton = new JButton("use card");
        creditCardButton.addActionListener(actionEvent -> {
            CreditCardGui creditCardGui = new CreditCardGui(currentAccountBalance.getCurrentAccountBalance(id), id, cash);
            creditCardGui.show();
        });

        JButton depositButton = new JButton("deposit");
        depositButton.addActionListener(actionEvent -> {
            DepositGui depositGui = new DepositGui(id, cash);
            depositGui.show();
        });

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