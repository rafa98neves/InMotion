package com.gp.inmotion.converters;

import javax.persistence.Converter;

@Converter
public class StringConverter extends AbstractConverter<String> {

    @Override
    String stringToEntityAttribute(String data) {
        return data;
    }

    @Override
    String entityAttributeToString(String attr) {
        return attr;
    }
}
