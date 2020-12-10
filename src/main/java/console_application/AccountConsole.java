package console_application;

import data_base.account_information.AccountInformationFetcher;
import model.domain.account.CurrentAccountBalance;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccountConsole {
    private AccountInformationFetcher accountInformationFetcher = new AccountInformationFetcher();
    private CurrentAccountBalance currentAccountBalance = new CurrentAccountBalance();
    private Scanner scanner = new Scanner(System.in);
    private int userId;

    public AccountConsole(int userId) {
        this.userId = userId;
    }

    public void openAccount() {
        BigDecimal balance = currentAccountBalance.getCurrentAccountBalance(userId);
        String actualCashOnAccount = balance.toString();
        String accountNumber = accountInformationFetcher.getUserAccountNumber(userId);
        System.out.println("Your account number : " + accountNumber);
        System.out.println("Cash on your account: " + actualCashOnAccount);
        System.out.println("\nif you want make a transfer, write 1\n" +
                "if you want use card, write 2\n" +
                "if you want deposit, write 3\n" +
                "if you want display transaction history, write 4\n" +
                "if you want log out, write 5\n");
        chooseAction(balance);
    }

    private void chooseAction(BigDecimal balance) {
        System.out.print("What do you want to do: ");
        int selectionNumber = scanner.nextInt();
        switch (selectionNumber) {
            case 1:
                TransferConsol transferConsol = new TransferConsol(userId, balance);
                transferConsol.setTransferDetails();
                break;
            case 2:
                CreditCardConsole creditCardConsole = new CreditCardConsole(userId, balance);
                creditCardConsole.setCreditCardDetails();
                break;
            case 3:
                DepositConsole depositConsole = new DepositConsole(userId);
                depositConsole.setDepositDetails();
                break;
            case 4:
                HistoryConsole historyConsole = new HistoryConsole(userId);
                historyConsole.showHistory();
                break;
            case 5:
                AccountConsole accountConsole = new AccountConsole(userId);
                accountConsole.openAccount();
                break;
            default:
                chooseAction(balance);
        }
    }
}
