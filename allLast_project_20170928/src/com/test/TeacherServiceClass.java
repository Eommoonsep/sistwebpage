package com.test;

import java.io.IOException;
import java.util.List;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeacherServiceClass {
	
	private TeacherDAO dao = null;
	
	public TeacherServiceClass() {
		this.dao = new TeacherDAO();
	}

	public String teacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		return "/WEB-INF/view/teacher/teacher.jsp";

	}
	
	//2. 강사 개인정보 확인
	public String teacher_teachercheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String teacher_id = info.getId_();

		TeacherDAO dao = new TeacherDAO();
		List<Teacher> teacher_teachercheck = dao.TeacherList(teacher_id);
		request.setAttribute("teacher_teachercheck", teacher_teachercheck);

		
		return "/WEB-INF/view/teacher/teacher_teachercheck.jsp";

	}
	
	public String teacher_teacher1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String teacher_id = info.getId_();
		
		TeacherDAO dao = new TeacherDAO();
		List<BasicInfo> ScheduleList = dao.courseScheduleList("1",teacher_id);
		request.setAttribute("ScheduleList", ScheduleList);
		return "/WEB-INF/view/teacher/teacher_teacher1.jsp";

	}
	
	
	
	
	public String teacher_teacher2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String teacher_id = info.getId_();
		
		TeacherDAO dao = new TeacherDAO();
		List<BasicInfo> ScheduleList = dao.courseScheduleList("2",teacher_id);
		request.setAttribute("ScheduleList", ScheduleList);
		return "/WEB-INF/view/teacher/teacher_teacher2.jsp";

	}
	
	public String teacher_teacher3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String teacher_id = info.getId_();		
		TeacherDAO dao = new TeacherDAO();
		List<BasicInfo> ScheduleList = dao.courseScheduleList("3",teacher_id);
		request.setAttribute("ScheduleList", ScheduleList);
		return "/WEB-INF/view/teacher/teacher_teacher3.jsp";
	}	
	
	public String teacher_bajam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String teacher_id = info.getId_();
		
		TeacherDAO dao = new TeacherDAO();
		//로그인 해서 세션에 값 저장한 것을 불러오면 필요 없어지는 코드
		
		List<ScoreAndGrade> ScoreManagingList1 = dao.scoreManagingList1("teacher", teacher_id);
		request.setAttribute("ScoreManagingList1", ScoreManagingList1);		
		
		

		return "/WEB-INF/view/teacher/teacher_bajam.jsp";

	}
	
	/*<c:forEach var="t" items="${ScoreList2}">*/
	//성적관리 ->
	public String teacher_grade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
		String teacher_id = info.getId_();
		
		TeacherDAO dao = new TeacherDAO();
		List<ScoreAndGrade> ScoreList2 = dao.scoreList2(teacher_id);
		request.setAttribute("ScoreList2", ScoreList2);

		return "/WEB-INF/view/teacher/teacher_grade.jsp";

	}
	
	
	
	//성적 조회 ->
	public String teacher_subject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		TeacherDAO dao = new TeacherDAO();
		
	
		String os_id = request.getParameter("os_id");
			
		
		
		
		List<Student> ScoreManagingList3 = dao.scoreManagingList3(os_id);
		
		
		request.setAttribute("ScoreManagingList3", ScoreManagingList3);
		
		return "/WEB-INF/view/teacher/teacher_subject.jsp";

	}	
	
	// 성적관리 -> 성적입력
		public String teacher_subjectInsert(HttpServletRequest request, HttpServletResponse response) {
			String code = "000";
			String result = "";

			/*
			 * assigned_attendance, assigned_written, assigned_performance, exam_date,
			 * exam_file, openedSubject_id
			 */
			String os_id = request.getParameter("subject_id");
			//나에게 submit을 날린 폼 태그에서 name 식별자명이 student_id인 태그의 값을 가져오겠다.
			String st_id = request.getParameter("student_id");
			Student st = new Student();
			st.setGrade_attend(Integer.parseInt(request.getParameter("grade_attend")));
			st.setGrade_written(Integer.parseInt(request.getParameter("grade_written")));
			st.setGrade_practice(Integer.parseInt(request.getParameter("grade_practice")));
			System.out.println(os_id);
			System.out.println(st_id);
			result = this.dao.scoreManagingInsert(os_id, st_id, st);

			
			/*
			if (result > 0) {
				code = "400";
			} else {
				code = "401";
			}*/

			return String.format("/WEB-INF/view/redirect.jsp?url=teacher_grade.it&code=%s", code);
		}
	
	//강사 스케줄 조회 - > 조회 -> 수강생 조회 ->
	public String teacher_schedulesubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TeacherDAO dao = new TeacherDAO();
		
		
		String os_id = request.getParameter("os_id");
		
		
		List<Student> ScoreManagingList4 = dao.scoreManagingList4(os_id);
		
		
		request.setAttribute("ScoreManagingList4", ScoreManagingList4);
		
		return "/WEB-INF/view/teacher/teacher_schedulesubject.jsp";

	}
	
	
	
	// 배점관리 -> 과목선택에 과목배점 삭제
	public String teachergradedelete(HttpServletRequest request, HttpServletResponse response) {
		String code = "000";
		int result = 0;

		BasicInfo bi = new BasicInfo();
		bi.setOs_id(request.getParameter("os_id"));
		
		result = this.dao.teachergradedelete(bi);

		if (result > 0) {
			code = "100";
		} else {
			code = "101";
		}
		return String.format("/WEB-INF/view/redirect.jsp?url=teacher_bajam.it&code=%s", code);
	}		
		
	

	// 강사 패스워드 수정
	public String teacherpwmodify(HttpServletRequest request, HttpServletResponse response) {

		Teacher tea = new Teacher();
		String code = "000";

		tea.setTeacher_id(request.getParameter("teacher_id"));
		tea.setTeacher_ssn(request.getParameter("teacher_ssn")); //ssn -> 비밀번호

		int result = this.dao.teacherPwUpdate(tea);
		// student_ssn student_name student_phone_number
		if (result > 0) {
			code = "200";
		} else {
			code = "201";
		}

		return String.format("/WEB-INF/view/redirect.jsp?url=teacher_teachercheck.it&code=%s", code);
	}

	
	// 강사 기본정보 수정
	public String teachermodify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = "000";
		Teacher tea = new Teacher();
		tea.setTeacher_name(request.getParameter("teacher_name"));
		tea.setTeacher_ssn(request.getParameter("teacher_ssn"));
		tea.setTeacher_phone(request.getParameter("teacher_phone"));
		tea.setTeacher_id(request.getParameter("teacher_id"));
		
		
		int result = this.dao.teacherUpdate(tea);
		if (result > 0) {
			code = "100";
		} else {
			code = "101";
		}

		return String.format("/WEB-INF/view/redirect.jsp?url=teacher_teachercheck.it&code=%s", code);

	}	
	

	// 배점관리 -> 성적입력
	public String teacher_subjectbajam(HttpServletRequest request, HttpServletResponse response) {
		String code = "000";
		int result = 0;

		BasicInfo bi = new BasicInfo();
		bi.setSc_attend(Integer.parseInt(request.getParameter("sc_attend")));
		bi.setSc_written(Integer.parseInt(request.getParameter("sc_written")));
		bi.setSc_practice(Integer.parseInt(request.getParameter("sc_practice")));
		bi.setEx_qs(request.getParameter("ex_qs"));
		bi.setEx_date(request.getParameter("ex_date"));
		bi.setOs_id(request.getParameter("os_id"));
		
		result = this.dao.teacherbajamInsert(bi);

		if (result > 0) {
			code = "100";
		} else {
			code = "101";
		}

		return String.format("/WEB-INF/view/redirect.jsp?url=teacher_bajam.it&code=%s", code);
	}

	// 성적삭제
	public String teacherscoreclear(HttpServletRequest request, HttpServletResponse response) {
		String code = "000";
		String os_id = request.getParameter("os_id");
		String student_id = request.getParameter("student_id");

		int result = this.dao.teacherscoredelete(os_id, student_id);
		if (result > 0) {
			code = "500";
		} else {
			code = "501";
		}
		return String.format("/WEB-INF/view/redirect.jsp?url=teacherscores.do&code=%s", code);
	}	
	
	
	
	
	
	// 과목삭제
	public String teachersubjectdelete(HttpServletRequest request, HttpServletResponse response) {
		String code = "000";
		String teacher_id = request.getParameter("teacher_id");
		String os_id = request.getParameter("os_id");

		int result = this.dao.teacherscoredelete(teacher_id, os_id);
		if (result > 0) {
			code = "500";
		} else {
			code = "501";
		}
		return String.format("/WEB-INF/view/redirect.jsp?url=teacher_bajam.it&code=%s", code);
	}	
	
		
	// 교재 이미지 출력 
	public String teacher_opensubjectimageform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String textbook_name = request.getParameter("textbook_name");
		TeacherDAO dao = new TeacherDAO();
		List<BasicInfo> booklist = dao.teacher_opensubjectimage(textbook_name);
		request.setAttribute("booklist", booklist);
		return "/WEB-INF/view/teacher/teacher_opensubjectimageform.jsp";
	}	
	

}