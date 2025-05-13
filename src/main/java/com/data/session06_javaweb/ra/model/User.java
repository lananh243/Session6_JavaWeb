package com.data.session06_javaweb.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
}
