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
 * Servlet implementation class User_delete
 */
@WebServlet("/User_delete")
public class User_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションが空の場合、ログイン画面に遷移
		HttpSession session = request.getSession();
		if(session.getAttribute("login_udb") == null) {
			response.sendRedirect("Login");
			return;
		}

		// URLが直接叩かれた場合、ログイン画面に遷移
		if(request.getParameter("id") == null) {
			response.sendRedirect("Login");
			return;
		}

		// id情報を取得して、それを元にuserを取得
		String id = request.getParameter("id");
		UserDataBeans udb = UserDAO.getUserDataBeansById(Integer.parseInt(id));
		request.setAttribute("udb", udb);

		request.getRequestDispatcher(UauHelper.USER_DELETE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean delete = UserDAO.deleteUserById(Integer.parseInt(id));

		if(!delete) {
			// エラーメッセージを格納
			request.setAttribute("errMsg", "削除に失敗しました。管理者にお問い合わせください。");

			// 全ユーザ情報を取得してリクエストスコープにセット
			ArrayList<UserDataBeans> udbList = UserDAO.getUserDataBeansFindAll();
			request.setAttribute("udbList", udbList);

			//ユーザ一覧にフォワード
			request.getRequestDispatcher(UauHelper.USER_LIST_PAGE).forward(request, response);
		} else {
			response.sendRedirect("User_list");
		}
	}

}
