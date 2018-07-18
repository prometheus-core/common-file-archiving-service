package org.prometheus.commons.archiving.core;

import java.util.List;
import java.util.stream.Stream;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.prometheus.commons.archiving.domain.ArchiveConfigRecord;
import org.prometheus.commons.archiving.domain.ArchiveSourceFilter;
import org.prometheus.commons.junit.JsonArgumentsProvider;

public class ArchiveConfigProcessorTest {

    @ParameterizedTest
    @MethodSource("loadCreateArchiveSourceFiltersData")
//    @JsonSource(resource = "/org/prometheus/commons/archiving/core/ArchiveConfigProcessorTest.json", type = ArchiveConfigProcessorTestData[].class)
    public void testCreateArchiveSourceFilters(ArchiveConfigProcessorTestData testData) {
        ArchiveConfigProcessor configProcessor = new ArchiveConfigProcessor();
        List<ArchiveSourceFilter> filters = configProcessor.createArchiveSourceFilters(testData.getConfig());
        Assertions.assertEquals(testData.fileMasks.size(), filters.size());
        filters.forEach((filter) -> {
            Assertions.assertTrue(testData.fileMasks.contains(filter.getFilePattern()));
        });
    }

    static Stream<? extends Arguments> loadCreateArchiveSourceFiltersData() {
        return JsonArgumentsProvider.provideArguments(null,
                "/org/prometheus/commons/archiving/core/ArchiveConfigProcessorTest.json",
                ArchiveConfigProcessorTestData[].class);
    }

    @Getter
    public class ArchiveConfigProcessorTestData {

        private ArchiveConfigRecord config;
        private int resultCount;
        private List<String> fileMasks;
    }
}
