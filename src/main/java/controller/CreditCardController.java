package controller;

import data_base.TransferDB;
import model.domain.transaction.TransactionChecker;
import model.domain.transaction.TransactionType;
import model.validation.Validator;

import java.math.BigDecimal;
import java.util.Optional;

public class CreditCardController {
    public void makeTransfer(TransferDetails transferDetails) {
        validationTransferData(transferDetails.getCash());

        Optional<BigDecimal> cashBigDecimal = TransactionChecker.checkFoundsOnAccount(transferDetails.getBalance(), transferDetails.getCash());

        cashBigDecimal.ifPresentOrElse(c -> transfer(c, transferDetails),
                () -> exceptionMessage("You cannot withdraw money. Insufficient funds."));
    }

    private void transfer(BigDecimal moneyPayedOut, TransferDetails transferDetails) {
        TransferDB transferDB = new TransferDB(transferDetails.getUserId(), transferDetails.getUserId(),
                TransactionType.CREDIT_CARD, moneyPayedOut, transferDetails.getTitle());
        transferDB.createTransfer();
    }

    private void validationTransferData(String cash) {
        Validator validator = new Validator();
        if (!validator.checkCash(cash))
            exceptionMessage("Wrong amount was entered");
    }

    private void exceptionMessage(String message) {
        throw new IllegalArgumentException(message);
    }
}
