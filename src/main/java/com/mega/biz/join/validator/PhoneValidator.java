package com.mega.biz.join.validator;

import com.mega.common.validator.ValidatorV2;

public class PhoneValidator implements ValidatorV2 {
    @Override
    public void validate(String phone) {
        if (phone == null || isBlank(phone)) {
            throw new IllegalArgumentException("휴대폰번호를 입력하지 않았습니다.");
        }
        if (isInvalidPhone(phone)) {
            throw new IllegalArgumentException("유효한 휴대폰 번호가 아닙니다.");
        }
    }

    private boolean isBlank(String phone) {
        return phone.trim().isEmpty();
    }

    private boolean isInvalidPhone(String phone) {
        String regex = "^01[016789]\\d{3,4}\\d{4}$";
        return !phone.matches(regex);
    }
}
