package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_COLOR_BURNPeer;

public class AdminServiceClass {

	public String admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/WEB-INF/view/admin/admin.jsp";

	}

	// 2. 강사계정관리
	public String adminteacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");

		AdminDAO dao = new AdminDAO();

		List<Teacher> tea = dao.admin_1_2_2_1();

		for (int i = 0; i < tea.size(); i++) {
			List<BasicInfo> info = dao.test(tea.get(i).getTeacher_id());

			if (info.size() > 0) {
				tea.get(i).setNoremovebutton(1);
			}

		}
		request.setAttribute("teacher", tea); // 전체 강사 출력

		// (기초정보) 과목 전체

		List<BasicInfo> subjectlist = dao.admin_1_1_1_2();
		request.setAttribute("subjectlist", subjectlist);
		request.setAttribute("code", code);

		return "/WEB-INF/view/admin/adminteacher.jsp";
	}

	// 2. 강사계정관리 - 조회
	public String adminteacher_subject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tea_id = request.getParameter("tea_id");
		AdminDAO dao = new AdminDAO();

		Teacher oneteacherinfo = dao.admin_1_2_2_2(tea_id);
		List<BasicInfo> oneteachercourse = dao.admin_1_2_2_3(tea_id);

		for (BasicInfo info : oneteachercourse) {

			String textbook_name = info.getTextbook_name();
			String filename = dao.textbookFilename(textbook_name);
			info.setTextbook_file(filename);

		}

		request.setAttribute("oneteacherInfo", oneteacherinfo);
		request.setAttribute("oneteachercourse", oneteachercourse);

		return "/WEB-INF/view/admin/adminteacher_subject.jsp";
	}

	// 강사계정관리 - 강사등록
	public String adminteacheradd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String teacher_name = request.getParameter("teacher_name");
		String teacher_ssn = request.getParameter("teacher_ssn");
		String teacher_phone = request.getParameter("teacher_phone");
		String arrayAbleSubject[] = request.getParameterValues("ablesubject");

		Teacher t = new Teacher();
		t.setTeacher_name(teacher_name);
		t.setTeacher_ssn(teacher_ssn);
		t.setTeacher_phone(teacher_phone);
		t.setArrayAbleSubject(arrayAbleSubject);

		int arrayAbleSubjectSize;

		if (arrayAbleSubject == null) {
			arrayAbleSubjectSize = 0;
		} else {

			arrayAbleSubjectSize = t.getArrayAbleSubject().length;

		}

		AdminDAO dao = new AdminDAO();
		String code = dao.admin_1_2_1_0(t, arrayAbleSubjectSize);

		if (code == "101") {
			return "";
		}
		return String.format("/WEB-INF/view/admin/redirect.jsp?url=adminteacher.it&code=%s", code);

	}

	// 강사계정관리- 등록- 기본과목 출력
	public void adminteachesubject2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		String tea_id = request.getParameter("tea_id");
		String tea_name = request.getParameter("tea_name");
		String tea_ssn = request.getParameter("tea_ssn");
		String tea_phone = request.getParameter("tea_phone");
		String ableSubject = request.getParameter("ableSubject"); // 과목명1,과/목/명2,...
		System.out.println("수정티쳐아이디" + tea_id);

		Teacher t = new Teacher();
		t.setTeacher_id(tea_id);
		t.setTeacher_name(tea_name);
		t.setTeacher_ssn(tea_ssn);
		t.setTeacher_phone(tea_phone);
		t.setAbleSubject(ableSubject);

		AdminDAO dao = new AdminDAO();

		// (기초정보) 과목 전체
		List<BasicInfo> albesubject = dao.admin_1_1_1_2();

		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(albesubject));
		out.flush();
		out.close();

	}

	// 강사계정관리- 수정- 기본과목 출력
	public String adminteachesubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tea_id = request.getParameter("tea_id");
		String tea_name = request.getParameter("tea_name");
		String tea_ssn = request.getParameter("tea_ssn");
		String tea_phone = request.getParameter("tea_phone");
		String ableSubject = request.getParameter("ableSubject"); // 과목명1,과/목/명2,...
		System.out.println("수정티쳐아이디" + tea_id);

		Teacher t = new Teacher();
		t.setTeacher_id(tea_id);
		t.setTeacher_name(tea_name);
		t.setTeacher_ssn(tea_ssn);
		t.setTeacher_phone(tea_phone);
		t.setAbleSubject(ableSubject);

		AdminDAO dao = new AdminDAO();

		// (기초정보) 과목 전체
		List<BasicInfo> subjectlist = dao.admin_1_1_1_2();
		List<BasicInfo> noremovesubject = dao.test(tea_id); // tea_id가 강의하는 subject_id

		for (int i = 0; i < subjectlist.size(); i++) { // 2
			String allsubject = subjectlist.get(i).getSubject_id();

			for (int j = 0; j < noremovesubject.size(); j++) {// 6
				String noremove = noremovesubject.get(j).getSubject_id();

				if (allsubject.equals(noremove)) {
					System.out.println("같은항목  :" + j + allsubject + "" + noremove);
					subjectlist.get(i).setNoremovesubject(1);
				}

			}
		}

		for (BasicInfo b : subjectlist) {

			System.out.println(b.getSubject_id() + "" + b.getNoremovesubject());

		}

		/*
		 * * Gson gson = new Gson(); PrintWriter out = response.getWriter();
		 * out.write(gson.toJson(albesubject)); out.flush(); out.close();
		 * 
		 */

		request.setAttribute("tea", t);
		request.setAttribute("subjectlist", subjectlist);

		// request.setAttribute("noremovesubject", noremovesubject);

		return "/WEB-INF/view/admin/admin_teacherupdateform.jsp";

	}

	// 2.강사계정관리 - 수정_submit버튼 클릭
	public String adminteacherupdate_submit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String teacher_id = request.getParameter("teacher_id");
		String teacher_name = request.getParameter("teacher_name");
		String teacher_ssn = request.getParameter("teacher_ssn");
		String teacher_phone = request.getParameter("teacher_phone");
		String subjects[] = request.getParameterValues("subjects");

		Teacher t = new Teacher();
		t.setTeacher_id(teacher_id);
		t.setTeacher_name(teacher_name);
		t.setTeacher_ssn(teacher_ssn);
		t.setTeacher_phone(teacher_phone);

		AdminDAO dao = new AdminDAO();
		String code = dao.admin_1_2_4_2(t, subjects);

		if (code == "101") {
			return "";
		}

		return String.format("/WEB-INF/view/admin/redirect.jsp?url=adminteacher.it&code=%s", code);

	}

	// 2.강사계정관리 - 삭제_submit버튼 클릭

	public String adminteacherDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = 0;
		String teacher_id = request.getParameter("teacher_id");

		AdminDAO dao = new AdminDAO();
		List<BasicInfo> info = dao.ablesubjectcheck(teacher_id);

		if (info.size() != 0) {
			System.out.println("able_subject테이블");
			code = dao.admin_1_2_3_1(teacher_id); // able_subject테이블에서 삭제
		}

		code = dao.admin_1_2_3_2(teacher_id); // teacher테이블에서 삭제

		if (code == 101) {
			return "";
		}

		return String.format("/WEB-INF/view/admin/redirect.jsp?url=adminteacher.it&code=%s", code);

	}

	//////////////////////// 정지인
	public String admin_open_subject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO dao = new AdminDAO();
		List<BasicInfo> courselist = dao.subMethod_1_3_2_1();
		List<BasicInfo> subject_name = dao.subMethod_1_3_4_1();
		List<BasicInfo> textbook = dao.subMethod_1_3_4_2();
		List<BasicInfo> teacher = dao.subMethod_1_3_4_3();
		request.setAttribute("courselist", courselist);
		request.setAttribute("subject_name", subject_name);
		request.setAttribute("textbook", textbook);
		request.setAttribute("teacher", teacher);

		return "/WEB-INF/view/admin/admin_open_subject.jsp";

	}

	public String admin_open_subjectupdateform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String os_id = request.getParameter("os_id");

		AdminDAO dao = new AdminDAO();
		List<BasicInfo> subject_name = dao.subMethod_1_3_4_1();
		List<BasicInfo> textbook = dao.subMethod_1_3_4_2();
		List<BasicInfo> teacher = dao.subMethod_1_3_4_3();
		List<BasicInfo> updatelist = dao.admin_1_5_6_2DAO(os_id);
		request.setAttribute("subject_name", subject_name);
		request.setAttribute("textbook", textbook);
		request.setAttribute("teacher", teacher);
		request.setAttribute("os_id", os_id);
		request.setAttribute("updatelist", updatelist);

		return "/WEB-INF/view/admin/admin_open_subjectupdateform.jsp";

	}

	public String admin_opensubject_subject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oc_id = request.getParameter("oc_id");
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> courselist = dao.subMethod_1_3_2_2(oc_id);
		List<BasicInfo> subjectlist = dao.subMethod_1_3_2_3(oc_id);

		request.setAttribute("courselist", courselist);
		request.setAttribute("subjectlist", subjectlist);

		return "/WEB-INF/view/admin/admin_opensubject_subject.jsp";

	}

	public String admin_open_subjectinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subject_id = request.getParameter("subject_id");
		String os_begin = request.getParameter("os_begin");
		String os_end = request.getParameter("os_end");
		String textbook_id = request.getParameter("textbook_id");
		String teacher_id = request.getParameter("teacher_id");
		String oc_id = request.getParameter("oc_id");

		BasicInfo b = new BasicInfo();
		b.setSubject_id(subject_id);
		b.setOs_begin(os_begin);
		b.setOs_end(os_end);
		b.setTextbook_id(textbook_id);
		b.setTeacher_id(teacher_id);
		b.setOc_id(oc_id);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_3_4_4DAO(b);

		return "/WEB-INF/view/redirect.jsp?url=admin_open_subject.it";
	}

	public String admin_open_subjectupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subject_id = request.getParameter("subject_id");
		String os_begin = request.getParameter("os_begin");
		String os_end = request.getParameter("os_end");
		String textbook_id = request.getParameter("textbook_id");
		String teacher_id = request.getParameter("teacher_id");
		String os_id = request.getParameter("os_id");

		BasicInfo b = new BasicInfo();
		b.setSubject_id(subject_id);
		b.setOs_begin(os_begin);
		b.setOs_end(os_end);
		b.setTextbook_id(textbook_id);
		b.setTeacher_id(teacher_id);
		b.setOs_id(os_id);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_3_4_5DAO(b);

		return "/WEB-INF/view/redirect.jsp?url=admin_open_subject.it";
	}

	public String admin_open_subjectdelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String os_id = request.getParameter("os_id2");
		AdminDAO dao = new AdminDAO();
		dao.admin_1_3_4_6DAO(os_id);

		return "/WEB-INF/view/redirect.jsp?url=admin_open_subject.it";
	}

	public String admin_opencourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> courselist = dao.subMethod_1_3_2_1();
		List<BasicInfo> room = dao.admin_1_3_1_2DAO();
		List<BasicInfo> course = dao.admin_1_3_1_3DAO();

		request.setAttribute("courselist", courselist);
		request.setAttribute("room", room);
		request.setAttribute("course", course);

		return "/WEB-INF/view/admin/admin_opencourse.jsp";

	}

	public String admin_open_courseupdateform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oc_id = request.getParameter("oc_id");
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> room = dao.admin_1_3_1_2DAO();
		List<BasicInfo> course = dao.admin_1_3_1_3DAO();
		List<BasicInfo> updatelist = dao.admin_1_5_6_1DAO(oc_id);

		request.setAttribute("updatelist", updatelist);
		request.setAttribute("room", room);
		request.setAttribute("course", course);
		request.setAttribute("oc_id", oc_id);
		return "/WEB-INF/view/admin/admin_open_courseupdateform.jsp";

	}

	public String admin_opencourseopensubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oc_id = request.getParameter("oc_id");
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> courselist = dao.subMethod_1_3_2_2(oc_id);
		List<BasicInfo> subjectlist = dao.subMethod_1_3_2_3(oc_id);
		List<Student> studentlist = dao.subMethod_1_3_2_4(oc_id);
		request.setAttribute("courselist", courselist);
		request.setAttribute("subjectlist", subjectlist);
		request.setAttribute("studentlist", studentlist);

		return "/WEB-INF/view/admin/admin_opencourseopensubject.jsp";

	}

	public String admin_opencourseinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		String oc_begin = request.getParameter("oc_begin");
		String oc_end = request.getParameter("oc_end");
		String room_id = request.getParameter("room_id");

		BasicInfo b = new BasicInfo();
		b.setCourse_id(course_id);
		b.setOc_begin(oc_begin);
		b.setOc_end(oc_end);
		b.setRoom_id(room_id);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_3_1_1DAO(b);

		return "/WEB-INF/view/redirect.jsp?url=admin_opencourse.it";
	}

	public String admin_opencourseupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oc_id = request.getParameter("oc_id");
		String course_id = request.getParameter("course_id");
		String oc_begin = request.getParameter("oc_begin");
		String oc_end = request.getParameter("oc_end");
		String room_id = request.getParameter("room_id");

		BasicInfo b = new BasicInfo();
		b.setCourse_id(course_id);
		b.setOc_begin(oc_begin);
		b.setOc_end(oc_end);
		b.setRoom_id(room_id);
		b.setOc_id(oc_id);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_3_3_1DAO(b);

		return "/WEB-INF/view/redirect.jsp?url=admin_opencourse.it";
	}

	public String admin_opencoursedelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oc_id = request.getParameter("oc_id2");

		AdminDAO dao = new AdminDAO();
		dao.admin_1_3_3_2DAO(oc_id);

		return "/WEB-INF/view/redirect.jsp?url=admin_opencourse.it";
	}

	public String admin_student(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 寃??湲곕뒫 異붽?
		String key = request.getParameter("key");
		String value = request.getParameter("value");

		if (key == null) {
			// 理쒖큹 ?ㅽ뻾??key, value媛 null???곹깭?대떎.
			// ?꾩껜 異쒕젰??key 媛?吏??
			key = "all";
			value = "";
		}
		AdminDAO dao = new AdminDAO();
		List<Student> studentlist = dao.admin_1_5_2_1(key, value);
		List<BasicInfo> courselist = dao.admin_1_5_5_3DAO();

		request.setAttribute("studentlist", studentlist);
		request.setAttribute("key", key);
		request.setAttribute("value", value);
		request.setAttribute("courselist", courselist);

		return "/WEB-INF/view/admin/admin_student.jsp";

	}

	public String admin_studentindrop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_id = request.getParameter("student_id");
		String oc_id = request.getParameter("oc_id");
		String drop_date = request.getParameter("drop_date");

		Student s = new Student();
		s.setStudent_id(student_id);
		s.setOc_id(oc_id);
		s.setDrop_date(drop_date);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_5_5_4DAO(s);

		return "/WEB-INF/view/redirect.jsp?url=admin_student.it";
	}

	public String admin_studentinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_name = request.getParameter("student_name");
		String student_ssn = request.getParameter("student_ssn");
		String student_phone = request.getParameter("student_phone");

		Student s = new Student();
		s.setStudent_name(student_name);
		s.setStudent_ssn(student_ssn);
		s.setStudent_phone(student_phone);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_5_1_1(s);

		return "/WEB-INF/view/redirect.jsp?url=admin_student.it";
	}

	public String admin_studentupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_name = request.getParameter("student_name");
		String student_hiredate = request.getParameter("student_hiredate");
		String student_phone = request.getParameter("student_phone");
		String student_id = request.getParameter("student_id");

		Student s = new Student();
		s.setStudent_name(student_name);
		s.setStudent_phone(student_phone);
		s.setStudent_hiredate(student_hiredate);
		s.setStudent_id(student_id);
		AdminDAO dao = new AdminDAO();
		dao.admin_1_5_3_1DAO(s);

		return "/WEB-INF/view/redirect.jsp?url=admin_student.it";
	}

	public String admin_studentdelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id2");

		AdminDAO dao = new AdminDAO();
		dao.admin_1_5_4_1DAO(student_id);

		return "/WEB-INF/view/redirect.jsp?url=admin_student.it";
	}

	public String admin_studentcourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id");
		AdminDAO dao = new AdminDAO();
		List<Student> studentinfo = dao.admin_1_5_5_1DAO(student_id);
		List<BasicInfo> studentlist2 = dao.subMethod_1_5_5_2(student_id);

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String nowDate = format.format(now);

		request.setAttribute("studentinfo", studentinfo);
		request.setAttribute("studentlist2", studentlist2);
		request.setAttribute("nowDate", nowDate);
		request.setAttribute("student_id", student_id);
		return "/WEB-INF/view/admin/admin_studentcourse.jsp";

	}

	public String admin_studentcourseinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("st_id");
		String oc_id = request.getParameter("oc_id");

		AdminDAO dao = new AdminDAO();
		Student s = new Student();
		s.setStudent_id(student_id);
		s.setOc_id(oc_id);
		dao.admin_1_5_5_5DAO(s);

		return "/WEB-INF/view/redirect.jsp?url=admin_student.it";
	}

	public String admin_studentcoursedelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id");

		AdminDAO dao = new AdminDAO();
		dao.admin_1_5_5_6DAO(student_id);

		return "/WEB-INF/view/redirect.jsp?url=admin_student.it";
	}

	public String admin_studentupdateform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO dao = new AdminDAO();
		String student_id = request.getParameter("student_id");
		List<Student> studentlist = dao.admin_1_5_6_3DAO(student_id);

		request.setAttribute("student_id", student_id);
		request.setAttribute("studentlist", studentlist);

		return "/WEB-INF/view/admin/admin_studentupdateform.jsp";

	}

	public String admin_studentindropform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id");
		AdminDAO dao = new AdminDAO();

		List<Student> studentlist = dao.admin_1_5_6_4DAO(student_id);
		List<BasicInfo> courselist = dao.admin_1_5_5_3DAO();

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String nowDate = format.format(now);

		request.setAttribute("nowDate", nowDate);
		request.setAttribute("courselist", courselist);
		request.setAttribute("student_id", student_id);
		request.setAttribute("studentlist", studentlist);
		return "/WEB-INF/view/admin/admin_studentindropform.jsp";

	}

	public String admin_studentcourseinsertform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id");
		AdminDAO dao = new AdminDAO();

		List<Student> studentlist = dao.admin_1_5_6_5DAO(student_id);
		List<BasicInfo> courselist = dao.admin_1_5_5_3DAO();
		request.setAttribute("courselist", courselist);
		request.setAttribute("student_id", student_id);
		request.setAttribute("studentlist", studentlist);
		return "/WEB-INF/view/admin/admin_studentcourseinsertform.jsp";

	}

	public String admin_studentcoursedeleteform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id");
		AdminDAO dao = new AdminDAO();

		List<Student> studentlist = dao.admin_1_5_6_6DAO(student_id);
		List<BasicInfo> courselist = dao.admin_1_5_5_3DAO();
		request.setAttribute("courselist", courselist);
		request.setAttribute("student_id", student_id);
		request.setAttribute("studentlist", studentlist);
		return "/WEB-INF/view/admin/admin_studentcoursedeleteform.jsp";

	}

	// 6.성적조회>과정&과목조회 admin_gpasearchform.it 요청주소와 매핑되는 메소드
	public String admin_gpasearch_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO dao = new AdminDAO();
		List<BasicInfo> gpasearch = null;
		gpasearch = dao.admin_gpasearch();
		request.setAttribute("admin_gpasearch_info", gpasearch);
		// gpasearch 이 아이를 admin_gpasearch_info 란 이름으로 호출하겠다.
		// -> admin_gpasearch_info의 메소드를 찾아서 밑의 jsp를 호출

		return "/WEB-INF/view/admin/admin_gpasearchform.jsp";

	}

	// 성적조회>과정&과목조회- 과정조회
	public String admin_ocbasicInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oc_id = request.getParameter("oc_id");

		AdminDAO dao = new AdminDAO();
		List<BasicInfo> basictoplist = dao.adminoc_top(oc_id);
		request.setAttribute("basictoplist", basictoplist);

		List<BasicInfo> subject = dao.admin_ocgpa_Info(oc_id);
		request.setAttribute("subject", subject);

		return "/WEB-INF/view/admin/admin_gpasearch.jsp";

	}

	// 성적조회> 과정&과목조회 - 과목조회-수강생
	public String admin_os_studentInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String os_id = request.getParameter("os_id");

		// System.out.println(os_id);
		AdminDAO dao = new AdminDAO();
		List<ScoreAndGrade> basicoslist = dao.admin_gpabasictop(os_id);
		request.setAttribute("basicoslist", basicoslist);

		List<Student> osstudent = dao.admin_studentgpa_Info(os_id);
		request.setAttribute("osstudent", osstudent);

		// os_id가 Student 자료형에 없기 때문에 ScoreAndGrade 자료형에서 불러오기 위해 임시 변수처리한 후
		List<ScoreAndGrade> os_id2 = dao.admin_gpabasictop(os_id);
		request.setAttribute("os_id2", os_id2);

		return "/WEB-INF/view/admin/admin_subject_gpasearch.jsp";
	}

	// 성적조회>개인성적조회>검색
	public String admin_personal_gpasearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "/WEB-INF/view/admin/admin_personal_gpasearch.jsp";

	}

	// 성적조회>개인성적조회>부분 검색
	public String admin_personal_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> admin_personal_gpa = new ArrayList<Student>();
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		System.out.println(key);
		System.out.println(value);
		AdminDAO dao = new AdminDAO();
		
		
		// st_count가 Student 자료형에 없기 때문에 ScoreAndGrade 자료형에서 불러오기 위해 임시 변수처리한 후
		List<BasicInfo> st_count = dao.subMethod_1_3_2_1();
		request.setAttribute("st_count", st_count);

		admin_personal_gpa = dao.admin_personal_gpa(key, value);
		request.setAttribute("admin_personal_gpa", admin_personal_gpa);

		return "/WEB-INF/view/admin/admin_personal_gpasearch2.jsp";

	}

	// 성적조회>수강생 기본정보조회
	public String admin_studentbasicInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_id = request.getParameter("student_id");
		AdminDAO dao = new AdminDAO();
		List<Student> studentlist = dao.admin_gpastudentInfo(student_id);
		request.setAttribute("studentlist", studentlist);

		List<ScoreAndGrade> st_oclist = dao.admin_student_gpa(student_id);
		request.setAttribute("st_oclist", st_oclist);

		return "/WEB-INF/view/admin/admin_personal_gpasearch3.jsp";

	}

	// 성적조회>수강생 모든 성적(All details of gpaInfo)
	public String admin_studentTotalgpa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_id = request.getParameter("student_id");
		String oc_id = request.getParameter("oc_id");
		AdminDAO dao = new AdminDAO();
		ScoreAndGrade st_end_top = dao.admin_details_of_student(student_id);
		request.setAttribute("st_end_top", st_end_top);

		List<ScoreAndGrade> st_total_gpa = dao.admin_full_details_of_st(student_id, oc_id);
		request.setAttribute("st_total_gpa", st_total_gpa);

		return "/WEB-INF/view/admin/admin_personal_gpasearch4.jsp";
	}

	
	
	//모달창에 교재명 이미지 출력하기
	public String admin_opencourseimageform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String textbook_name = request.getParameter("textbook_name");
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> booklist = dao.admin_1_5_6_7DAO(textbook_name);
		request.setAttribute("booklist", booklist);
		return "/WEB-INF/view/admin/admin_opencourseimageform.jsp";
	}
	public String admin_opensubjectimageform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String textbook_name = request.getParameter("textbook_name");
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> booklist = dao.admin_1_5_6_7DAO(textbook_name);
		request.setAttribute("booklist", booklist);
		return "/WEB-INF/view/admin/admin_opensubjectimageform.jsp";
	}
	
	
	public String admin_teachersubject_imageform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String textbook_name = request.getParameter("textbook_name");
		AdminDAO dao = new AdminDAO();
		List<BasicInfo> booklist = dao.admin_1_5_6_7DAO(textbook_name);
		request.setAttribute("booklist", booklist);
		
		
		return "/WEB-INF/view/admin/admin_teachersubject_imageform.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
