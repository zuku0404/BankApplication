package console_application;

import controller.CreditCardController;
import controller.TransferDetails;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreditCardConsole {
    private static final String TITLE_CREDIT_CARD = "cash withdrawal at an ATM";
    private int userId;
    private BigDecimal balance;

    public CreditCardConsole(int userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public void setCreditCardDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money do you want to withdraw ");
        String creditCardCash = scanner.nextLine();
        CreditCardController creditCardController = new CreditCardController();
        TransferDetails transferDetails = new TransferDetails(creditCardCash, userId, TITLE_CREDIT_CARD, balance);
        try {
            creditCardController.makeTransfer(transferDetails);
            AccountConsole accountConsole = new AccountConsole(userId);
            accountConsole.openAccount();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            if (WrongDataInAccountScript.whatNextAfterWrongData()) {
                setCreditCardDetails();
            } else {
                AccountConsole accountConsole = new AccountConsole(userId);
                accountConsole.openAccount();
            }
        }
    }
}
