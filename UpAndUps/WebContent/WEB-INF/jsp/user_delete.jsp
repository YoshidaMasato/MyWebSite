<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<p>ユーザ：${udb.name}</p>
					<p>を削除しますか？</p>
				</div>
				<div class="col-3 offset-3">
					<form action="User_delete" method="post">
						<input type="hidden" name="id" value="${udb.id}">
						<input type="submit" class="btn btn-danger" style="width: 80%" value="削除">
					</form>
				</div>
				<div class="col-3">
					<a href="User_list">
						<button type="button" class="btn btn-dark" style="width: 80%">キャンセル</button>
					</a>
				</div>
			</div>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

	</body>
</html>