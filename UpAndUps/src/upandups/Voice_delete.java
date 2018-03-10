package upandups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.VoiceSampleDataBeans;
import dao.VoiceSampleDAO;

/**
 * Servlet implementation class Voice_delete
 */
@WebServlet("/Voice_delete")
public class Voice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voice_delete() {
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

		String id = request.getParameter("id");

		// idを元にボイスサンプルのタイトルを取得
		VoiceSampleDataBeans vsdb = VoiceSampleDAO.getVoiceSampleDataBeansById(Integer.parseInt(id));

		request.setAttribute("vsdb", vsdb);
		request.getRequestDispatcher(UauHelper.VOICE_DELETE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String user_id = request.getParameter("user_id");

		// idを元に対象のボイスサンプルを削除
		boolean delete = VoiceSampleDAO.deleteVoiceSampleData(Integer.parseInt(id));

		// フォワードの準備
		// user_idを元にボイスデータを取得
		ArrayList<VoiceSampleDataBeans> vsdbList = VoiceSampleDAO.getVoiceSampleDataBeansByUserId(Integer.parseInt(user_id));
		request.setAttribute("vsdbList", vsdbList);

		// 登録用にidの値を返す
		request.setAttribute("id", user_id);

		if(!delete) {
			request.setAttribute("errMsg", "削除に失敗しました。管理者にお問い合わせください。");
			request.getRequestDispatcher(UauHelper.VOICE_UPDATE_PAGE).forward(request, response);
		} else {
			request.getRequestDispatcher(UauHelper.VOICE_UPDATE_PAGE).forward(request, response);
		}

	}

}
