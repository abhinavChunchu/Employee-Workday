package com.employee.vacation.tracker.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String employeeId;
    private float vacationDays;
    private EmployeeType employeeType;
    private float workingDays;
}
