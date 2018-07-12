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
     * Custom name provided by user for specific archiving record
     */
    @Id
    String businessName;



    /**
     *
     * Example 1:
     * C:\Day ahead\DA reports\$YYYY\$MM
     *
     * This is result of directory analysis:
     * C:\Day ahead\DA reports\MyFolder - this folder is not selected
     * C:\Day ahead\DA reports\2015\01 -> all files goes into Day_Ahead_2015_01.zip/ (xz LZMA2) /7zip
     * C:\Day ahead\DA reports\2015\02 -> Day_Ahead_2015_02
     * C:\Day ahead\DA reports\2015\03
     * ...
     * C:\Day ahead\DA reports\2015\12
     * ...
     * C:\Day ahead\DA reports\2018\02
     * C:\Day ahead\DA reports\2018\03
     * C:\Day ahead\DA reports\2018\04
     * C:\Day ahead\DA reports\2018\05
     * C:\Day ahead\DA reports\2018\06
     *
     * Example 2:
     * C:\myfiles
     *
     * Example no date in directory:
     * C:\Day ahead\another reports\$YYYY
     */
    String sourcePath;

    /**
     * Here you can apply file filter *.*, *.txt
     *
     * This can also support: $YYYY and $MM
     *
     * Example 1: *.*
     *
     *
     * Example 2:
     * MyFile_$YYYY_$MM*.dat
     *
     * MyFile_2016_01.data
     * MyFile_2016_02.data
     * MyFile_2016_03.data
     * MyFile_2016_04.data
     * MyFile_2016_05.data
     * ....
     * MyFile_2016_12.data
     *
     * if archiveFileName = Day_Ahead_$YYYY_$MM -> each file is archived in specific file name
     * if archiveFileName = Day_Ahead_$YYYY -> All files for that year goes into single archive
     *
     * It should support multiple filters delimited by ; or |
     * example: *.dat;*.txt
     *
     * MyFile_$YYYY_$MM*.dat
     *
     * name: FILE_$MM.txt
     */
    String fileMask;

    /**
     * Nice to have
     * Not required, dynamically calculated on the fly, but later stored in database
     *
     *
     */

    Size sourcePathSize;

    /**
     * What files to compress and archive. Means older than specified value
     * Example: 3 months it takes all files ONLY older than 3 months and do archiving
     * Example: Older > 3 months
     */
    ArchiveTimeType archiveTrigger;

    /*
    * When to delete files from archive
    *
    * Priority: low
     */
    ArchiveTimeType retentionPeriod;

    /**
     * example: Day_Ahead_$YYYY_$MM.zip
     */
    String archiveFileName;

    /**
     * C:\Day ahead\DA reports\$YYYY\$MM\
     */
    String archiveFolder;

    boolean deleteSourceFilesAfterArchive;


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
