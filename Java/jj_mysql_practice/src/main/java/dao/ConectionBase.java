package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionBase {
    //DBへの接続を開く
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //データベースdb1接続へのURL
        final String url = "jdbc:mysql://localhost/db2?characterEncoding=UTF-8";
        //DBのユーザー
        final String user_name = "user2";
        //DBのパスワード
        final String password = "pass2";
        //接続オブジェクト
        Connection con = null;
        //MySQLのJDBCドライバーをロードする
        Class.forName("com.mysql.cj.jdbc.Driver");
        //接続の確立
        con = DriverManager.getConnection(url, user_name, password);
        return con;
    }
}
