package upandups;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDetailDataBeans;
import dao.UserDetailDAO;

/**
 * Servlet implementation class Talent_detail
 */
@WebServlet("/Talent_detail")
public class Talent_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Talent_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// スコープのidから情報を取得して変数に代入
		String id = request.getParameter("id");

		// idを元にTalent_detailに必要な情報を取得
		UserDetailDataBeans uddb = UserDetailDAO.getUserDetailDataBeansListById(Integer.parseInt(id));

		// リクエストスコープに取得したデータをセットし、タレント詳細画面にフォワード
		request.setAttribute("uddb", uddb);
		request.getRequestDispatcher(UauHelper.TALENT_DETAIL_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
