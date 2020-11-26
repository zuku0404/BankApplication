package model.domain.account;

import data_base.account_information.AccountInformationFetcher;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrentAccountBalance {
    public BigDecimal getCurrentAccountBalance(int id) {
        AccountInformationFetcher ac = new AccountInformationFetcher();
        return ac.getCurrentCash(id).setScale(2, RoundingMode.CEILING);
    }
}
