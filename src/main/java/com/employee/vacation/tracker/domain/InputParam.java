package com.employee.vacation.tracker.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class InputParam {

    @NotNull
    private String employeeId;

    @NotNull
    private int days;
}
