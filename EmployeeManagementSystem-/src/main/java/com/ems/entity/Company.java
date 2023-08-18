package com.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String email;
	private Long phnNumber;
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Employee_id")
	private Employee employee;
	@Builder
	public Employee(int id, String name, String address, Long phnNumber, Employee employee) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phnNumber = phnNumber;
		this.employee=employee;
	}*/
}
