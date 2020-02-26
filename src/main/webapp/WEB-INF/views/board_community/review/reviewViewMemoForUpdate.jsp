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

<script language="javascript">
	function boardlist(){
		location.href='reviewList.do?current_page=${current_page}';
	}
</script>
<title>����Խ��� ����</title>
</head>
<body>
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
<div id="line_div">
	<div id="sub_logo">
		<h2>QnA</h2>
    </div> 
 <div id="site_div">	

<c:url var="updateUrl" value="/review_update.do"/>
<sf:form modelAttribute="boardData" method="POST" action="${updateUrl}" enctype="multipart/form-data" id="form" >
	<table class="tlb_board">
		<input type="hidden" name="idx" value="${idx}">
		<input type="hidden" name="current_page" value="${current_page}">
		<tr>
			<td style="background-color: #f2f2f2"><b>����</b></td>
			<td style="float: left; margin-left: 10px;">
			<sf:input path="subject" size="50" maxlength="50" /><br /> 
			<sf:errors path="subject" cssClass="error" /></td>
		</tr>
		<tr>
			<td style="background-color: #f2f2f2"><b>���̵�</b></td>
			<td style="float: left; margin-left: 10px;">
			<sf:input readonly="true" path="id" 
						  size="50" maxlength="50" />
			<sf:errors path="id" cssClass="error" />			
			</td>
		</tr>
		<tr>
			<td style="background-color: #f2f2f2"><b>ī�װ�</b></td>
			<td style="float: left; margin-left: 10px;">
			<c:if test="${boardData.getDepth()==0}"> <!-- ����� �ƴ� �� ���� ����-->
				<sf:select path="review_case">
				<sf:option value="���ݸ���" label="���ݸ���"/>
				<sf:option value="���ݸ���" label="���ݸ���"/>
				<sf:option value="��Ÿ����" label="��Ÿ����"/>
				</sf:select>
				</c:if>
				<c:if test="${boardData.getDepth()==1}"> <!-- ����� �� -->
					[<c:out value="${boardData.getReview_case()}" />]
				
				</c:if>
			</td>
			
		</tr>
		<c:if test="${boardData.getDepth()==0}"> <!-- ����� �ƴ� �� ���� ����-->
		<tr>
			<td style="background-color: #f2f2f2"><b>�����</b></td>
			<td style="float: left; margin-left: 10px;">
			<sf:input path="banks" size="30" maxlength="30" value="${banks}"/>
				<sf:errors path="banks" cssClass="error"/></td>
		</tr>
		<tr>
			<td style="background-color: #f2f2f2"><b>��ǰ��</b></td>
			<td style="float: left; margin-left: 10px;">
			<sf:input path="re_productname" size="30" maxlength="30" value="${re_productname}"/>
				<sf:errors path="re_productname" cssClass="error"/></td>
		</tr>
		<tr>
			<td style="background-color: #f2f2f2"><b>������</b></td>
				<td style="float: left; margin-left: 10px;">
				<sf:select path="satisfaction">
				<sf:option value="�ڡڡڡڡ�  �ſ츸��" label="�ڡڡڡڡ�   �ſ츸��"/>
				<sf:option value="�ڡڡڡ�  ����" label="�ڡڡڡ�      ����"/>
				<sf:option value="�ڡڡ�  ����" label="�ڡڡ�         ����"/>
				<sf:option value="�ڡ�  �Ҹ���" label="�ڡ�		  �Ҹ���"/>
				<sf:option value="��  �ſ�Ҹ���" label="��		 �ſ�Ҹ���"/>
			</sf:select></td>
		</tr>
		</c:if>
		
		<tr>
			<td style="background-color: #f2f2f2"><b>����</b></td>
			<td><sf:textarea path="content" size="200"
					Style="width:550px;height:250px; margin-left: 10px;" maxlength="200" /><br /> 
				<sf:errors path="content" cssClass="error" /></td>
		</tr>
		
		<tr>
			<td style="background-color: #f2f2f2"><b>����</b></td>
			<td style="float: left; margin-left: 10px;">
			<input type="file" name="file"></td>
		</tr>
	</table>
		<div class="div_board_bnt">
				<input type="submit" value="����" id="save" class="bnt_view"/>
				<input type="button" value="���" onclick="javascript:boardlist()" class="bnt_view"/>
		</div>
</sf:form>
</div>
</div>
</div>
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</body>
</html>
