package com.employee.vacation.tracker.resource;

import com.employee.vacation.tracker.domain.InputParam;
import com.employee.vacation.tracker.service.EmployeeVerficationService;
import org.springframework.web.bind.annotation.*;
import com.employee.vacation.tracker.domain.Employee;

import java.util.List;

@RestController
@CrossOrigin
class EmployeeVacationTrackerResource {

    private final List<Employee> employeeList;

    private final EmployeeVerficationService employeeVerficationService;

    public EmployeeVacationTrackerResource(List<Employee> employeeList, EmployeeVerficationService employeeVerficationService){
        this.employeeList = employeeList;
        this.employeeVerficationService = employeeVerficationService;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employeeList;
    }


    @PostMapping("/employee-work")
    public List<Employee> work(@RequestBody InputParam param) throws Exception {
        return employeeVerficationService.work(param.getEmployeeId(), param.getDays());
    }


    @PostMapping("/employee-vacation")
    public List<Employee> takeVacation(@RequestBody InputParam param) throws Exception {
        return employeeVerficationService.takeVacation(param.getEmployeeId(), param.getDays());
    }

}