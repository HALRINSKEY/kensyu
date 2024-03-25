package model;

import java.sql.Connection;
import java.sql.SQLException;

import beans.UserBean;
import dao.UserDAO;

public class Authenicate {
    private String error_msg = "";
    private String user_name = "";
    private UserBean DBbean = new UserBean();

    public Authenicate(String user_id)throws SQLException, ClassNotFoundException {
        try (Connection con = UserDAO.getConnection();) {
			UserDAO userDAO = new UserDAO();
            DBbean = new UserBean();
			//データベースに接続して、ID,PWを取得
			DBbean = userDAO.getUserInfo(con, user_id);
            this.user_name = DBbean.getUser_name();
        }
    }

    public boolean Check(String password){
        if(DBbean.getUser_id() == null) {//UserIDの存在を確認
            error_msg = "ユーザーID,パスワードが間違っています";
            return false;
        }else if(!(DBbean.getPassword().equals(password))){//パスワードチェック
            error_msg = "ユーザーID,パスワードが間違っています";
			return false;
        }else{
            return true;
        }
	}   
    

    public String getError_msg() {
        return error_msg;
    }

    public String getUser_name() {
        return user_name;
    }
    
}
