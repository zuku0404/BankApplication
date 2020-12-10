package console_application;

import controller.TransferController;
import controller.TransferDetails;

import java.math.BigDecimal;
import java.util.Scanner;

public class TransferConsol {
    private int userId;
    private BigDecimal balance;

    public TransferConsol(int userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public void setTransferDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nidRecipient: ");
        String idRecipient = scanner.nextLine();
        System.out.print("title: ");
        String title = scanner.nextLine();
        System.out.print("cash: ");
        String cash = scanner.nextLine();

        TransferController transferController = new TransferController();
        TransferDetails transferDetails = new TransferDetails(userId, idRecipient, title, cash, balance);
        try {
            transferController.makeTransfer(transferDetails);
            AccountConsole accountConsole = new AccountConsole(userId);
            accountConsole.openAccount();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            if (WrongDataInAccountScript.whatNextAfterWrongData()) {
                setTransferDetails();
            }
        }
    }
}
