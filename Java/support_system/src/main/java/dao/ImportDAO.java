package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportDAO extends ConectionBase{
    /**
	* 
	* @param con, path
	* @return 
	* @throws SQLException
	*/



    public void ImportCSV(Connection con, String name, String path) throws SQLException {

		//SQL命令文
		String filepath = path;
		String filename = name;

		filepath = filepath.replace("\\", "\\\\\\\\");
		filepath += "\\\\\\\\"+filename;

		final String sql = "load data local infile '" + filepath + "' into table repair_table FIELDS TERMINATED BY ',' optionally enclosed by '\"' LINES TERMINATED BY '\r\n' (order_id,serial_no,product_code,product_name,repair_end,repair_order,out_state,check_state,repair_detail,disorder_repair,end_date,order_date)";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {

			//System.out.println(stmt);

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
