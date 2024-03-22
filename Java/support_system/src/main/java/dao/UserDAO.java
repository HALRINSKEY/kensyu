package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import beans.UserBean;

public class UserDAO extends ConectionBase {
    /**
	* ユーザーIDからidとpasswordのBeanを取得
	* @param con, user_id
	* @return int IDBean
	* @throws SQLException
	*/
	public UserBean getUserInfo(Connection con, String user_id) throws SQLException {
		//Beanの初期化
		UserBean userBean = new UserBean();

		//ユーザーIDで取得するSQL
		final String sql = "select user_table.user_id,user_table.password,user_table.user_name from user_table where user_table.user_id=?";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, user_id);

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
					String password = rs.getString("user_table.password");
					String user_name = rs.getString("user_table.user_name");

					//取得した値をBeanにセット
					userBean.setUser_id(user_id);
					userBean.setPassword(password);
					userBean.setUser_name(user_name);
				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return userBean;
	}

}
