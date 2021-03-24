package com.employee.vacation.tracker.resource;

import com.employee.vacation.tracker.domain.InputParam;
import com.employee.vacation.tracker.service.EmployeeVerficationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.vacation.tracker.domain.Employee;

import java.util.List;

@RestController
class EmployeeVacationTrackerResource {

    @Autowired
    private List<Employee> employeeList;

    @Autowired
    private EmployeeVerficationService employeeVerficationService;

    @GetMapping("/employee")
    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    @PostMapping("/employee-work")
    public String work(@RequestBody InputParam param){
        try{
            employeeVerficationService.work(param.getEmployeeId(), param.getDays());
            return "update successfull";
        } catch (Exception exception){
           return exception.getMessage();
        }
    }


    @PostMapping("/employee-vacation")
    public String takeVacation(@RequestBody InputParam param){
        try{
            return employeeVerficationService.takeVacation(param.getEmployeeId(), param.getDays());
        } catch (Exception exception){
            return exception.getMessage();
        }
    }

}