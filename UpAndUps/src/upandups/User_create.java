package upandups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.PrefecturesDataBeans;
import beans.UserDataBeans;
import beans.UserDetailDataBeans;
import beans.VocalRangeDataBeans;
import dao.PrefecturesDAO;
import dao.UserDAO;
import dao.UserDetailDAO;
import dao.VocalRangeDAO;

/**
 * Servlet implementation class User_create
 */
@WebServlet("/User_create")
@MultipartConfig(location="/C:\\Users\\s9922\\Documents\\MyWebSite\\UpAndUps\\WebContent\\uploaded", maxFileSize=10485760)
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
		// prefecturesテーブルのリストを取得してスコープにセット
		ArrayList<PrefecturesDataBeans> pdbList = PrefecturesDAO.getPrefecturesDataBeansAll();
		request.setAttribute("pdbList", pdbList);

		// vocal_rangeテーブルのリストを取得してスコープにセット
		ArrayList<VocalRangeDataBeans> vrdbList = VocalRangeDAO.getVocalRangeDataBeansAll();
		request.setAttribute("vrdbList", vrdbList);

		// フォワード
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
		String blood_type = request.getParameter("bloodtype");
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
		String photo_name = null;
		if(part.getSize() > 0) {
			photo_name = this.getFileName(part);
			part.write(photo_name);
		} else {
			photo_name = null;
		}

		// 値をDAOに渡してDBに登録
		boolean create = UserDetailDAO.createUser(
				login_id
				, passMD5
				, passCheckMD5
				, name
				, sex
				, photo_name
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

		if(!create) {
			request.setAttribute("errMsg", "入力された内容が正しくないか、未入力の必須項目があります。");

			// 入力されていた値をBeansにセット
			UserDataBeans udb = new UserDataBeans();
			udb.setLogin_id(login_id);
			udb.setName(name);

			UserDetailDataBeans uddb = new UserDetailDataBeans();
			uddb.setSex(sex);
			uddb.setAffiliation_form(affiliation_form);
			uddb.setBirth_date(birth_date);
			uddb.setBirth_place_id(Integer.parseInt(birth_place_id));
			uddb.setBlood_type(blood_type);
			uddb.setVocal_range_id(Integer.parseInt(vocal_range_id));
			uddb.setSpecial_skill(special_skill);
			uddb.setHobby(hobby);
			uddb.setLicense(license);
			uddb.setTwitter_url(twitter_url);
			uddb.setTwitter_id(twitter_id);
			uddb.setFilmographies_anime(filmographies_anime);
			uddb.setFilmographies_film(filmographies_film);
			uddb.setFilmographies_narration(filmographies_narration);
			uddb.setFilmographies_other(filmographies_other);

			// prefecturesテーブルのリストを取得してスコープにセット
			ArrayList<PrefecturesDataBeans> pdbList = PrefecturesDAO.getPrefecturesDataBeansAll();
			request.setAttribute("pdbList", pdbList);

			// vocal_rangeテーブルのリストを取得してスコープにセット
			ArrayList<VocalRangeDataBeans> vrdbList = VocalRangeDAO.getVocalRangeDataBeansAll();
			request.setAttribute("vrdbList", vrdbList);

			request.setAttribute("udb", udb);
			request.setAttribute("uddb", uddb);
			request.getRequestDispatcher(UauHelper.USER_CREATE_PAGE).forward(request, response);
		} else {
			// 入力された値を元にDBでユーザ検索し、ユーザ情報を取得
			UserDataBeans udb = UserDAO.getUserDataBeansByLoginId(login_id,passMD5);

			//ユーザ情報をセッションスコープにセットしてユーザ一覧にリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("login_udb", udb);
			response.sendRedirect("User_list");
		}

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
