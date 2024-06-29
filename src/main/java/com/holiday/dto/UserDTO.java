package com.holiday.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private Integer userId;

    private String userName;

    private String userPassword;    // gives null as output but save password in db

    private String userCity;
}
