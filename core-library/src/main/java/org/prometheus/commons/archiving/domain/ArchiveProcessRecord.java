package org.prometheus.commons.archiving.domain;

import lombok.Data;

import java.util.List;

/**
 * Example: C:\Users\myself\06-Day ahead\DA reports\2015\01 1(config):M(process) relationship
 *
 * ResultOb
 *
 * Example: from 1 config I generated 50 ProcessRecords, while I process them I was able to process
 * 20, but then I got exception NO SPACE LEFT ON DEVICE ->> ROLLBACK
 */
@Data
public class ArchiveProcessRecord {

    /**
     * example: Day_Ahead_2015_03.zip
     */
    String archiveFileName;

    /**
     * C:\Day ahead\DA reports\2015\03\
     */
    String archiveFolder;

    String sourcePath;
    List<ArchiveSource> files;
    String archiveName;

    // Not required, dynamically calculated on the fly, but later stored in database
    ArchiveConfigRecord.Size sourcePathSize;
}
