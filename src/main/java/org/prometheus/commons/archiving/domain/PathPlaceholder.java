package org.prometheus.commons.archiving.domain;


import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PathPlaceholder {
    YYYY("$YYYY","This is placeholder for year values.")
    ,MM("$MM", "This is placeholder for month values");

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

        // TODO
    }

    /**
     *
     * @param possibleMonth
     * @return
     */
    private boolean isMonth(String possibleMonth){
        List<String> allPossibleMonths =  Arrays.asList("01","02",.... // TODO);

        // TODO
    }
}
