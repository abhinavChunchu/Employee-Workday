package com.employee.vacation.tracker.service;

import com.employee.vacation.tracker.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeVerficationService {

    @Autowired
    private List<Employee> employeeList;

    public void work(String employeeId, int days) throws Exception {
        if (days > 260) {
            throw new Exception("Work days exceeded more than 260");
        } else if(days < 0) {
            throw new Exception("Work days can't be less than zero");
        }


        Optional<Employee> optionalEmployee = getFirst(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setWorkingDays(days);

            if (days < 260) {
                switch (employee.getEmployeeType()) {
                    case HOURLY:
                        extracted(days, employee, 10);
                        break;

                    case MANAGER:
                        extracted(days, employee, 30);
                        break;

                    default:
                        extracted(days, employee, 15);
                        break;
                }
            }
        } else {
            throw new Exception("No employee with given employee Id");
        }

    }

    public String takeVacation(String employeeId, int days) throws Exception {
        Optional<Employee> optionalEmployee = getFirst(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            float diff = employee.getVacationDays() - days;
            if (diff > 0) {
                employee.setVacationDays(diff);
                return "vacation days available";
            } else {
                return "vacation days not available";
            }
        }
        throw new Exception("No employee with given employee Id");

    }

    private Optional<Employee> getFirst(String employeeId) {
        return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst();
    }

    private void extracted(int days, Employee employee, int availableVacationDays) {
        float diff = 260 - days;
        if (diff <= availableVacationDays) {
            employee.setVacationDays(diff);
        } else if(diff == 0){
            employee.setVacationDays(diff);
        }
    }
}
