package org.prometheus.commons.archiving.domain;



import java.util.Arrays;
import java.util.List;

public enum PathPlaceholder {
    $YYYY("$YYYY","This is placeholder for year values.")
    ,$MM("$MM", "This is placeholder for month values")
    ,$DD("$DD","")
    ,$HH("$HH","");

    PathPlaceholder(
            String pathPlaceholderString,
            String description){
        this.pathPlaceholderString = pathPlaceholderString;
        this.description = description;

    }
    private String pathPlaceholderString;
    private String description;

    public String getPathPlaceholderString(){
        return pathPlaceholderString;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Convert string into Integer and the integer should have only 4 digits, if not return false
     * @param possibleYear
     * @return
     */
    private boolean isYear(String possibleYear){
        Integer possibleYearInt = Integer.getInteger(possibleYear);
        if (possibleYear.length() != 4){
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
    private boolean isMonth(String possibleMonth){
        List<String> allPossibleMonths =  Arrays.asList(
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

        if (allPossibleMonths.contains(possibleMonth)){
            return true;
        } else {
            return false;
        }
    }
}
