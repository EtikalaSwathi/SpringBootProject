package com.ems.service;

import java.util.List;

import javax.validation.Valid;

import com.ems.dto.CompanyDTO;
import com.ems.dto.EmployeeDTO;
import com.ems.entity.Company;
import com.ems.entity.Employee;

public interface EmployeeService {
	EmployeeDTO addEmployee(Employee employee);
	List<EmployeeDTO> getAllEmployee();
	EmployeeDTO getEmployeeById(int id);
	List<EmployeeDTO> getEmployeeByName(String name);
	List<EmployeeDTO> getEmployeeByPrice(double price);
	//Employee addEmployee(EmployeeDTO employeeDTO);
}
