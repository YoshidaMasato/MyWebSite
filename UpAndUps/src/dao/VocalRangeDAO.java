package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.VocalRangeDataBeans;

public class VocalRangeDAO {

	public static ArrayList<VocalRangeDataBeans> getVocalRangeDataBeansAll(){
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM vocal_range ORDER BY id");
			ResultSet rs = st.executeQuery();
			ArrayList<VocalRangeDataBeans> vrdbList = new ArrayList<VocalRangeDataBeans>();

			while(rs.next()) {
				VocalRangeDataBeans vrdb = new VocalRangeDataBeans();
				vrdb.setId(rs.getInt("id"));
				vrdb.setName(rs.getString("name"));
				vrdb.setCategory(rs.getString("category"));
				vrdbList.add(vrdb);
			}
			return vrdbList;

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
