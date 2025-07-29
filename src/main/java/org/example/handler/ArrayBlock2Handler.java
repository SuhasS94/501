package org.example.handler;
import org.beanio.types.TypeConversionException;
import org.example.code.ArrayBlock1;
import org.example.code.ArrayBlock2;
import org.beanio.types.TypeHandler;
import java.util.*;

public class ArrayBlock2Handler implements TypeHandler {

    @Override
    public Object parse(String text) throws TypeConversionException {
        List<ArrayBlock2> list = new ArrayList<>();
        if (text == null || text.isEmpty()) return list;

        String[] tokens = text.split("~~");
        boolean started = false;

        for (String token : tokens) {
            if ("B".equals(token)) {
                started = true;
                continue;
            }
            if (!started) continue;
            if ("B".equals(token)) break; // End marker
            if (token.isEmpty()) continue;

            String[] parts = token.split("\\|", -1); // Keep empty fields
            ArrayBlock2 ab2 = new ArrayBlock2();
            ab2.setA2Block1(parts.length > 0 ? parts[0] : "");
            ab2.setA2Block2(parts.length > 1 ? parts[1] : "");
            ab2.setA2Block3(parts.length > 2 ? parts[2] : "");
            ab2.setA2Block4(parts.length > 3 ? parts[3] : "");
            ab2.setA2Block5(parts.length > 4 ? parts[4] : "");
            ab2.setA2Block6(parts.length > 5 ? parts[5] : "");
            ab2.setA2Block7(parts.length > 6 ? parts[6] : "");
            list.add(ab2);
        }

        return list;
    }


    private String getField(String[] fields, int index) {
        return index < fields.length ? fields[index] : "";
    }

    @Override
    public String format(Object value) {
        return null;
    }

    @Override
    public Class<?> getType() {
        return List.class;
    }
}


