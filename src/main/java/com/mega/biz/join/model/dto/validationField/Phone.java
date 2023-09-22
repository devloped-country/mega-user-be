package com.mega.biz.join.model.dto.validationField;

import com.mega.biz.join.validator.PhoneValidator;
import lombok.Getter;

@Getter
public class Phone {

    private final String phone;
    private final PhoneValidator validator = new PhoneValidator();


    public Phone(String phone) {
        validator.validate(phone);
        this.phone = phone;
    }
}
