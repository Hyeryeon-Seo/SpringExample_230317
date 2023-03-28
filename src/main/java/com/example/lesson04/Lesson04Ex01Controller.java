package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04/ex01")
@Controller // return string => jsp view (찾아주는 어노테이션)   / restcontroller하면 뷰의 경로가 글자로 보여져서
public class Lesson04Ex01Controller {

	
	@Autowired
	private UserBO userBO;
	
	
	// 1. 회원 정보 추가 페이지
	// http://localhost/lesson04/ex01/add_user_view (회원 정보 추가 페이지)
	// requestMapping대로 해당 주소를 쓰면, addUser.jsp로 이동한다
	// html화면이 나오면 view 붙여주고 > jsp로 가게 될 것이다는 의미
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET) // requestMapping은 get도 post도 다 허용하지만, 하나(get)만 허용하려면 method써주기 / path=는 하나일땐 안써도됨
	public String addUserView() {
		//   /WEB-INF/jsp/lesson04/addUser.jsp (이jsp만들기)_  (application.proper..에서 설정해둔 거 나머지만 쓴다)
		return "lesson04/addUser";  // 리턴 jsp view 경로  _ 와 jsp 이름 일치 되어야! 여기서는 슬래시빼고씀  (requestMapping주소와 별개)
	}
	
	// 2. 회원 정보 추가 처리
	//(그냥 아래 페이지 바로 치고 들어갈 시): 405 method 불일치  - 꼭 위의 add_user_view 페이지 통해야 (아래 post라서)
	// (위 주소에서 이동되는) addUser.jsp에서 입력받은 데이터 값 처리하는 페이지 -> 이후 afterAddUser.jsp로 이동시킨다 
	// http://localhost/lesson04/ex01/add_user (회원가입 누르면 - > 데이터 처리 주소 .. -> 결과페이지: 입력 성공이라는 뷰페이지 ) 
	// 정보입력페이지 addUser.jsp에서 post방식으로 입력받아 받는 페이지 /add_user >> 결과처리페이지로 return (afteraddUser)
	@PostMapping("/add_user") // 이경우 requestMapping하면 안됨 get방식되면 안되므로 - 무조건 post방식만 허용하는 주소를 쉽게 쓰는 법은 아래와 같다
	public String addUser( // String 리턴 - "jsp view 주소"
			// id 는 안 받음 
			// 아래 RequestParam은 위 주소에서 이동된 addUser.jsp에서 받은 파라미터 (jsp input의 name들)
			@RequestParam("name") String name,  // 거의 db따라간다 (not null등)
			@RequestParam("yyyymmdd") String yyyymmdd, //requ..param, 아까 jsp의 input namer과 같아야 함
			@RequestParam(value="email", required=false) String email, // 비필수니 꼭 value 붙여야 / false. :null허용
			@RequestParam(value="introduce", required=false) String introduce) {
			// db에 넣고자 위의 파라미터 받음 - db에 인서트하고 (bo,dao거침) - 결과 jsp view
		
		// insert DB (필드따로)
			userBO.addUserAsField(name, yyyymmdd, email, introduce);
		/*  위에서 이미 썼는데..? param. .. -> 하는 거 아님
		public void addUserAsField(
				@RequestParam("id") int id, 
				@RequestParam("name") String name,
				@RequestParam("yyyymmdd") String yyyymmdd,
				@RequestParam(value="email", required=false) String email,
				@RequestParam(value="introduce", required=false) String introduce) {
		*/	
			
		// 결과 jsp view
		// properties 설정 제외한 주소 (슬래시 제외하고 시작)
		return "lesson04/afterAddUser";
	}

	
	// 3. 최신 유저(회원) 정보 출력페이지
	// http://localhost/lesson04/ex01/get_latest_user_view 
	@GetMapping("/get_latest_user_view")
	public String getLatestUserView(Model model) {
		// 가장 최근에 가입된 사람 한명 select DB
		User user = userBO.getLatestUser(); // 반드시 import시 내가 만든 model의 User
		// 여기까진 그냥 가져오고 끝 > MVC패턴 중 model에 담아야
		model.addAttribute("user", user); // ""key 이름 아무렇게 지으면 됨  - value값에 객체 담아야 - 나중에 jsp에서 알아서 꺼낼 수, 여러개 담을수
		model.addAttribute("title", "회원 정보"); // 담고 안담고는 서버 마음
		
		return "lesson04/getLatestUser"; // jsp로 연결
	}
	
	
	
	
}
