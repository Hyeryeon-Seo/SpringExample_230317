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
</head>S
<body>

	<div class="container"> <!--container는 부트스트랩 에 있음 -->
		<h1 class="mt-3">회원 정보 추가</h1>
		
			<div class="form-group">
				<label for="name"><b>이름</b></label> 
				<div class="d-flex"> <!-- 가로배열 -->
					<input type="text" id="name" class="form-control col-3" > <!-- 여기서 name제거해도됨(파라미터x) ,  placeholder 생략가능 -->
					<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>				
				</div>
				<!-- <small>중복되었습니다.</small> -->
				<small id="nameStatusArea"></small>   <!-- 글자색상도정의할거라서 span태그싸주는게 -->
			
			</div>

			<button type="button" class="btn btn-success" id="joinBtn">가입하기</button>
			
	</div>


<script>
$(document).ready(function() {
	// 중복확인 버튼 클릭
	$("#nameCheckBtn").on('click', function() {
		// 클릭하자마자 초기화 처리하기 (안그럼 계속 누를 때 마다 , 문구 중복으로 뜸)
		// #nameStatusArea 하위 태그들을 초기화
		$("#nameStatusArea").empty();
		
		// alert("aaa"); 콘솔띄우고 에러나는지 확인해볼 것
		let name = $("#name").val().trim();
		
		// validation
		if (name == "") {
			$("#nameStatusArea").append('<span class="text-danger">이름이 비어있습니다.</span>'); // 태그 추가, append 함수  .. 여기서 동적으로 추가 
			return; // 서버로 가면안돼서 return으로 끝내기
		}
		
		// 이름이 중복됐는지 체그 -> AJAX 통신 (다른 서버창 넘기지않고 같은 창에서)
		$.ajax ({
			// request
			// get메소드도 가능 (민감한 정보아니고 노출해도 상관없다면)	
			type:"get" // 사실 get은 이거 안써서 안보내도 알아서 get됨
			, url:"/lesson06/ex02/is_duplication"  // 중복인지확인, 이 주소로 요청
			, data:{"name":name}
			
			// response
			, success:function(data) { // json해석했다면 data는 object로 들어올 것
				// {"code":1, "isDuplication":true}
				// {"code":500, "errorMessage":"실패한 이유"}
				// if (data.code == 1) {
					// data는 map, dictionary
					if (data.isDuplication) {
						$("#nameStatusArea").append('<span class="text-danger">이름이 중복되었습니다.</span>');
					}
			}
			, error:function(request, status, error) {
				alert("중복확인에 실패했습니다. 관리자에게 문의해주세요.");
			}
			
		});
	});
	
	// 가입 버튼 클릭
	$("#joinBtn").on("click", function() {
		// nameStatusArea 상자 하위 노드(객체, ..여기선 태그)들이 있는지 확인
		console.log($("nameStatusArea").children().length); // 자식들 다 가져온다는 뜻
		if ($("nameStatusArea").children().length == 0) {
			alert("서버호출 가능");
		} else {
			alert("서버호출 불가");
		} 
	});
	
});


</script>
</body>
</html>