package com.interview.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.interview.demo.dto.CompanyUpdateRequest;
import com.interview.demo.entity.Company;
import com.interview.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	private CompanyRepository companyRepository; 
	
	public CompanyService(CompanyRepository companyRepository ) {
		this.companyRepository=companyRepository;
	}
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}
	public Company getOneCompanyById(Long companyId) {
		return companyRepository.findById(companyId).orElse(null); 
	}
	public Company createOneCompany(Company newCompany) {
		return companyRepository.save(newCompany);
	}
	public Company updateOneCompanyById(Long companyId, CompanyUpdateRequest updateCompany) {
		Optional<Company> company = companyRepository.findById(companyId);
		if(company.isPresent()) {
		Company toUpdate = company.get();
		toUpdate.setName(updateCompany.getName());
		toUpdate.setAddress(updateCompany.getAddress());
		companyRepository.save(toUpdate);
		return toUpdate;
		}else	
			return null;
	}
	public void deleteOneCompanyById(Long companyId) throws Exception {
		Optional<Company> company = companyRepository.findById(companyId);
		if(company.isPresent()) {
			companyRepository.deleteById(companyId);}
		else {
			throw new Exception("bulunamadı");
		}
	}
}
