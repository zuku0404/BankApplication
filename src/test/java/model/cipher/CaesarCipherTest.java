package model.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
// wszystkie znaki dozwolone oprocz polskich !!
class CaesarCipherTest {
    @ParameterizedTest
    @MethodSource("data")
    void encryptPassword_nonEncryptedInput_encryptedOutput (String password, String expectedResult){
        //given
        CaesarCipher caesarCipher = new CaesarCipher();
        //when
        String passwordFromCesarCipher = caesarCipher.encryptPassword(password);
        //then
        Assertions.assertEquals(passwordFromCesarCipher,expectedResult);
    }

    private static Stream<Arguments> data(){
        return Stream.of(Arguments.of("abcd","efgh"),
                Arguments.of("ABCD","EFGH"),
                Arguments.of("tata","xexe"),
                Arguments.of("dubida123!","hyfmhe567%"),
                Arguments.of("dasn2131","hewr6575"),
                Arguments.of("1232184","56765<8"),
                Arguments.of("%23fds#1",")67jhw'5"),
                Arguments.of("bom*^HD 31SDA","fsq.bLH$75WHE")
                );}

}