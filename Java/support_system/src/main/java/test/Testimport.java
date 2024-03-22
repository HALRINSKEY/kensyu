package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Testimport {
    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        //データベースdb1接続へのURL
		final String url = "jdbc:mysql://localhost/dbtest?characterEncoding=UTF-8&allowLoadLocalInfile=true";
		//DBのユーザー
		final String username = "test";
		//DBのパスワード
		final String password = "test";
		//接続オブジェクト
		Connection con = null;
		//MySQLのJDBCドライバーをロードする
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Start");

		try {
		//接続の確立
			con = DriverManager.getConnection(url, username, password);
			System.out.println("接続成功！");
		} catch(SQLException e){
			System.out.println("接続失敗");
			e.printStackTrace();
		}

        final String sql = "load data local infile 'C:\\\\研修\\\\kensyu\\\\Java\\\\.metadata\\\\.plugins\\\\org.eclipse.wst.server.core\\\\tmp0\\\\wtpwebapps\\\\support_system\\\\upload\\\\?' into table repair_table FIELDS TERMINATED BY ',' optionally enclosed by '\"' LINES TERMINATED BY '\r\n' (order_id,serial_no,product_code,product_name,repair_end,repair_order,out_state,check_state,repair_detail,disorder_repair,end_date,order_date)";
		//SQL実行の準備

			//SQL実行
        try (PreparedStatement stmt = con.prepareStatement(sql);) {
            String filename = "test2.csv";
            stmt.setString(1, filename);
            System.out.println("cmd:"+stmt);
    
            //SQL実行
            int rs = stmt.executeUpdate();
            System.out.println(rs + ":import success");

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}        

    }
    
}
