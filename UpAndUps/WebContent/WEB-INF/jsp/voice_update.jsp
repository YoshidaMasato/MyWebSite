<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
	<head>
	    <title>所属タレント</title>
	    <jsp:include page="/baselayout/head.html" />
	    <link rel="stylesheet" href="css/mediaelementplayer.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
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

			<p><font color=red>${errMsg}</font></p>
			<!-- フォーム -->
			<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<form action="Voice_update" method="post" enctype="multipart/form-data">

					<!-- ボイスサンプル -->
					<div class="form-group row">
					  <div class="col-sm-8 offset-sm-2">
						  <div class="form-row">
						    <div class="col">
						      <input type="text" name="vsTitle" class="form-control" placeholder="タイトル">
						    </div>
						    <div class="col">
						      <div class="custom-file">
								  <input type="file" name="voicesample" class="custom-file-input" id="customFile">
								  <label class="custom-file-label" for="customFile"></label>
							  </div>
						    </div>
						  </div>
					  </div>
					</div>
					<input type="hidden" name="id" value="${id}">

					<!-- 送信ボタン -->
					<button type="submit" class="btn btn-secondary">追加</button>
				</form>

				<br>
				<br>

			</div>
			</div>
			<!-- /フォーム -->

			<!-- ボイスサンプル -->
			<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<table class="table">
				  <tbody>
				  	<c:forEach var="vsdb" items="${vsdbList}">
					    <tr>
					      <td style="background-color: #eee; width: 30%" class="text-center">${vsdb.title}</td>
					      <td>
					      	<div class="row">
								<div class="media-wrapper col-10">
									<audio id="player2" preload="none" controls style="max-width:100%;">
								        <source src="./uploaded/${vsdb.file_url}" type="audio/wav">
								    </audio>
								</div>
								<div class="col-2">
									<a href="Voice_delete?id=${vsdb.id}"><button type="button" class="btn btn-danger">削除</button></a>
								</div>
							</div>
						  </td>
					    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
			</div>
			<!-- /ボイスサンプル -->
			<br>
			<a href="User_list">戻る</a>

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

		<script src="js/mediaelement-and-player.js"></script>
		<script src="js/ja.js"></script>
		<script src="js/mediaelement.js"></script>
		<script>
			$('video, audio').mediaelementplayer({
				// Configuration
				success: function(media) {
					var isNative = /html5|native/i.test(media.rendererName);

					var isYoutube = ~media.rendererName.indexOf('youtube');

					// etc.
				}
			});
		</script>

	</body>
</html>