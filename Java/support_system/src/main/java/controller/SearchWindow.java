package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SearchBean;
import model.Authenicate;
import model.SearchDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/SearchWindow")
public class SearchWindow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWindow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ArrayList<SearchBean> resultList = new ArrayList<SearchBean>();

		//JSPから、検索条件の取得

		SearchBean inputBean = new SearchBean();

		inputBean.setOrder_date_start(request.getParameter("order_date_start"));
		inputBean.setOrder_date_end(request.getParameter("order_date_end"));
		inputBean.setEnd_date_start(request.getParameter("end_date_start"));
		inputBean.setEnd_date_end(request.getParameter("end_date_end"));
		inputBean.setOrder_id(request.getParameter("order_id"));
		inputBean.setProduct_code(request.getParameter("product_code"));
		inputBean.setProduct_name(request.getParameter("product_name"));
		inputBean.setSerial_no(request.getParameter("serial_no"));
		inputBean.setOut_state(request.getParameter("out_state"));
		inputBean.setCheck_state(request.getParameter("check_state"));
		inputBean.setRepair_detail(request.getParameter("repair_detail"));
		inputBean.setDisorder_repair(request.getParameter("disorder_repair"));

		// System.out.println("order_date_start:"+inputBean.getOrder_date_start());
		// System.out.println("order_date_end:"+inputBean.getOrder_date_end());
		// System.out.println("end_date_start:"+inputBean.getEnd_date_start());
		// System.out.println("end_date_end:"+inputBean.getEnd_date_end());
		// System.out.println("order_id:"+inputBean.getOrder_id());
		// System.out.println("product_code:"+inputBean.getProduct_code());
		// System.out.println("product_name:"+inputBean.getProduct_name());
		// System.out.println("serial_no:"+inputBean.getSerial_no());
		// System.out.println("out_state:"+inputBean.getOut_state());
		// System.out.println("check_state:"+inputBean.getCheck_state());
		// System.out.println("repair_detail:"+inputBean.getRepair_detail());
		// System.out.println("disorder_repair:"+inputBean.getDisorder_repair());
		

		try {
			SearchDB searchDB = new SearchDB();
			resultList = searchDB.Search(inputBean); //Beanに入った検索結果がarraylistに格納されて返ってくる

			// for (SearchBean str : resultList){
			// 	System.out.println("---------------------------");
			// 	System.out.println(str.getOrder_id());
			// 	System.out.println(str.getOrder_date());
			// 	System.out.println(str.getProduct_name());
			// }
			request.setAttribute("resultCount", resultList.size());
			request.setAttribute("resultList", resultList);

			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());
			//エラーページ転送
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/WEB-INF/searchwindow.jsp").forward(request, response);
	}

	/**
	 * ログイン
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//JSPから、ユーザーID、パスワードの取得
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String user_name = "";
		//社員IDの確認
		System.out.println("------------------------");
		System.out.println("user_id:" + user_id);
		System.out.println("password:" + password);

		try{
			Authenicate authenicate = new Authenicate(user_id);
			user_name = authenicate.getUser_name();
			if(!(authenicate.Check(password))){
				System.out.println("false");
				//JSPへのkeyと値をセット
				request.setAttribute("error_msg", authenicate.getError_msg());
				//エラーページ転送
				request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
				return;
			}
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}

		System.out.println("true");
		HttpSession session = request.getSession();//sessionオブジェクト生成
		session.setAttribute("user_name",user_name);
		request.getRequestDispatcher("/WEB-INF/searchwindow.jsp").forward(request, response);

	}

}
