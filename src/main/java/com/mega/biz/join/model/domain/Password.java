package com.mega.biz.join.model.domain;

import lombok.Getter;

@Getter
public class Password {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;

    private final String password;

    public Password(String password) {
        validate(password);
        this.password = password;
    }

    private void validate(String password) {
        if (password == null || isBlank(password)) {
            throw new IllegalArgumentException("비밀번호를 입력하지 않았습니다.");
        }
        if (isInvalidPasswordLength(password)) {
            throw new IllegalArgumentException("비밀번호를 8자 이상, 16자리 이하로 입력해 주세요.");
        }
        if (isInvalidPassword(password)) {
            throw new IllegalArgumentException("대소문자, 숫자, 특수문자를 사용해 주세요");
        }
    }

    private boolean isInvalidPasswordLength(String password) {
        return password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH;
    }

    private boolean isBlank(String password) {
        return password.trim().isEmpty();
    }

    private boolean isInvalidPassword(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        return !(hasUppercase && hasLowercase && hasDigit && hasSpecialChar);
    }
}
