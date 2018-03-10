package upandups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PrefecturesDataBeans;
import beans.UserDetailDataBeans;
import beans.VocalRangeDataBeans;
import dao.PrefecturesDAO;
import dao.UserDetailDAO;
import dao.VocalRangeDAO;

/**
 * Servlet implementation class User_update
 */
@WebServlet("/User_update")
public class User_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストスコープからidの値を取得
		String id = request.getParameter("id");

		// idの値を元にユーザ詳細データを取得
		UserDetailDataBeans uddb = UserDetailDAO.getUserDetailDataBeansListById(Integer.parseInt(id));
		ArrayList<PrefecturesDataBeans> pdbList = PrefecturesDAO.getPrefecturesDataBeansAll();
		ArrayList<VocalRangeDataBeans> vrdbList = VocalRangeDAO.getVocalRangeDataBeansAll();
		request.setAttribute("vrdbList", vrdbList);
		request.setAttribute("pdbList", pdbList);
		request.setAttribute("uddb", uddb);
		request.getRequestDispatcher(UauHelper.USER_UPDATE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
