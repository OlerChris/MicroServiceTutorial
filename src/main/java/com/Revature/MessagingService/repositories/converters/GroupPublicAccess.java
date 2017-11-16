package com.Revature.MessagingService.repositories.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GroupPublicAccess implements AttributeConverter<Boolean,Character> {
    @Override
    public Character convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? 'T' : 'F';
    }

    @Override
    public Boolean convertToEntityAttribute(Character character) {
        return character == 'T';
    }
}
