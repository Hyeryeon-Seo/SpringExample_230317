package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	StudentBO studentBO;
	
	// http://localhost/lesson04/ex02/add_student_view
	@GetMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}

	// (아래: 주소 치고 들어가는 게 아니라, 위 주소 jsp통해서 submit시)
	// http://localhost/lesson04/ex02/add_student
	@PostMapping("/add_student")
	public String addStudent(
			// 객체로 받아오기 - db에 넣기 위해
			// name 속성의 파라미터명과 일치하는 필드에 값이 들어간다.
			@ModelAttribute Student student, // 생략도 가능한 어노 (임포트하기)
			// 회사따라 형식도 다른데-  그 안의 파라미터도 모두 나열해서 쓰기도 한다
			Model model) { // 선언
			
	
		// DB insert
		studentBO.addStudent(student); // 애를 지나는 순간 마이바티스가 채워줘서.. (여기 넘긴것만으로도) id채워짐
		// 이 줄에 브레이크포인트 걸고 확인해봐야 (한줄씩) 어디서 에러걸리는 지 알 수 있다
		
		
		// DB select - 지금 가입한 사람 (정보를 db에서 셀렉트) - 그 id로 select
		// student객체에 덮어쓰든 새로운 객체 만들거나
		// 동시 여러명 가입해도 상관 x
		Student latestStudent = studentBO.getStudentById(student.getId()); // Student 클래스의 id 변수 getter 
		
		
		// Model에 셀렉트된 데이터를 담는다 (그래야 view가 사용 가능) - 계속 맵에 담아서 줄 수 있음
		// latestStudent에 가장최신학생정보 담겨져있어
		model.addAttribute("result", latestStudent);
		model.addAttribute("title", "최근 가입된 학생 정보");
		
		
		// 결과 - 추가된 학생 정보를 보여주는 jsp
		return "lesson04/afterAddStudent";
		
	}
	
	
}
