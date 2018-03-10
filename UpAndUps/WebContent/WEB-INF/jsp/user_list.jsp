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
		<!-- /ヘッダー -->
			<br>

			<!-- ログアウト -->
			<jsp:include page="/baselayout/logout.jsp" />
			<!-- /ログアウト -->

			<div class="lighter">
				<form action="user_list.html" method="post">
				    <span><input type="text" class="search rounded" placeholder="Search..."></span>
				</form>
			</div>
			<p class="text-secondary">*&nbsp名前の一部で検索できます&nbsp*</p>

			<hr>

			<div class="row">
			<div class="col-xl-8 offset-xl-2 col-lg-8 offset-lg-2 col-md-10 offset-md-1 col-sm-12 offset-sm-0 col-xs-12 offset-xs-0">
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">ログインID</th>
			      <th scope="col">名前</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="udb" items="${udbList}">
				    <tr>
				      <th scope="row">${udb.id}</th>
				      <td>${udb.login_id}</td>
				      <td>${udb.name}</td>
				      <td>
				        <a href="Talent_detail?id=${udb.id}"><button type="button" class="btn btn-outline-info">参照</button></a>
						<a href="User_update?id=${udb.id}"><button type="button" class="btn btn-outline-primary">更新</button></a>
						<a href="Voice_update?id=${udb.id}"><button type="button" class="btn btn-outline-secondary">Voice</button></a>
						<a href="User_delete?id=${udb.id}"><button type="button" class="btn btn-outline-danger">削除</button></a>
					  </td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			</div>
			</div>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

	</body>
</html>