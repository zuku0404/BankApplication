package gui.account;

public class KindOfTransfer {
    private String deposit = "TRANSFER_TYPE = 'deposit'";
    private String credit_card = "TRANSFER_TYPE = 'credit_card'";
    private String transfer = "TRANSFER_TYPE = 'transfer' ";
    private String expenses = "TRANSFER_TYPE = 'credit_card' AND TRANSFER_TYPE = 'transfer'";
    private String all = "TRANSFER_TYPE = 'credit_card' AND TRANSFER_TYPE = 'deposit' AND TRANSFER_TYPE = 'transfer'";

    public String choseCondition(String transferChosen) {
        switch (transferChosen) {
            case "deoisit":
                return deposit;
            case "credit_card":
                return credit_card;
            case "transfer":
                return transfer;
            case "all expenses":
                return expenses;
            case "all":
                return all;
        }
        return null;
    }
}
