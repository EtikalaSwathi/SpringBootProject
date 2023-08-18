package com.ems.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ems.entity.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	@NotNull(message="Employee Id should not be null")
	private int id;
	
	@NotBlank(message="Employee Name should not be blank")
	@NotNull(message="Employee Name should not be null")
	private String name;
	
	@NotNull
	private double price;
	
	Company company;
	
	
}
