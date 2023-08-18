package com.ems.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	List<EmployeeDTO> findEmployeeByName(String name);
	List<EmployeeDTO> findEmployeeByPrice(double price);
}
