// src/main/java/org/example/parser/CustomDelimitedParserFactory.java
package org.example.parser;

import org.beanio.stream.RecordUnmarshaller;
import org.beanio.stream.delimited.DelimitedRecordParserFactory;

public class CustomDelimitedParserFactory extends DelimitedRecordParserFactory {
    String customDelimiter = "~~";

    public void setCustomDelimiter(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    public RecordUnmarshaller createUnmarshaller() {
        return new CustomDelimitedReader(this, customDelimiter);
    }

}
