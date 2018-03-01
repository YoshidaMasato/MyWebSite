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
			<div class="lighter">
				<form action="talent_list.html" method="post">
				    <span><input type="text" class="search rounded" placeholder="Search..."></span>
				</form>
			</div>
			<p class="text-secondary">*&nbsp名前の一部で検索できます&nbsp*</p>

			<hr>

			<div class="row">
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/matsui_naoko-300x500.jpg" width="100px" height="167px"><br>松井 菜桜子</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/arisawa_mutsuki-300x500.jpg" width="100px" height="167px"><br>有澤 睦生</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/ushiki_masato.jpg" width="100px" height="167px"><br>牛木 理人</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/ookubo_chika-300x500.jpg" width="100px" height="167px"><br>大久保 ちか</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/oonami_yoshihito-300x500.jpg" width="100px" height="167px"><br>大浪 嘉仁</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/matsui_naoko-300x500.jpg" width="100px" height="167px"><br>松井 菜桜子</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/arisawa_mutsuki-300x500.jpg" width="100px" height="167px"><br>有澤 睦生</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/ushiki_masato.jpg" width="100px" height="167px"><br>牛木 理人</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/ookubo_chika-300x500.jpg" width="100px" height="167px"><br>大久保 ちか</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/oonami_yoshihito-300x500.jpg" width="100px" height="167px"><br>大浪 嘉仁</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/matsui_naoko-300x500.jpg" width="100px" height="167px"><br>松井 菜桜子</a></p>
			    </div>
			    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2 text-center">
			        <p><a href="talent_detail.html"><img alt="" src="./images/arisawa_mutsuki-300x500.jpg" width="100px" height="167px"><br>有澤 睦生</a></p>
			    </div>

			</div>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />

		</div>

	</body>
</html>