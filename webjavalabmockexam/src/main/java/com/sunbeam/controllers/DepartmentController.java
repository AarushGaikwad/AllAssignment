package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dtos.DepartmentDto;
import com.sunbeam.entities.Department;
import com.sunbeam.services.DepartmentServiceImpl;

@RequestMapping("/depts")
@RestController
public class DepartmentController {
	
	private DepartmentServiceImpl departmentService;
	@Autowired
	public DepartmentController(DepartmentServiceImpl departmentService) {
		this.departmentService = departmentService;
	}
	
	//Get All Departments By DTO
	/*
	@GetMapping
	public Resp<?> getAllDepartment(){
		List<DepartmentDto> deptList = departmentService.getAllDepartment();
		return Resp.success(deptList);
	}
	*/
	
	//Get All Department By Entity
	@GetMapping
	public Resp<?> getAllDepartment(){
		List<Department> deptList = departmentService.getAllDepartment();
		return Resp.success(deptList);
	}
	
	//Delete Department By Entity
	@DeleteMapping("/{id}")
	public Resp<?> deleteDepartment(@PathVariable int id){
		departmentService.deleteDepartmentById(id);
		return Resp.success("Department deleted");
	}
	
	//Add Department by using Entity
	@PostMapping("/add")
	public Resp<?> addDepartment(@RequestBody Department dept){
		departmentService.addDepartment(dept);
		return Resp.success(dept);
	}
	
}
