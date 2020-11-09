package model.cipher;

public class CaesarCipher {
    private static final int SHIFT = 4;
    private static final int NUMBER_SIGNS_IN_ASCII = 127;

    public String encryptPassword(String password) {
        StringBuilder encryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char sign =  password.charAt(i);
            if (sign + SHIFT > NUMBER_SIGNS_IN_ASCII) {
                encryptedPassword.append((char) (sign - (NUMBER_SIGNS_IN_ASCII - SHIFT)));
            } else {
                encryptedPassword.append((char) (sign + SHIFT));
            }
        }
        return encryptedPassword.toString();
    }
}

