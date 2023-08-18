package com.ems.dto;


import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ems.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
	@NotNull(message="id should not be null")
	@Column(name="Company_id")
	private int id;
	
	@NotNull(message="name should not be empty")
	@Size(min=4)
	private String name;
	
	@NotBlank(message="address should not be empty")
	private String address;
	
	@Email(message="Email can not be empty")
	private String email;
	
	@Min(value=100000000)
	@Max(value=9999999999L)
	//@Pattern(regexp="\\d{10}",message="phone number should be 10 digits")
	private Long phnNumber;
	
	private List<Employee> employeeList;
	
	/*@Builder
	public CompanyDTO(int id,
			@NotNull(message="Name of the company never be null") @NotBlank(message="name of company can never be empty")@Size(min=10,max=30)String name,
			@NotBlank(message = "Name of company can never be empty") String address,
			@Pattern(regexp = "\\d{10}") String phnNumber, List<Employee> employeeList) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phnNumber = phnNumber;
		this.employeeList = employeeList;
	}*/
	
	
	
}
