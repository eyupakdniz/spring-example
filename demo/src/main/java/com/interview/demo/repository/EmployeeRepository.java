package com.interview.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByCompanyId(Long companyId);

}
