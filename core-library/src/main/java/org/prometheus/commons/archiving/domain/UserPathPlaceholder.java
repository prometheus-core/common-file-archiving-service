package org.prometheus.commons.archiving.domain;

import java.util.Arrays;
import java.util.List;

public enum UserPathPlaceholder {
    $YYYY("YYYY", "This is placeholder for year values.", "\\d{4}"),
    $MM("MM", "This is placeholder for month values", "(01|02|03|04|05|06|07|08|09|10|11|12)"),
    $M("M", "This is placeholder for month values", "(1|2|3|4|5|6|7|8|9|10|11|12)"),
    $DD("DD", "", "TODO"),
    $HH("HH", "", "TODO");
    //$SEQUENCE and it will detect 123;

    UserPathPlaceholder(String pathPlaceholderString, String description, String expression) {
        this.pathPlaceholderString = pathPlaceholderString;
        this.description = description;
        this.expression = expression;

    }
    private String pathPlaceholderString;
    private String description;
    private String expression;

    public String getPathPlaceholderString() {
        return pathPlaceholderString;
    }

    public String getDescription() {
        return description;
    }

    public String getExpression() {
        return expression;
    }

    /**
     * Convert string into Integer and the integer should have only 4 digits, if not return false
     *
     * @param possibleYear
     * @return
     */
    private boolean isYear(String possibleYear) {
        Integer possibleYearInt = Integer.getInteger(possibleYear);
        if (possibleYear.length() != 4) {
            //throw new IllegalArgumentException("Year must be in 4 digit form");
            return false;
        }
        return true;
    }

    /**
     *
     * @param possibleMonth
     * @return
     */
    private boolean isMonth(String possibleMonth) {
        List<String> allPossibleMonths = Arrays.asList(
                "01",
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",
                "09",
                "10",
                "11",
                "12");

        if (allPossibleMonths.contains(possibleMonth)) {
            return true;
        } else {
            return false;
        }
    }
}
