package org.prometheus.commons.archiving.domain;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserPathPlaceholderTest {

    @ParameterizedTest
    @CsvSource({"123, false", "1982, true", "2018, true"})
    public void testYyyyExpression(String name, boolean expectedResult) {
        Pattern pattern = Pattern.compile(UserPathPlaceholder.$YYYY.getExpression());
        Assertions.assertEquals(expectedResult, pattern.matcher(name).matches());
    }

    @ParameterizedTest
    @CsvSource({"1, false", "00, false", "01, true", "12, true", "13, false"})
    public void testMmExpression(String name, boolean expectedResult) {
        Pattern pattern = Pattern.compile(UserPathPlaceholder.$MM.getExpression());
        Assertions.assertEquals(expectedResult, pattern.matcher(name).matches());
    }

    @ParameterizedTest
    @CsvSource({"01, false", "09, false", "0, false", "1, true", "9, true", "10, true", "12, true", "13, false"})
    public void testMExpression(String name, boolean expectedResult) {
        Pattern pattern = Pattern.compile(UserPathPlaceholder.$M.getExpression());
        Assertions.assertEquals(expectedResult, pattern.matcher(name).matches());
    }

}
