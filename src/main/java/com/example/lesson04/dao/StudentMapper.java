package com.example.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson04.model.Student;

@Repository
public interface StudentMapper {

	public void insertStudent(Student student);
	// 한 개니까 param감쌀 필요 없음
	
	public Student selectStudentById(int id);
	
}
