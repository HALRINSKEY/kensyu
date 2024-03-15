package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.MemberBean;
import dao.MemberDAO;

public class MemberLogic {
    //1社員取得メソッド
	public MemberBean getMember(String member_id) throws SQLException, ClassNotFoundException {

		//社員IDのチェック(数字以外がないか)
		boolean isNumeric = member_id.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IllegalArgumentException("数字以外が入っています");
		}
		try (Connection con = MemberDAO.getConnection();) {
			//社員DAOの初期化
			MemberDAO memberDAO = new MemberDAO();
			//データベースに接続して、社員報を取得
			return memberDAO.getMember(con, member_id);
		}
	}

    //全社員取得メソッド
	public ArrayList<MemberBean> getAllMember() throws SQLException, ClassNotFoundException {
		
        try (Connection con = MemberDAO.getConnection();) {
			//社員DAOの初期化
			MemberDAO MemberDAO = new MemberDAO();
			//データベースに接続して、全社員の一覧情報を取得
			return MemberDAO.getAllMember(con);
		}
	}
}
