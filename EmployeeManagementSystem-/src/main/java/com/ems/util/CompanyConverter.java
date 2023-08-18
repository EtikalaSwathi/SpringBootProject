package com.ems.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ems.dto.CompanyDTO;
import com.ems.entity.Company;
@Component
public class CompanyConverter {
	public Company convertToCompanyEntity(CompanyDTO companyDTO) {
		Company company=new Company();
		if(companyDTO!=null) {
			BeanUtils.copyProperties(companyDTO, company);
		}
		return company;
	}
	public static CompanyDTO convertToCompanyDTO(Company company) {
		CompanyDTO companyDTO=new CompanyDTO();
		if(company!=null) {
			BeanUtils.copyProperties(company, companyDTO);
		}
		return companyDTO;
	}
}
