package org.prometheus.commons.archiving.domain;

import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Data;
import org.apache.commons.text.StringSubstitutor;

/**
 * Single file path pattern to filter source files by name and date
 */
@Data
public class ArchiveSourceFilter {

    private static final StringSubstitutor SUBSTITUTOR;

    private String folderPattern;
    private String filePattern;

    static {
        Map<String, String> valuesMap = EnumSet.allOf(UserPathPlaceholder.class).stream()
                .collect(Collectors.toMap(p -> p.getPathPlaceholderString(),
                        p -> String.format("(%s)", p.getExpression())));
        SUBSTITUTOR = new StringSubstitutor(valuesMap);
    }

    public ArchiveSourceFilter(String sourcePath, String fileMask) {
        this.folderPattern = SUBSTITUTOR.replace(sourcePath);
        this.filePattern = fileMask;
    }

}
