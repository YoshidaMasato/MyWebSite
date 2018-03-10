package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.VoiceSampleDataBeans;

public class VoiceSampleDAO {

	public static boolean createVoiceSampleData(int user_id, String title, String file_url) {

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			// titleが空文字、ファイルネームがnullの場合はfalseを返す
			if(title.equals("") || file_url.equals(null)) {
				return false;
			}

			st = con.prepareStatement("SELECT MIN(sort_id + 1) AS sort_id FROM voicesample WHERE (sort_id + 1) NOT IN (SELECT sort_id FROM voicesample)");
			ResultSet rs = st.executeQuery();
			int sort_id;

			if(!rs.next()) {
				return false;
			} else {
				sort_id = rs.getInt("sort_id");
			}

			st = con.prepareStatement("INSERT INTO voicesample(user_id, title, file_url, sort_id) VALUE(?,?,?,?)");
			st.setInt(1, user_id);
			st.setString(2, title);
			st.setString(3, file_url);
			st.setInt(4, sort_id);
			int result = st.executeUpdate();
			System.out.println(result + "行が追加されました。");

			return true;

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

	public static ArrayList<VoiceSampleDataBeans> getVoiceSampleDataBeansByUserId(int user_id) {
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM voicesample WHERE user_id = ? ORDER BY sort_id");
			st.setInt(1, user_id);
			ResultSet rs = st.executeQuery();

			ArrayList<VoiceSampleDataBeans> vsdbList = new ArrayList<VoiceSampleDataBeans>();
			while(rs.next()) {
				VoiceSampleDataBeans vsdb = new VoiceSampleDataBeans();
				vsdb.setId(rs.getInt("id"));
				vsdb.setUser_id(rs.getInt("user_id"));
				vsdb.setTitle(rs.getString("title"));
				vsdb.setFile_url(rs.getString("file_url"));
				vsdb.setSort_id(rs.getInt("sort_id"));
				vsdbList.add(vsdb);
			}
				System.out.println("searching VoiceSampleDataBeans by UserId has been completed");
				return vsdbList;

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

	public static VoiceSampleDataBeans getVoiceSampleDataBeansById(int id) {

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM voicesample WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(!rs.next()) {
				return null;
			} else {
				VoiceSampleDataBeans vsdb = new VoiceSampleDataBeans();
				vsdb.setId(rs.getInt("id"));
				vsdb.setUser_id(rs.getInt("user_id"));
				vsdb.setTitle(rs.getString("title"));
				vsdb.setFile_url(rs.getString("file_url"));
				vsdb.setSort_id(rs.getInt("sort_id"));
				return vsdb;
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

	public static boolean deleteVoiceSampleData(int id) {

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("DELETE FROM voicesample WHERE id = ?");
			st.setInt(1, id);

			int result = st.executeUpdate();
			System.out.println(result + "行が削除されました。");

			return true;

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
