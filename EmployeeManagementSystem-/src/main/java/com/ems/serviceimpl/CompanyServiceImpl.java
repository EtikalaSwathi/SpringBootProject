package com.ems.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.CompanyDTO;
import com.ems.entity.Company;
import com.ems.repository.CompanyRepository;
import com.ems.service.CompanyService;
import com.ems.util.CompanyConverter;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	CompanyConverter companyConverter;
	
	public <companyConverter> CompanyDTO addCompany1(Company company) {
		Company c=companyRepository.save(company);
		return companyConverter.convertToCompanyDTO(company);
	}

	@Override
	public List<CompanyDTO> getAllCompany() {
		List<Company> company=companyRepository.findAll();
		List<CompanyDTO> dtoList=new ArrayList<>();
		for(Company c:company)
		{
			dtoList.add(companyConverter.convertToCompanyDTO(c));
		}
		return dtoList;
	}

	@Override
	public CompanyDTO getCompanyById(int id) {
		Company company=companyRepository.findById(id).get();
		return companyConverter.convertToCompanyDTO(company);
	}

	@Override
	public CompanyDTO updateCompany(int id, Company company) {
		Company c=companyRepository.findById(id).get();
		c.setName(company.getName());
		c.setAddress(company.getAddress());
		c.setEmail(company.getEmail());
		c.setPhnNumber(company.getPhnNumber());
		Company c1=companyRepository.save(c);
		return companyConverter.convertToCompanyDTO(c1);
	}
	@Override
	public String deleteCompany(int id) {
		companyRepository.deleteById(id);
		return "Company details got deleted successfuly";
	}

	@Override
	public List<CompanyDTO> getCompanyByPhnNumber(String phnNumber) {
		return companyRepository.findCompanyByPhnNumber(phnNumber);
	}

	@Override
	public List<CompanyDTO> getCompanyByName(String name) {
		// TODO Auto-generated method stub
		return companyRepository.findCompanyByName(name);
	}

	@Override
	public CompanyDTO addCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
