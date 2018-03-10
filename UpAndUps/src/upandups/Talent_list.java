package upandups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDetailDataBeans;
import dao.UserDetailDAO;

/**
 * Servlet implementation class Talent_list
 */
@WebServlet("/Talent_list")
public class Talent_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Talent_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URLが直接叩かれた場合、ホーム画面に遷移
		if(request.getParameter("sex") == null) {
			response.sendRedirect("Index");
			return;
		}

		// リクエストスコープにあるsex情報を取得
		String sex = request.getParameter("sex");

		// sex情報を元にDAOでuddbListを取得
		ArrayList<UserDetailDataBeans> uddbList = UserDetailDAO.getUserDetailDataBeansListBySex(sex);
		request.setAttribute("uddbList", uddbList);

		request.getRequestDispatcher(UauHelper.TALENT_LIST_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 検索フォームのワードを元に部分一致検索
		request.setCharacterEncoding("UTF-8");
		String search_word = request.getParameter("search_word");
		ArrayList<UserDetailDataBeans> uddbList = UserDetailDAO.getUserDetailDataBeansByName(search_word);
		request.setAttribute("uddbList", uddbList);

		request.getRequestDispatcher(UauHelper.TALENT_LIST_PAGE).forward(request, response);

	}

}
