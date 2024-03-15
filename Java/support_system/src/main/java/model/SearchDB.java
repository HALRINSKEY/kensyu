package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.SearchBean;
import dao.RepairDAO;

public class SearchDB {
    public ArrayList<SearchBean> Search (SearchBean inputBean) throws SQLException, ClassNotFoundException{
        try (Connection con = RepairDAO.getConnection()) {
			//DAOの初期化
			RepairDAO repairDAO = new RepairDAO();
			//データベースに接続して検索結果取得
			return repairDAO.getResult(con,inputBean);
		}
    } 

}
