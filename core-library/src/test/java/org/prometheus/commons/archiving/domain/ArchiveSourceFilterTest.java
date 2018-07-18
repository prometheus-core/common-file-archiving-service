package org.prometheus.commons.archiving.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArchiveSourceFilterTest {

    @Test
    public void testPlaceholderReplacement() {
        ArchiveSourceFilter filter = new ArchiveSourceFilter("C:\\Day ahead\\DA reports\\${YYYY}", null);
        Assertions.assertEquals("C:\\Day ahead\\DA reports\\(\\d{4})", filter.getFolderPattern());
    }

}
