package org.prometheus.commons.archiving.core;

import java.util.List;
import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;
import org.prometheus.commons.archiving.domain.ArchiveProcessRecord;
import org.prometheus.commons.archiving.domain.ArchiveSourceFilter;

/**
 * Creates ArchiveProcessRecord from ArchiveConfigRecord (Future replacement for the ArchiveUtil)
 */
public class ArchiveConfigProcessor {

    List<ArchiveProcessRecord> createProcessRecords(List<ArchiveConfigRecord> configRecords) {
        return null;
    }

    List<ArchiveSourceFilter> createArchiveSourceFilters(ArchiveConfigRecord configRecord) {
        return null;
    }

}
