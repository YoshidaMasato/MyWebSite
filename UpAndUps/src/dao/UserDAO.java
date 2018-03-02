package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.UserDataBeans;

public class UserDAO {

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
				udb.setCreate_date(rs.getDate("create_date"));
				udb.setUpdate_date(rs.getDate("update_date"));
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
			st = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = st.executeQuery();

			ArrayList<UserDataBeans> udbList = new ArrayList<UserDataBeans>();

			while(rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setLogin_id(rs.getString("login_id"));
				udb.setName(rs.getString("name"));
				udb.setCreate_date(rs.getDate("create_date"));
				udb.setUpdate_date(rs.getDate("update_date"));
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

}
