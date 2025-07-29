package org.example.handler;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import org.example.code.ArrayBlock1;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ArrayBlock1Handler implements TypeHandler {

    @Override
    public Object parse(String text) throws TypeConversionException {
        List<ArrayBlock1> list = new ArrayList<>();
        if (text == null || text.isEmpty()) return list;

        String[] tokens = text.split("~~");
        for (String token : tokens) {
            if ("B".equals(token)) break; // Stop at start of next block
            if (token.isEmpty() || "A".equals(token)) continue;

            String[] parts = token.split("\\|", -1); // Keep empty fields
            ArrayBlock1 ab1 = new ArrayBlock1();
            ab1.setABlock1(parts.length > 0 ? parts[0] : "");
            ab1.setABlock2(parts.length > 1 ? parts[1] : "");
            ab1.setABlock3(parts.length > 2 ? parts[2] : "");
            ab1.setABlock4(parts.length > 3 ? parts[3] : "");
            ab1.setABlock5(parts.length > 4 ? parts[4] : "");
            list.add(ab1);
        }

        return list;
    }

    private String getField(String[] fields, int index) {
        return index < fields.length ? fields[index] : "";
    }

    @Override
    public String format(Object value) {
        // Optional: serialization logic if needed
        return null;
    }

    @Override
    public Class<?> getType() {
        return List.class;
    }
}
