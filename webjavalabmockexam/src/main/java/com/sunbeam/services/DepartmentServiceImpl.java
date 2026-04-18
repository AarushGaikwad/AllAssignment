package com.sunbeam.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.DepartmentDao;
import com.sunbeam.dtos.DepartmentDto;
import com.sunbeam.entities.Department;

@Service
public class DepartmentServiceImpl {
	private ModelMapper modelMapper;
	private DepartmentDao departmentDao;
	@Autowired
	public DepartmentServiceImpl(ModelMapper modelMapper, DepartmentDao departmentDao) {
		this.modelMapper = modelMapper;
		this.departmentDao = departmentDao;
	}
	
	//Get All Departments By Using DTO
	/*
	public List<DepartmentDto> getAllDepartment(){
		//By using
		List<Department> deptList = departmentDao.findAll();
		List<DepartmentDto> deptDtoList = new ArrayList<>();
		for (Department department : deptList) {
			DepartmentDto deptDto = modelMapper.map(department, DepartmentDto.class);
			deptDtoList.add(deptDto);
		}
		return deptDtoList;
	}
	*/
	
	//Get All Departments By Using Entity
	public List<Department> getAllDepartment(){
		List<Department> deptList = departmentDao.findAll();
		return deptList;
	}
	
	
	//Delete Department By Using DTO
	/*
	public DepartmentDto deleteDepartmentById(int id) {
		//DepartmentDto deptDto = departmentDao.deleteById(id);
		if(departmentDao.existsById(id)) {
			departmentDao.deleteById(id);
		}
		return null;
	}
	*/
	
	//Delete Department By using Entity
	public Department deleteDepartmentById(int id) {
		if(departmentDao.existsById(id))
			departmentDao.deleteById(id);
		return null;
	}
	
	//Add Department using Entity
	public Department addDepartment(Department dept) {
		departmentDao.save(dept);
		return dept;
	}
	
}
