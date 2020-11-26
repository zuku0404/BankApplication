//package model.domain.pesel;
////
////import org.junit.jupiter.api.Assertions;
////import org.junit.jupiter.params.ParameterizedTest;
////import org.junit.jupiter.params.provider.Arguments;
////import org.junit.jupiter.params.provider.MethodSource;
////
////import java.util.Arrays;
////import java.util.List;
////import java.util.stream.Stream;
////
////class PeselCheckerTest {
////
////    @ParameterizedTest
////    @MethodSource("birthData")
////    public void modificationDateOfBirth_nonConvertedData_convertedData(String pesel, String birth, List<String> expectedResult) {
////        PeselChecker pc = new PeselChecker(pesel, birth);
////        List<String> modifiedBirthDate = pc.modificationDateOfBirth();
////        Assertions.assertEquals(modifiedBirthDate, expectedResult);
////    }
////
////    public static Stream<Arguments> birthData() {
////        return Stream.of(Arguments.of("04-12-1994", Arrays.asList("9","4","0","4","1","2")),
////                Arguments.of("12-03-1994", Arrays.asList("9","4","1","2","0","3"))
////        );}
////
////
////        @ParameterizedTest
////    @MethodSource ("dataCorrectSixNumbers")
////    public void isFirstSixNumberCorrect_data_data (String pesel, String dateOfBirth, boolean expectedNumber){
////        PeselChecker pc = new PeselChecker(pesel,dateOfBirth);
////            boolean dateAndPeselCorrectness = pc.checkPesel();
////            Assertions.assertEquals(dateAndPeselCorrectness,expectedNumber);
////        }
////        private static Stream dataCorrectSixNumbers (){
////        return Stream.of(
////                Arguments.of(new String[]{"9","3","0","4","0","4"},"04-04-1993",true),
////                Arguments.of(new String[]{"9","3","0","4","0","5"},"04-04-1993",false)
////                        );
////        }
////
////
////}