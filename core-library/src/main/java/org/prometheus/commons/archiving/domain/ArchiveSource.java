package org.prometheus.commons.archiving.domain;

import lombok.Data;

/**
 * Represents single source file for archiving
 */
@Data
public class ArchiveSource {

    private final String sourceFilePath;
    private final String year;
    private final String month;
}
