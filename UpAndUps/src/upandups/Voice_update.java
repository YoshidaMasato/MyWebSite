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

import beans.VoiceSampleDataBeans;
import dao.VoiceSampleDAO;

/**
 * Servlet implementation class Voice_update
 */
@WebServlet("/Voice_update")
@MultipartConfig(location="/C:\\Users\\s9922\\Documents\\MyWebSite\\UpAndUps\\WebContent\\uploaded", maxFileSize=104857600)
public class Voice_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voice_update() {
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

		// スコープのidにある値を受け取ってボイスデータを取得
		String id = request.getParameter("id");
		ArrayList<VoiceSampleDataBeans> vsdbList = VoiceSampleDAO.getVoiceSampleDataBeansByUserId(Integer.parseInt(id));
		request.setAttribute("vsdbList", vsdbList);

		// 登録用にidの値を返す
		request.setAttribute("id", id);

		// フォワード
		request.getRequestDispatcher(UauHelper.VOICE_UPDATE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォームから受け取り
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("vsTitle");
		String id = request.getParameter("id");

		// 音声データをアップロード
		Part part = request.getPart("voicesample");
		String vs_name = null;
		if(part.getSize() > 0) {
			vs_name = this.getFileName(part);
			part.write(vs_name);
		} else {
			vs_name = null;
		}

		// DBに登録
		boolean voice_update = VoiceSampleDAO.createVoiceSampleData(Integer.parseInt(id), title, vs_name);

		// ページ一覧表示用に、idにある値を受け取ってボイスデータを取得
		ArrayList<VoiceSampleDataBeans> vsdbList = VoiceSampleDAO.getVoiceSampleDataBeansByUserId(Integer.parseInt(id));
		request.setAttribute("vsdbList", vsdbList);

		// 登録用にidの値を返す
		request.setAttribute("id", id);

		// falseならエラーメッセージを格納して戻す
		if(!voice_update) {
			request.setAttribute("errMsg", "アップロードに失敗しました。");
			request.getRequestDispatcher(UauHelper.VOICE_UPDATE_PAGE).forward(request, response);
		} else {
			request.getRequestDispatcher(UauHelper.VOICE_UPDATE_PAGE).forward(request, response);
		}
	}

	// アップロードファイルのファイルネームを取得
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
