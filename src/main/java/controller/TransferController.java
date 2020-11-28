package controller;

import data_base.TransferDB;
import model.domain.transaction.TransactionChecker;
import model.domain.transaction.TransactionType;
import model.validation.Validator;

import java.math.BigDecimal;
import java.util.Optional;

public class TransferController {
    public void makeTransfer(TransferDetails transferDetails) {
        validationTransferData(transferDetails.getCash(), transferDetails.getTitle(), transferDetails.getRecipientUserId());

        Optional<BigDecimal> verifiedCash = TransactionChecker.checkFoundsOnAccount(transferDetails.getBalance(), transferDetails.getCash());

        verifiedCash.ifPresentOrElse(c -> transfer(c, transferDetails),
                () -> exceptionMessage("You cannot withdraw money. Insufficient funds."));
    }

    private void transfer(BigDecimal moneyPayedOut, TransferDetails transferDetails) {
        TransferDB transferDB = new TransferDB(transferDetails.getUserId(), Integer.parseInt(transferDetails.getRecipientUserId()),
                TransactionType.TRANSFER, moneyPayedOut, transferDetails.getTitle());
        transferDB.createTransfer();
    }

    private void validationTransferData(String cash, String title, String idRecipient) {
        Validator validator = new Validator();

        if (!validator.checkCash(cash))
            exceptionMessage("Wrong amount was entered");
        else if (!validator.checkTitle(title))
            exceptionMessage("Transfer title is missing");
        else if (!validator.checkIdUserRecipient(idRecipient))
            exceptionMessage("Wrong recipient id");
    }

    private void exceptionMessage(String message) {
        throw new IllegalArgumentException(message);
    }
}

