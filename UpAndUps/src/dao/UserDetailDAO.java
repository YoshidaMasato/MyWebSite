package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import base.DBManager;
import beans.UserDetailDataBeans;
import upandups.Util;

public class UserDetailDAO {

	public static ArrayList<UserDetailDataBeans> getUserDetailDataBeansListBySex(String sex){
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			if(sex.equals("all")) {
				st = con.prepareStatement("SELECT user.name,user_detail.* "
						+ "FROM user INNER JOIN user_detail "
						+ "ON user.id = user_detail.user_id "
						+ "WHERE user.login_id NOT IN ('admin')");
			} else {
				st = con.prepareStatement("SELECT user.name,user_detail.* "
						+ "FROM user INNER JOIN user_detail "
						+ "ON user.id = user_detail.user_id "
						+ "WHERE user.login_id NOT IN ('admin') AND user_detail.sex = ?");
				st.setString(1, sex);
			}

			ResultSet rs = st.executeQuery();
			ArrayList<UserDetailDataBeans> uddbList = new ArrayList<UserDetailDataBeans>();

			while(rs.next()) {
				UserDetailDataBeans uddb = new UserDetailDataBeans();
				uddb.setId(rs.getInt("id"));
				uddb.setUser_id(rs.getInt("user_id"));
				uddb.setSex(rs.getString("sex"));
				uddb.setPhoto_url(rs.getString("photo_url"));
				uddb.setAffiliation_form(rs.getString("affiliation_form"));
				uddb.setBirth_date(rs.getString("birth_date"));
				uddb.setVocal_range_id(rs.getInt("vocal_range_id"));
				uddb.setSpecial_skill(rs.getString("special_skill"));
				uddb.setHobby(rs.getString("hobby"));
				uddb.setLicense(rs.getString("license"));
				uddb.setTwitter_url(rs.getString("twitter_url"));
				uddb.setTwitter_id(rs.getString("twitter_id"));
				uddb.setFilmographies_anime("filmographies_anime");
				uddb.setFilmographies_film("filmographies_film");
				uddb.setFilmographies_narration("filmographies_narration");
				uddb.setFilmographies_other("filmographies_other");
				uddb.setName(rs.getString("name"));
				uddbList.add(uddb);
			}

			System.out.println("searching UserDetailDataBeansList by Sex has been completed");
			return uddbList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public static ArrayList<UserDetailDataBeans> getUserDetailDataBeansByName(String search_word){

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement(
					"SELECT user.name,user_detail.* "
					+ "FROM user INNER JOIN user_detail "
					+ "ON user.id = user_detail.user_id "
					+ "WHERE user.login_id NOT IN ('admin')"
					+ " AND user.name LIKE ?");
			st.setString(1, "%" + search_word + "%");
			ResultSet rs = st.executeQuery();

			ArrayList<UserDetailDataBeans> uddbList = new ArrayList<UserDetailDataBeans>();
			while(rs.next()) {
				UserDetailDataBeans uddb = new UserDetailDataBeans();
				uddb.setId(rs.getInt("id"));
				uddb.setUser_id(rs.getInt("user_id"));
				uddb.setSex(rs.getString("sex"));
				uddb.setPhoto_url(rs.getString("photo_url"));
				uddb.setAffiliation_form(rs.getString("affiliation_form"));
				uddb.setBirth_date(rs.getString("birth_date"));
				uddb.setVocal_range_id(rs.getInt("vocal_range_id"));
				uddb.setSpecial_skill(rs.getString("special_skill"));
				uddb.setHobby(rs.getString("hobby"));
				uddb.setLicense(rs.getString("license"));
				uddb.setTwitter_url(rs.getString("twitter_url"));
				uddb.setTwitter_id(rs.getString("twitter_id"));
				uddb.setFilmographies_anime("filmographies_anime");
				uddb.setFilmographies_film("filmographies_film");
				uddb.setFilmographies_narration("filmographies_narration");
				uddb.setFilmographies_other("filmographies_other");
				uddb.setName(rs.getString("name"));
				uddbList.add(uddb);
			}

			return uddbList;

		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public static boolean createUser(
			String login_id
			, String passMD5
			, String passCheckMD5
			, String name
			, String sex
			, String photo_url
			, String affiliation_form
			, String birth_date
			, String birth_place_id
			, String blood_type
			, String vocal_range_id
			, String special_skill
			, String hobby
			, String license
			, String twitter_url
			, String twitter_id
			, String filmographies_anime
			, String filmographies_film
			, String filmographies_narration
			, String filmographies_other
			, String cPassMD5) {

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			// 登録用パスワードが合っているか確認
			st = con.prepareStatement("SELECT * FROM create_pass WHERE password = ?");
			st.setString(1, cPassMD5);
			ResultSet rs = st.executeQuery();

			if(!rs.next()) {
				return false;
			}

			if(login_id.equals("") || passMD5.equals("") || passCheckMD5.equals("") || name.equals("") || sex.equals("") || photo_url.equals("") || affiliation_form.equals("") || birth_date.equals("") || birth_place_id.equals("") || blood_type.equals("") || vocal_range_id.equals("") || special_skill.equals("") || hobby.equals("")) {
				// 未入力の必須項目があればfalseを返す。
				return false;
			}

			// 出身地、声域が選択されていない場合falseを返す。
			if(birth_place_id.equals("0") || vocal_range_id.equals("0")) {
				return false;
			}

			if(passMD5.equals(passCheckMD5)) {
				// 現在日時を取得
				Date d = new Date();

				// 日時の表示形式をフォーマットしてString型にキャスト
				String create_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

				// userテーブルにデータ登録
				st = con.prepareStatement("INSERT INTO user(login_id, password, name, create_date, update_date) VALUES(?,?,?,?,?)");
				st.setString(1, login_id);
				st.setString(2, passMD5);
				st.setString(3, name);
				st.setString(4, create_date);
				st.setString(5, create_date);

				// 追加された行数をint型で受け取って出力
				int result = st.executeUpdate();
				System.out.println(result + "行が追加されました。");


				// user_detailテーブルにデータ登録
				st = con.prepareStatement("INSERT INTO user_detail(user_id, sex, photo_url, affiliation_form, birth_date, birth_place_id, blood_type, vocal_range_id, special_skill, hobby, license, twitter_url, twitter_id, filmographies_anime, filmographies_film, filmographies_narration, filmographies_other) VALUES((SELECT MAX(id) FROM user),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				st.setString(1, sex);
				st.setString(2, photo_url);
				st.setString(3, affiliation_form);
				st.setString(4, birth_date);
				st.setInt(5, Integer.parseInt(birth_place_id));
				st.setString(6, blood_type);
				st.setInt(7, Integer.parseInt(vocal_range_id));
				st.setString(8, special_skill);
				st.setString(9, hobby);
				st.setString(10, license);
				st.setString(11, twitter_url);
				st.setString(12, twitter_id);
				st.setString(13, filmographies_anime);
				st.setString(14, filmographies_film);
				st.setString(15, filmographies_narration);
				st.setString(16, filmographies_other);

				result = st.executeUpdate();
				System.out.println(result + "行が追加されました。");

				return true;
			} else {
				return false;
			}


		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

	}

	public static boolean updateUser(
			int id
			, String passMD5
			, String passCheckMD5
			, String name
			, String sex
			, String photo_url
			, String affiliation_form
			, String birth_date
			, String birth_place_id
			, String blood_type
			, String vocal_range_id
			, String special_skill
			, String hobby
			, String license
			, String twitter_url
			, String twitter_id
			, String filmographies_anime
			, String filmographies_film
			, String filmographies_narration
			, String filmographies_other) {

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			if(name.equals("") || sex.equals("") || affiliation_form.equals("") || birth_date.equals("") || birth_place_id.equals("") || blood_type.equals("") || vocal_range_id.equals("") || special_skill.equals("") || hobby.equals("")) {
				// 未入力の必須項目があればfalseを返す。
				return false;
			}

			// 出身地、声域が選択されていない場合falseを返す。
			if(birth_place_id.equals("0") || vocal_range_id.equals("0")) {
				return false;
			}

			if(passMD5.equals(passCheckMD5)) {
				// 現在日時を取得
				Date d = new Date();

				// 日時の表示形式をフォーマットしてString型にキャスト
				String update_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

				// userテーブルのデータを更新
				st = con.prepareStatement("UPDATE user SET name = ?, update_date = ? WHERE id = ?");
				st.setString(1, name);
				st.setString(2, update_date);
				st.setInt(3, id);

				// 更新された行数をint型で受け取って出力
				int result = st.executeUpdate();
				System.out.println(result + "行が更新されました。");

				// パスワードの入力があれば更新
				if(!passMD5.equals("")) {
					st = con.prepareStatement("UPDATE user SET password = ? WHERE id = ?" );
					st.setString(1, passMD5);
					st.setInt(2, id);
				}

				// 更新された行数をint型で受け取って出力
				int result2 = st.executeUpdate();
				System.out.println(result2 + "行が更新されました。");

				// user_detailテーブルのデータ更新
				// 画像のアップロードの有無で分岐
				if(photo_url == null) {
					st = con.prepareStatement("UPDATE user_detail SET sex = ?, affiliation_form = ?, birth_date = ?, birth_place_id = ?, blood_type = ?, vocal_range_id = ?, special_skill = ?, hobby = ?, license = ?, twitter_url = ?, twitter_id = ?, filmographies_anime = ?, filmographies_film = ?, filmographies_narration = ?, filmographies_other = ? WHERE user_id = ?");
					st.setString(1, sex);
					st.setString(2, affiliation_form);
					st.setString(3, birth_date);
					st.setInt(4, Integer.parseInt(birth_place_id));
					st.setString(5, blood_type);
					st.setInt(6, Integer.parseInt(vocal_range_id));
					st.setString(7, special_skill);
					st.setString(8, hobby);
					st.setString(9, license);
					st.setString(10, twitter_url);
					st.setString(11, twitter_id);
					st.setString(12, filmographies_anime);
					st.setString(13, filmographies_film);
					st.setString(14, filmographies_narration);
					st.setString(15, filmographies_other);
					st.setInt(16, id);
				} else {
					st = con.prepareStatement("UPDATE user_detail SET sex = ?, photo_url = ?, affiliation_form = ?, birth_date = ?, birth_place_id = ?, blood_type = ?, vocal_range_id = ?, special_skill = ?, hobby = ?, license = ?, twitter_url = ?, twitter_id = ?, filmographies_anime = ?, filmographies_film = ?, filmographies_narration = ?, filmographies_other = ? WHERE user_id = ?");
					st.setString(1, sex);
					st.setString(2, photo_url);
					st.setString(3, affiliation_form);
					st.setString(4, birth_date);
					st.setInt(5, Integer.parseInt(birth_place_id));
					st.setString(6, blood_type);
					st.setInt(7, Integer.parseInt(vocal_range_id));
					st.setString(8, special_skill);
					st.setString(9, hobby);
					st.setString(10, license);
					st.setString(11, twitter_url);
					st.setString(12, twitter_id);
					st.setString(13, filmographies_anime);
					st.setString(14, filmographies_film);
					st.setString(15, filmographies_narration);
					st.setString(16, filmographies_other);
					st.setInt(17, id);
				}

				result = st.executeUpdate();
				System.out.println(result + "行が更新されました。");

				return true;
			} else {
				return false;
			}


		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}

	}

	public static UserDetailDataBeans getUserDetailDataBeansListById(int id) {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT user.login_id,user.name,user_detail.*,prefectures.name AS prefectures_name,vocal_range.name AS vocal_range_name FROM ((user INNER JOIN user_detail ON user.id = user_detail.user_id) INNER JOIN prefectures ON user_detail.birth_place_id = prefectures.id) INNER JOIN vocal_range ON user_detail.vocal_range_id = vocal_range.id WHERE user.id = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if(!rs.next()) {
				return null;
			} else {
				UserDetailDataBeans uddb = new UserDetailDataBeans();
				uddb.setId(rs.getInt("id"));
				uddb.setUser_id(rs.getInt("user_id"));
				uddb.setSex(rs.getString("sex"));
				uddb.setPhoto_url(rs.getString("photo_url"));
				uddb.setAffiliation_form(rs.getString("affiliation_form"));
				uddb.setBirth_date(rs.getString("birth_date"));
				uddb.setBirth_date_format(Util.birth_date_format(rs.getString("birth_date")));
				uddb.setBirth_place_id(rs.getInt("birth_place_id"));
				uddb.setPrefectures_name(rs.getString("prefectures_name"));
				uddb.setBlood_type(rs.getString("blood_type"));
				uddb.setVocal_range(rs.getString("vocal_range_name"));
				uddb.setSpecial_skill(rs.getString("special_skill"));
				uddb.setHobby(rs.getString("hobby"));
				uddb.setLicense(rs.getString("license"));
				uddb.setTwitter_url(rs.getString("twitter_url"));
				uddb.setTwitter_id(rs.getString("twitter_id"));
				uddb.setFilmographies_anime(rs.getString("filmographies_anime"));
				uddb.setFilmographies_film(rs.getString("filmographies_film"));
				uddb.setFilmographies_narration(rs.getString("filmographies_narration"));
				uddb.setFilmographies_other(rs.getString("filmographies_other"));
				uddb.setName(rs.getString("name"));
				uddb.setLogin_id(rs.getString("login_id"));

				System.out.println("searching UserDetailDataBeans by Id has been completed");
				return uddb;
			}

		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

}
