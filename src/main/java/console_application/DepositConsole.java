package console_application;

import controller.DepositController;
import controller.TransferDetails;

import java.util.Scanner;

public class DepositConsole {
    Scanner scanner = new Scanner(System.in);
    private static final String TITLE_DEPOSIT = "payment of money";
    private int userId;

    public DepositConsole(int userId) {
        this.userId = userId;
    }

    public void setDepositDetails() {
        System.out.print("amount deposited into the account: ");
        String depositCash = scanner.nextLine();
        DepositController depositController = new DepositController();
        TransferDetails transferDetails = new TransferDetails(depositCash, userId, TITLE_DEPOSIT);
        try {
            depositController.makeTransfer(transferDetails);
            AccountConsole accountConsole = new AccountConsole(userId);
            accountConsole.openAccount();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            if (WrongDataInAccountScript.whatNextAfterWrongData()) {
                setDepositDetails();
            }
        }
    }
}
