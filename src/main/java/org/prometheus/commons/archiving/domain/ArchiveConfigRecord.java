package org.prometheus.commons.archiving.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveConfigRecord {

    
    /**
     * Dynamic record id for persistence.
     */

    /**
     * Pure configuration input data
     */

    @Id
    String businessName;

    String sourcePath;

    String fileMask;

    // Not required, dynamically calculated on the fly, but later stored in database
    Size sourcePathSize;

    /**
     * What files to compress and archive. Means older than specified value
     * Example: 3 months it takes all files ONLY older than 3 months and do archiving
     */
    ArchiveTimeType archiveTrigger;

    /*
    * When to delete files from archive
     */
    ArchiveTimeType retentionPeriod;

    /**
     * Day_Ahead_$YYYY_$MM
     */
    String archiveFileName;

    /**
     * C:\Day ahead\DA reports\$YYYY\
     */
    String archiveFolder;


    class ArchiveTimeType{
        Integer number;

        ArchiveTimeUnit archiveTimeUnit;
    }

    enum ArchiveTimeUnit{
        DAYS,MONTHS,YEARS;
    }


    class Size{
        Integer size;

        SizeUnit sizeUnit;

    }

    enum SizeUnit{
        MB,GB,TB;
    }

}
