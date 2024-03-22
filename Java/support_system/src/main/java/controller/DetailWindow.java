package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SearchBean;
import model.SearchDB;


/**
 * Servlet implementation class DetailWindow
 */
@WebServlet("/DetailWindow")
public class DetailWindow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailWindow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchBean detailBean = new SearchBean();
		SearchDB sd = new SearchDB();

		try {
			detailBean = sd.SelectDate(request.getParameter("order_id"));
			request.setAttribute("detailBean", detailBean);
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());
			//エラーページ転送
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/WEB-INF/detailwindow.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
