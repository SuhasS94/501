// src/main/java/org/example/parser/GroupingDelimitedUnmarshaller.java
package org.example.parser;

import org.beanio.stream.RecordUnmarshaller;
import java.util.ArrayList;
import java.util.List;

/**
 * Splits on a multi‑char delimiter, but whenever it sees OPEN it
 * captures everything up to CLOSE as one token.
 */
public class GroupingDelimitedUnmarshaller implements RecordUnmarshaller {
    private final String delim, open, close;

    public GroupingDelimitedUnmarshaller(String delim, String open, String close) {
        this.delim = delim;
        this.open  = open;
        this.close = close;
    }

    @Override
    public String[] unmarshal(String record) {
        List<String> tokens = new ArrayList<>();
        int i = 0, n = record.length();

        while (i < n) {
            // 1) If we see the open marker, pull in the entire group
            if (record.startsWith(open, i)) {
                int end = record.indexOf(close, i + open.length());
                if (end < 0) end = n;
                tokens.add(record.substring(i, end + close.length()));
                i = end + close.length();
            }
            // 2) Otherwise split on delim, preserving empty tokens
            else {
                int next = record.indexOf(delim, i);
                if (next < 0) {
                    // last token: everything to end (could be empty if record.endsWith(delim))
                    tokens.add(record.substring(i));
                    break;
                }
                // Are we at a bare delim (i.e. next == i)?  That means an empty token.
                if (next == i) {
                    // But if that delim is immediately before a group, skip it:
                    int peek = i + delim.length();
                    if (peek < n && record.startsWith(open, peek)) {
                        i = peek;
                        continue;       // do *not* emit a ""
                    }
                    // Otherwise it really is an empty field:
                    tokens.add("");
                    i += delim.length();
                    continue;
                }
                // Normal non‑empty field:
                tokens.add(record.substring(i, next));
                i = next + delim.length();
            }
        }
        return tokens.toArray(new String[0]);
    }

    public List<String> toList(String record) {
        // optional, for BeanReader; just delegate
        return java.util.Arrays.asList(unmarshal(record));
    }
}
