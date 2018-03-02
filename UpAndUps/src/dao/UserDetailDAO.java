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

public class UserDetailDAO {

	public static ArrayList<UserDetailDataBeans> getUserDetailDataBeansListBySex(String sex){
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			if(sex == "all") {
				st = con.prepareStatement("SELECT user.name,user_detail.*"
						+ "FROM user INNER JOIN user_detail"
						+ "ON user.id = user_detail.user_id");
			} else {
				st = con.prepareStatement("SELECT user.name,user_detail.*"
						+ "FROM user INNER JOIN user_detail"
						+ "ON user.id = user_detail.user_id"
						+ "WHERE user_detail.sex = ?");
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
				uddb.setBirth_date(rs.getDate("birth_date"));
				uddb.setVocal_range_id(rs.getInt("vocal_range_id"));
				uddb.setSpecial_skill(rs.getString("special_skill"));
				uddb.setHobby(rs.getString("hobby"));
				uddb.setLicense(rs.getString("license"));
				uddb.setTwitter_url(rs.getString("twitter_url"));
				uddb.setTwitter_id(rs.getString("twitter_id"));
				uddb.setFilmographies(rs.getString("filmographies"));
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

			if(login_id == "" || passMD5 == "" || passCheckMD5 == "" || name == "" || sex == "" || photo_url == "" || affiliation_form == "" || birth_date == "" || birth_place_id == "" || blood_type == "" || vocal_range_id == "" || special_skill == "" || hobby == "") {
				// 未入力の必須項目があればfalseを返す。
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
				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO user_detail(user_id, sex, photo_url, affiliation_form, birth_date, birth_place_id, blood_type, vocal_range_id, special_skill, hobby");
				if(!license.equals("")) {
					sb.append(",license");
				}
				if(!twitter_url.equals("") & !twitter_id.equals("")) {
					sb.append(",twitter_url, twitter_id");
				}
				if(!filmographies_anime.equals("")) {
					sb.append(",filmographies_anime");
				}
				if(!filmographies_film.equals("")) {
					sb.append(",filmographies_film");
				}
				if(!filmographies_narration.equals("")) {
					sb.append(",filmographies_narration");
				}
				if(!filmographies_other.equals("")) {
					sb.append(",filmographies_other");
				}
				sb.append(") VALUES(?,?,?,?,?,?,?,?,?,?");
				if(!license.equals("")) {
					sb.append(",?");
				}
				if(!twitter_url.equals("") & !twitter_id.equals("")) {
					sb.append(",?, ?");
				}
				if(!filmographies_anime.equals("")) {
					sb.append(",?");
				}
				if(!filmographies_film.equals("")) {
					sb.append(",?");
				}
				if(!filmographies_narration.equals("")) {
					sb.append(",?");
				}
				if(!filmographies_other.equals("")) {
					sb.append(",?");
				}
				sb.append(")");

				String sql = new String(sb);
				st = con.prepareStatement(sql);
				st.setInt(1, id); /* userテーブルのidをSQLで取得して持ってくる */
				st.setString(2, sex);
				st.setString(3, photo_url);
				st.setString(4, affiliation_form);
				st.setString(5, birth_date);
				st.setInt(6, Integer.parseInt(birth_place_id));
				st.setString(7, blood_type);
				st.setInt(8, Integer.parseInt(vocal_range_id));
				st.setString(9, special_skill);
				st.setString(10, hobby);
				if(!license.equals("")) {
					st.setString(11, license);
				}
				if(!twitter_url.equals("") & !twitter_id.equals("")) {
					sb.append(",twitter_url, twitter_id");
				}
				if(!filmographies_anime.equals("")) {
					sb.append(",filmographies_anime");
				}
				if(!filmographies_film.equals("")) {
					sb.append(",filmographies_film");
				}
				if(!filmographies_narration.equals("")) {
					sb.append(",filmographies_narration");
				}
				if(!filmographies_other.equals("")) {
					sb.append(",filmographies_other");
				}
				sb.append(") VALUES(?,?,?,?,?,?,?,?,?,?");
				if(!license.equals("")) {
					sb.append(",?");
				}
				if(!twitter_url.equals("") & !twitter_id.equals("")) {
					sb.append(",?, ?");
				}
				if(!filmographies_anime.equals("")) {
					sb.append(",?");
				}
				if(!filmographies_film.equals("")) {
					sb.append(",?");
				}
				if(!filmographies_narration.equals("")) {
					sb.append(",?");
				}
				if(!filmographies_other.equals("")) {
					sb.append(",?");
				}

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

}
