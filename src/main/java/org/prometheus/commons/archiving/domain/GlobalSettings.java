package org.prometheus.commons.archiving.domain;

/**
 *
 */
public class GlobalSettings {

    private CompressionAlgorithm compressionAlgorithm = CompressionAlgorithm.LZMA2;

    enum CompressionAlgorithm{
        ZIP, LZMA2
    }
}
