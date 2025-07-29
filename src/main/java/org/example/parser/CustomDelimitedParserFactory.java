// src/main/java/org/example/parser/CustomDelimitedParserFactory.java
package org.example.parser;

import java.io.Reader;
import java.io.Writer;

import org.beanio.stream.RecordMarshaller;
import org.beanio.stream.RecordParserFactory;
import org.beanio.stream.RecordParserFactorySupport;
import org.beanio.stream.RecordReader;
import org.beanio.stream.RecordUnmarshaller;
import org.beanio.stream.RecordWriter;

/**
 * A RecordParserFactory that groups [[{{…}}]] blocks into single tokens
 * and otherwise splits on a multi‑char delimiter.
 */
public class CustomDelimitedParserFactory
        extends RecordParserFactorySupport
        implements RecordParserFactory {

    private String delimiter = "~~";
    private static final String OPEN  = "[[{{";
    private static final String CLOSE = "}}]]";

    public void setCustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void init() {
        // no‑op; you could validate delimiter here
    }

    @Override
    public RecordReader createReader(Reader in) {
        // we only need unmarshaller for String→String[]
        return null;
    }

    @Override
    public RecordUnmarshaller createUnmarshaller() {
        return new GroupingDelimitedUnmarshaller(delimiter, OPEN, CLOSE);
    }

    @Override
    public RecordWriter createWriter(Writer out) {
        return null;
    }

    @Override
    public RecordMarshaller createMarshaller() {
        return null;
    }
}
