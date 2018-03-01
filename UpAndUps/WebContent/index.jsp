<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
    <title>株式会社アップアンドアップス</title>
    <jsp:include page="/baselayout/head.html" />
</head>

	<body background="./images/005-Grunge-Paper.png">

		<!-- ヘッダー -->
		<div class="container" align="center">

			<script type="text/JavaScript">
				var img = new Array();
				img[0] = "./images/StPh01c.jpg";
				img[1] = "./images/StPh03c.jpg";
				img[2] = "./images/StPh04c.jpg";
				img[3] = "./images/StPh05c.jpg";
				img[4] = "./images/StPh06c.jpg";
				document.write('<img src="'+img[Math.floor(Math.random()*img.length)]+'" style="width:100%;" border="0">');
			</script>

			<noscript>
			   <img src="./images/StPh01c.jpg" alt="top画" width="100%">
			</noscript>
			<br>
			<br>

			<jsp:include page="/baselayout/header.jsp" />
		<!-- ヘッダーここまで -->

				<a class="twitter-timeline" width="400px" height="800px" data-chrome="transparent noheader" href="https://twitter.com/up_and_ups?ref_src=twsrc%5Etfw">Tweets by up_and_ups</a>
				<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

	</body>
</html>