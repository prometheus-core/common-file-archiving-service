package org.prometheus.commons.junit;

import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * Either value or resource attribute have to be specified
 */
@ArgumentsSource(JsonArgumentsProvider.class)
public @interface JsonSource {

    /**
     * JSON as string
     *
     * @return
     */
    String value() default "";

    /**
     * Path to the resource with JSON
     *
     * @return
     */
    String resource() default "";

    /**
     * Type for the deserialization (should be array currently), e.g.
     * type=ArchiveConfigRecord[].class
     *
     * @return
     */
    Class<?> type();
}
