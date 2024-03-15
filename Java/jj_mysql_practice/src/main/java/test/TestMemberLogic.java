package test;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.MemberBean;
import model.MemberLogic;

public class TestMemberLogic {

	public static void main(String[] args) {

		// 社員ロジックの初期化
		MemberLogic memberLogic = new MemberLogic();
		try {
			// 社員ID
			MemberBean memberBean = memberLogic.getMember("0001");
			// 社員Beanのテスト結果（値を取得し、表示する）
			System.out.println("社員ID：" + memberBean.getMember_id());
			System.out.println("社員名：" + memberBean.getMember_name());
			System.out.println("部署名：" + memberBean.getDivision_name());
			System.out.println("入社日：" + memberBean.getEnter_date());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("IDエラー:" + e.getMessage());
		}

		try {
			ArrayList<MemberBean> memberList = memberLogic.getAllMember();
			// 全社員Beanのテスト結果（値を取得し、表示する）
			for (MemberBean member : memberList) {
				System.out.println("------------------------------------------");
				System.out.println("社員ID：" + member.getMember_id());
				System.out.println("社員名：" + member.getMember_name());
				System.out.println("部署名：" + member.getDivision_name());
				System.out.println("入社日：" + member.getEnter_date());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
