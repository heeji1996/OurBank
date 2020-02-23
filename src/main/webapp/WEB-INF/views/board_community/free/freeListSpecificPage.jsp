<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.http.*"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.text.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page session="false"%>
<%@page import="com.ourbank.app.bean.FreeBoard_Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.ourbank.app.PageNumberingManager"%>

<html>
<head>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Noto+Sans+KR&display=swap" rel="stylesheet">

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >

<meta http-equiv="Content-Type" content="text/html" ; charset="EUC-KR">
<title>free</title>
<script>
function totallist(){
	location.href='freeList.do?current_page=1';
}
function signuplist(){
	location.href='freeSignUpList.do?current_page=1';
}
function savingslist(){
	location.href='freeSavingsList.do?current_page=1';
}
function etclist(){
	location.href='freeEtcList.do?current_page=1';
}
</script>
</head>
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** ���̵� �޴� ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">Ŀ�´�Ƽ</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="reviewList.do?current_page=1"> ����Խ��� </a></li>
				<li>- <a href="freeList.do?current_page=1"> �����Խ��� </a></li>
				<li>- <a href="meetList.do?current_page=1"> ���ӹ� </a></li>
				<li>- <a href="debateList.do?current_page=1"> ��й� </a></li>
				<li>- <a href="investList.do?current_page=1"> ����ũ ���Ͽ� </a></li>
				<li>- <a href="#"> BEST �Խù� </a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** ���� ****************************  -->
<div>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/body.css" >
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/h_script.js"></script>
<meta http-equiv="Content-Type" content="text/html" ; charset="EUC-KR">
<title>�����Խ��� �۸��</title>
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
<c:set var="total_cnt" value="${totalCnt}" />
<%
	int c_page = Integer.parseInt((String) (pageContext.getAttribute("current_page")));
	pageContext.setAttribute("c_page", c_page);

%>
<table width="700">
	<tr>
		<td>
				<div style="float: left; width: 40%; padding:10px;" >
					<button type="button" onclick="javascript:totallist()">��ü</button>
					<button type="button" onclick="javascript:signuplist()">�����λ�</button>
					<button type="button" onclick="javascript:savingslist()">�ñ��ؿ�</button>
					<button type="button" onclick="javascript:etclist()">��Ÿ</button>
				</div>
				<div style="float: right; width: 50%; vertical-align: center">
					<form name=searchf method=post action="freeSearch.do">
						<input type="text" name="searchStr" size="30" maxlenght="50">
						<input type="submit" value="��ã��">
					</form>
				</div>
		
		</td>
	</tr>
</table>
<table cellspacing=1 width=700 border=0>

	
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
<h2>�����Խ���</h2>	
  </div> 
 <div id="site_div">	

	<div class="comunity_top_menu" >
	<div style="float: right; width: 50%; vertical-align: center">
					<form name=searchf method=post action="freeSearch.do" id="searchf">
						<input type="text" name="searchStr" size="30" maxlenght="50">
						<input type="submit" value="��ã��">
					</form>
		</div>
	</div>
<div style="margin-top: 50px; font-weight: bold;">
<table cellspacing=1 width=700>

	<tr>
		<td>�� �Խù���: <c:out value="${totalCnt}" /></td>
		<td><p align="right">
				������:
				<c:out value="${current_page}" />

			</p></td>
	</tr>

</table>

<table cellspacing=1 width=700 border=1>
	<tr>
		<td width="50"><p align="center">��ȣ</td>
		<td width="100"><p align="center">���̵�</td>
		<td width="320"><p align="center">����</td>
		<td width="100"><p align="center">�����</td>
		<td width="100"><p align="center">��ȸ��</td>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td width="40"><p align="center">${board.getIdx()}</p></td>
			<td width="100"><p align="center">${board.getId()}</p></td>
			<td width="320">
				<p align="center">
					<a
						href="freeView.do?idx=${board.getIdx()}
							&current_page=<c:out value="${current_page}"/>
							&searchStr=None"
						title="${board.getContent()}"> <c:out
							value="${board.getSubject()}" /></a>
				</p>
			</td>
			<td width="100"><p align="center">
					<c:out value="${board.getCreated_date()}" />
				</p></td>
			<td width="100"><p align="center">
					<c:out value="${board.getHits()}" />
				</p></td>
		</tr>
	</c:forEach>

			</td>
	</tr>

</table>
</div>

<table cellspacing=1 width=700 >
	<thead>
	<tr>
		<td width="50" class="tlb_board_top">�۹�ȣ</td>
		<td width="320" class="tlb_board_top">����</td>
		<td width="100" class="tlb_board_top">���̵�</td>
		<td width="100" class="tlb_board_top">�����</td>
		<td width="100" class="tlb_board_top">��ȸ��</td>
	</tr> </thead>
	<tbody>
	<c:forEach var="board" items="${boardList}">
		<tr class="tlb_board_bottom">
			<td width="50">${board.getIdx_num()}</td>
			<td width="320">
				
					<!-- �α��� o -->
					<c:if test="${id == null }"> <!--   (���� ${id != null }�ιٲٱ�!!-->
					<a href="freeView.do?idx_num=${board.getIdx_num()}&current_page=<c:out value="${current_page}"/>&searchStr=None"
						title="${board.getContent()}" > <c:out value="${board.getSubject()}" /></a>
					</c:if>
						
					<!-- �α��� x -->
					<c:if test="${id !=null}">
					<a onclick="boardView_idCheck(this.href);return false;" onkeypress="this.onclick;"
						href="freeView.do" > <c:out value="${board.getSubject()}" /></a>
					</c:if>
				
			</td>
			<td width="100">
				<c:out value="${board.getId() }"/>
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
		int total_cnt = ((Integer) (pageContext.getAttribute("total_cnt"))).intValue();

		int total_pages = PageNumberingManager.getInstance().getTotalPage(total_cnt, rowsPerPage);
		pageContext.setAttribute("t_pages", total_pages);
	%>

</table>
<table cellspacing="1" width="700" border="1">


<div style="margin-top: 50px; font-weight: bold;">
<table cellspacing="1" width="700" class="page">

	<tr>
		<td><c:forEach var="i" begin="1" end="${t_pages}">
				<a href="freeList.do?current_page=${i}"> [ <c:if
						test="${i==c_page}">
						<b>
					</c:if> ${i} <c:if test="${i==c_page}">
						<b>
					</c:if> ]
				</a>
			</c:forEach></td>
	</tr>
</table>

<%-- <c:if test="sessionID�� admin�̸�"> --%> 
<table cellspacing="1" width="700">
	<tr>
		<td><input type="button" value="�۾���"
			onclick="window.location='free_show_write_form.do'"></td>
	</tr>
</table>
<%-- </c:if> --%>
</div>	
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
</html>

</div>

<!-- �α��� �� �� �� '�۾���' �� �� (���� ${id != null }�ιٲٱ�!! -->
<c:if test="${id==null}">
	<div>
			<input type="button" value="�۾���" class="bnt_comu"
			onclick="window.location='free_show_write_fome.do'"></td>
	</div>
</c:if>
</div>
</div>
</div>
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
</html>

