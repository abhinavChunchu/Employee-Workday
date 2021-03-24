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

    public List<Employee> work(String employeeId, int days) throws Exception {
        if (days > 260) {
            throw new Exception("Work days exceeded more than 260");
        } else if (days < 0) {
            throw new Exception("Work days can't be less than zero");
        }


        Optional<Employee> optionalEmployee = getFirst(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setWorkingDays(days);

            switch (employee.getEmployeeType()) {
                case HOURLY:
                    setVacationDays(days, employee, 10);
                    break;

                case MANAGER:
                    setVacationDays(days, employee, 30);
                    break;

                default:
                    setVacationDays(days, employee, 15);
                    break;
            }

            return employeeList;
        }

        throw new Exception("No employee with given employee Id");


    }

    public List<Employee> takeVacation(String employeeId, int days) throws Exception {
        Optional<Employee> optionalEmployee = getFirst(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            float diff = employee.getVacationDays() - days;
            if (diff >= 0) {
                employee.setVacationDays(diff);
            }

            return employeeList;
        }
        throw new Exception("No employee with given employee Id");

    }

    private Optional<Employee> getFirst(String employeeId) {
        return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst();
    }

    private void setVacationDays(int days, Employee employee, int availableVacationDays) {
        float diff = 260 - days;
        if (diff == 0) {
            employee.setVacationDays(availableVacationDays);
        } else if (diff <= availableVacationDays) {
            employee.setVacationDays(availableVacationDays - diff);
        } else {
            employee.setVacationDays(0);
        }
    }
}
