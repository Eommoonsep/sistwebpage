package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

public class StudentServiceClass {

	public String studentmain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * EncodeDecode endecode = new EncodeDecode();
		 * request.setAttribute("endecode", endecode);
		 */

		return "/WEB-INF/view/student/student_main.jsp";

	}

	public String student_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�쁽�옱�씠鍮덈떎.");
		  
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");

		String student_id = info.getId_();

		// String loginid= request.getParameter("student_id");
		// String student_id =
		// EncodeDecode.decode(request.getParameter("student_id"));
		StudentDAO dao = new StudentDAO();
		Student st = dao.studentInfo(student_id);
		request.setAttribute("student_info", st);

		return "/WEB-INF/view/student/student_info.jsp";

	}

	public String student_score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String student_id = info.getId_();
		System.out.println(student_id);
		
		StudentDAO dao = new StudentDAO();
		List<BasicInfo> studentcourselist = dao.studentCourseList(student_id);
		request.setAttribute("studentcourselist", studentcourselist);

		return "/WEB-INF/view/student/student_score.jsp";

	}

	public String student_subject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String st_id = info.getId_();
		String oc_id = request.getParameter("oc_id");
		StudentDAO dao = new StudentDAO();
		List<ScoreAndGrade> studentScoreList = dao.studentScoreList(oc_id, st_id);

		for (ScoreAndGrade st : studentScoreList) {

			String textbook_name = st.getTextbook_name();
			
			if(textbook_name == null){
				String filename = "";
			} else {
				String filename = dao.textbookFilename(textbook_name);
				st.setTextbook_filename(filename);
			}

		}

		
		
		request.setAttribute("studentScoreList", studentScoreList);

		return "/WEB-INF/view/student/student_subject.jsp";

	}

	public String studentpasswordupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String student_id = info.getId_();
		System.out.println("�삉寃��궗:"+student_id);
		String pw = request.getParameter("pw");	//�쁽�옱鍮꾨�踰덊샇
		String newpw = request.getParameter("newpw");	//�깉 鍮꾨�踰덊샇
		
		System.out.println("�쁽鍮꾨�:"+pw + "�깉鍮꾨�:"+newpw);
		StudentDAO dao = new StudentDAO();
		
		int code = dao.studentpasswordupdate(student_id, pw, newpw);
		System.out.println(code);
		
		if(code == 0){
			return "";
		}
		
		
		return String.format("/WEB-INF/view/student/redirect.jsp?url=student_info.it&code=%s", code);

	}

	public String studentinfoupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_id = request.getParameter("student_id");
		String phone = request.getParameter("phone");

		StudentDAO dao = new StudentDAO();
		int code = dao.stduentInfoUpdate(student_id, phone);

		if (code == 0) {
			return "";
		}
		request.setAttribute("student_id", student_id);
		request.setAttribute("code", code);
		// request.setAttribute("student_id", student_id);
		return String.format("/WEB-INF/view/student/redirect.jsp?url=student_info.it&code=%s", code);

	}

}
