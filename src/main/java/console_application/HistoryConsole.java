package console_application;

import controller.HistoryController;
import model.domain.transaction.TransactionType;
import model.domain.transaction.Transfer;

import java.util.List;
import java.util.Scanner;

public class HistoryConsole {
    private int userId;
    private TransactionType transfer;

    public HistoryConsole(int userId) {
        this.userId = userId;
    }

    public void showHistory() {
        System.out.print("\nwhat kind of operation do you want display\n" +
                "deposit, write 1 \n" +
                "transfer, write 2\n" +
                "credit card, write 3\n" +
                "transfer,credit card, write 4\n" +
                "all transaction, write 5\n" +
                "What do you want to do: ");
        Scanner scanner = new Scanner(System.in);
        int transferNumber = scanner.nextInt();
        switch (transferNumber) {
            case 1:
                transfer = TransactionType.DEPOSIT;
                break;
            case 2:
                transfer = TransactionType.TRANSFER;
                break;
            case 3:
                transfer = TransactionType.CREDIT_CARD;
                break;
            case 4:
                transfer = TransactionType.WITHDRAWAL;
                break;
            case 5:
                transfer = TransactionType.ALL_TRANSACTION;
                break;
            default:
                showHistory();
        }
        HistoryController controller = new HistoryController();
        List<Transfer> filteredTransfers = controller.getFilteredTransfers(userId, transfer);
        for (Transfer a : filteredTransfers) {
            System.out.println(a.toString());
        }
        System.out.println("if you want to close stories press enter");
        scanner.nextLine();
        AccountConsole accountConsole = new AccountConsole(userId);
        accountConsole.openAccount();
    }
}
