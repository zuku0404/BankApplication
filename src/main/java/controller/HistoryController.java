package controller;

import data_base.account_information.AccountInformationFetcher;
import model.domain.transaction.Transfer;

import java.util.ArrayList;
import java.util.List;

public class HistoryController {

    private AccountInformationFetcher userHistory = new AccountInformationFetcher();

    public List<Transfer> getFilteredTransfers(int userId, String kindOfAction) {
        return new ArrayList<>(userHistory.getHistoryForSpecificTransferType(userId, kindOfAction));
    }


}
