package upandups;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.UserDetailDAO;

/**
 * Servlet implementation class User_create
 */
@WebServlet("/User_create")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class User_create extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(UauHelper.USER_CREATE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// フォームの値を変数に代入
		request.setCharacterEncoding("UTF-8");
		String login_id = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String affiliation_form = request.getParameter("affiliation_form");
		String birth_date = request.getParameter("birth_date");
		String birth_place_id = request.getParameter("birth_place_id");
		String blood_type = request.getParameter("blood_type");
		String vocal_range_id = request.getParameter("vocal_range");
		String special_skill = request.getParameter("special_skill");
		String hobby = request.getParameter("hobby");
		String license = request.getParameter("license");
		String twitter_url = request.getParameter("twitter_url");
		String twitter_id = request.getParameter("twitter_id");
		String filmographies_anime = request.getParameter("filmographies_anime");
		String filmographies_film = request.getParameter("filmographies_film");
		String filmographies_narration = request.getParameter("filmographies_narration");
		String filmographies_other = request.getParameter("filmographies_other");
		String create_pass = request.getParameter("create_pass");

		// パスワードを暗号化
		String passMD5 = Util.convertToMD5(password);
		String passCheckMD5 = Util.convertToMD5(passwordCheck);
		String cPassMD5 = Util.convertToMD5(create_pass);

		System.out.println(cPassMD5);

		// 画像をアップロード
		Part part = request.getPart("photo");
		String photo_name = this.getFileName(part);
		part.write(getServletContext().getRealPath("/WebContent/uploaded") + "/" + photo_name);
		response.sendRedirect("User_list");

		// 値をDAOに渡してDBに登録
		UserDetailDAO.createUser(
				login_id
				, passMD5
				, passCheckMD5
				, name
				, sex
				, photo_url
				, affiliation_form
				, birth_date
				, birth_place_id
				, blood_type
				, vocal_range_id
				, special_skill
				, hobby
				, license
				, twitter_url
				, twitter_id
				, filmographies_anime
				, filmographies_film
				, filmographies_narration
				, filmographies_other
				, cPassMD5
				);

	}

	private String getFileName(Part part) {
		String name = null;
		for(String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if(dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
                break;
			}
		}
		return name;
	}

}
