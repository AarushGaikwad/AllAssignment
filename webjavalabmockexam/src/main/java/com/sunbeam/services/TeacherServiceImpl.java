package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.DepartmentDao;
import com.sunbeam.dtos.TeacherDao;
import com.sunbeam.entities.Department;
import com.sunbeam.entities.Teacher;

@Service
public class TeacherServiceImpl {
	
	private DepartmentDao departmentDao;
	private TeacherDao teacherDao;
	@Autowired
	public TeacherServiceImpl(DepartmentDao departmentDao, TeacherDao teacherDao) {
		this.departmentDao = departmentDao;
		this.teacherDao = teacherDao;
	}
	
	//Show Teacher in a Department
	public List<Teacher> showTeacherInDeptartment(int id){
		if(departmentDao.existsById(id)) {
			Department department = departmentDao.findById(id).get();
			List<Teacher> list = department.getTeacherList();
			return list;
		}
		return null;
	}
	
	// Add teacher in Department
	public Teacher addTeacher(Teacher teacher, int deptId) {
	    if (departmentDao.existsById(deptId)) {
	        Department department = departmentDao.findById(deptId).get();
	        teacher.setDept(department);
	        return teacherDao.save(teacher);
	    }
	    return null;
	}
	
	public Teacher updateSalary(int id, double newSalary) {
		if(teacherDao.existsById(id)) {
			Teacher teacher = teacherDao.findById(id).get();
			teacher.setSalary(newSalary);
			return teacherDao.save(teacher);
		}
		return null;
	}
	
}
