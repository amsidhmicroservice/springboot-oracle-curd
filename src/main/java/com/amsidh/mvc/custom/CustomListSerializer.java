package com.amsidh.mvc.custom;

import com.amsidh.mvc.entity.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomListSerializer extends StdSerializer<List<Book>> {

    public CustomListSerializer() {
        this(null);
    }

    public CustomListSerializer(Class<List<Book>> t) {
        super(t);
    }

    @Override
    public void serialize(
            List<Book> items,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Long> ids = new ArrayList<>();
        for (Book item : items) {
            ids.add(item.getBookId());
        }
        generator.writeObject(ids);
    }
}