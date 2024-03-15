package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberBean;
import model.MemberLogic;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//JSPから、社員IDの取得
		String member_id = request.getParameter("member_id");
		//社員IDの確認
		System.out.println("member_id:" + member_id);
		//社員ロジック初期化
		MemberLogic memberLogic = new MemberLogic();
		//リストインスタンス化
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();

		try{
			if(member_id.equals("all")){
				memberList = memberLogic.getAllMember();
			}else{
				MemberBean memberBean = memberLogic.getMember(member_id);
				//社員Beanの存在を確認
				if(memberBean.getMember_id() == null) {
					//JSPへのkeyと値をセット
					request.setAttribute("error_msg", "社員IDが存在しません");
					//エラーページ転送
					request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
					return;
				}
				memberList.add(memberBean);
			}
			//JSPへのkeyと値セット
			request.setAttribute("memberList", memberList);

		}catch(IllegalArgumentException e) {
			//JSPへのkeyと値をセット
			request.setAttribute("error_msg", e.getMessage());
			//エラーページ転送
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;

		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		request.getRequestDispatcher("/WEB-INF/member.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
