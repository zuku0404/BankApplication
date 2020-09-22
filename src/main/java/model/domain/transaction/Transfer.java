package model.domain.transaction;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class Transfer {
    private String userName;
    private String userSurname;
    private String recipientName;
    private String recipientSurname;
    private String transferType;
    private double transferCash;
    private String title;

    public Transfer(String userName, String userSurname, String recipientName, String recipientSurname, String transferType,
                    double transferCash, String title) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.transferType = transferType;
        this.transferCash = transferCash;
        this.title = title;
    }
}
