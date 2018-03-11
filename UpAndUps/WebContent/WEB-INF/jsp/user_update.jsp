<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
	<head>
		<jsp:include page="/baselayout/head.html" />
	    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	    <script src="https://cdn.jsdelivr.net/npm/gijgo@1.8.1/combined/js/gijgo.min.js" type="text/javascript"></script>
	    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.8.1/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	    <title>所属タレント</title>
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
				<form action="User_update" method="post" enctype="multipart/form-data">
					<!-- ログインID -->
					<div class="form-group row">
					  <label for="loginId" class="col-sm-4 col-form-label">ログインID</label>
					  <div class="col-sm-8">
					    <input type="text" readonly class="form-control-plaintext" name="loginId" value="${uddb.login_id}">
					  </div>
					</div>

					<!-- パスワード -->
					<div class="form-group row">
					  <label for="password" class="col-sm-4 col-form-label">パスワード</label>
					  <div class="col-sm-8">
					    <input type="password" class="form-control" name="password" placeholder="">
					  </div>
					</div>

					<!-- パスワード(確認) -->
					<div class="form-group row">
					  <label for="passwordCheck" class="col-sm-4 col-form-label">パスワード(確認)</label>
					  <div class="col-sm-8">
					    <input type="password" class="form-control" name="passwordCheck" placeholder="">
					  </div>
					</div>

					<!-- 名前 -->
					<div class="form-group row">
					  <label for="name" class="col-sm-4 col-form-label">名前</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" name="name" value="${uddb.name}">
					  </div>
					</div>

					<!-- 性別 -->
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">性別</label>
						<div class="col-sm-8 text-left">
							<c:if test="${uddb.sex == '男'}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="sex" id="sex1" value="男" checked="checked">
								  <label class="form-check-label" for="sex1">男</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="sex" id="sex2" value="女">
								  <label class="form-check-label" for="inlineRadio2">女</label>
								</div>
							</c:if>
							<c:if test="${uddb.sex == '女'}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="sex" id="sex1" value="男">
								  <label class="form-check-label" for="sex1">男</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="sex" id="sex2" value="女" checked="checked">
								  <label class="form-check-label" for="sex2">女</label>
								</div>
							</c:if>
						</div>
					</div>

					<!-- 宣材写真 -->
					<div class="form-group row">
						<label for="photo" class="col-sm-4 col-form-label">宣材写真</label>
						<div class="col-sm-8 text-left">
							<div class="custom-file">
							  <input type="file" name="photo" class="custom-file-input" id="customFile">
							  <label class="custom-file-label" for="customFile">size 300x500</label>
							</div>
						</div>
					</div>

					<!-- 所属形態 -->
					<div class="form-group row">
						<label for="inputAttribute" class="col-sm-4 col-form-label">所属形態</label>
						<div class="col-sm-8 text-left">
							<c:if test="${uddb.affiliation_form == '所属'}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio1" value="所属" checked="checked">
								  <label class="form-check-label" for="inlineRadio1">所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio2" value="準所属">
								  <label class="form-check-label" for="inlineRadio2">準所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio3" value="預かり所属">
								  <label class="form-check-label" for="inlineRadio3">預かり所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio4" value="新人">
								  <label class="form-check-label" for="inlineRadio4">新人</label>
								</div>
							</c:if>
							<c:if test="${uddb.affiliation_form == '準所属'}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio1" value="所属">
								  <label class="form-check-label" for="inlineRadio1">所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio2" value="準所属" checked="checked">
								  <label class="form-check-label" for="inlineRadio2">準所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio3" value="預かり所属">
								  <label class="form-check-label" for="inlineRadio3">預かり所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio4" value="新人">
								  <label class="form-check-label" for="inlineRadio4">新人</label>
								</div>
							</c:if>
							<c:if test="${uddb.affiliation_form == '預かり所属'}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio1" value="所属">
								  <label class="form-check-label" for="inlineRadio1">所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio2" value="準所属">
								  <label class="form-check-label" for="inlineRadio2">準所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="sex" id="inlineRadio3" value="預かり所属" checked="checked">
								  <label class="form-check-label" for="inlineRadio3">預かり所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio4" value="新人">
								  <label class="form-check-label" for="inlineRadio4">新人</label>
								</div>
							</c:if>
							<c:if test="${uddb.affiliation_form == '新人'}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio1" value="所属">
								  <label class="form-check-label" for="inlineRadio1">所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio2" value="準所属">
								  <label class="form-check-label" for="inlineRadio2">準所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio3" value="預かり所属">
								  <label class="form-check-label" for="inlineRadio3">預かり所属</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="affiliation_form" id="inlineRadio4" value="新人" checked="checked">
								  <label class="form-check-label" for="inlineRadio4">新人</label>
								</div>
							</c:if>
						</div>
					</div>

					<!-- 生年月日 -->
					<div class="form-group row" id="datepicker-default">
					  <label for="birth_date" class="col-sm-4 col-form-label">生年月日</label>
					  <div class="col-sm-8 text-left form-inline">
					    <input type="date" width="276" name="birth_date" value="${uddb.birth_date}"/>
					  </div>
					</div>

					<!-- 出身地 -->
					<div class="form-group row">
					  <label for="birth_place_id" class="col-sm-4 col-form-label">出身地</label>
					    <div class="col-sm-8 text-left">
							<select class="form-control" name="birth_place_id">
								<option value="0">選択してください</option>
								<optgroup label="--- 都道府県 ---">
									<c:forEach var="pdb" items="${pdbList}">
										<c:if test="${pdb.name == uddb.prefectures_name}" var="prFlg" />
										<c:if test="${prFlg}">
											<option value="${pdb.id}" selected>${pdb.name}</option>
										</c:if>
										<c:if test="${!prFlg}">
											<option value="${pdb.id}">${pdb.name}</option>
										</c:if>
									</c:forEach>
								</optgroup>
							</select>
						</div>
					</div>

					<!-- 血液型 -->
					<div class="form-group row">
						<label for="inputAttribute" class="col-sm-4 col-form-label">血液型</label>
						<div class="col-sm-8 text-left">

							<c:if test="${uddb.blood_type == 'A型'}" var="btFlgA" />
							<c:if test="${btFlgA}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeA" value="A型" checked="checked">
								  <label class="form-check-label" for="bloodtypeA">A型</label>
								</div>
							</c:if>
							<c:if test="${!btFlgA}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeA" value="A型">
								  <label class="form-check-label" for="bloodtypeA">A型</label>
								</div>
							</c:if>

							<c:if test="${uddb.blood_type == 'B型'}" var="btFlgB" />
							<c:if test="${btFlgB}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeB" value="B型" checked="checked">
								  <label class="form-check-label" for="bloodtypeB">B型</label>
								</div>
							</c:if>
							<c:if test="${!btFlgB}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeB" value="B型">
								  <label class="form-check-label" for="bloodtypeB">B型</label>
								</div>
							</c:if>

							<c:if test="${uddb.blood_type == 'O型'}" var="btFlgO" />
							<c:if test="${btFlgO}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeO" value="O型" checked="checked">
								  <label class="form-check-label" for="bloodtypeO">O型</label>
								</div>
							</c:if>
							<c:if test="${!btFlgO}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeO" value="O型">
								  <label class="form-check-label" for="bloodtypeO">O型</label>
								</div>
							</c:if>

							<c:if test="${uddb.blood_type == 'AB型'}" var="btFlgAB" />
							<c:if test="${btFlgAB}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeAB" value="AB型" checked="checked">
								  <label class="form-check-label" for="bloodtypeAB">AB型</label>
								</div>
							</c:if>
							<c:if test="${!btFlgAB}">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="bloodtype" id="bloodtypeAB" value="AB型">
								  <label class="form-check-label" for="bloodtypeAB">AB型</label>
								</div>
							</c:if>

						</div>
					</div>

					<!-- 声域 -->
					<div class="form-group row">
					  <label for="inputName" class="col-sm-4 col-form-label">声域</label>
					    <div class="col-sm-8 text-left">
							<select class="form-control" name="vocal_range">
							  <option>選択してください</option>
							  <optgroup label="--- 女声 ---">
								<c:forEach var="vrdb" items="${vrdbList}">
									<c:if test="${vrdb.category == '女声'}">
										<c:if test="${vrdb.name == uddb.vocal_range}" var="vrFlg" />
										<c:if test="${vrFlg}">
											<option value="${vrdb.id}" selected="selected">${vrdb.name}</option>
										</c:if>
										<c:if test="${!vrFlg}">
											<option value="${vrdb.id}">${vrdb.name}</option>
										</c:if>
									</c:if>
								</c:forEach>
							  </optgroup>
							  <optgroup label="--- 男声 ---">
								<c:forEach var="vrdb" items="${vrdbList}">
									<c:if test="${vrdb.category == '男声'}">
										<c:if test="${vrdb.name == uddb.vocal_range}" var="vrFlg" />
										<c:if test="${vrFlg}">
											<option value="${vrdb.id}" selected="selected">${vrdb.name}</option>
										</c:if>
										<c:if test="${!vrFlg}">
											<option value="${vrdb.id}">${vrdb.name}</option>
										</c:if>
									</c:if>
								</c:forEach>
							  </optgroup>
							  <optgroup label="--- 少年 ---">
								  <c:forEach var="vrdb" items="${vrdbList}">
									<c:if test="${vrdb.category == '少年'}">
										<c:if test="${vrdb.name == uddb.vocal_range}" var="vrFlg" />
										<c:if test="${vrFlg}">
											<option value="${vrdb.id}" selected="selected">${vrdb.name}</option>
										</c:if>
										<c:if test="${!vrFlg}">
											<option value="${vrdb.id}">${vrdb.name}</option>
										</c:if>
									</c:if>
								</c:forEach>
							  </optgroup>
							</select>
						</div>
					</div>

					<!-- 特技 -->
					<div class="form-group row">
					  <label for="special_skill" class="col-sm-4 col-form-label">特技</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" name="special_skill" value="${uddb.special_skill}">
					  </div>
					</div>

					<!-- 趣味 -->
					<div class="form-group row">
					  <label for="hobby" class="col-sm-4 col-form-label">趣味</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" name="hobby" value="${uddb.hobby}">
					  </div>
					</div>

					<!-- 免許 -->
					<div class="form-group row">
					  <label for="license" class="col-sm-4 col-form-label">免許</label>
					  <div class="col-sm-8">
					    <input type="text" class="form-control" name="license" value="${uddb.license}">
					  </div>
					</div>

					<!-- Twitter -->
					<div class="form-group row">
					  <label for="twitter" class="col-sm-4 col-form-label">Twitter</label>
					  <div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <input type="text" class="form-control" name="twitter_url" placeholder="URL" value="${uddb.twitter_url}">
						    </div>
						    <div class="col">
						      <input type="text" class="form-control" name="twitter_id" placeholder="@user_name" value="${uddb.twitter_id}">
						    </div>
						  </div>
					  </div>
					</div>

					<!-- 主な出演作品 -->
					<div class="form-group row">
						<label for="filmographies_anime" class="col-sm-4 col-form-label">主な出演作品</label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="filmographies_anime">アニメ</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea name="filmographies_anime" class="form-control" id="filmographies_anime" rows="3">${uddb.filmographies_anime}</textarea>
						    </div>
					      </div>
					    </div>
				    </div>
				    <div class="form-group row">
						<label for="filmographies_film" class="col-sm-4 col-form-label"></label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="filmographies_film">映画</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea name="filmographies_film" class="form-control" id="filmographies_film" rows="3">${uddb.filmographies_film}</textarea>
						    </div>
					      </div>
					    </div>
				    </div>
				    <div class="form-group row">
						<label for="filmographies_narration" class="col-sm-4 col-form-label"></label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="filmographies_narration">ナレーション</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea name="filmographies_narration" class="form-control" id="filmographies_narration" rows="3">${uddb.filmographies_narration}</textarea>
						    </div>
					      </div>
					    </div>
				    </div>
				    <div class="form-group row">
						<label for="filmographies_other" class="col-sm-4 col-form-label"></label>
						<div class="col-sm-8">
						  <div class="form-row">
						    <div class="col">
						      <label for="filmographies_other">その他</label>
						    </div>
						    <div class="col">
						    </div>
						  </div>
						  <div class="form-row">
						    <div class="col">
						      <textarea name="filmographies_other" class="form-control" id="filmographies_other" rows="3">${uddb.filmographies_other}</textarea>
						    </div>
					      </div>
					    </div>
				    </div>

					<br>
					<input type="hidden" name="id" value="${uddb.id}">
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