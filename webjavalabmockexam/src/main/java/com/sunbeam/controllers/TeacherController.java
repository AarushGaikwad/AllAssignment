package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Teacher;
import com.sunbeam.services.TeacherServiceImpl;

@RequestMapping("/teacher")
@RestController
public class TeacherController {

	private TeacherServiceImpl teacherService;
	@Autowired
	public TeacherController(TeacherServiceImpl teacherService) {
		this.teacherService = teacherService;
	}
	
	@GetMapping("/{id}")
	public Resp<?> getAllTeacher(@PathVariable int id){
		List<Teacher> list = teacherService.showTeacherInDeptartment(id);
		return Resp.success(list);	
	}
	
	@PostMapping("/addTeacher/{id}")
	public Resp<?> addTeacher(@RequestBody Teacher teacher, @PathVariable int id){
		Teacher teach = teacherService.addTeacher(teacher, id);
		return Resp.success(teach);	
	}
	
	@PatchMapping("/updateSal/{id}")
	public Resp<?> updateSalary(@PathVariable int id, @RequestParam double newSalary){
		teacherService.updateSalary(id, newSalary);
		return Resp.success("Salary updated");
	}
	
}
