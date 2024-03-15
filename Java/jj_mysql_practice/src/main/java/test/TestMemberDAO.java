package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.MemberBean;
import dao.MemberDAO;

public class TestMemberDAO {

	public static void main(String[] args) {
		try (Connection con = MemberDAO.getConnection();){//DB接続

			//社員DAO初期化
			MemberDAO memberDAO = new MemberDAO();

			/**ShainDAO.getShainのテスト*/
			//社員ID
			String member_id = "0001";
			//社員Beanの取得
			MemberBean memberBean = memberDAO.getMember(con, member_id);

			//社員Beanのテスト結果（値を取得し、表示する）
			System.out.println("社員ID：" + memberBean.getMember_id());
			System.out.println("社員名：" + memberBean.getMember_name());
			System.out.println("部署名：" + memberBean.getDivision_name());
			System.out.println("入社日：" + memberBean.getEnter_date());


			/**ShainDAO.getAllShainのテスト*/
			ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
			memberList = memberDAO.getAllMember(con);

			for(MemberBean member:memberList){
				System.out.println("---------------------------");
				System.out.println("社員ID：" + member.getMember_id());
				System.out.println("社員名：" + member.getMember_name());
				System.out.println("部署名：" + member.getDivision_name());
				System.out.println("入社日：" + member.getEnter_date());
				System.out.println("pw：" + member.getPassword());
				System.out.println("att：" + member.isAttribute());

			}

		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}

	}

}
