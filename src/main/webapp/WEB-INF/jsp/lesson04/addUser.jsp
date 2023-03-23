<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  jsp할땐 서버 안꺼도 됨 / 자바코드작성시엔 끄기-->
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- 부트스트랩페이지(get...kr)에서 4.6버전 CSS, Bundel 복붙 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script></head>
<body>
	
	<div class="container"> <!--container는 부트스트랩 에 있음 -->
		<h1 class="mt-3">회원 정보 추가</h1>
		
		<form method="post" action="/lesson04/ex01/add_user"> <!-- post방식으로 입력받아 데이터처리하는 주소 -->
			<div class="form-group">
				<label for="name"><b>이름</b></label> <!-- 뭐에 대한 라벨인지 for로, 아래 input에서는 for있으면 아래에도 id써줘야(동일하게), name도필수 아래 -->
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
			<input type="submit" class="btn btn-success" value="회원가입"> <!-- value는 버튼 안 글자내용 -->
			
			
		</form>
	
	</div>
	
</body>
</html>