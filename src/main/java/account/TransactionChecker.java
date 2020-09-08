package account;

import java.math.BigDecimal;

import static javax.swing.JOptionPane.showMessageDialog;

public class TransactionChecker {

    public static BigDecimal checkFoundsOnAccount(BigDecimal allCashOnAccount, String creditCardCashText) {
        BigDecimal amount = new BigDecimal(creditCardCashText);
        if (allCashOnAccount.compareTo(amount) >= 0) {
            return amount.negate();
        } else {
            showMessageDialog(null, "you cannot withdraw money insufficient funds in your account");
            return BigDecimal.ZERO;
        }
    }
}
