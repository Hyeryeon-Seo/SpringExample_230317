<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- core 라이브러리 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain." />
	
	<h3>1. 길이 구하기</h3>
	${fn:length(str1)}
	
	<h3>2. 특정 문자열이 있는지 확인</h3>
	No가 존재하는가? ${fn:contains(str1, "No")}<br> <!-- 확인할 포함된 구문은 "", '' 작은큰따옴표 모두 가능 -->
	no가 존재하는가? ${fn:contains(str1, "no")}<br> <!-- 대소문자도 구분 -->
	
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}"><!-- 대소문자구별없이 contains_문자열포함 확인 -->
		문장에 no라는 문자열이 존재합니다.(대소문자 구별 안함)<br><!--참이면 구문 뜸 -->
	</c:if>
	
	<h3>3. 특정 문자열로 시작하는지 확인</h3>
	No로 시작하는가? ${fn:startsWith(str1, 'No')}<br>
	
	<h3>4. 특정 문자열로 끝나는지 확인</h3>
	n으로 끝나는가? ${fn:endsWith(str1, 'n')}<br>
	.으로 끝나는가? ${fn:endsWith(str1, '.')}<br>
	gain.으로 끝나는가? ${fn:endsWith(str1, 'gain.')}<br>  <!-- 이렇게하면 true됨. 원래는 위도 true인데. 해당버전에서문제 -->
	
	<h3>5. 문자열 치환</h3> <%-- fn:replace 정말 많이 쓰니 꼭 알아두기 --%>
	<c:set var="str2" value="나는 치킨을 좋아한다" />
	
	${str2}<br>
	${fn:replace(str2, "치킨", "떡볶이")} <!-- (꼭 띄어쓰기기준은 아니고) 치킨을 떡볶이로 바꿈/ 작은'따옴표도 가능 -->
	
	<h3>6. 구분자로 잘라서 배열 만들기(split)</h3>
	${fn:split(str1, '.')[0]}<br> <!-- .기준으로 자르고, 첫번째는 배열순서index[0] -->
	${fn:split(str1, '.')[1]}<br>
	
	<h3>7. 시작 인덱스부터 종료 인덱스까지 자르기(substring)</h3>
	<%-- 나는 치킨을 좋아한다 --%>
	<%-- str2에서 '치킨' 추출_ '치'와 '킨'은 각각 index 3,4번째 (0부터시작, 띄어쓰기도index포함) --%>
	${fn:substring(str2, 3, 5)} <!-- 3,4 니까 뒤는 +1해서 3,5로 써준다 -->
	
	<h3>8. 모두 소문자로 변경(toLowerCase)</h3> <%-- 자주 씀 --%>
	${fn:toLowerCase(str1)}
	
	<h3>9. 모두 대문자로 변경(toUpperCase)</h3>
	${fn:toUpperCase(str1)}
	
	<h3>10. 앞 뒤 공백 제거(trim)</h3> <!-- 예를들어 사용자가 아이디 여백입력시 제거할 수 -->
	<c:set var="str3" value="           h  el  lo           " />
	<pre>str3: ${str3}</pre> <%--pre 태그써야 그대로 뜸 / 그냥 출력 시 공백무시됨 --%>
	<pre>str3 trim: ${fn:trim(str3)}</pre> <%-- trim써서 앞뒤공백제거 (사이공백은 그대로)--%>




</body>
</html>