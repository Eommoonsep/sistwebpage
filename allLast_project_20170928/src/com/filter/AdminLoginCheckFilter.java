package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.test.LoginInfo;

public class AdminLoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		boolean login = false;

		// 로그인 페이지 유효화
		String command = httpRequest.getRequestURI();
		command = command.substring(httpRequest.getContextPath().length());
		command = command.substring(1, command.indexOf(".it"));

		if (command.startsWith("login")) {
			// 로그인 사용자 인증을 위한 값 저장
			login = true;
		}

		if (session != null) {

			if (session.getAttribute("logininfo") != null) {

				// 관리자 확인
				if (((LoginInfo) session.getAttribute("logininfo")).getGrade() == 0) {
					login = true;
				}
				// 관리자 확인
				if (((LoginInfo) session.getAttribute("logininfo")).getGrade() == 1) {
					login = true;
				}
				// 관리자 확인
				if (((LoginInfo) session.getAttribute("logininfo")).getGrade() == 2) {
					login = true;
				}

			}
		}

		if (login) {
			chain.doFilter(request, response);
		} else {

			RequestDispatcher dispatcher = null;
			if (session.getAttribute("logout") != null) {
				request.getRequestDispatcher("/WEB-INF/view/redirect.jsp?url=loginfail.it");
			} else {
				request.getRequestDispatcher("/WEB-INF/view/redirect.jsp?url=logout.it");
			}

			// RequestDispatcher dispatcher =
			// request.getRequestDispatcher("/WEB-INF/view/redirect.jsp?url=loginfail.it");
			
			dispatcher.forward(request, response);
		
		}
	}

	@Override
	public void destroy() {
	}
}