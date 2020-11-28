package controller;

import data_base.TransferDB;
import model.domain.transaction.TransactionType;
import model.validation.Validator;

import java.math.BigDecimal;

public class DepositController {
    public void makeTransfer(TransferDetails transferDetails) {

        validationTransferData(transferDetails.getCash());

        BigDecimal depositCashDecimal = new BigDecimal(transferDetails.getCash());
        transfer(depositCashDecimal, transferDetails);

    }

    private void transfer(BigDecimal cash, TransferDetails transferDetails) {
        TransferDB transferDB = new TransferDB(transferDetails.getUserId(), transferDetails.getUserId(), TransactionType.DEPOSIT,
                cash, transferDetails.getTitle());
        transferDB.createTransfer();
    }
    private void validationTransferData(String cash) {
        Validator validator = new Validator();
        if (!validator.checkCash(cash)) {
            throw new IllegalArgumentException("Wrong amount was entered");
        }
    }
}
