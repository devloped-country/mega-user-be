package com.mega.biz.join.model.dto.validationField;


import com.mega.biz.join.validator.EmailValidator;
import lombok.Getter;

@Getter
public class Email {

    private final String email;
    private final EmailValidator validator = new EmailValidator();

    public Email(String email) {
        validator.validate(email);
        this.email = email;
    }
}
