<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.http.*"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.text.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page session="false"%>
<%@page import="com.ourbank.app.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.ourbank.app.PageNumberingManager"%>
<%@page import="com.ourbank.app.bean.BestBoard_Bean" %>

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
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html" ; charset="EUC-KR">
<title>Best�Խù� �۸��</title>
</head>

<!-- *********************** �Խ��� �۾��� �� ****************************  -->	
<jsp:include page="../../header.jsp"></jsp:include>
<!-- *********************** ���̵� �޴� ****************************  -->	
   <div id="body_div">
	<div id="side_menu">
		<h4><a href="/app/reviewList.do?current_page=1">Ŀ�´�Ƽ</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="/app/reviewList.do?current_page=1"> �� ��</a></li>
				<li>- <a href="/app/freeList.do?current_page=1"> �����Խ���</a></li>
				<li>- <a href="/app/meetingList.do?current_page=1"> ���ӹ�</a></li>
				<li>- <a href="/app/debateList.do?current_page=1"> ��й�</a></li>
				<li>- <a href="/app/investList.do?current_page=1"> ����ũ���Ͽ�</a></li>
				<li>- <a href="/app/bestList.do?current_page=1"> BEST�Խù�</a></li>
			</ul>
		</div>
	</div>
<!-- *********************** ���� ****************************  -->
<c:set var="current_page" value="${current_page}" />

<%
	int c_page = Integer.parseInt((String) (pageContext.getAttribute("current_page")));
	pageContext.setAttribute("c_page", c_page);
	
	HttpSession session=request.getSession();
	String id=(String) session.getAttribute("id");
%>
<c:set var="id" value="<%=id%>"/>
<script type="text/javascript">
	//����Ʈ _ ����ũ ���� �� 
	function boardView_idCheck() {
		var loginUser = "${id}";
		if(!loginUser) {
			alert('�α��� �� �̿� �����մϴ�.');
			return location.href = "loginForm.do";		
		}else{
		
		}
	}
</script>

<div id="line_div">
 <div id="sub_logo">
<h2>BEST�Խù�</h2>	
 </div> 
 <div id="site_div">	

<div style="margin-top: 50px; font-weight: bold;">
<table cellspacing=1 width=700 >
	<tr>
		<td><p align="right">
				������:
				<c:out value="${current_page}" />
			</td>
	</tr>
</table>
</div>
<table cellspacing=1 >
	<thead>
	<tr>
		<td width="50" class="tlb_board_top">�۹�ȣ</td>
		<td width="320" class="tlb_board_top">����</td>
		<td width="100" class="tlb_board_top">���̵�</td>
		<td width="100" class="tlb_board_top">�����</td>
		<td width="100" class="tlb_board_top">��ȸ��</td>
	</tr> </thead>
	<tbody>

	<c:set var="count" value="0" />
	 <c:forEach var="board" items="${boardList}">
	   <c:set var="count" value="${count+1}"/>

		<tr class="tlb_board_bottom">
			<td width="50">${count}</td>
			<td width="320">
				
					<!-- �α��� o -->
					<c:if test="${id != null }"> <!--   (���� ${id != null }�ιٲٱ�!!-->
					<a href="bestView.do?best_idx=${board.getBest_idx()}&current_page=<c:out value="${current_page}"/>
						&category_num=<c:out value="${board.getCategory_num() }"/>"
						title="${board.getContent()}"> <c:out value="  ${board.getSubject()}" /></a>
					</c:if>
						
					<!-- �α��� x -->
					<c:if test="${id ==null}">
					<a onclick="boardView_idCheck(this.href);return false;" onkeypress="this.onclick;"
						href="bestView.do" > <c:out value="${board.getSubject()}" /></a>
					</c:if>
				
			</td>
			<td width="100">
				<c:out value="${board.getId()}"/>
				</td>
			<td width="100">
					<c:out value="${board.getCreated_date()}" />
				</td>
			<td width="100">
					<c:out value="${board.getHits()}" />
				</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>

	<%
		int rowsPerPage = 10;
		//best�Խù� �ִ�20��
		int total_pages = PageNumberingManager.getInstance().getTotalPage(20, rowsPerPage);
		pageContext.setAttribute("t_pages", total_pages); 
	%>
<div style="margin-top: 50px; font-weight: bold;">
<table cellspacing="1" width="700" class="page">
	<tr>
		<td><c:forEach var="i" begin="1" end="${t_pages}">
				<a href="bestList.do?current_page=${i}"> [ <c:if
						test="${i==c_page}">
						<b>
					</c:if> ${i} <c:if test="${i==c_page}">
						<b>
					</c:if> ]
				</a>
			</c:forEach></td>
	</tr>
</table>
</div>
</div>
</div>
</div>

<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
</html>