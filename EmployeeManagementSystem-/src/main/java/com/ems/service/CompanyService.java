package com.ems.service;

import java.util.List;
import com.ems.dto.CompanyDTO;
import com.ems.entity.Company;

public interface CompanyService {
	CompanyDTO addCompany(Company company);
	List<CompanyDTO> getAllCompany();
	CompanyDTO getCompanyById(int id);
	CompanyDTO updateCompany(int id,Company company);
	String deleteCompany(int id);
	List<CompanyDTO> getCompanyByPhnNumber(String phnNumber);
	List<CompanyDTO> getCompanyByName(String name);
}
