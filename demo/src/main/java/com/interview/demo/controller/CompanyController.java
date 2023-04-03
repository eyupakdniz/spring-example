package com.interview.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.dto.CompanyUpdateRequest;
import com.interview.demo.entity.Company;
import com.interview.demo.service.CompanyService;


@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService companySerivce;
	public CompanyController(CompanyService companySerivce) {
		this.companySerivce = companySerivce;
	}
	@GetMapping("/")
	public List<Company> getAllCompany(){
		return companySerivce.getAllCompany();
	}
	@PostMapping("/create") 
	public Company createOneCompany(@RequestBody  Company newCompany) {
		 return companySerivce.createOneCompany(newCompany);
	}
	@GetMapping("/{companyId}")
	public Company getOneCompany(@PathVariable Long companyId) {
		return companySerivce.getOneCompanyById(companyId);
	}
	@PutMapping("/update/{companyId}")
	public Company updateOneCompany(@PathVariable Long companyId, 
			@RequestBody CompanyUpdateRequest updateCompany) {
		return companySerivce.updateOneCompanyById(companyId, updateCompany);
	}
	@DeleteMapping("/delete/{companyId}")
	public void deleteOneCompany(@PathVariable Long companyId) {
		try {
		companySerivce.deleteOneCompanyById(companyId);
		}catch(Exception e) {}
	}
}
