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

			<div class="row">
				<div class="col-12">
					<p>${vsdb.title}</p>
					<p>を削除しますか？</p>
				</div>
				<div class="col-3 offset-3">
					<form action="Voice_delete" method="post">
						<input type="hidden" name="id" value="${vsdb.id}">
						<input type="hidden" name="user_id" value="${vsdb.user_id}">
						<input type="submit" class="btn btn-danger" style="width: 80%" value="削除">
					</form>
				</div>
				<div class="col-3">
					<a href="Voice_update?id=${vsdb.user_id}">
						<button type="button" class="btn btn-dark" style="width: 80%">キャンセル</button>
					</a>
				</div>
			</div>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

	</body>
</html>