package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.SearchBean;

public class RepairDAO extends ConectionBase{
    /**
	* 検索条件からSQL検索結果Beanを取得
	* @param con
	* @return resultList
	* @throws SQLException
	*/

    private String orderdate = "";
    private String enddate = "";

    public ArrayList<SearchBean> getResult(Connection con, SearchBean inputBean) throws SQLException {
        ArrayList<SearchBean> resultList = new ArrayList<SearchBean>();
        makeSQLCommnd(inputBean);
        final String sql = "select * from repair_table where order_id like ? and product_code like ? and product_name like ? and serial_no like ? and out_state like ? and check_state like ? and repair_detail like ? and disorder_repair like ? " + orderdate + enddate;

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setString(1, "%"+inputBean.getOrder_id()+"%");
			stmt.setString(2, "%"+inputBean.getProduct_code()+"%");
			stmt.setString(3, "%"+inputBean.getProduct_name()+"%");
            stmt.setString(4, "%"+inputBean.getSerial_no()+"%");
            stmt.setString(5, "%"+inputBean.getOut_state()+"%");
            stmt.setString(6, "%"+inputBean.getCheck_state()+"%");
            stmt.setString(7, "%"+inputBean.getRepair_detail()+"%");
            stmt.setString(8, "%"+inputBean.getDisorder_repair()+"%");
            
            System.out.println("cmd:"+stmt);

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索でいると、if文の中に入る
				while (rs.next()) {
                    SearchBean resultBean = new SearchBean();

					//取得した値をBeanにセット
					resultBean.setOrder_id(rs.getString("repair_table.order_id"));
                    resultBean.setSerial_no(rs.getString("repair_table.serial_no"));
                    resultBean.setProduct_code(rs.getString("repair_table.product_code"));
                    resultBean.setProduct_name(rs.getString("repair_table.product_name"));
					resultBean.setOrder_date(rs.getString("repair_table.order_date"));
                    resultBean.setEnd_date(rs.getString("repair_table.end_date"));
                    resultBean.setOut_state(rs.getString("repair_table.out_state"));
                    resultBean.setCheck_state(rs.getString("repair_table.check_state"));
                    resultBean.setRepair_detail(rs.getString("repair_table.repair_detail"));
                    resultBean.setDisorder_repair(rs.getString("repair_table.disorder_repair"));

                    resultList.add(resultBean);
				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}


        return resultList;
    }

    public void makeSQLCommnd(SearchBean inputBean){
        //受付日のSQL文作成
        if( !(inputBean.getOrder_date_start().isEmpty()) & !(inputBean.getOrder_date_end().isEmpty()) ){
            orderdate = "and order_date between 'Start' and 'End' ";
            orderdate = orderdate.replace("Start", inputBean.getOrder_date_start());
            orderdate = orderdate.replace("End", inputBean.getOrder_date_end());
         }
         //修理完了日のSQL文作成
         if( !(inputBean.getEnd_date_start().isEmpty()) & !(inputBean.getEnd_date_end().isEmpty()) ){
            enddate = "and end_date between 'Start' and 'End' ";
            enddate = enddate.replace("Start", inputBean.getEnd_date_start());
            enddate = enddate.replace("End", inputBean.getEnd_date_end());
         }
        
    }
}
