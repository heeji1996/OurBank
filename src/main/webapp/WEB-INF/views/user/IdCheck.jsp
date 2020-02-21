<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product.css" >
<title>ID �ߺ�üũ</title>

<script type="text/javascript">
function reject(){
	opener.document.getElementById("id").value="";
}
function id_reCheck(){
	var id=document.getElementById("id").value;
	if(id==""){
		alert("���̵� �Է��� �ּ���");
	}else{
		url="idCheck.do?id="+id;
		location.href=url;
	}
}
function useId(){
	opener.document.getElementById("id").value=document.getElementById("changed_id").value;
	opener.document.getElementById("id_check").value=1;
	self.close();
}
</script>
</head>
<body onload="reject()">
<c:set var="check" value="${check}" />
<c:set var="id" value="${id}"/>

	<div id="idcheck_form" >
	<c:choose>
		<c:when test="${check}">
		<div>
		<div class="border">
			<input id="changed_id" type="hidden" value="${id}">
			<b>${id}</b> �� ��� ���� �մϴ�.<p>
			<input class="button" type="button" value="ID����ϱ�" onclick="useId()"><p>
		</div>
			<a href="#" onclick="self.close();">�ݱ�</a>
		</div>
		</c:when>
		<c:otherwise >
		<div >
		<div class="border">
			<b>${id}</b> �� �̹� �����ϴ� ID �Դϴ�.<p>
			<sf:input id="id" path="id"  maxlength="50" placeholder="���̵� �Է����ּ���"></sf:input>
			<input class="button" type="button" value="�ߺ�Ȯ��" onclick="id_reCheck()" >
		</div>	
		</div>
		</c:otherwise>
	</c:choose>
	<p>
	
</div>
</body>
</html>