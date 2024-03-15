package model;

import java.sql.Connection;
import java.sql.SQLException;

import beans.UserBean;
import dao.UserDAO;

public class Authenicate {
    private String error_msg = "";

    public boolean Check(String user_id, String password)throws SQLException, ClassNotFoundException {
        
        
        try (Connection con = UserDAO.getConnection();) {
			UserDAO userDAO = new UserDAO();
            UserBean DBbean = new UserBean();
			//データベースに接続して、ID,PWを取得
			DBbean = userDAO.getUserInfo(con, user_id);

            //UserIDの存在を確認
            if(DBbean.getUser_id() == null) {
                //JSPへのkeyと値をセット
                //エラーページ転送
                error_msg = "ユーザーIDが存在しません";
                return false;
            }

            //パスワードチェック
            if(!(DBbean.getPassword().equals(password))){
				//JSPへのkeyと値をセット
                error_msg = "パスワードが間違っています";
				return false;
			}

        return true;
		}   
    }

    public String getError_msg() {
        return error_msg;
    }
    
}
