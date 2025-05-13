package com.data.session06_javaweb.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private int employee_id;
    private String name;
    private LocalDate birthday;
    private String phone;
    private String email;
    private double salary;
    private String position;
}
