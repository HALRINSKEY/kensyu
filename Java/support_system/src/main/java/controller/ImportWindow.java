package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Import;

/**
 * Servlet implementation class ImportWindow
 */
@WebServlet("/ImportWindow")
@MultipartConfig
public class ImportWindow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportWindow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//name属性がcsv_fileのファイルをPartオブジェクトとして取得
		Part part = request.getPart("csv_file");
		//ファイル名を取得
		//String filename=part.getSubmittedFileName();//ie対応が不要な場合
		String name=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/upload");
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		System.out.println(name);
		//書き込み
		part.write(path+File.separator+name);

		//SQL実行
		try{
			Import im = new Import();
			im.ImportDB(name,path);
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("error_msg", "ファイルの読み込みに失敗しました");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/WEB-INF/importwindow.jsp").forward(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
		  super.service( request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error_msg", "ファイルの読み込みに失敗しました");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
	  }

}
