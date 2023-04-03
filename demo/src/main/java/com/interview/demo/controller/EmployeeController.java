package com.interview.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.dto.EmployeeCreateRequest;
import com.interview.demo.dto.EmployeeUpdateRequest;
import com.interview.demo.entity.Employee;
import com.interview.demo.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping("/")
	public List<Employee> getAllEmployee(@RequestParam Optional<Long> companyId){
		return employeeService.getAllEmployees(companyId);
	}
	@PostMapping("/create")
	public Employee createOneEmployee(@RequestBody EmployeeCreateRequest newEmployeeRequest) {
		return employeeService.createOneEmployee(newEmployeeRequest);
	}
	@GetMapping("/{employeeId}")
	public Employee getOneEmployee(@PathVariable Long employeeId, 
			@RequestBody EmployeeUpdateRequest updateEmployee) {
		return employeeService.updateOneEmployeeById(employeeId,updateEmployee);
	}
	@PutMapping("/update/{employeeId}")
	public Employee updateOneEmployee(@PathVariable Long employeeId, 
			@RequestBody EmployeeUpdateRequest newEmployee) {
		return employeeService.updateOneEmployeeById(employeeId, newEmployee);
	}
	@DeleteMapping("/delete/{employeeId}")
	public void deleteOneEmployee(@PathVariable Long employeeId) {
		employeeService.deleteById(employeeId);
	}
}