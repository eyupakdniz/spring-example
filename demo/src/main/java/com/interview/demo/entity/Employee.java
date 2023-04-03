package com.interview.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {

	@Id
	Long id;
	
	String name;
	String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="company_id", nullable=false)
	@JsonIgnore
	Company company;
}
