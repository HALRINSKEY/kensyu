package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import dao.ConectionBase;

public class Testcmd extends ConectionBase {

    public static void main(String[] args)throws SQLException, ClassNotFoundException {
		//データベースdb1接続へのURL
		final String url = "jdbc:mysql://localhost/dbtest?characterEncoding=UTF-8&allowLoadLocalInfile=true";
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

		final String sql = "SHOW VARIABLES LIKE 'local_infile'";
		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
                    System.out.println(rs.getString("Variable_name"));
                    System.out.println(rs.getString("Value"));

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}        

    }


}