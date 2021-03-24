package com.employee.vacation.tracker.resource;

import com.employee.vacation.tracker.domain.InputParam;
import com.employee.vacation.tracker.service.EmployeeVerficationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.employee.vacation.tracker.domain.Employee;

import java.util.List;

@RestController
@CrossOrigin
class EmployeeVacationTrackerResource {

    @Autowired
    private List<Employee> employeeList;

    @Autowired
    private EmployeeVerficationService employeeVerficationService;

    private Gson gson = new Gson();

    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employeeList;
    }


    @PostMapping("/employee-work")
    public String work(@RequestBody InputParam param){
        try{
            employeeVerficationService.work(param.getEmployeeId(), param.getDays());
            return gson.toJson("update successfull");
        } catch (Exception exception){
           return gson.toJson(exception.getMessage());
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