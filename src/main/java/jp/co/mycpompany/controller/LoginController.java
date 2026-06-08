package jp.co.mycpompany.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.mycpompany.dto.UserDTO;
import jp.co.mycpompany.service.AuthenticateService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jspPath = "/WEB-INF/common/login.jsp";
		request.getRequestDispatcher(jspPath).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//処理成功時の遷移先で初期
		String jspPath = "/WEB-INF/common/main.jsp";
		try {

			//認証の業務処理クラス
			AuthenticateService service = new AuthenticateService();

			//画面からのパラメータの取り出し
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

			//業務処理の実行
			UserDTO user = service.execute(userId, password);

			//実行結果による遷移先の制御
			if (user == null) {
				//エラーならログイン画面に戻って再実行
				request.setAttribute("errorMessage", "ユーザID・パスワードが間違っています");
				jspPath = "/WEB-INF/common/login.jsp";
			}

		} catch (Exception e) {
			//致命的エラーの場合アプリケーションの続行はできないのでエラー専用ページに遷移
			throw new ServletException(e.getCause());
		}
		request.getRequestDispatcher(jspPath).forward(request, response);
	}

}
