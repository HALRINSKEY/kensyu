package test;

import java.sql.Connection;
import java.sql.SQLException;
//import java.util.ArrayList;

import beans.UserBean;
import dao.UserDAO;

public class TestUserDAO {

	public static void main(String[] args) {
		try (Connection con = UserDAO.getConnection();){//DB接続

			//社員DAO初期化
			UserDAO userDAO = new UserDAO();

			/**UserDAO.getUserInfoのテスト*/
			//社員ID
			String user_id = "0001";
			//社員Beanの取得
			UserBean userBean = userDAO.getUserInfo(con, user_id);

			//社員Beanのテスト結果（値を取得し、表示する）
			System.out.println("ID：" + userBean.getUser_id());
			System.out.println("password：" + userBean.getPassword());
			


			// /**ShainDAO.getAllShainのテスト*/
			// ArrayList<Bean> memberList = new ArrayList<Bean>();
			// memberList = UserDAO.getAllMember(con);

			// for(Bean member:memberList){
			// 	System.out.println("---------------------------");
			// 	System.out.println("社員ID：" + member.getMember_id());
			// 	System.out.println("社員名：" + member.getMember_name());
			// 	System.out.println("部署名：" + member.getDivision_name());
			// 	System.out.println("入社日：" + member.getEnter_date());
			// }

		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}

	}

}
