package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.PrefecturesDataBeans;

public class PrefecturesDAO {

	public static ArrayList<PrefecturesDataBeans> getPrefecturesDataBeansAll(){
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM prefectures ORDER BY id");
			ResultSet rs = st.executeQuery();
			ArrayList<PrefecturesDataBeans> pdbList = new ArrayList<PrefecturesDataBeans>();

			while(rs.next()) {
				PrefecturesDataBeans pdb = new PrefecturesDataBeans();
				pdb.setId(rs.getInt("id"));
				pdb.setName(rs.getString("name"));
				pdbList.add(pdb);
			}
			return pdbList;

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
