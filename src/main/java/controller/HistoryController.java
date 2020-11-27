package controller;

import data_base.account_information.AccountInformationFetcher;
import model.domain.transaction.TransactionType;
import model.domain.transaction.Transfer;

import java.util.ArrayList;
import java.util.List;

public class HistoryController {

    private AccountInformationFetcher userHistory = new AccountInformationFetcher();

    public List<Transfer> getFilteredTransfers(int userId, TransactionType transfers) {
        String[] actionsToDisplayed = transfers.getTypeOfTransaction().split(",");
        List<Transfer> transactionTypes = new ArrayList<>();
        for (String kindOfAction : actionsToDisplayed) {
            transactionTypes.addAll(userHistory.getHistoryForSpecificTransferType(userId, kindOfAction));
        }
        return transactionTypes;
    }
}
