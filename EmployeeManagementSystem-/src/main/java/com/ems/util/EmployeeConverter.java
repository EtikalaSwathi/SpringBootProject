package com.ems.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;

@Component
public class EmployeeConverter {
	public Employee convertToEmployeeEntity(EmployeeDTO employeeDTO) {
		Employee employee=new Employee();
		if(employee!=null) {
			BeanUtils.copyProperties(employeeDTO, employee);
		}
		return employee;
	}
	public static EmployeeDTO convertToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO=new EmployeeDTO();
		if(employee!=null) {
			BeanUtils.copyProperties(employee, employeeDTO);
		}
		return employeeDTO;
	}
}
