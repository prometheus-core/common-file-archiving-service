package org.prometheus.commons.archiving.core;

import java.util.ArrayList;
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
        ArrayList<ArchiveSourceFilter> filters = new ArrayList<ArchiveSourceFilter>();
        String[] fileMasks = configRecord.getFileMask().split("[,;]");
        for (String fileMask : fileMasks) {
            filters.add(new ArchiveSourceFilter(configRecord.getSourcePath(), fileMask));
        }
        return filters;
    }

}
