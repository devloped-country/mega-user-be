package com.mega.biz.join.model.dto.validationField;

import com.mega.biz.join.validator.PasswordValidator;
import lombok.Getter;

@Getter
public class Password {

    private final String password;
    private final PasswordValidator validator = new PasswordValidator();

    public Password(String password) {
        validator.validate(password);
        this.password = password;
    }
}
