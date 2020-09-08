package account.cipher;

import java.util.ArrayList;
import java.util.List;

public class CaesarDecipher {
    public static String decryptPassword(String encryptedPassword) {
        String decryptedPassword = "";
        int numberOffsetLetters = 10;
        List<Character> listOfLettersInDecryptedPass = new ArrayList<>();

        for (int i = 0; i <= encryptedPassword.length() - 1; i++) {
            if (Character.isUpperCase(encryptedPassword.charAt(i))) {
                char letter = (char) (((int) encryptedPassword.charAt(i) - numberOffsetLetters - 65) % 26 + 65);
                listOfLettersInDecryptedPass.add(letter);
            } else {
                char letter = (char) (((int) encryptedPassword.charAt(i) - numberOffsetLetters - 97) % 26 + 97);
                listOfLettersInDecryptedPass.add(letter);
            }
        }
        for (
                Character a : listOfLettersInDecryptedPass) {
            decryptedPassword += a;
        }
        return decryptedPassword;
    }
}
