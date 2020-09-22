package model.cipher;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {

    public String encryptPassword(String password) {
        String newPassword = "";
        List<Character> allLetters = new ArrayList<>();
        int numberOffsetLetters = 10;

        for (int i = 0; i <= password.length() - 1; i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                char letter = (char) (((int) password.charAt(i) + numberOffsetLetters - 65) % 27 + 65);
                allLetters.add(letter);
            } else {
                char letter = (char) (((int) password.charAt(i) + numberOffsetLetters - 96) % 27 + 96);
                allLetters.add(letter);
            }
        }
        for (Character a : allLetters) {
            newPassword += a;
        }
        return newPassword;
    }
}
