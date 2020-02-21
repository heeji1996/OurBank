<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.http.*" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function goToMyInfoUpdate(){
	location.href='myInfoUpdateForm.do?id=${userBean.getId()}';
}
function goToMyPge(){
	location.href='myPage.do';
}
function deleteId(){
	location.href='deleteId.do?id=${userBean.getId()}';
}
</script>
</head>

<body>
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	
	<jsp:include page="../header.jsp"></jsp:include>
	
<!-- *********************** ���̵� �޴� ****************************  -->	
		<div id="side_menu">
		<h4><a href="#">My Page</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="#"> ������������ </a></li>
				<li>- <a href="#"> ���� �ۼ��� �� </a></li>
				<li>- <a href="#"> ������ ��ǰ ��ȸ </a></li>
				<li>- <a href="#"> ���ɻ�ǰ </a></li>
				<li>- <a href="manageDeposit.do"> ���� ��ǰ ������ ���� </a></li>
				<li>- <a href="manageSaving.do"> ���� ��ǰ ������ ���� </a></li>
			</ul>
		</div>
	</div>
	
	
<!-- *********************** ���� ****************************  -->
<div style="padding: 10px;">
	<table border="1" cellpadding="10px" >
		<tr>
		<td>
			<ul>
				<li>���̵�</li>
				<li>��й�ȣ</li>
			</ul>
		</td>
		<td>
			<ul>
				<li><c:out value="${userBean.getId()}"></c:out></li>
				<li>************</li>
			</ul>
		</td>
		</tr>
		<tr>
		<td>
			<ul>
				<li>�̸�</li>
				<li>�������</li>
				<li>�޴��� ��ȣ</li>
				<li>�ּ�</li>
				<li>�̸���</li>
			</ul>
		</td>
		<td>
			<ul>
				<li><c:out value="${userBean.getUser_name()}"></c:out></li>
				<li><c:out value="${userBean.getUser_birth()}"></c:out></li>
				<li><c:out value="${userBean.getUser_phone()}"></c:out></li>
				<li><c:out value="${userBean.getUser_address()}"></c:out></li>
				<li><c:out value="${userBean.getUser_email()}"></c:out></li>
				
			</ul>
		</td>
		</tr>
		<tr>
		<td colspan="2" align="center" >
		<!-- ���� ����ڿ� �ٲ��ֱ� -->
		<input type="button" value="��������" onclick="goToMyPge()">
		<input type="submit" value="ȸ����������" onclick="goToMyInfoUpdate()">
		<input type="button" value="ȸ������" onclick="deleteId()">
		</td>
		</tr>
	</table>
</div>

	<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>