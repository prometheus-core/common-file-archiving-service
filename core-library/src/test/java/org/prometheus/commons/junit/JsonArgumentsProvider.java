package org.prometheus.commons.junit;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

    private String value;
    private String resource;
    private Type type;

    @Override
    public void accept(final JsonSource annotation) {
        value = annotation.value();
        resource = annotation.resource();
        type = (Type) annotation.type();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
        String content = value;
        if (StringUtils.isBlank(content)) {
            try (InputStream resourceStream = getClass().getResourceAsStream(resource)) {
                content = IOUtils.toString(resourceStream, StandardCharsets.UTF_8);
            } catch (IOException ex) {
            }
        }
        Object[] sourceArray = type != null
                ? (new Gson()).fromJson(content, type)
                : new Object[0];
        return Arrays.stream(sourceArray).map(Arguments::of);
    }

    /**
     * Utility for parameterized tests to give an alternate way of JSON-based arguments since custom
     * annotations do not work in maven-surefire-plugin v2.22.0
     *
     * @param jsonText Raw JSON content
     * @param jsonResource Path to load JSON from a resource
     * @param type Type for deserialization (have to be array currently)
     * @return Deserialized objects
     */
    public static Stream<? extends Arguments> provideArguments(String jsonText, String jsonResource, Type type) {
        JsonArgumentsProvider argsProvider = new JsonArgumentsProvider();
        argsProvider.value = jsonText;
        argsProvider.resource = jsonResource;
        argsProvider.type = type;
        return argsProvider.provideArguments(null);
    }
}
