public class AccountCreator {

    public Account createAccount() {
        return new Account(generateAccountNumber(),0.0);
    }

    private String generateAccountNumber() {
        AccountFinderDB accountFinderDB = new AccountFinderDB();
        for (int i = 0; i< 30; i++) {
            String newAccountNumber = createRandomAccountNumber();
            if (accountFinderDB.checkIfAccountNumberIsAvailable(newAccountNumber)) {
                return newAccountNumber;
            }
        }
        return null;   /// zwrocic Exception
    }
    private String createRandomAccountNumber() {
        String newAccountNumber = "1140";
        for (int i = 1; i < 23; i++) {
            newAccountNumber += String.valueOf((int) (Math.random() * 10));
        }
        return newAccountNumber;
    }
}
