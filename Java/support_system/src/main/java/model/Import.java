package model;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ImportDAO;

public class Import {
	public void ImportDB (String name, String path) throws SQLException, ClassNotFoundException{
        try(Connection con = ImportDAO.getConnection()){
            ImportDAO importDAO = new ImportDAO();
            importDAO.ImportCSV(con, name, path);
        }
	}
}
