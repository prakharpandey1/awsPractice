package org.example.awsec2practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String position;
    private double salary;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private boolean isFullTime;

}