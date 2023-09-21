package com.mega.biz.join.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String email;
    private String password;
    private String name;
    private String phone;
    private Long userStatus;
    private String salt;
}
