package com.employee.vacation.tracker;

import com.employee.vacation.tracker.domain.Employee;
import com.employee.vacation.tracker.domain.EmployeeType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeVacationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeVacationTrackerApplication.class, args);
	}

	@Bean
	public List<Employee> loadEmployeesInfo(){
		List<Employee> employeeList = new ArrayList<>();

		// hourly employees data
		employeeList.add(setEmployeeDetails("1H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("2H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("3H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("4H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("5H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("6H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("7H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("8H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("9H", EmployeeType.HOURLY, 0, 0));
		employeeList.add(setEmployeeDetails("10H",EmployeeType.HOURLY, 0, 0));

		// salary employees data
		employeeList.add(setEmployeeDetails("1S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("2S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("3S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("4S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("5S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("6S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("7S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("8S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("9S", EmployeeType.SALARIED, 0, 0));
		employeeList.add(setEmployeeDetails("10S",EmployeeType.SALARIED, 0, 0));


		// managers data
		employeeList.add(setEmployeeDetails("1M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("2M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("3M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("4M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("5M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("6M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("7M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("8M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("9M", EmployeeType.MANAGER, 0, 0));
		employeeList.add(setEmployeeDetails("10M",EmployeeType.MANAGER, 0, 0));
		return employeeList;
	}

	private Employee setEmployeeDetails(String employeeId, EmployeeType employeeType, float vacationDays, float workingDays){
		Employee employee = new Employee();
		employee.setEmployeeType(employeeType);
		employee.setVacationDays(vacationDays);
		employee.setWorkingDays(workingDays);
		employee.setEmployeeId(employeeId);

		return employee;
	}

}
