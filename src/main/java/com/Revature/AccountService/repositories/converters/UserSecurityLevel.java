package com.Revature.AccountService.repositories.converters;

import com.Revature.AccountService.beans.enums.SecurityLevel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserSecurityLevel implements AttributeConverter<SecurityLevel,Integer> {
    @Override
    public Integer convertToDatabaseColumn(SecurityLevel securityLevel) {
        return securityLevel.getLevelId();
    }

    @Override
    public SecurityLevel convertToEntityAttribute(Integer integer) {
        return SecurityLevel.getSecurityLevelbyLevelId(integer);
    }
}
