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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/body.css" >
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>

<script language="javascript">
	function boardlist(){
		location.href='/OurBank/meeting_listSpecificPageWork?current_page=${current_page}';
	}
</script>
<title>���ӹ�Խ��� �ۼ���</title>
</head>

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
<h2>���ӹ� �Խ���</h2>	
<div id="board_div">	

<c:url var="updateUrl" value="/meeting_DoUpdateBoard.do"/>
<sf:form modelAttribute="boardData" method="POST" action="${updateUrl}" enctype="multipart/form-data" id="form" >
	<table class="board" width="400" border="1" cellspacing="0" cellpadding="5">
		<input type="hidden" name="idx_num" value="${idx_num}">
		<input type="hidden" name="current_page" value="${current_page}">
		
		<tr>
			<td><b>����</b></td>
			<td><sf:input path="subject" size="50" maxlength="50" /></td>
			<sf:errors path="subject" cssClass="error" />		
		</tr>
		<tr>
			<td><b>���̵�</b></td>
			<td>
			<sf:input readonly="true" path="id" 
						  size="50" maxlength="50" />
			<sf:errors path="id" cssClass="error" />			
			</td>
		</tr>
		<tr>
			<td><b>����</b></td>
			<td><sf:textarea path="content" size="200" cssStyle="width:350px;height:100px" 
			maxlength="200"/><br/></td>
			<sf:errors path="content" cssClass="error" />		
		</tr>
		<tr>
			<td><b>����</b></td>
			<td><input type="file" name="file"></td>
			<!-- <td><input type="file" path=${ boardData.getFilename()}></td>  -->
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0" border="0" width="500">
		<tr>
			<td><input type="submit" value="����" id="save"/>
				<input type="button" value="���" onclick="javascript:boardlist()" />
			</td>
		</tr>
	</table>
</sf:form>
</div>
</div>

<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>

</html>