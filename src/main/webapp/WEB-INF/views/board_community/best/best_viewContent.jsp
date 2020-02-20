<%@page import="java.nio.file.Path"%>
<%@page import="org.springframework.core.io.ClassPathResource"%>
<%@page import="com.ourbank.app.bean.DebateBoard_Bean"%>
<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.http.*"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/body.css" >
<title>BEST �ۺ���</title>
</head>

<!-- model�� ������ �а� �ҷ��� -->
<c:set var="best_idx" value="${best_idx}" />
<c:set var="current_page" value="${current_page}" />
<c:set var="filename" value="${filename}"/>

<%
	String filename=(String) (pageContext.getAttribute("filename"));
%>
<script  language="javascript">
function boardlist(){
		location.href='best_listSpecificPageWork.do?current_page=${current_page}';
}

function download(){
	var param="<%=filename%>";
	en_filename=encodeURI(param)
	location.href="best_download.do?filename="+en_filename;
}
</script>

<!-- *********************** �Խ��� �۾��� �� ****************************  -->	
<jsp:include page="../../header.jsp"></jsp:include>
<!-- *********************** ���̵� �޴� ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">Ŀ�´�Ƽ</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="/app/review_listSpecificPageWork.do?current_page=1"> �� ��</a></li>
				<li>- <a href="/app/free_listSpecificPageWork.do?current_page=1"> �����Խ���</a></li>
				<li>- <a href="/app/meeting_listSpecificPageWork.do?current_page=1"> ���ӹ�</a></li>
				<li>- <a href="/app/debate_listSpecificPageWork.do?current_page=1"> ��й�</a></li>
				<li>- <a href="/app/_listSpecificPageWork.do?current_page=1"> ����ũ���Ͽ�</a></li>
				<li>- <a href="/app/best_listSpecificPageWork.do?current_page=1"> BEST�Խù�</a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** ���� ****************************  -->	

<div id="body_div">
<h2>BEST�Խù�</h2>	
<div id="board_div">

<table cellspacing="0" cellpadding="5" border="1" width="500">
	
	<tr>
		<td><b>��ȸ��</b></td><td><c:out value="${boardData.getHits()}"/></td>
	</tr>
	<tr>
		<td><b>�ۼ���</b></td><td><c:out value="${boardData.getCreated_date()}"/></td>
	</tr>
	<tr>
		<td><b>���̵�</b></td><td><c:out value="${boardData.getId()}"/></td>
	</tr>
	<tr>
		<td><b>����</b></td><td><c:out value="[${board.getCategory()}�Խ���]  ${boardData.getSubject()}"/></td>
	</tr>
	<tr>
		<td><b>����</b></td><td><c:out value="${boardData.getContent()}"/></td>
	</tr>
	<tr>
		<td>����÷��</td>
		<td><input type="button"
		onclick="download()" 
		value="${boardData.getFilename()}"/></td>
	</tr>
</table>

<table cellspacing="0" cellpadding="0" border="0" width="500">
	<tr>
	<td>
		<input type="button" value="���" onclick="javascript:boardlist()">
	</td>
	</tr>

</table>
</div>
</div>

<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
</html>