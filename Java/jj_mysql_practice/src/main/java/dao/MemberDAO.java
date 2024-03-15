package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.MemberBean;

public class MemberDAO extends ConectionBase {
    /**
	* 社員IDから社員Beanを取得
	* @param con, member_id
	* @return int memberBean
	* @throws SQLException
	*/
	public MemberBean getMember(Connection con, String member_id) throws SQLException {
		//社員Beanの初期化
		MemberBean memberBean = new MemberBean();

		//社員IDで取得するSQL
		final String sql = "select member_master.id, member_master.name, division_master.name, member_master.enter_date, member_master.password, member_master.attribute "
			+ "from member_master, division_master where member_master.division_id = division_master.division_id and member_master.id=?";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, member_id);

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
					String member_name = rs.getString("member_master.name");
					String division_name = rs.getString("division_master.name");
					String enter_date = rs.getString("member_master.enter_date");
					String password = rs.getString("member_master.password");
					boolean attribute = rs.getBoolean("member_master.attribute");

					//取得した値を社員Beanにセット
					memberBean.setMember_id(member_id);
					memberBean.setMember_name(member_name);
					memberBean.setDivision_name(division_name);
					memberBean.setEnter_date(enter_date);
					memberBean.setPassword(password);
					memberBean.setAttribute(attribute);
				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return memberBean;
	}

    /**
	* 全社員を取得
	* @param con
	* @return memberList
	* @throws SQLException
	*/
	public ArrayList<MemberBean> getAllMember(Connection con) throws SQLException {
		//ArrayListの初期化
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();

		//社員IDで取得するSQL
		final String sql = "select member_master.id, member_master.name,division_master.name, member_master.enter_date, member_master.password, member_master.attribute "
				+ "from member_master, division_master where member_master.division_id = division_master.division_id";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//取得した行数を繰り返す
				while (rs.next()) {

					//社員Beanの初期化
					MemberBean memberBean = new MemberBean();

					//値を取得
					String member_id = rs.getString("member_master.id");
					String member_name = rs.getString("member_master.name");
					String division_name = rs.getString("division_master.name");
					String enter_date = rs.getString("member_master.enter_date");
					String password = rs.getString("member_master.password");
					boolean attribute = rs.getBoolean("member_master.attribute");

					//取得した値を社員Beanにセット
					memberBean.setMember_id(member_id);
					memberBean.setMember_name(member_name);
					memberBean.setDivision_name(division_name);
					memberBean.setEnter_date(enter_date);
					memberBean.setPassword(password);
					memberBean.setAttribute(attribute);

					//リストに社員Beanの追加
					memberList.add(memberBean);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return memberList;
	}
}
