package org.example.handler;

import org.beanio.types.TypeHandler;

import org.beanio.types.TypeHandler;
import org.example.code.ArrayBlock1;

import java.util.ArrayList;
import java.util.List;

public class ArrayBlock1Handler implements TypeHandler {

    @Override
    public Object parse(String text) {
        List<ArrayBlock1> list = new ArrayList<>();

        if (text == null || text.trim().isEmpty()) return list;

        String content = text.trim();
        if (content.startsWith("[[") && content.endsWith("]]")) {
            content = content.substring(2, content.length() - 2);
        }

        String[] blocks = content.split("\\Q{{\\E");
        for (String block : blocks) {
            block = block.trim();
            if (block.endsWith("}}")) {
                block = block.substring(0, block.length() - 2);
            }
            String[] fields = block.split("~~", -1);
            if (fields.length >= 6 && fields[0].isEmpty()) {
                // skip first if it's empty due to leading ~~ after {{
                fields = java.util.Arrays.copyOfRange(fields, 1, fields.length);
            }
            if (fields.length >= 5) {
                ArrayBlock1 ab = new ArrayBlock1();
                ab.aBlock1 = fields[0];
                ab.aBlock2 = fields[1];
                ab.aBlock3 = fields[2];
                ab.aBlock4 = fields[3];
                ab.aBlock5 = fields[4];
                list.add(ab);
            }

        }

        return list;
    }

    @Override
    public String format(Object value) {
        return null; // Not used in unmarshalling
    }

    @Override
    public Class<?> getType() {
        return List.class;
    }
}
