package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	/**
	* JDBCデータベース接続テスト
	* @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	*/
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//データベースdb1接続へのURL
		final String url = "jdbc:mysql://localhost/dbtest?characterEncoding=UTF-8";
		//DBのユーザー
		final String username = "test";
		//DBのパスワード
		final String password = "test";
		//接続オブジェクト
		Connection con = null;
		//MySQLのJDBCドライバーをロードする
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Start");

		try {
		//接続の確立
			con = DriverManager.getConnection(url, username, password);
			System.out.println("接続成功！");
		} catch(SQLException e){
			System.out.println("接続失敗");
			e.printStackTrace();
		}
		finally {
			con.close(); //接続を閉じておく
		}
	}
}