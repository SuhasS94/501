package org.example.handler;

import org.beanio.types.TypeHandler;


import org.beanio.types.TypeHandler;
import org.example.code.ArrayBlock2;

import java.util.ArrayList;
import java.util.List;
public class ArrayBlock2Handler implements TypeHandler {

    @Override
    public Object parse(String text) {
        List<ArrayBlock2> list = new ArrayList<>();

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
            if (fields.length >= 8 && fields[0].isEmpty()) {
                fields = java.util.Arrays.copyOfRange(fields, 1, fields.length);
            }
            if (fields.length >= 7) {
                ArrayBlock2 ab = new ArrayBlock2();
                ab.a2Block1 = fields[0];
                ab.a2Block2 = fields[1];
                ab.a2Block3 = fields[2];
                ab.a2Block4 = fields[3];
                ab.a2Block5 = fields[4];
                ab.a2Block6 = fields[5];
                ab.a2Block7 = fields[6];
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


