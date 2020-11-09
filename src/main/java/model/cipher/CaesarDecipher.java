package model.cipher;

public class CaesarDecipher {
    public String decryptPassword(String encryptedPassword) {
        int shift = 4;
        int numberSignsInAscii = 127;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < encryptedPassword.length(); i++) {
            char sign = encryptedPassword.charAt(i);
            if (sign - shift < 0) {
                password.append((char) (sign + (numberSignsInAscii - shift)));
            } else {
                password.append((char) (sign - shift));
            }
        }
        return password.toString();
    }
}

