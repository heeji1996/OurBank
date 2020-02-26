<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.http.*" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/body.css" >
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/h_script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>리뷰게시판 글쓰기</title>
<script type="text/javascript">
// 작성 취소
function boardlist(){
	location.href='reviewList.do?current_page=1';
}
</script>

</head>


<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	   <div id="body_div">
	<div id="side_menu">
		<h4><a href="/app/reviewList.do?current_page=1">커뮤니티</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="/app/reviewList.do?current_page=1"> 리 뷰</a></li>
				<li>- <a href="/app/freeList.do?current_page=1"> 자유게시판</a></li>
				<li>- <a href="/app/meetingList.do?current_page=1"> 모임방</a></li>
				<li>- <a href="/app/debateList.do?current_page=1"> 토론방</a></li>
				<li>- <a href="/app/investList.do?current_page=1"> 재테크노하우</a></li>
				<li>- <a href="/app/bestList.do?current_page=1"> BEST게시물</a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** 내용 ****************************  -->
<div id="line_div">
	<div id="sub_logo">
		<h2>리뷰 게시판</h2>
    </div> 
 <div id="site_div">
<c:url var="insertUrl" value="/review_write_form.do" />	
<sf:form modelAttribute="boardBean" commandName="boardBean" enctype="multipart/form-data" 
	id="form" method="POST" action="${insertUrl}" >
	
	<sf:hidden path="ref" value="${ref}"/>
	<sf:hidden path="step" value="${step}"/>
	<sf:hidden path="depth" value="${depth}"/>
	<sf:hidden path="re_idx" value="${re_idx}"/>
	<sf:hidden path="idx" value="${id_x}"/>

	<table class="tlb_board">
		<tr>
			<td style="background-color: #f2f2f2"><b>제목</b></td>
			<td style="float: left; margin-left: 10px;">
			<c:if test="${re_idx==0}">
			<sf:input path="subject" size="50" maxlength="50" id="subject" value="[리뷰게시판]"/><br />
			</c:if> 
			<c:if test="${re_idx==1}">
			<sf:input path="subject" size="50" maxlength="50" id="subject" value="${subject }" />
			</c:if><br />
			<sf:errors path="subject" cssClass="error" /></td>
		</tr>
		<tr>
		<th style="background-color: #f2f2f2"><b>아아디</b></th>
		 <td style="float: left; margin-left: 10px;">
		 <sf:input path="id" value="${uid}" size="50" cssStyle="width:450px;"/></td>
		</tr>
			<td style="background-color: #f2f2f2"><b>카테고리</b></td>
			<td style="float: left; margin-left: 10px;">
				<c:if test="${re_idx==0}"> <!-- 본글일 때 -->
					<sf:select path="review_case">
					<sf:option value="예금리뷰" label="예금리뷰"/>
					<sf:option value="적금리뷰" label="적금리뷰"/>
					<sf:option value="기타리뷰" label="기타리뷰"/>
					</sf:select>
				</c:if>
				<c:if test="${re_idx==1}"> <!-- 답글일 때 -->
					<c:out value="[${review_case}]"></c:out>
				</c:if>
			</td>
		</tr>
		
		<c:if test="${re_idx==0}"> <!-- 본글일 때 -->
		<tr>
			<td style="background-color: #f2f2f2"><b>은행명</b></td>
			<td style="float: left; margin-left: 10px;">
				<sf:input path="banks" size="30" maxlength="30" id="banks" value="${banks}"/>
				<sf:errors path="banks" cssClass="error"/></td>
		</tr>
		<tr>
			<td style="background-color: #f2f2f2"><b>상품명</b></td>
			<td style="float: left; margin-left: 10px;">
			<sf:input path="re_productname" size="30" maxlength="30" id="re_productname" value="${re_productname}"/>
				<sf:errors path="re_productname" cssClass="error"/></td>
		</tr>
		<tr>
			<td style="background-color: #f2f2f2"><b>만족도</b></td>
				<td style="float: left; margin-left: 10px;">
				<sf:select path="satisfaction">
				<sf:option value="★★★★★  매우만족" label="★★★★★   매우만족"/>
				<sf:option value="★★★★  만족" label="★★★★      만족"/>
				<sf:option value="★★★  보통" label="★★★         보통"/>
				<sf:option value="★★  불만족" label="★★		  불만족"/>
				<sf:option value="★  매우불만족" label="★		 매우불만족"/>
			</sf:select></td>
		</tr>
		</c:if>
	
		<tr>
			<td style="background-color: #f2f2f2"><b>내용</b></td>
			<td><sf:textarea path="content" size="200" id="content"
					Style="width:550px;height:250px; margin-left: 10px;" maxlength="200" /><br /> 
				<sf:errors path="content" cssClass="error" /></td>
		</tr>

		<tr>
			<td style="background-color: #f2f2f2"><b>파일</b></td>
			<td style="float: left; margin-left: 10px;">
			<input type="file" name="file"></td>
		</tr>
	</table>
	<div class="div_board_bnt">
				<input type="submit" value="등 록" id="save" class="bnt_view"/>
				<input type="button" value="목 록" onclick="javascript:boardlist()" class="bnt_view"/>
		</div>
</sf:form>
</div>
</div>
</div>	
	
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</html>