package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static String url = "jdbc:mysql://localhost/mywebsite";
    private static String user = "root";
    private static String pass = "password";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);/* 各環境に合わせて変更してください*/
			System.out.println("DBConnected!!");
			return con;
		} catch (ClassNotFoundException e) {
			throw new IllegalMonitorStateException();
		} catch (SQLException e) {
			throw new IllegalMonitorStateException();
		}
	}
}
