<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 코어 임포트 (구글 검색해서) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	<h2>1. 변수 정의하기 (c:set)</h2>
	<c:set var="number1" value="100" />
	<c:set var="number2">250</c:set>
	<!-- var변수명, value어떤값담을지(혹은 number2처럼 태그사이에값넣기) ,  /로 닫을 수-->
	
	number1: ${number1}<br> 
	number2: ${number2}<br> 
	number1 + number2: ${number1 + number2}  <%-- ${} 안에서만 자바구문. el문법으로 산술가능  --%>
	<%--html주석태그 <!..-- >로는 EL문법${} 주석처리 안되어 에러남 주의!  이 자바스크립태그써줘야 --%>
	
	<h2>2. 변수 출력하기 (c:out)</h2>
	<!-- 이미 위에서도 변수 출력했지만 태그사용해 출력도 가능 -->
	number1: <c:out value="${number1}" /><br>
	<c:out value="Hello World" /><br> 
	<!-- 위 경우 그냥 c:out태그 아니어도 밖에 hello..써도 나오지만.  
	예를들어 <script>사이에 쓰면 무조건수행되는 경우가 있다. 이 경우
	아래처럼 c:out태그쓰면 글자 그대로 나오게할수. 즉 그대로 수행안되고 글자그대로 출력 가능하게 해주는 태그다! -->
	<%-- 문구 그대로 출력된다. --%>
	<%-- + 참고로 $_{} EL문법(자바문법처럼)의 경우도 이처럼 HTML주석말고, JSP주석 처리 해줘야 먹힌다 --%>
	<c:out value="<script>alert('얼럿창 띄우기')</script>" /><br>
	<c:out value="<script>alert('얼럿창 띄우기')</script>" escapeXml="true" /><br>
	<%--escapeXml false시 (글자그대로출력x) 스크립트가 수행된다. 
	(escape처리시 글자그대로 출력- 사실 c:out 태그 value""안에만 써줘도 자동 escape 처리되나, true도 써주면 정확)--%>
	<%-- <c:out value="<script>alert('얼럿창 띄우기')</script>" escapeXml="false" /><br> 
	>> 해당 부분 그대로 드래그된 상태에서 ctl shift / 하면 자동주석처리--%>	
	
	<h2>3. 조건문 (c:if)</h2>
	<c:if test="${number1 > 50}"> <!--if참이면 아래 그대로 수행 -->
		number1은 50보다 크다. <br>
	</c:if>
	<c:if test="${number1 == 100}">
		number1은 100과 같다. <br>
	</c:if>
	<c:if test="${number1 eq 100}">  <!-- 위와 동일. 이전에는 ==써도 버그났었다 -->
		number1은 100과 같다. <br>
	</c:if>
	<c:if test="${number1 ne 222}"> <!-- 같지않다 혹은 != -->
		number1은 222가 아니다. <br>
	</c:if>
	<c:if test="${!empty number1}"> <!-- 비어있지 않다-->
		number1은 비어있지 않다. <br>
	</c:if>
	<c:if test="${not empty number1}"> <!-- 비어있지 않다-->
		number1은 비어있지 않다. <br>
	</c:if>
	
	
	
</body>
</html>