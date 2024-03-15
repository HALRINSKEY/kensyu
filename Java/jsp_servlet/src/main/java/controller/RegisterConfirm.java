package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemBean;

/**
 * Servlet implementation class RegisterConfirm
 */
@WebServlet("/RegisterConfirm")
public class RegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//requestオブジェクトからパラメータを取得
		String itemID = request.getParameter("itemID");
		String itemName = request.getParameter("itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));

		//コンソール表示
		System.out.println("商品ID:商品名:価格:");
		System.out.println(itemID+":"+itemName+":"+itemPrice+"円");

		//商品オブジェクトの生成
		ItemBean itemBean = new ItemBean(itemID, itemName, itemPrice);
		
		//requestにセット
		//request.setAttribute("itemBean", itemBean);

		//sessionの取得
		HttpSession seession = request.getSession();
		//seessionに商品オブジェクトをセット
		seession.setAttribute("itemBean", itemBean);

		//ページの転送
        request.getRequestDispatcher("/WEB-INF/RegisterConfirm.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
