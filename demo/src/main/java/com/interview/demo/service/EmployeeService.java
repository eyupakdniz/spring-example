package com.interview.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.interview.demo.dto.EmployeeCreateRequest;
import com.interview.demo.dto.EmployeeUpdateRequest;
import com.interview.demo.entity.Company;
import com.interview.demo.entity.Employee;
import com.interview.demo.repository.EmployeeRepository;



@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private CompanyService companySerive;
	
	public EmployeeService(EmployeeRepository employeeRepository, CompanyService companySerive) {/**/
		this.employeeRepository = employeeRepository;
		this.companySerive = companySerive;
	}
	public List<Employee> getAllEmployees(Optional<Long> companyId) {
		if(companyId.isPresent())
			return employeeRepository.findByCompanyId(companyId.get());
		return employeeRepository.findAll();
	}
	public Employee saveOneEmployee(Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	public Employee getOneEmployeeById(Long employeeId, EmployeeUpdateRequest updateEmployee) {
		return employeeRepository.findById(employeeId).orElse(null);
		
	}
	public Employee createOneEmployee(EmployeeCreateRequest newEmployeeRequest) {
		Company company = companySerive.getOneCompanyById(newEmployeeRequest.getId());
		if(company == null) 	
			return null;
		Employee toSave = new Employee();
		toSave.setId(newEmployeeRequest.getId());
		toSave.setName(newEmployeeRequest.getName());
		toSave.setTitle(newEmployeeRequest.getTitle());
		toSave.setCompany(company);
		return employeeRepository.save(toSave); 
	}
	public Employee updateOneEmployeeById(Long employeeId, EmployeeUpdateRequest updateEmployee) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			Employee toUpdate = employee.get();
			toUpdate.setName(updateEmployee.getName());
			toUpdate.setTitle(updateEmployee.getTitle());
			employeeRepository.save(toUpdate);
			return toUpdate;
		}else
		return null;
	}
	public void deleteById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}	
}
