<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
	<head>
	    <title>お問い合わせ</title>
	    <jsp:include page="/baselayout/head.html" />
	</head>

	<body background="./images/005-Grunge-Paper.png">
		<!-- ヘッダー -->
		<div class="container" align="center">

			<jsp:include page="/baselayout/header.jsp" />
		<!-- ヘッダーここまで -->

			<br>
			<div class="text-left">
				<form action="send_success.html" method="post">
					<div class="form-group">
					  <label for="exampleFormControlInput1">お名前（必須）</label>
					  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="">
					</div>
					<br>
					<div class="form-group">
					  <label for="exampleFormControlInput1">メールアドレス（必須）</label>
					  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
					</div>
					<br>
					<div class="form-group">
					  <label for="exampleFormControlInput1">件名（必須）</label>
					  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="">
					</div>
					<br>
					<div class="form-group">
					  <label for="exampleFormControlTextarea1">メッセージ本文（必須）</label>
					  <textarea class="form-control" id="exampleFormControlTextarea1" rows="8"></textarea>
					</div>
					<button type="submit" class="btn btn-secondary">送信</button>
				</form>
			</div>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />

		</div>

	</body>
</html>