package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.dto.CompanyDTO;
import com.ems.entity.Company;


public interface CompanyRepository extends JpaRepository<Company,Integer>{
	List<CompanyDTO> findCompanyByPhnNumber(String phnNumber);
	List<CompanyDTO> findCompanyByName(String name);
}
