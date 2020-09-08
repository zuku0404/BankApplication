package account;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class TransferFrame {
    int userId;
    int userRecipientId;
    String transferType;
    double transferCash;
    String title;

    public TransferFrame(int userId, int userRecipientId, String transferType, double transferCash, String title) {
        this.userId = userId;
        this.userRecipientId = userRecipientId;
        this.transferType = transferType;
        this.transferCash = transferCash;
        this.title = title;
    }
}
