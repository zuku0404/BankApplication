package model.domain.transaction;

public enum TransactionType {
    DEPOSIT("deposit"),
    TRANSFER ("transfer"),
    CREDIT_CARD("credit card"),
    WITHDRAWAL("transfer,credit card"),
    ALL_TRANSACTION("deposit,transfer,credit card");

    private String typeOfTransaction;

    TransactionType(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

}
