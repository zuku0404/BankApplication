package model.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidatorTest {
    @ParameterizedTest
    @MethodSource("dataCash")
    void checkCash_cashFromData_resultAsInData(String cash, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkCash(cash);
        //then
        Assertions.assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataCash() {
        return Stream.of(Arguments.of("123", true),
                Arguments.of("123,23", true),
                Arguments.of("123.54", true),
                Arguments.of("123.245", false),
                Arguments.of("sadsad", false),
                Arguments.of("1223332231321", true),
                Arguments.of("1223332231321,2332", false),
                Arguments.of("1a", false),
                Arguments.of("", false)
        );
    }

    // true -> kiedy wystepuje chociaz jeden zank bez znakow bialych na poczatku i na koncu
    @ParameterizedTest
    @MethodSource("dataTitle")
    void checkTitle_titleFromData_resultAsInData(String title, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkTitle(title);
        //then
        Assertions.assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataTitle() {
        return Stream.of(Arguments.of("trakaka", true),
                Arguments.of("", false),
                Arguments.of("t", true),
                Arguments.of(" ", false),
                Arguments.of("to musi dzialac ", true)
        );
    }

    // true -> kazda zwykla liczba, piewsza nie moze byc 0
    @ParameterizedTest
    @MethodSource("dataUserRecipient")
    void checkIdUserRecipient_userRecipientFromData_resultAsInData(String id, boolean exceptedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkIdUserRecipient(id);
        //then
        Assertions.assertEquals(result, exceptedResult);
    }

    private static Stream<Arguments> dataUserRecipient() {
        return Stream.of(Arguments.of("12", true),
                Arguments.of("ads", false),
                Arguments.of("12 ", false),
                Arguments.of("1a", false),
                Arguments.of("12,3", false),
                Arguments.of("", false),
                Arguments.of("12!", false),
                Arguments.of("-1", false),
                Arguments.of("1", true),
                Arguments.of("0", false),
                Arguments.of("01", false),
                Arguments.of("10", true)
        );
    }

    // true -> jedna duza, jedna mala litera, znak specjalny, jedna liczbe  co najmniej 8 znakow;
    @ParameterizedTest
    @MethodSource("dataPassword")
    void checkPassword_passwordFromData_resultAsInData(String password, boolean expectResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkPassword(password);
        //then
        Assertions.assertEquals(result, expectResult);
    }

    private static Stream<Arguments> dataPassword() {
        return Stream.of(Arguments.of("asdasS@12s", true),
                Arguments.of("asdasS12s", false),
                Arguments.of("asdas@12s", false),
                Arguments.of("asdasS", false),
                Arguments.of("asdasSSfddf@a", false),
                Arguments.of("asdasS@1", true),
                Arguments.of("asdasSSf@2ds    ddf@a", false)
        );
    }

    // true -> jeden wyraz o dlugosci 8 liter posiadajace jedna duza litere
    @ParameterizedTest
    @MethodSource("dataLogin")
    void checkLogin_loginFromData_resultAsInData(String login, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        // when
        boolean result = validator.checkLogin(login);
        //then
        Assertions.assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataLogin() {
        return Stream.of(Arguments.of("Mama", false),
                Arguments.of("321dscMama", true),
                Arguments.of("Mama ma Kota", false),
                Arguments.of("MamaMusi", true),
                Arguments.of("mamaMusi", true),
                Arguments.of("mAma", false),
                Arguments.of("Mama sds", false)
        );
    }

    // true -> pierwsza duza litera druga mala
    @ParameterizedTest
    @MethodSource("dataNameSurname")
    void checkNameSurname(String nameSurname, boolean expectedResult) {
        // given
        Validator validator = new Validator();
        // when
        boolean result = validator.checkNameSurname(nameSurname);
        // then
        Assertions.assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataNameSurname() {
        return Stream.of(Arguments.of("Ewa", true),
                Arguments.of("Ewa konewa", false),
                Arguments.of("Ew", true),
                Arguments.of("E", false),
                Arguments.of("sdawa", false),
                Arguments.of("sdAwa", false),
                Arguments.of("WsdadA", false),
                Arguments.of("Sdawa32", false)
        );
    }

    // true -> XX-XX-XXXX
    @ParameterizedTest
    @MethodSource("dataBirth")
    void checkDataOfBirth_birthFromData_resultAsInData(String date, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        //when
        boolean result = validator.checkDataOfBirth(date);
        //then
        Assertions.assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataBirth() {
        return Stream.of(Arguments.of("12-02-2020", true),
                Arguments.of("12-13-2020", true),
                Arguments.of("12 02 2020", false),
                Arguments.of("12.02.2020", false),
                Arguments.of("2020-12-3", false),
                Arguments.of("2020-22-3", false),
                Arguments.of("12-13-2020", true),
                Arguments.of("12-13-3020", false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataPesel")
    void checkPesel_peselFromData_resultAsInData(String pesel, boolean expectedResult) {
        //given
        Validator validator = new Validator();
        // when
        boolean result = validator.checkPesel(pesel);
        //then
        Assertions.assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> dataPesel() {
        return Stream.of(Arguments.of("11123456789", true),
                Arguments.of("123456789343242", false),
                Arguments.of("12345678", false),
                Arguments.of("1s23456789", false)
        );
    }
}