package com.mega.biz.join.validator;

import com.mega.common.validator.ValidatorV2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ValidatorV2 {

    @Override
    public void validate(String email) {
        if (email == null || isBlank(email)) {
            throw new IllegalArgumentException("Email을 입력하지 않았습니다.");
        }
        if (isInvalidEmail(email)) {
            throw new IllegalArgumentException("올바른 Email 양식이 아닙니다.");
        }
    }

    private boolean isBlank(String email) {
        return email.trim().isEmpty();
    }

    private boolean isInvalidEmail(String email) {
        String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
