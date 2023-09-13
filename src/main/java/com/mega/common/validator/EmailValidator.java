package com.mega.common.validator;

import java.util.regex.Pattern;

public class EmailValidator implements Validator{
    @Override
    public String validate(String inputValue) {
        checkReg(inputValue);
        return inputValue;
    }

    private void checkReg(String inputValue) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailPattern, inputValue)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 주소임");
        }
    }
}
