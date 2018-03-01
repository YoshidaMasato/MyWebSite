<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
	<head>
	    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	    <script src="https://cdn.jsdelivr.net/npm/gijgo@1.8.1/combined/js/gijgo.min.js" type="text/javascript"></script>
	    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.8.1/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
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
				<form action="user_list.html" method="post">

					<!-- ログインID -->
					<div class="form-group row">
					  <label for="loginId" class="col-sm-4 col-form-label">ログインID</label>
					  <div class="col-sm-8">
					    <input type="text" readonly class="form-control-plaintext" id="loginId" value="matsui_naoko">
					  </div>
					</div>

					<!-- パスワード -->
					<div class="form-group row">
					  <label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
					  <div class="col-sm-8">
					    <input type="password" class="form-control" id="inputPassword" placeholder="">
					  </div>
					</div>

					<!-- パスワード(確認) -->
					<div class="form-group row">
					  <label for="inputPassword" class="col-sm-4 col-form-label">パスワード(確認)</label>
					  <div class="col-sm-8">
					    <input type="password" class="form-control" id="inputPassword" placeholder="">
					  </div>
					</div>

					<!-- 名前 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">名前</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" id="inputName" value="松井 菜桜子">
					  </div>
					</div>

					<!-- 性別 -->
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">性別</label>
						<div class="col-sm-8 text-left">
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="sex1" value="option1">
							  <label class="form-check-label" for="inlineRadio1">男</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="sex2" value="option2" checked="checked">
							  <label class="form-check-label" for="inlineRadio2">女</label>
							</div>
						</div>
					</div>

					<!-- 宣材写真 -->
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">宣材写真</label>
						<div class="col-sm-8 text-left">
							<div class="custom-file">
							  <input type="file" class="custom-file-input" id="customFile">
							  <label class="custom-file-label" for="customFile">size 300x500</label>
							</div>
						</div>
					</div>

					<!-- 所属形態 -->
					<div class="form-group row">
						<label for="inputAttribute" class="col-sm-4 col-form-label">所属形態</label>
						<div class="col-sm-8 text-left">
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="sex" id="inlineRadio1" value="option1" checked="checked">
							  <label class="form-check-label" for="inlineRadio1">所属</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="sex" id="inlineRadio2" value="option2">
							  <label class="form-check-label" for="inlineRadio2">準所属</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="sex" id="inlineRadio3" value="option3">
							  <label class="form-check-label" for="inlineRadio3">預かり所属</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="sex" id="inlineRadio4" value="option4">
							  <label class="form-check-label" for="inlineRadio4">新人</label>
							</div>
						</div>
					</div>

					<!-- 生年月日 -->
					<div class="form-group row" id="datepicker-default">
					  <label for="inputName" class="col-sm-4 col-form-label">生年月日</label>
					  <div class="col-sm-8 text-left form-inline">
					    <input type="date" width="276" />
					  </div>
					</div>

					<!-- 出身地 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">出身地</label>
					    <div class="col-sm-8 text-left">
							<select class="form-control">
								<option>選択してください</option>
								<optgroup label="--- 都道府県 ---">
									<option value="北海道">北海道</option>
									<option value="青森県">青森県</option>
									<option value="岩手県">岩手県</option>
									<option value="宮城県">宮城県</option>
									<option value="秋田県">秋田県</option>
									<option value="山形県">山形県</option>
									<option value="福島県">福島県</option>
									<option value="茨城県">茨城県</option>
									<option value="栃木県">栃木県</option>
									<option value="群馬県">群馬県</option>
									<option value="埼玉県">埼玉県</option>
									<option value="千葉県">千葉県</option>
									<option value="東京都">東京都</option>
									<option value="神奈川県">神奈川県</option>
									<option value="新潟県">新潟県</option>
									<option value="富山県">富山県</option>
									<option value="石川県">石川県</option>
									<option value="福井県">福井県</option>
									<option value="山梨県">山梨県</option>
									<option value="長野県">長野県</option>
									<option value="岐阜県">岐阜県</option>
									<option value="静岡県">静岡県</option>
									<option value="愛知県">愛知県</option>
									<option value="三重県">三重県</option>
									<option value="滋賀県">滋賀県</option>
									<option value="京都府">京都府</option>
									<option value="大阪府">大阪府</option>
									<option value="兵庫県">兵庫県</option>
									<option value="奈良県">奈良県</option>
									<option value="和歌山県">和歌山県</option>
									<option value="鳥取県">鳥取県</option>
									<option value="島根県">島根県</option>
									<option value="岡山県">岡山県</option>
									<option value="広島県">広島県</option>
									<option value="山口県">山口県</option>
									<option value="徳島県">徳島県</option>
									<option value="香川県">香川県</option>
									<option value="愛媛県">愛媛県</option>
									<option value="高知県">高知県</option>
									<option value="福岡県">福岡県</option>
									<option value="佐賀県">佐賀県</option>
									<option value="長崎県">長崎県</option>
									<option value="熊本県">熊本県</option>
									<option value="大分県">大分県</option>
									<option value="宮崎県">宮崎県</option>
									<option value="鹿児島県">鹿児島県</option>
									<option value="沖縄県">沖縄県</option>
								</optgroup>
							</select>
						</div>
					</div>

					<!-- 血液型 -->
					<div class="form-group row">
						<label for="inputAttribute" class="col-sm-4 col-form-label">血液型</label>
						<div class="col-sm-8 text-left">
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="bloodtype" id="inlineRadio1" value="option1" checked="checked">
							  <label class="form-check-label" for="inlineRadio1">A型</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="bloodtype" id="inlineRadio2" value="option2">
							  <label class="form-check-label" for="inlineRadio2">B型</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="bloodtype" id="inlineRadio3" value="option3">
							  <label class="form-check-label" for="inlineRadio3">O型</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="bloodtype" id="inlineRadio4" value="option4">
							  <label class="form-check-label" for="inlineRadio4">AB型</label>
							</div>
						</div>
					</div>

					<!-- 声域 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">声域</label>
					    <div class="col-sm-8 text-left">
							<select class="form-control">
							  <option>選択してください</option>
							  <optgroup label="--- 女声 ---">
								  <option>ソプラノ</option>
								  <option>メゾソプラノ</option>
								  <option>アルト</option>
							  </optgroup>
							  <optgroup label="--- 男声 ---">
								  <option>ソプラニスタ</option>
								  <option>カウンターテノール</option>
								  <option>テノール</option>
								  <option>バリトン</option>
								  <option>バス</option>
							  </optgroup>
							  <optgroup label="--- 少年 ---">
								  <option>ボーイソプラノ</option>
							  </optgroup>
							</select>
						</div>
					</div>

					<!-- 特技 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">特技</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" id="inputSkill" value="歌唱・謎解き">
					  </div>
					</div>

					<!-- 趣味 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">趣味</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" id="inputSkill" value="料理・油絵">
					  </div>
					</div>

					<!-- 免許 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">免許</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" id="inputSkill" value="特になし">
					  </div>
					</div>

					<!-- Twitter -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">Twitter</label>
					  <div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <input type="text" class="form-control" placeholder="URL">
						    </div>
						    <div class="col">
						      <input type="text" class="form-control" placeholder="@user_name">
						    </div>
						  </div>
					  </div>
					</div>

					<!-- 主な出演作品 -->
					<div class="form-group row">
						<label for="inputName" class="col-sm-4 col-form-label">主な出演作品</label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="inputState">アニメ</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
						    </div>
					      </div>
					    </div>
				    </div>
				    <div class="form-group row">
						<label for="inputName" class="col-sm-4 col-form-label"></label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="inputState">映画</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
						    </div>
					      </div>
					    </div>
				    </div>
				    <div class="form-group row">
						<label for="inputName" class="col-sm-4 col-form-label"></label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="inputState">ナレーション</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
						    </div>
					      </div>
					    </div>
				    </div>
				    <div class="form-group row">
						<label for="inputName" class="col-sm-4 col-form-label"></label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="inputState">その他</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
						    </div>
					      </div>
					    </div>
				    </div>

					<br>
					<!-- 送信ボタン -->
					<button type="submit" class="btn btn-secondary">送信</button>
				</form>
			</div>
			</div>
			<!-- /フォーム -->

			<!-- フッター -->
			<jsp:include page="/baselayout/footer.jsp" />
		</div>

		<script>
		  $('#datepicker').datepicker({
	            uiLibrary: 'bootstrap4'
	        });
		</script>
	</body>
</html>