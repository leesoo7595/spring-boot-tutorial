package org.isooproject;

import org.springframework.core.convert.converter.Converter;

// String을 Library 형태로 컨버터시켜준다.
public class LibraryConverter implements Converter<String, Library> {

    @Override
    public Library convert(String id) {
        Library library = new Library();
        library.setId(Integer.parseInt(id));
        return null;
    }
}
