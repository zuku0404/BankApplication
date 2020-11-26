//package model.domain.transaction;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//import java.util.stream.Stream;
//
//class TransactionCheckerTest {
//    @ParameterizedTest
//    @MethodSource("dataFounds")
//    public void checkFoundsOnAccount(BigDecimal allCashOnAccount, String cash, Optional<BigDecimal> expectedResult) {
//        Optional<BigDecimal> result = TransactionChecker.checkFoundsOnAccount(allCashOnAccount, cash);
//        Assertions.assertEquals(result,Optional.of("-" + cash));
//
//    }
//    private static Stream dataFounds() {
//        return Stream.of(Arguments.of(new BigDecimal(250), "20", Optional.of(new BigDecimal())));
//    }
//}