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
		<!-- ヘッダーここまで -->

			<br>
			<br>
			<form action="user_list.html">
			<div class="row">
				<div class="col-4 offset-4">
				  <div class="form-group">
				    <label for="InputLoginId">ログインID</label>
				    <input type="text" class="form-control" id="InputLoginId" placeholder="">
				  </div>
				  <div class="form-group">
				    <label for="InputPassword">パスワード</label>
				    <input type="password" class="form-control" id="InputPassword" placeholder="">
				  </div>
				  <br>
				  <button type="submit" class="btn btn-secondary">ログイン</button>
				  <br>
				  <br>
				  <a href="user_create.html">新規登録</a>
				</div>
			</div>
			</form>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />

		</div>

	</body>
</html>