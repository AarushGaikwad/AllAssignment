package com.sunbeam.dtos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
