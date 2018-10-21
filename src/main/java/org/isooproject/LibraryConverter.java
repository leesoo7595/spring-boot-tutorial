package org.isooproject;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// String을 Library 형태로 컨버터시켜준다.
@Component
public class  LibraryConverter implements Converter<String, Library> {

    @Override
    public Library convert(String id) {
        Library library = new Library();
        library.setId(Integer.parseInt(id));
        return library;
    }
}
