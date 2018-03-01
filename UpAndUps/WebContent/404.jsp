<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
	<head>
	    <title>株式会社アップアンドアップス - 404エラー</title>
	    <jsp:include page="/baselayout/head.html" />
	</head>

	<body background="./images/005-Grunge-Paper.png">
		<!-- ヘッダー -->
		<div class="container" align="center">

			<jsp:include page="/baselayout/header.jsp" />
		<!-- ヘッダーここまで -->

			<br>
			<br>
			<img alt="" src="./images/404.png"><br>
			<br>
			<h5>ご指定のページが見つかりませんでした。</h5>
			<br>
			<a href="Index">ホーム画面</a>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

	</body>
</html>