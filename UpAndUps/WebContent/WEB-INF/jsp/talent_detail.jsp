<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<table class="table">
				  <tbody>
				    <tr>
				      <th rowspan="10" class="thph"><img alt="" src="./uploaded/${uddb.photo_url}"></th>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">名　前</td>
				      <td>
				      	<ruby>
				      	${uddb.name}<rp>（</rp><rt>まつい&nbsp;なおこ</rt><rp>）</rp>
				      	</ruby>
				      </td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">誕生日</td>
				      <td>${uddb.birth_date_format}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">出身地</td>
				      <td>${uddb.prefectures_name}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">血液型</td>
				      <td>${uddb.blood_type}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">声　域</td>
				      <td>${uddb.vocal_range}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">特　技</td>
				      <td>${uddb.special_skill}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">趣　味</td>
				      <td>${uddb.hobby}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">免　許</td>
				      <td>${uddb.license}</td>
				    </tr>
				    <tr>
				      <td style="background-color: #eee">Twitter</td>
				      <td>
				        <a href="${uddb.twitter_url}"><img src="./images/tw.png" alt="tw" width="28" height="28" class="alignleft size-full wp-image-301">${uddb.twitter_id}</a>
				      </td>
				    </tr>
				  </tbody>
				</table>
			</div>
			</div>

			<br>

			<!-- ボイスサンプル -->
			<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<!-- 見出し -->
				<div class="alert alert-dark" role="alert">
				  <h3 style="margin: 0">ボイスサンプル</h3>
				</div>
				<table class="table">
				  <tbody>
				   <c:forEach var="vsdb" items="${vsdbList}">
					    <tr>
					      <td style="background-color: #eee; width: 30%" class="text-center">${vsdb.title}</td>
					      <td>
							<div class="media-wrapper">
								<audio id="player2" preload="none" controls style="max-width:100%;">
							        <source src="./uploaded/${vsdb.file_url}" type="audio/wav">
							    </audio>
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

			<!-- 主な出演作品 -->
			<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<!-- 見出し -->
				<div class="alert alert-dark" role="alert">
				  <h3 style="margin: 0">主な出演作品</h3>
				</div>

				<!-- タイトル -->
				<h4 class="text-left" style="margin-bottom: 0"><img alt="microphone" src="./images/microphone.png" style="width: 30px; margin-bottom: 10px">&nbsp;アニメ</h4>
				<hr style="margin-top: 0">
				<!-- /タイトル -->
				<ul class="text-left">
					${uddb.filmographies_anime}
				</ul>

				<br>

				<!-- タイトル -->
				<h4 class="text-left" style="margin-bottom: 0"><img alt="microphone" src="./images/microphone.png" style="width: 30px; margin-bottom: 10px">&nbsp;映画</h4>
				<hr style="margin-top: 0">
				<!-- /タイトル -->
				<ul class="text-left">
					<li>「ゴースト」デミ・ムーア</li>
					<li>「フレンチ・キス」メグ・ライアン</li>
				</ul>

				<br>

				<!-- タイトル -->
				<h4 class="text-left" style="margin-bottom: 0"><img alt="microphone" src="./images/microphone.png" style="width: 30px; margin-bottom: 10px">&nbsp;歌</h4>
				<hr style="margin-top: 0">
				<!-- /タイトル -->
				<ul class="text-left">
					<li>オリジナルアルバム「世界征服」、「道楽女王」</li>
				</ul>

			</div>
			</div>
			<!-- /主な出演作品 -->


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