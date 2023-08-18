package com.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ems.dto.EmployeeDTO;
import com.ems.entity.Company;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.service.EmployeeService;
import com.ems.util.EmployeeConverter;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeConverter employeeConverter;
	
	@PostMapping("/addEmployee")
	ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
		try {
			Employee employee=employeeConverter.convertToEmployeeEntity(employeeDTO);
			if(employee!=null) {
				return new ResponseEntity<EmployeeDTO>(employeeService.addEmployee(employee),HttpStatus.CREATED);
			}
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Employee data is not entered properly,check it");
		}
		return new ResponseEntity<EmployeeDTO>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getAllEmployee")
	ResponseEntity<List<EmployeeDTO>> getAllEmployee()
	{
		return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAllEmployee(),HttpStatus.FOUND);
	}
	@GetMapping("/getEmployeeById/{id}")
	ResponseEntity<EmployeeDTO> getCompanyById(@PathVariable int id)
	{
		return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeById(id),HttpStatus.FOUND);
	}
	@GetMapping("/getemployeebyPrice")
	ResponseEntity<Employee> getEmployeeByPrice(@PathVariable double price){
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	@GetMapping("/getemployeebyname")
	ResponseEntity<Employee> getEmployeeByName(@PathVariable String name){
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

}
