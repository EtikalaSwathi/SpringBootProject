package com.ems.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ems.dto.EmployeeDTO;

import com.ems.entity.Employee;
import com.ems.repository.CompanyRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import com.ems.util.EmployeeConverter;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeConverter employeeConverter;
	
	@Autowired
	CompanyRepository companyRepository;
		

	@Override
	public EmployeeDTO addEmployee(Employee employee) {
		Employee e=employeeRepository.save(employee);
		return EmployeeConverter.convertToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> employee=employeeRepository.findAll();
		List<EmployeeDTO> dtoList=new ArrayList<>();
		for(Employee e:employee)
		{
			dtoList.add(employeeConverter.convertToEmployeeDTO(e));
		}
		return dtoList;
	}

	@Override
	public EmployeeDTO getEmployeeById(int id) {
		Employee employee=employeeRepository.findById(id).get();
		return employeeConverter.convertToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getEmployeeByName(String name) {
		
		return employeeRepository.findEmployeeByName(name);
	}

	@Override
	public List<EmployeeDTO> getEmployeeByPrice(double price) {
		
		return employeeRepository.findEmployeeByPrice(price);
	}

	/*@Override
	public Employee addEmployee(EmployeeDTO employeeDTO) {
		Employee employee=Employee.builder()
				.id(employeeDTO.getId())
				.name(employeeDTO.getName())
				.price(employeeDTO.getPrice())
				.company(employeeDTO.getCompany())
				.build();
		return employeeRepository.save(employee);
	}*/
}
