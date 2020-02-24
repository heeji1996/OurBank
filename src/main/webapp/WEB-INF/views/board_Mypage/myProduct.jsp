<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.http.*"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
<!-- JQouery -->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/product.css">


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>My Page</title>
<script type="text/javascript">
	function chageLangSelect() {
		var bankSelect = document.getElementById("pro_bank");
		// select element���� ���õ� option�� value�� ����ȴ�.
		var selectValue = bankSelect.options[bankSelect.selectedIndex].value;
		//���ڵ���
		var en_bank = encodeURIComponent(selectValue);

		location.href = "depositByBank.do?current_page=" + $
		{
			current_page
		}
		+"&bank=" + en_bank;

	}
	$(function() {
		$( "#accordion" ).accordion({

			  active: false,

			  collapsible: true

			  });

	});
	jQuery( document ).ready( function() {
        $( 'h3' ).width( '750px' );
        $( '.div_dp' ).width( '700px' );
      } );
	

</script>
</head>
<body>
	<!-- *********************** �Խ��� �۾��� �� ****************************  -->
	<jsp:include page="../header.jsp"></jsp:include>

	<!-- *********************** ���̵� �޴� ****************************  -->

	<div id="side_menu">
		<h4>
			<a href="#">My Page</a>
		</h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="#"> ������������ </a></li>
				<li>- <a href="#"> ���� �ۼ��� �� </a></li>
				<li>- <a href="#"> ������ ��ǰ ��ȸ </a></li>
				<li>- <a href="#"> ���ɻ�ǰ </a></li>
			</ul>
		</div>
	</div>

	<!-- *********************** ���� ****************************  -->
	<div id="my_product">
	<div class="btn-group">
				<button class="button">����</button>
				<button class="button">����</button>
			</div>
		<div class="main">
			<h2>�߰� ���� ���</h2>
			<p>
			<form method="post" action="myProduct.do">
			<input type="submit" >
			<div class="wrap">
				<div id="accordion">
				<c:forEach var="deposit_bean" items="${de_bank_bean}">
						<h3>${deposit_bean.getKor_co_nm()}&nbsp;&nbsp;</h3>
						<div class="div_dp">
							<c:forEach var="deposit_product" items="${de_product_bean}">
								<!-- �������� ���� -->
								<c:set var="dp_bk" value="${deposit_bean.getKor_co_nm()}" />
								<c:set var="dp_pd_bk" value="${deposit_product.getKor_co_nm()}" />
								<c:if test="${dp_bk==dp_pd_bk}">
								
								<input id="pdt_nm" type="checkbox" name="fin_prdt_cd"
										value="${deposit_product.getFin_prdt_cd()}"
										onselect="inject_info()"></input>
										${deposit_product.getFin_prdt_nm()}&nbsp;&nbsp;	
								</c:if>
							</c:forEach>
						</div>
				</c:forEach>
				</div>
			</div>
			</form>
		</div>
	</div>
	<!-- *********************** �Խ��� �۾��� �� ****************************  -->

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>