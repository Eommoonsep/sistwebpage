package com.test;

import java.util.*;
import java.sql.*;

public class TeacherDAO {

	public List<Teacher> TeacherList(String tea_id) {
		List<Teacher> result = new ArrayList<Teacher>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_teacher_view AS SELECT teacher_id, teacher_name,
			 * teacher_ssn, teacher_phone ,(SELECT LISTAGG(CAST(subject_name AS
			 * VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY subject_name) FROM subject sj,
			 * able_subject asj WHERE sj.subject_id = asj.subject_id AND teacher_id =
			 * te.teacher_id) AS able_subject , teacher_hiredate FROM teacher te;
			 */

			String sql = "SELECT teacher_id, teacher_name, teacher_ssn, teacher_phone, able_subject, TO_CHAR(teacher_hiredate, 'YYYY-MM-DD') AS teacher_hiredate FROM admin_teacher_view WHERE teacher_id = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tea_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");
				String teacher_ssn = rs.getString("teacher_ssn");
				String teacher_phone = rs.getString("teacher_phone");
				String able_subject = rs.getString("able_subject");
				String teacher_hiredate = rs.getString("teacher_hiredate");

				Teacher t = new Teacher();
				t.setTeacher_id(teacher_id);
				t.setTeacher_name(teacher_name);
				t.setTeacher_ssn(teacher_ssn);
				t.setTeacher_phone(teacher_phone);
				t.setAbleSubject(able_subject);
				t.setTeacher_hiredate(teacher_hiredate);

				result.add(t);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<BasicInfo> scheduleList(String tea_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;

		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id ,able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, room_name, textbook_name, st_count FROM tea_os_view WHERE teacher_id = ?";
			/*
			 * String sql =
			 * "SELECT student_id, student_name, student_phone, TO_CHAR(student_hiredate, 'YYYY-MM-DD') AS student_hiredate,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, TO_CHAR(drop_date, 'YYYY-MM-DD') AS drop_date FROM stu_os_view WHERE oc_id = (SELECT oc_id FROM open_subject os WHERE os_id = ?) ORDER BY student_id"
			 * ;
			 */
			/*
			 * switch (key) {
			 * 
			 * case "all": break; case "teacher": sql += " WHERE teacher_id = ?"; break; }
			 */

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tea_id);
			/*
			 * switch (key) { case "all": break; case "teacher":
			 * 
			 * break; }
			 */
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int st_count = rs.getInt("st_count");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setAbleSubject(able_subject);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setCourse_name(course_name);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				b.setRoom_name(room_name);
				b.setTextbook_name(textbook_name);
				b.setSt_count(st_count);
				result.add(b);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<BasicInfo> scheduleList2(String id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id, able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, st_count FROM tea_os_view WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				int st_count = rs.getInt("st_count");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setAbleSubject(able_subject);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setSt_count(st_count);
				result.add(b);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<Student> scheduleList3(String id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW stu_os_view AS SELECT t.student_id, t.student_name,
			 * t.student_phone, t.student_hiredate , (SELECT drop_date FROM drop_out d,
			 * student_history sh WHERE d.STUDENT_ID = sh.STUDENT_ID AND sh.student_id =
			 * t.student_id) AS drop_date , (SELECT oc.oc_id FROM open_course oc,
			 * student_history sh WHERE t.student_id = sh.student_id AND oc.oc_id =
			 * sh.oc_id) AS oc_id , (SELECT oc.oc_begin FROM open_course oc, student_history
			 * sh WHERE t.student_id = sh.student_id AND oc.oc_id = sh.oc_id) AS oc_begin ,
			 * (SELECT oc.oc_end FROM open_course oc, student_history sh WHERE t.student_id
			 * = sh.student_id AND oc.oc_id = sh.oc_id) AS oc_end FROM student t;
			 */

			String sql = "SELECT student_id, student_name, student_phone, TO_CHAR(student_hiredate, 'YYYY-MM-DD') AS student_hiredate,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, TO_CHAR(drop_date, 'YYYY-MM-DD') AS drop_date FROM stu_os_view WHERE oc_id = (SELECT oc_id FROM open_subject os WHERE os_id = ?) ORDER BY student_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");
				String oc_end = rs.getString("oc_end");
				String drop_date = rs.getString("drop_date");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);
				s.setOc_end(oc_end);
				s.setDrop_date(drop_date);

				result.add(s);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<BasicInfo> scheduleList4(String id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id ,able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, room_name, textbook_name, st_count FROM tea_os_view WHERE os_begin < TO_CHAR(SYSDATE, 'YYYY-MM-DD') AND os_end > TO_CHAR(SYSDATE, 'YYYY-MM-DD') AND teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int st_count = rs.getInt("st_count");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setAbleSubject(able_subject);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setCourse_name(course_name);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				b.setRoom_name(room_name);
				b.setTextbook_name(textbook_name);
				b.setSt_count(st_count);
				result.add(b);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<Student> scheduleList5(String id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW stu_os_view AS SELECT t.student_id, t.student_name,
			 * t.student_phone, t.student_hiredate , (SELECT drop_date FROM drop_out d,
			 * student_history sh WHERE d.STUDENT_ID = sh.STUDENT_ID AND sh.student_id =
			 * t.student_id) AS drop_date , (SELECT oc.oc_id FROM open_course oc,
			 * student_history sh WHERE t.student_id = sh.student_id AND oc.oc_id =
			 * sh.oc_id) AS oc_id , (SELECT oc.oc_begin FROM open_course oc, student_history
			 * sh WHERE t.student_id = sh.student_id AND oc.oc_id = sh.oc_id) AS oc_begin ,
			 * (SELECT oc.oc_end FROM open_course oc, student_history sh WHERE t.student_id
			 * = sh.student_id AND oc.oc_id = sh.oc_id) AS oc_end FROM student t;
			 */

			/*
			 * CREATE OR REPLACE VIEW test_view AS SELECT os_id,(SELECT oc_id FROM
			 * open_course oc WHERE os.oc_id = oc.oc_id) AS oc_id FROM open_subject os;
			 */

			String sql = "SELECT student_id, student_name, student_phone, TO_CHAR(student_hiredate, 'YYYY-MM-DD') AS student_hiredate,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, TO_CHAR(drop_date, 'YYYY-MM-DD') AS drop_date FROM stu_os_view WHERE oc_id = (SELECT oc_id FROM open_subject os WHERE os_id = ?) ORDER BY student_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");
				String oc_end = rs.getString("oc_end");
				String drop_date = rs.getString("drop_date");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);
				s.setOc_end(oc_end);
				s.setDrop_date(drop_date);

				result.add(s);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<BasicInfo> scheduleList6(String key, String tea_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * os_001 JAVA 2015-01-01 2015-02-01 JAVA기반 2015-01-01 2015-03-01 강의실1 이것이 자바다
			 * 10 os_008 C언어 2017-02-01 2017-07-01 C언어, 자바 프로그래밍 개발자 과정 2017-02-01
			 * 2017-10-01 강의실5 정보보안기초 10
			 */

			String sql = "SELECT os_id ,able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, room_name, textbook_name, st_count FROM tea_os_view";

			switch (key) {
			case "all":
				break;
			case "teacher":
				sql += " WHERE os_end < TO_CHAR(SYSDATE, 'YYYY-MM-DD') AND teacher_id = ?";
				break;
			}

			pstmt = conn.prepareStatement(sql);
			switch (key) {
			case "all":
				break;
			case "teacher":
				pstmt.setString(1, tea_id);
				break;
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int st_count = rs.getInt("st_count");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setAbleSubject(able_subject);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setCourse_name(course_name);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				b.setRoom_name(room_name);
				b.setTextbook_name(textbook_name);
				b.setSt_count(st_count);
				result.add(b);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<Student> scheduleList7(String id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			/*
			 * st_011 이용호 010-4917-3082 2016-02-01 2016-06-01 st_012 최관종 010-2910-8852
			 * 2016-02-02 2016-06-01 st_013 노승한 010-4655-7142 2016-02-03 2016-06-01 st_014
			 * 최재완 010-3559-9335 2016-02-04 2016-06-01 st_015 도영남 010-7400-3009 2016-02-05
			 * 2016-06-01 st_016 박승권 010-6235-5530 2016-02-06 2016-06-01 st_017 정난숙
			 * 010-3001-9322 2016-02-07 2016-06-01 st_018 김영옥 010-2869-9752 2016-02-08
			 * 2016-06-01 st_019 최연옥 010-4440-5729 2016-02-09 2016-06-01 st_020 최순주
			 * 010-8013-8689 2016-02-10 2016-06-01 2016-04-01
			 */

			String sql = "SELECT student_id, student_name, student_phone, TO_CHAR(student_hiredate, 'YYYY-MM-DD') AS student_hiredate,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, TO_CHAR(drop_date, 'YYYY-MM-DD') AS drop_date FROM stu_os_view WHERE oc_id = (SELECT oc_id FROM open_subject os WHERE os_id = ?) ORDER BY student_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");
				String oc_end = rs.getString("oc_end");
				String drop_date = rs.getString("drop_date");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);
				s.setOc_end(oc_end);
				s.setDrop_date(drop_date);

				result.add(s);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<ScoreAndGrade> scoreList(String key, String tea_id) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id ,able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, room_name, textbook_name, st_count, sc_attend, sc_written, sc_practice,  TO_CHAR(ex_date, 'YYYY-MM-DD') AS ex_date, ex_qs FROM tea_os_view WHERE os_end < TO_CHAR(SYSDATE, 'YYYY-MM-DD') AND teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tea_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int st_count = rs.getInt("st_count");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				String ex_date = rs.getString("ex_date");
				String ex_qs = rs.getString("ex_qs");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setOs_id(os_id);
				sg.setAbleSubject(able_subject);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setCourse_name(course_name);
				sg.setOc_begin(oc_begin);
				sg.setOc_end(oc_end);
				sg.setRoom_name(room_name);
				sg.setTextbook_name(textbook_name);
				sg.setSt_count(st_count);
				sg.setSc_attend(sc_attend);
				sg.setSc_written(sc_written);
				sg.setSc_practice(sc_practice);
				sg.setEx_date(ex_date);
				sg.setEx_qs(ex_qs);
				result.add(sg);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	// 성적관리 -> 과목선택 강사에따른 과목,출력
	/*
	 * os_001 JAVA 2015-01-01 2015-02-01 JAVA기반 2015-01-01 2015-03-01 강의실1 이것이 자바다
	 * 40 30 30 10 8 os_008 C언어 2017-02-01 2017-07-01 C언어, 자바 프로그래밍 개발자 과정
	 * 2017-02-01 2017-10-01 강의실5 정보보안기초 20 30 50 10 0 os_010 JAVA 2017-11-01
	 * 2017-12-01 JAVA기반 2017-11-01 2018-01-01 강의실1 이것이 자바다 40 30 30 11 0
	 */
	public List<ScoreAndGrade> scoreList2(String tea_id) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT os_id, able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin,  TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end, room_name, textbook_name,  sc_attend, sc_written, sc_practice, st_count, g_count FROM tea_os_view WHERE teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tea_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				int st_count = rs.getInt("st_count");
				int g_count = rs.getInt("g_count");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setOs_id(os_id);
				sg.setAble_subject(able_subject);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setCourse_name(course_name);
				sg.setOc_begin(oc_begin);
				sg.setOc_end(oc_end);
				sg.setRoom_name(room_name);
				sg.setTextbook_name(textbook_name);
				sg.setSc_attend(sc_attend);
				sg.setSc_written(sc_written);
				sg.setSc_practice(sc_practice);
				sg.setSt_count(st_count);
				sg.setG_count(g_count);
				result.add(sg);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	// oc_001 JAVA기반 2015-01-01 2015-03-01
	public List<BasicInfo> scoreList5(String id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT oc_id, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin, TO_CHAR(oc_end, 'YYYY-MM-DD') AS oc_end FROM tea_os_view WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");

				BasicInfo b = new BasicInfo();
				b.setOc_id(oc_id);
				b.setCourse_name(course_name);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				result.add(b);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public List<ScoreAndGrade> scoreList3(String id) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id,  able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, st_count, sc_attend, sc_written, sc_practice, TO_CHAR(ex_date, 'YYYY-MM-DD') AS ex_date, ex_qs FROM tea_os_view WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				int st_count = rs.getInt("st_count");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				String ex_date = rs.getString("ex_date");
				String ex_qs = rs.getString("ex_qs");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setOs_id(os_id);
				sg.setAbleSubject(able_subject);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setSt_count(st_count);
				sg.setSc_attend(sc_attend);
				sg.setSc_written(sc_written);
				sg.setSc_practice(sc_practice);
				sg.setEx_date(ex_date);
				sg.setEx_qs(ex_qs);
				result.add(sg);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	public int scoreAdd(ScoreAndGrade sg) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO score (os_id, sc_written, sc_practice, sc_attend, ex_qs, ex_date) VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sg.getOs_id());
			pstmt.setInt(2, sg.getSc_written());
			pstmt.setInt(3, sg.getSc_practice());
			pstmt.setInt(4, sg.getSc_attend());
			pstmt.setString(5, sg.getEx_qs());
			pstmt.setString(6, sg.getEx_date());
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	// 吏�紐낆뼵�땲

	public List<ScoreAndGrade> scoreManagingList1(String key, String teacher_id) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id,  able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD')AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY-MM-DD') AS oc_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS oc_end, room_name, textbook_name, sc_attend, sc_written, sc_practice,  st_count, TO_CHAR(ex_date, 'YYYY-MM-DD') AS ex_date, ex_qs FROM tea_os_view WHERE teacher_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher_id);

			/*
			 * switch (key) { case "teacher":
			 * 
			 * break; }
			 */

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int st_count = rs.getInt("st_count");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				String ex_date = rs.getString("ex_date");
				String ex_qs = rs.getString("ex_qs");
				String os_id = rs.getString("os_id");

				ScoreAndGrade sg = new ScoreAndGrade();

				sg.setOs_id(os_id);
				sg.setAble_subject(able_subject);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setCourse_name(course_name);
				sg.setOc_begin(oc_begin);
				sg.setOc_end(oc_end);
				sg.setRoom_name(room_name);
				sg.setTextbook_name(textbook_name);
				sg.setSt_count(st_count);
				sg.setSc_attend(sc_attend);
				sg.setSc_written(sc_written);
				sg.setSc_practice(sc_practice);
				sg.setEx_date(ex_date);
				sg.setEx_qs(ex_qs);

				result.add(sg);
			}
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	public List<ScoreAndGrade> scoreManagingList2(String id) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW tea_os_view AS SELECT (SELECT teacher_id FROM teacher
			 * t WHERE t.teacher_id = os.teacher_id) AS teacher_id ,os_id ,(SELECT
			 * LISTAGG(CAST(subject_name AS VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY
			 * subject_name) FROM subject sj WHERE sj.subject_id = os.subject_id) AS
			 * able_subject , os_begin, os_end ,(SELECT course_name FROM course c,
			 * open_course oc WHERE c.course_id = oc.course_id AND oc.oc_id = os.oc_id) AS
			 * course_name ,(SELECT oc_begin FROM open_course oc WHERE oc.oc_id = os.oc_id)
			 * AS oc_begin ,(SELECT oc_end FROM open_course oc WHERE oc.oc_id = os.oc_id) AS
			 * oc_end ,(SELECT room_name FROM room r, open_course oc WHERE r.room_id =
			 * oc.room_id AND oc.oc_id = os.oc_id) AS room_name ,(SELECT textbook_name FROM
			 * text_book tb WHERE tb.textbook_id = os.textbook_id) AS textbook_name ,(SELECT
			 * COUNT(sh.student_id) AS count_ FROM student_history sh, open_course oc WHERE
			 * sh.oc_id = oc.oc_id AND os.oc_id = oc.oc_id) AS st_count --�닔媛� �븰�깮�닔
			 * ,(SELECT sc_attend FROM score s WHERE os.os_id = s.os_id) AS sc_attend
			 * ,(SELECT sc_written FROM score s WHERE os.os_id = s.os_id) AS sc_written
			 * ,(SELECT sc_practice FROM score s WHERE os.os_id = s.os_id) AS sc_practice
			 * ,(SELECT ex_date FROM score s WHERE os.os_id = s.os_id) AS ex_date ,(SELECT
			 * ex_qs FROM score s WHERE os.os_id = s.os_id) AS ex_qs ,(SELECT oc_id FROM
			 * open_course oc WHERE oc.oc_id = os.oc_id) AS oc_id ,(SELECT
			 * COUNT(grade_attend) FROM grade g WHERE os.os_id = g.os_id) AS g_count
			 * --�꽦�쟻�엯�젰�닔 FROM open_subject os;
			 */

			String sql = "SELECT os_id, able_subject, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, "
					+ "st_count FROM tea_os_view WHERE os_id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				int totalStudent = rs.getInt("st_count");

				ScoreAndGrade sg = new ScoreAndGrade();

				sg.setOc_id(os_id);
				sg.setSubject_name(subject_name);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setTotalStudent(totalStudent);

				result.add(sg);
			}
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	// ok
	// 성적관리 -> 성적 입력 완료
	public List<Student> scoreManagingList3(String os_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW grade_refer_view AS SELECT os.os_id as os_id,
			 * g.student_id as student_id, g.grade_attend, g.grade_written,
			 * g.grade_practice, grade_attend + grade_written + grade_practice as sum FROM
			 * grade g, open_subject os WHERE g.os_id = os.os_id;
			 * 
			 * 
			 * CREATE OR REPLACE VIEW teacher_soo_view AS SELECT stu.student_id AS
			 * student_id, stu.student_name AS student_name, stu.student_phone AS
			 * student_phone, stu.student_hiredate AS student_hiredate , re.os_id AS os_id,
			 * re.SUM AS sum, re.grade_attend AS grade_attend, re.grade_practice AS
			 * grade_practice, re.grade_written AS grade_written , TO_CHAR(do.drop_date,
			 * 'YYYY-MM-DD') AS drop_date, TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end FROM
			 * student stu, grade_refer_view re, drop_out do, open_course oc WHERE
			 * stu.student_id = re.student_id(+) AND re.student_id = do.student_id(+) AND
			 * do.oc_id = oc.oc_id(+);
			 * 
			 * SELECT student_id, student_name, student_phone, student_hiredate, oc_end,
			 * drop_date, grade_attend, grade_written, grade_practice, sum FROM
			 * teacher_soo_view WHERE os_id = 'os_001';
			 * 
			 */

			// os_id로 성적받아옴
			String sql = "SELECT student_id, student_name, student_phone, student_hiredate, drop_date, complete_ck,drop_date, grade_attend, grade_written, grade_practice, grade_total FROM teacher_soo_view WHERE os_id = ? ORDER BY student_id";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");
				String complete_ck = rs.getString("complete_ck");
				String drop_date = rs.getString("drop_date");
				int grade_attend = rs.getInt("grade_attend");
				int grade_written = rs.getInt("grade_written");
				int grade_practice = rs.getInt("grade_practice");
				int grade_total = rs.getInt("grade_total");

				Student s = new Student();

				s.setOs_id(os_id);
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);
				s.setComplete_ck(complete_ck);
				s.setDrop_date(drop_date);
				s.setGrade_attend(grade_attend);
				s.setGrade_written(grade_written);
				s.setGrade_practice(grade_practice);
				s.setGrade_total(grade_total);

				result.add(s);
			}
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;

	}
	
	// 배점관리 -> 과목선택에 성적입력(update)
	public int teacherbajamInsert(BasicInfo bi) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			/*UPDATE score SET sc_attend = 40, sc_written = 30, sc_practice = 30, ex_qs = 'JAVA.zip', ex_date = '2017-09-23'  WHERE os_id= 'os_001';*/
			String sql = "UPDATE score SET sc_attend = ?, sc_written = ?, sc_practice = ?, ex_qs = ?, ex_date = ?  WHERE os_id= ? ";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			System.out.printf("%s, %s, %s, %s, %s, %s", bi.getSc_attend(), bi.getSc_written(), bi.getSc_practice(), bi.getEx_qs(), bi.getEx_date(), bi.getOs_id());
			
			pstmt.setInt(1, bi.getSc_attend());
			pstmt.setInt(2, bi.getSc_written());
			pstmt.setInt(3, bi.getSc_practice());
			pstmt.setString(4, bi.getEx_qs());
			pstmt.setString(5, bi.getEx_date());
			pstmt.setString(6, bi.getOs_id());
			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}	
	
	// 배점관리 -> 과목선택 -> 과목배점삭제(update)
		public int teachergradedelete (BasicInfo bi) {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBConnection.connect();
				/*
				 * STUDENT_ID STUDENT_PASSWORD STUDENT_NAME STUDENT_SSN STUDENT_PHONE_NUMBER
				 * STUDENT_REG_DATE
				 */
				String sql = "UPDATE score SET sc_attend = '', sc_written = '', sc_practice = '', ex_qs = '', ex_date = ''  WHERE os_id= ?";
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bi.getOs_id());
				result = pstmt.executeUpdate();

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
				} catch (SQLException se2) {
				}
				try {
					DBConnection.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return result;
		}		

	// continue
	// 강사계정>성적관리>과목선택>성적입력
	public String scoreManagingInsert(String os_id, String st_id, Student st) {
		// os_id로 성적받아옴
		String result = "";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConnection.connect();
	
			String sql = "INSERT INTO grade(grade_id, grade_attend, grade_written, grade_practice, student_id, os_id) VALUES ((SELECT CONCAT('grade_',LPAD(NVL(MAX(REPLACE(grade_id, 'grade_')), 0)+1,3,'0'))from grade),?, ?, ?, ?, ?)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, st.getGrade_attend());
		pstmt.setInt(2, st.getGrade_written());
		pstmt.setInt(3, st.getGrade_practice());
		pstmt.setString(4, st_id);
		pstmt.setString(5, os_id);
		System.out.println(sql);
		 pstmt.executeUpdate();
		 result="100";
		
	}catch(ClassNotFoundException|SQLException e) {
		result ="101";
		e.printStackTrace();
	}finally
	{

		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException se2) {
		}
		try {
			DBConnection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}return result;

}

	// -수강생 정보 출력 강의예정 - 조회
	public List<Student> scoreManagingList4(String os_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW sub_os_view AS SELECT GRADE_ATTEND, GRADE_WRITTEN,
			 * GRADE_PRACTICE, GRADE_ATTEND + GRADE_WRITTEN + GRADE_PRACTICE AS sum ,
			 * sh.student_id , student_name, student_phone, student_hiredate , oc.oc_end ,
			 * (SELECT drop_date FROM drop_out d WHERE d.student_id = sh.student_id) AS
			 * drop_date , oc.oc_id , teacher_id FROM student_history sh, student s, grade
			 * g, open_course oc, open_subject os WHERE sh.student_id = s.student_id AND
			 * s.student_id = g.student_id(+) AND sh.oc_id = oc.oc_id AND oc.oc_id =
			 * os.oc_id ORDER BY student_id;
			 * 
			 * CREATE OR REPLACE VIEW test_view AS SELECT os_id,(SELECT oc_id FROM
			 * open_course oc WHERE os.oc_id = oc.oc_id) AS oc_id FROM open_subject os;
			 */

			//os_id로 조회
			String sql = "SELECT student_id, student_name, student_phone, student_hiredate, complete_ck,drop_date FROM teacher_soo_view WHERE os_id = ? ORDER BY student_id";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");
				String complete_ck = rs.getString("complete_ck");
				String drop_date = rs.getString("drop_date");

				Student s = new Student();

				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);
				s.setComplete_ck(complete_ck);
				s.setDrop_date(drop_date);
				s.setOs_id(os_id);

				result.add(s);
			}
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	// ���떊�뿉 press any key 諛붽씀怨� 0�늻瑜대㈃ 醫낅즺
	// -媛뺤궗濡쒓렇�씤 4. �꽦�쟻愿�由�>怨쇰ぉ�꽑�깮>�븰�깮�꽑�깮
	public List<ScoreAndGrade> maximScorelist(String sub) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			// 媛뺤궗id, 怨쇱젙id, �븰�깮id
			String sql = "SELECT sc_attend, sc_written, sc_practice from score WHERE os_id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, sub);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");

				ScoreAndGrade s = new ScoreAndGrade();

				s.setSc_attend(sc_attend);
				s.setSc_written(sc_written);
				s.setSc_practice(sc_practice);

				result.add(s);
			}
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	public int GradeManagingAdd(String sub, String stid, int a, int b, int c) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			// �븰�깮id, 怨쇱젙id, 異쒖꽍�젏�닔 ,�븘湲곗젏�닔, �떎湲곗젏�닔
			String sql = "INSERT INTO GRADE (GRADE_ID, STUDENT_ID, OS_ID, GRADE_WRITTEN, GRADE_PRACTICE, GRADE_ATTEND) "
					+ "VALUES ((SELECT CONCAT('grade_', LPAD(REPLACE(MAX(grade_id), 'grade_') + 1, 3, '0')) AS grade_id FROM grade), ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stid);
			pstmt.setString(2, sub);
			pstmt.setInt(3, b);
			pstmt.setInt(4, c);
			pstmt.setInt(5, a);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	// 강의 예정,중,끝
	public List<BasicInfo> courseScheduleList(String key, String teacher_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		/*
		 * private String course_id, course_name; private String subject_id,
		 * subject_name; private String oc_id, oc_begin, oc_end; private String os_id,
		 * os_begin, os_end; private String room_id, room_name; private int room_count;
		 * private String textbook_id, textbook_name, textbook_publisher; private int
		 * st_count; private String teacher_name,teacher_id; private String
		 * student_name,date_, drop_date; private String ex_qs_ck,score_regi_ck; private
		 * String teaching_ck; private int os_count; private String ableSubject; private
		 * int progress; private String able_subject;
		 * 
		 * //강사 자료형 추가생성 private int sc_attend; private int sc_written; private int
		 * sc_practice;
		 */

		try {
			conn = DBConnection.connect();
			// 과목번호, 과목명, 과목기간, 과정명, 과정기간, 강의실, 교재명, 수강생인원
			// 강의 예정, 강의 중, 강의 종료
			String sql = "SELECT os_id, able_subject, to_char(os_begin, 'YYYY/MM/DD') AS os_begin, to_char(os_end, 'YYYY/MM/DD') AS os_end, course_name, TO_CHAR(oc_begin, 'YYYY/DD/MM') AS oc_begin, TO_CHAR(oc_end, 'YYYY/MM/DD') AS oc_end, room_name, textbook_name, st_count FROM tea_os_view";

			switch (key) {
			case "1":
				sql += " WHERE to_char(os_begin, 'YYYY/MM/DD') > to_char(SYSDATE, 'YYYY/MM/dd') and teacher_id = ?";
				break;
			case "2":
				sql += " WHERE to_char(os_begin, 'YYYY/MM/DD') <= TO_CHAR(SYSDATE, 'YYYY/MM/dd') AND to_char(os_end, 'YYYY/MM/DD') >= TO_CHAR(SYSDATE, 'YYYY/MM/DD') and teacher_id = ?";
				break;
			case "3":
				sql += " WHERE to_char(os_end, 'YYYY/MM/DD') < TO_CHAR(SYSDATE, 'YYYY/MM/dd') AND teacher_id = ?";
				break;
			}

			sql += " ORDER BY os_begin, os_end";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String able_subject = rs.getString("able_subject");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				int st_count = rs.getInt("st_count");

				BasicInfo tb = new BasicInfo();
				tb.setOs_id(os_id);
				tb.setAble_subject(able_subject);
				tb.setOs_begin(os_begin);
				tb.setOs_end(os_end);
				tb.setCourse_name(course_name);
				tb.setOc_begin(oc_begin);
				tb.setOc_end(oc_end);
				tb.setRoom_name(room_name);
				tb.setTextbook_name(textbook_name);
				tb.setSt_count(st_count);

				result.add(tb);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
				// nothing we can do
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	// 강사 비밀번호 변경
	public int teacherPwUpdate(Teacher tea) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE teacher SET teacher_ssn = ? WHERE teacher_id = ?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tea.getTeacher_ssn());
			pstmt.setString(2, tea.getTeacher_id());
			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;

	}

	// 강사 개인 정보수정
	public int teacherUpdate(Teacher tea) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			/*
			 * STUDENT_ID STUDENT_PASSWORD STUDENT_NAME STUDENT_SSN STUDENT_PHONE_NUMBER
			 * STUDENT_REG_DATE
			 */
			String sql = "UPDATE teacher SET teacher_name = ?, teacher_ssn = ?, teacher_phone = ?  WHERE teacher_id =?";

			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tea.getTeacher_name());
			pstmt.setString(2, tea.getTeacher_ssn());
			pstmt.setString(3, tea.getTeacher_phone());
			pstmt.setString(4, tea.getTeacher_id());

			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	// 배점관리 -> 과목선택에 성적입력(update)
	public int teacherbajamInsert(String os_id) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			String sql = "UPDATE score SET sc_attend = ?, sc_written = ?, sc_practice = ? WHERE os_id= ?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			BasicInfo bi = new BasicInfo();

			pstmt.setInt(1, bi.getSc_attend());
			pstmt.setInt(2, bi.getSc_written());
			pstmt.setInt(3, bi.getSc_practice());
			pstmt.setString(4, os_id);
			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	// 성적삭제
	public int teacherscoredelete(String os_id, String student_id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			/*
			 * STUDENT_ID STUDENT_PASSWORD STUDENT_NAME STUDENT_SSN STUDENT_PHONE_NUMBER
			 * STUDENT_REG_DATE
			 */
			String sql = "DELETE grade WHERE os_id=? AND student_id =?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, os_id);
			pstmt.setString(2, student_id);
			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

	// 과목삭제
	public int teachersubjectdelete(String teacher_id, String os_id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			/*
			 * STUDENT_ID STUDENT_PASSWORD STUDENT_NAME STUDENT_SSN STUDENT_PHONE_NUMBER
			 * STUDENT_REG_DATE
			 */
			String sql = "DELETE open_subject WHERE os_id = ? AND teacher_id =?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, teacher_id);
			pstmt.setString(2, os_id);
			result = pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}
	
	// 교재 출력
	public List<BasicInfo> teacher_opensubjectimage(String textbook_name) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT textbook_name, textbook_file FROM text_book WHERE textbook_name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, textbook_name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String textbook_file = rs.getString("textbook_file");

				BasicInfo b = new BasicInfo();
				b.setTextbook_name(textbook_name);
				b.setTextbook_file(textbook_file);

				result.add(b);

			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();

			}

		}

		return result;

	}
		
}
