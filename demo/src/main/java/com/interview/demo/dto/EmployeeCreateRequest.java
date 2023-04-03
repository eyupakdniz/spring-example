package com.interview.demo.dto;

import lombok.Data;

@Data
public class EmployeeCreateRequest {

	Long id;
	String name;
	String Title;
	Long companyId;
}
