package com.ems.controller;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ems.dto.CompanyDTO;
import com.ems.entity.Company;
import com.ems.service.CompanyService;
import com.ems.util.CompanyConverter;

@RestController
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyConverter companyConverter;
	
	@PostMapping("/addCompany")
	ResponseEntity<CompanyDTO> addCompany(@RequestBody @Valid CompanyDTO companyDTO){
		Company company=companyConverter.convertToCompanyEntity(companyDTO);
		return new ResponseEntity<CompanyDTO>(companyService.addCompany(company),HttpStatus.CREATED);
	}
	@GetMapping("/getCompanyById/{id}")
	ResponseEntity<CompanyDTO> getCompanyById(@PathVariable int id)
	{
		return new ResponseEntity<CompanyDTO>(companyService.getCompanyById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllCompany")
	ResponseEntity<List<CompanyDTO>> getCompany()
	{
		return new ResponseEntity<List<CompanyDTO>>(companyService.getAllCompany(),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateCompany/{id}")
	ResponseEntity<CompanyDTO> updateCompany(@PathVariable int id,@RequestBody CompanyDTO companyDTO)
	{
		Company company=companyConverter.convertToCompanyEntity(companyDTO);
		return new ResponseEntity<CompanyDTO>(companyService.updateCompany(id, company),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCompanyById/{id}")
	ResponseEntity<String> deleteCompanyById(@PathVariable int id)
	{
		return new ResponseEntity<String>(companyService.deleteCompany(id),HttpStatus.OK);
	}
	@GetMapping("/getCompanybyphnNumber")
	ResponseEntity<CompanyDTO> getCompanyByPhnNumber(@PathVariable String phnNumber){
		return new ResponseEntity<CompanyDTO>(HttpStatus.OK);
	}
	@GetMapping("/getbookbyname")
	ResponseEntity<CompanyDTO> getBookByName(@PathVariable String name){
		return new ResponseEntity<CompanyDTO>(HttpStatus.OK);
	}
}
