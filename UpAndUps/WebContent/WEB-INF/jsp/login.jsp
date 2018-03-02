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
			<form action="Login" method="post">
				<div class="row">
					<div class="col-4 offset-4">
					  <div class="form-group">
					    <label for="InputLoginId">ログインID</label>
					    <input type="text" class="form-control" name="InputLoginId" placeholder="">
					  </div>
					  <div class="form-group">
					    <label for="InputPassword">パスワード</label>
					    <input type="password" class="form-control" name="InputPassword" placeholder="">
					  </div>
					  <br>
					  <p><font color=red>${errMsg}</font></p>
					  <button type="submit" class="btn btn-secondary">ログイン</button>
					  <br>
					  <br>
					  <a href="User_create">新規登録</a>
					</div>
				</div>
			</form>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />

		</div>

	</body>
</html>