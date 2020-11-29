package model.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CaesarDecipherTest {
    @ParameterizedTest
    @MethodSource("data")
    void decryptPassword_encryptedInput_nonEncryptedOutput(String exceptedResult, String password) {
        CaesarCipher cd = new CaesarCipher();
        String decryptedPassword = cd.decryptPassword(password);
        Assertions.assertEquals(exceptedResult, decryptedPassword);
    }
    private static Stream data() {
        return Stream.of(
                Arguments.of("zuku13*{}", "~yoy57.\u007F\u0002"),
                Arguments.of("abcd", "efgh"),
                Arguments.of("ABCD", "EFGH"),
                Arguments.of("tata", "xexe"),
                Arguments.of("dubida123!", "hyfmhe567%"),
                Arguments.of("dasn2131", "hewr6575"),
                Arguments.of("1232184", "56765<8"),
                Arguments.of("%23fds#1", ")67jhw'5"),
                Arguments.of("bom*^HD 31SDA", "fsq.bLH$75WHE")
        );
    }
}