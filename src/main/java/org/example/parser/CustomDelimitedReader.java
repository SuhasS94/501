// src/main/java/org/example/parser/GroupingDelimitedUnmarshaller.java
package org.example.parser;

import org.apache.commons.lang3.StringUtils;
import org.beanio.stream.delimited.DelimitedParserConfiguration;
import org.beanio.stream.delimited.DelimitedRecordParser;


public class CustomDelimitedReader extends DelimitedRecordParser {
    String delimiter;

    public CustomDelimitedReader(DelimitedParserConfiguration config, String delimiter) {
        super(config);
        this.delimiter = delimiter;
    }

    public String[] unmarshal(String text) {
        return StringUtils.splitByWholeSeparatorPreserveAllTokens(text, delimiter);
    }
}
