package com.test;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
 

public class LoginServiceClass {
	public String loginmain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/WEB-INF/view/loginmain.jsp";

	}

	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/WEB-INF/view/login.jsp";

	}

	public String loginsubmit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		String loginselect = request.getParameter("loginselect");
		String id_ = request.getParameter("id_");
		String pw = request.getParameter("pw");
	
		 
		System.out.println(loginselect + id_ + pw);

		String url = "loginfail.it";
		if (id_ == null || id_.equals("")) {

		} else {

			LoginInfo result = null;
			LoginDAO dao = new LoginDAO();

			if (loginselect.equals("0")) {
				  result = dao.loginAdmin(id_, pw);

			}
			if (loginselect.equals("1")) {
				  result = dao.loginTeacher(id_, pw);

			}
			if (loginselect.equals("2")) {
				  result = dao.loginStudent(id_, pw);

			}

		 

			if (result instanceof LoginInfo) {
				session = request.getSession();
				session.setAttribute("logininfo", result);
				

				if (result.getId_().contains("admin")) {
					url = "admin.it";

				}
				if (result.getId_().contains("tea")) {
					url = "teacher.it";

				}
				if (result.getId_().startsWith("st")) {
					url = "studentmain.it";

				}
			}

		}
		System.out.println(url);
		return String.format("/WEB-INF/view/redirect.jsp?url=%s&code=000", url);

	}

	// "logout.it"
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("logout", "");
		
		return String.format("/WEB-INF/view/redirect.jsp?url=logoutform.it");

	}

	// "loginfail.it"
	public String loginfail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/WEB-INF/view/loginfail2.jsp";

	}

	// "logoutform.it"
	public String logoutform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/WEB-INF/view/logoutform.jsp";

	}
}