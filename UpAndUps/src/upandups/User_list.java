package upandups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class User_list
 */
@WebServlet("/User_list")
public class User_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションが空の場合、ログイン画面に変遷
		HttpSession session = request.getSession();
		if(session.getAttribute("login_udb") == null) {
			response.sendRedirect("Login");
			return;
		}

		// 全ユーザ情報を取得してリクエストスコープにセット
		ArrayList<UserDataBeans> udbList = UserDAO.getUserDataBeansFindAll();
		request.setAttribute("udbList", udbList);

		//ユーザ一覧にフォワード
		request.getRequestDispatcher(UauHelper.USER_LIST_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォームから値を取得して、DAOでユーザデータを検索
		request.setCharacterEncoding("UTF-8");
		String search_word = request.getParameter("search_word");
		ArrayList<UserDataBeans> udbList = UserDAO.getUserDataBeansByName(search_word);
		request.setAttribute("udbList", udbList);

		// ユーザ一覧にフォワード
		request.getRequestDispatcher(UauHelper.USER_LIST_PAGE).forward(request, response);

	}

}
