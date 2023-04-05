<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--core 와 fmt 라이브러리 복붙하기 -->
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 라이브러리</title>
<!-- formatting : 나타내는 포맷을 어떤 식으로(어떤 형식) 보여줄 것인가를 지정해주는 라이브러리  -->
</head>
<body>
	<c:set var="number" value="12345678" />
	<h2>숫자 출력</h2>
	<fmt:formatNumber value="${number}" /><br> <!-- 세자리마다 , 찍은 숫자 형태 / 여기서type은 암묵적으로 숨어있음 (아래참고)-->

	<h2>Type</h2>
	숫자 : <fmt:formatNumber value="${number}" type="number" /><br> <!-- 원래는 이렇게 number라는 type이 지정되어 있다 (명시안해도뜸) -->
	숫자 3자리마다 쉼표 제거 : <fmt:formatNumber value="${number}" type="number" groupingUsed="false" /><br>
	
	<%-- percent --%>
	100% : <fmt:formatNumber value="1" type="percent" /><br> <!-- 0에서 부터 1까지를 비율로 나타내는 게 'percent' 이므로, 100퍼센트는 value에 100이 아닌 1을 넣기 주의 -->
	40% : <fmt:formatNumber value="0.4" type="percent" /><br>
	
	<%-- 통화(currency) --%>
	통화 (원) : <fmt:formatNumber value="${number}" type="currency" /><br>
	통화 (달러) : <fmt:formatNumber value="${number}" type="currency" currencySymbol="$" /><br> 
	
	<h2>var로 변수에 저장</h2>
	통화 (달러) : <fmt:formatNumber value="${number}" type="currency" currencySymbol="$" var="dollar" /><br> <!-- var써서 변수이름 저장해둘 수 -->
	달러 EL태그로 출력 : ${dollar}
	
	<h2>Pattern</h2>
	3.14 : <fmt:formatNumber value="3.14" /><br>
	3.14(0.0000) : <fmt:formatNumber value="3.14" pattern="0.0000" /><br>
	3.14(#.####) : <fmt:formatNumber value="3.14" pattern="#.####" /><br> <!--#: 0을 굳이 안 붙이고 그 자리까지만 나타냄, 아래의 경우는 .. -->
	3.141592(#.####) : <fmt:formatNumber value="3.141592" pattern="#.####" /><br> <!-- #: .#네자리까지, 그 뒤 소수점자리는 반올림 해서 소수자리맞춤  -->
	<hr>
	
	<!--이전에배울땐, simpleDateFormat 등 자바구문 사용해서 jsp에서 활용가능했으나, 이제는 jsp에서 자바구문 안 쓸 거라 fmt 태그 활용  -->
	<h2>Date 객체를 String 형태로 출력 => fmt:formatDate</h2>
	<!-- dater객체 내려받아야 해서 controller에서 model 필요 -->
	${today}<br>
	<fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="pattern1"/> <!-- var로 변수 저장해둘시, 안뜨고 해당var변수 불러서 출력 가능 -->
	pattern1 : ${pattern1}<br>
	<fmt:formatDate value="${today}" pattern="yyyy/MM/dd HH:mm:ss" var="pattern2"/>
	pattern2 : ${pattern2}<br>
	
	<h2>String 형태를 Date 객체로 변환 => fmt:parseDate</h2>
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd HH:mm:ss" var="date2" /> <!-- value의 string을 date객체로 변환 , 그런데 value의 pattern(이전)형식 어떤지도써줘야- 그럼 해당pattern의 string을 date객체로 변환-->
	Date 객체: ${date2}
	
	
	
</body>
</html>