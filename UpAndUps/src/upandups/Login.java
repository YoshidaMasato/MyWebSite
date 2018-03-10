package upandups;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションにログイン情報がある場合、ユーザ一覧画面に遷移
		HttpSession session = request.getSession();
		if(session.getAttribute("login_udb") != null) {
			response.sendRedirect("User_list");
			return;
		}
		request.getRequestDispatcher(UauHelper.LOGIN_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォームに入力された値を変数に代入
		String login_id = request.getParameter("InputLoginId");
		String password = request.getParameter("InputPassword");

		// パスワードを暗号化
		String passMD5 = Util.convertToMD5(password);

		System.out.println(login_id);
		System.out.println(passMD5);

		// 入力された値を元にDBでユーザ検索し、ユーザ情報を取得
		UserDataBeans udb = UserDAO.getUserDataBeansByLoginId(login_id,passMD5);

		if(udb == null) {
			// DAOからnullが返ってきたらログイン失敗
			request.setAttribute("errMsg", "ログインIDまたはパスワードが間違っています");
			request.getRequestDispatcher(UauHelper.LOGIN_PAGE).forward(request, response);
		} else {
			// ユーザ情報をセッションスコープにセットしてユーザ一覧に遷移
			HttpSession session = request.getSession();
			session.setAttribute("login_udb", udb);
			response.sendRedirect("User_list");
		}
	}

}
