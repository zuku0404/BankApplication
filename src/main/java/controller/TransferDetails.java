package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter

public class TransferDetails {
    private int userId;
    private String recipientUserId;
    private String title;
    private String cash;
    private BigDecimal balance;

    public TransferDetails(String cash, int userId, String title) {
        this.userId = userId;
        this.title = title;
        this.cash = cash;
    }

    public TransferDetails(String cash, int userId, String title, BigDecimal balance) {
        this.userId = userId;
        this.title = title;
        this.cash = cash;
        this.balance = balance;
    }
}
