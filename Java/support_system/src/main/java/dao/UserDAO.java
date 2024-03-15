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
		final String sql = "select user_table.user_id,user_table.password from user_table where user_table.user_id=?";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, user_id);

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
					String password = rs.getString("user_table.password");

					//取得した値をBeanにセット
					userBean.setUser_id(user_id);
					userBean.setPassword(password);
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

    // /**
	// * 全社員を取得
	// * @param con
	// * @return memberList
	// * @throws SQLException
	// */
	// public ArrayList<Bean> getAllMember(Connection con) throws SQLException {
	// 	//ArrayListの初期化
	// 	ArrayList<Bean> memberList = new ArrayList<Bean>();

	// 	//社員IDで取得するSQL
	// 	final String sql = "select member_master.id, member_master.name,division_master.name, member_master.enter_date "
	// 			+ "from member_master, division_master where member_master.division_id = division_master.division_id";

	// 	//SQL実行の準備
	// 	try (PreparedStatement stmt = con.prepareStatement(sql);) {

	// 		//SQL実行
	// 		try (ResultSet rs = stmt.executeQuery();) {

	// 			//取得した行数を繰り返す
	// 			while (rs.next()) {

	// 				//社員Beanの初期化
	// 				Bean memberBean = new Bean();

	// 				//値を取得
	// 				String member_id = rs.getString("member_master.id");
	// 				String member_name = rs.getString("member_master.name");
	// 				String division_name = rs.getString("division_master.name");
	// 				String enter_date = rs.getString("member_master.enter_date");

	// 				//取得した値を社員Beanにセット
	// 				memberBean.setMember_id(member_id);
	// 				memberBean.setMember_name(member_name);
	// 				memberBean.setDivision_name(division_name);
	// 				memberBean.setEnter_date(enter_date);

	// 				//リストに社員Beanの追加
	// 				memberList.add(memberBean);

	// 			}

	// 		}
	// 	} catch (SQLException e) {
	// 		System.out.println("SQLException: " + e.getMessage());
	// 		System.out.println("SQLState: " + e.getSQLState());
	// 		System.out.println("VendorError: " + e.getErrorCode());
	// 		e.printStackTrace();
	// 		throw e;
	// 	}

	// 	return memberList;
	// }
}
