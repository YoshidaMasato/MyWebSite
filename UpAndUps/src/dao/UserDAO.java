package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.UserDataBeans;

public class UserDAO {

	public static boolean deleteUserById(int id) {

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();

			// userテーブルの情報を削除
			st = con.prepareStatement("DELETE FROM user WHERE id = ?");
			st.setInt(1, id);
			int result = st.executeUpdate();
			System.out.println(result + "行を削除しました。");

			// user_detailテーブルの情報を削除
			st = con.prepareStatement("DELETE FROM user_detail WHERE user_id = ?");
			st.setInt(1, id);
			result = st.executeUpdate();
			System.out.println(result + "行を削除しました。");

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

	public static UserDataBeans getUserDataBeansById(int id) {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(!rs.next()) {
				return null;
			} else {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setCreate_date(rs.getString("create_date"));
				udb.setUpdate_date(rs.getString("update_date"));
				return udb;
			}
		} catch(SQLException e) {
			e.printStackTrace();
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

	public static UserDataBeans getUserDataBeansByLoginId(String login_id, String password) {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE login_id = ? AND password = ?");
			st.setString(1, login_id);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();

			if(!rs.next()) {
				return null;
			} else {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setCreate_date(rs.getString("create_date"));
				udb.setUpdate_date(rs.getString("update_date"));
				return udb;
			}
		} catch(SQLException e) {
			e.printStackTrace();
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

	public static ArrayList<UserDataBeans> getUserDataBeansFindAll() {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE login_id NOT IN ('admin')");
			ResultSet rs = st.executeQuery();

			ArrayList<UserDataBeans> udbList = new ArrayList<UserDataBeans>();

			while(rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setCreate_date(rs.getString("create_date"));
				udb.setUpdate_date(rs.getString("update_date"));
				udbList.add(udb);
			}

			System.out.println("searching UserDataBeansList by All has been completed");
			return udbList;

		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public static ArrayList<UserDataBeans> getUserDataBeansByName(String search_word){

		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM user WHERE login_id NOT IN ('admin') AND name LIKE ?");
			st.setString(1, "%" + search_word + "%");

			ResultSet rs = st.executeQuery();
			ArrayList<UserDataBeans> udbList = new ArrayList<UserDataBeans>();
			while(rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setCreate_date(rs.getString("create_date"));
				udb.setUpdate_date(rs.getString("update_date"));
				udbList.add(udb);
			}

			return udbList;

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
