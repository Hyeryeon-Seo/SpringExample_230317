package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentMapper;
import com.example.lesson04.model.Student;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	public void addStudent(Student student) {// int도 가능하나 // import
		// 여기 () input 자리 : Student(자료형) student 객체명 
		studentMapper.insertStudent(student); 
		// 미리 쓰면 안되고 mapper에서 만들고나서 autowired하고 메소드명 써줘야 -글고 Mapper에서 새로쓴 거 저장,갱신해줘야 에러 안남
		
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}
