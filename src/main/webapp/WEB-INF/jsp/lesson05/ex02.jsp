<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2)</title>
</head>
<body>
	<h2>1. 조건문 (c:choose, c:when, c:otherwise)</h2>
	<!--  when: else if같이 -->
	<c:set var="weight" value="65" />
	
	<c:choose>
		<%-- 59키로 이하 --%>
		<c:when test="${weight < 60}">
			떡볶이 먹자<br>
		</c:when>
		<%-- 61 ~ 69 --%>
		<c:when test="${weight < 70 }"> 
			샐러드 먹자<br>
		</c:when>
		<%-- 70 ~ --%>
		<c:otherwise>
			굶자<br>
		</c:otherwise>
	</c:choose>

	<h2>2. 반복문 (c:forEach)</h2>
	<%-- 0 ~ 5 => 6번 --%>
	<c:forEach begin="0" end="5" step="1" var="val1">
		${val1}<br>
	</c:forEach>
	<br>
	
	<%-- 16 ~ 20 => 5번 --%>
	<c:forEach begin="16" end="20" step="1" var="val2" varStatus="status">
	<%-- varStatus 속성 통해서 (="status"통해서 여기에 객체 들어감) 이 안의 count, index등을 사용가능하게 함--%>
		var:${val2} current:${status.current}
		first:${status.first} <%--이 반복문이 첫번째인지 묻기--%> last:${status.last}
		count:${status.count} <%-- 1부터 시작해서 셈 --%> index:${status.index} <%--index 0부터/ 현재는 돌고있는 current값과 동일하나, 리스트사용시 용이 --%>
		<br>
	</c:forEach> 
	
	<%-- 서버에서 가져온 List<String> 출력 --%>
	<c:forEach items="${fruits}" var="fruit" varStatus="status" > <%-- items는 Model에 담았던 값이므로 반드시 EL문법으로 감싸기 --%>
	<%-- forEach (향상for문처럼) 하나하나 꺼내서 돌아 / 꺼내서 담을 var 변수명 짓기 (items의 모델명과 같으면 안된다!)--%>
		${fruit} ::::: ${status.count} ${status.index}
	</c:forEach>

	<%-- 서버에서 가져온 List<Map> 출력--%>
	<c:forEach items="${users}" var="user" varStatus="status"> <!-- items,var는 필수/ varStatus는 옵션 _여기서 명시하는 이유는 몇번째 사람인지 명시 위해 숫자 붙이려고-->
		<h4>${status.count}번째 사람 정보</h4>
		이름: ${user.name}<br> <!-- 만약 .필드명없이 key {user}만 쓰면 map형식으로 모든 필드 다 출력 -->
		나이: ${user.age}<br>
		취미: ${user.hobby}<br>
	</c:forEach>

	<%-- 테이블 구성 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
		<%-- user 반복문 써줄 건데, 이전의 스크립틀릿(이주석같은) 이 아니라 c:forEach로 반복문 써준다 --%> 
		<%-- 아래처럼_ users(userList부름) 개수만큼 돌게 되고, 하나씩 꺼낸 map을 (list안의 'user') var에 저장해준다 --%>
		<%-- 만약 id값 지정해주고 싶으면, varStatus를 사용 (.count로 1부터 부여가능, index는 0부터) --%>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.hobby}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>



</body>
</html>