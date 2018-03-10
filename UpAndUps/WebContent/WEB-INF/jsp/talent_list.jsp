<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
	<head>
	    <title>所属タレント</title>
	    <jsp:include page="/baselayout/head.html" />
	</head>

	<body background="./images/005-Grunge-Paper.png">
		<!-- ヘッダー -->
		<div class="container" align="center">
			<jsp:include page="/baselayout/header.jsp" />
		<!-- ヘッダーここまで -->

			<br>
			<br>
			<div class="lighter">
				<form action="Talent_list" method="post">
				    <span><input type="text" name="search_word" class="search rounded" placeholder="Search..."></span>
				</form>
			</div>
			<p class="text-secondary">*&nbsp名前の一部で検索できます&nbsp*</p>

			<hr>

			<div class="row">
				<c:forEach var="uddb" items="${uddbList}">
				    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
				        <p><a href="Talent_detail?id=${uddb.user_id}"><img alt="" src="./uploaded/${uddb.photo_url}" width="100px" height="167px"><br>${uddb.name}</a></p>
				    </div>
			    </c:forEach>

			</div>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />

		</div>

	</body>
</html>