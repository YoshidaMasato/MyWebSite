<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
	<head>
	    <link rel="stylesheet" href="css/mediaelementplayer.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
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

			<!-- フォーム -->
			<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<form action="voice_update.html" method="post">

					<!-- ボイスサンプル -->
					<div class="form-group row">
					  <div class="col-sm-8 offset-sm-2">
						  <div class="form-row">
						    <div class="col">
						      <input type="text" class="form-control" placeholder="タイトル">
						    </div>
						    <div class="col">
						      <div class="custom-file">
								  <input type="file" class="custom-file-input" id="customFile">
								  <label class="custom-file-label" for="customFile"></label>
							  </div>
						    </div>
						  </div>
					  </div>
					</div>

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
				    <tr>
				      <td style="background-color: #eee">自己紹介</td>
				      <td>
				      	<div class="row">
							<div class="media-wrapper col-10">
								<audio id="player2" preload="none" controls style="max-width:100%;">
							        <source src="http://www.largesound.com/ashborytour/sound/AshboryBYU.mp3" type="audio/mp3">
							    </audio>
							</div>
							<div class="col-2">
								<a href="voice_delete.html"><button type="button" class="btn btn-danger">削除</button></a>
							</div>
						</div>
					  </td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">ナレーションサンプル1</td>
				      <td>
				      	<div class="row">
							<div class="media-wrapper col-10">
								<audio id="player2" preload="none" controls style="max-width:100%;">
							        <source src="http://www.largesound.com/ashborytour/sound/AshboryBYU.mp3" type="audio/mp3">
							    </audio>
							</div>
							<div class="col-2">
								<a href="voice_delete.html"><button type="button" class="btn btn-danger">削除</button></a>
							</div>
						</div>
					  </td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">テレビナレーション</td>
				      <td>
				      	<div class="row">
							<div class="media-wrapper col-10">
								<audio id="player2" preload="none" controls style="max-width:100%;">
							        <source src="http://www.largesound.com/ashborytour/sound/AshboryBYU.mp3" type="audio/mp3">
							    </audio>
							</div>
							<div class="col-2">
								<a href="voice_delete.html"><button type="button" class="btn btn-danger">削除</button></a>
							</div>
						</div>
					  </td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">ラジオCM</td>
				      <td>
				      	<div class="row">
							<div class="media-wrapper col-10">
								<audio id="player2" preload="none" controls style="max-width:100%;">
							        <source src="http://www.largesound.com/ashborytour/sound/AshboryBYU.mp3" type="audio/mp3">
							    </audio>
							</div>
							<div class="col-2">
								<a href="voice_delete.html"><button type="button" class="btn btn-danger">削除</button></a>
							</div>
						</div>
					  </td>
				    </tr>
				  </tbody>
				</table>
			</div>
			</div>
			<!-- /ボイスサンプル -->

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