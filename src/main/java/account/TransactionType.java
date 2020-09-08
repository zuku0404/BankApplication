package account;

public enum TransactionType {
    DEPOSIT("deposit"),
    TRANSFER ("transfer"),
    CREDIT_CARD("credit card");

    private String typeOfTransaction;

    TransactionType(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }



}
