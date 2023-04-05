<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%--AJAX를 사용하려면 jquery 원본 필요--%>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container"> <!--container는 부트스트랩 에 있음 -->
		<h1 class="mt-3">회원 정보 추가</h1>
		
		<!-- 지금은 input 파라미터 - 빈칸으로 넘어갈 수 있지만, 자바스크립트에서는 NULL아니면 채워져있어야 함 -->
		<form method="post" action="/lesson06/ex01/add_user"> <!-- post방식으로 입력받아 데이터처리하는 주소 -->
		<%--사실 여기서 FORM태그없애도됨 ajax써서 --%>
			<div class="form-group">
				<label for="name"><b>이름</b></label> <!-- 뭐에 대한 라벨인지 for로, 
				아래 input에서는 for있으면 아래에도 id써줘야(동일하게), name도필수 - 그래야 넘어감 -->
				<input type="text" id="name" name="name" class="form-control col-3" > <!-- placeholder 생략가능 -->
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="6"></textarea>  <!-- 기니까 textarea. 줄바꿈 사이에 하면 그대로 공백 드러나니 딱 붙이기, class에 form control하면 예뻐짐
				rows는 글자수 행 -->
			</div>
<!-- 			<input type="submit" class="btn btn-success" value="회원가입"> value는 버튼 안 글자내용
 -->			<%--ajax일떄는 submit없애야! / AJAX통신일 때는 반드시 button 타입으로 지정한다. --%>
 				<input type="button" id="addBtn" class="btn btn-success" value="회원가입">
			
		</form>
	</div>


<script>
	$(document).ready(function() { // 제이쿼리문법 - 준비되었을때 하겠다는 뜻
		// (1) jquery의 submit기능 이용하기
		/*
		$("form").on("submit", function(e) { // form태그 여러개면 id로 정해서 select가능
			// e.preventDefault(); // submit 되는 것을 막는다 (넘어가지x)
			// alert("서브밋 버튼 클릭");
			
			// validation (유효성 체크)
			let name = $("#name").val().trim(); // id가져오기 #으로 / trim 써서 앞뒤여백없애기
			if (!name) { // name비어있을때를 쓰려면 - !name / name ==  / name.length < 1 세 가지중 하나로
				alert("이름을 입력하세요");
				return false; // submit 안함
			}
			
			let yyyymmdd = $("#yyyymmdd").val().trim();
			if (!yyyymmdd) {
				alert("생년월일을 입력하세요");
				return false;
			}
			
			// name,yyyymmdd있으면 submit으로
			// 여기까지 도달하면 submit
			
		});
		*/
		
		// (2) jquery의 AJAX 통신을 이용하기
		$("#addBtn").on("click", function() {
			// 빈칸없이 입력되었는지_ validation (유효성 체크)
			let name = $("#name").val().trim(); // id가져오기 #으로 / trim 써서 앞뒤여백없애기
			if (!name) { // name비어있을때를 쓰려면 - !name / name ==  / name.length < 1 세 가지중 하나로
				alert("이름을 입력하세요");
				return;
			}
			
			let yyyymmdd = $("#yyyymmdd").val().trim();
			if (!yyyymmdd) {
				alert("생년월일을 입력하세요");
				return;
			}
			
			let email = $("input[name=email]").val().trim(); // 여기는 비필수라 alert띄울필요없고 trim만 해주기 (앞뒤여백제거)
			let introduce = $("#introduce").val();
			console.log(name); // console로 간단히 출력해서(검사-콘솔에서 확인해보기) 잘 가져왔는지 확인
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			// AJAX: 폼태그와 상관없이 비동기로 별도 요청(Request)  -- 그대로 머무름.
			$.ajax({  // 제이쿼리의 ajax 함수
				// request (브라우저가 하던 일을 내가 직접 요청 날리고)
				type:"POST"
				, url:"/lesson06/ex01/add_user"
				, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} // :앞은 위 변수 request파라미터 이름, 뒤는   / json형식
				
				// response (응답도 여기서 받는다)
				, success:function(data) { // data아무렇게나이름지어도됨 / data: response 결과 응답
					if (data == "성공") {
						location.href = "/lesson06/ex01/result_view";
					}
					// alert(data);
				}
				, complete:function(data) { // 성공했던 실패했든
					alert("성공이든 실패이든 완료");
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				} // 여기까지가 클라이언트가 할 수 있는 모든 일
				
				
			});
			
		});
		
		
	});   
</script>

</body>
</html>