package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.VoiceSampleDataBeans;

public class VoiceSampleDAO {

	public static VoiceSampleDataBeans getVoiceSampleDataBeansByUserId(int user_id) {
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM voicesample WHERE user_id = ? ORDER BY sort_id");
			st.setInt(1, user_id);
			ResultSet rs = st.executeQuery();

			VoiceSampleDataBeans vsdb = new VoiceSampleDataBeans();
			vsdb.setId(rs.getInt("id"));
			vsdb.setUser_id(rs.getInt("user_id"));
			vsdb

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
