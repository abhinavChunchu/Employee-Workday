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

	private static  final float HOURLY_VACATION_DAYS = 10;

	private static  final float SALARY_VACATION_DAYS = 15;

	private static  final float MANAGER_VACATION_DAYS = 15;



	public static void main(String[] args) {
		SpringApplication.run(EmployeeVacationTrackerApplication.class, args);
	}

	@Bean
	public List<Employee> loadEmployeesInfo(){
		List<Employee> employeeList = new ArrayList<>();

		// hourly employees data
		employeeList.add(setEmployeeDetails("1H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("2H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("3H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("4H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("5H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("6H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("7H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("8H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("9H", EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("10H",EmployeeType.HOURLY, HOURLY_VACATION_DAYS, 0));

		// salary employees data
		employeeList.add(setEmployeeDetails("1S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("2S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("3S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("4S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("5S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("6S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("7S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("8S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("9S", EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("10S",EmployeeType.HOURLY, SALARY_VACATION_DAYS, 0));


		// managers data
		employeeList.add(setEmployeeDetails("1M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("2M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("3M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("4M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("5M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("6M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("7M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("8M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("9M", EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));
		employeeList.add(setEmployeeDetails("10M",EmployeeType.HOURLY, MANAGER_VACATION_DAYS, 0));

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
