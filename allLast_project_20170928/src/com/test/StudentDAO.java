package com.test;

import java.sql.*;
import java.util.*;

public class StudentDAO {

	//�븰�깮 濡쒓렇�씤
	public void studentLogin(String id_, String pw) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	// �뜝�럥�빢�뤆�룆踰→틦占� �슖�돦裕꾬옙�쟽�뜝�럩逾� > 1.�뤆�룇裕뉛옙逾ε뜝�럩�젧�솻洹ｋ샑占쎈꼪�뜝�럩逾�
	public Student studentInfo(String st_id) {
		Student st = new Student();


		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT st.student_id , st.student_name, st.student_ssn, st.student_phone, (SELECT COUNT(oc_id) FROM student_history WHERE st.student_id = student_id) AS co_count FROM student st WHERE st.student_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, st_id);
			
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_ssn = rs.getString("student_ssn");
				String student_phone = rs.getString("student_phone");
				int course_count = rs.getInt("co_count");

				st.setStudent_id(student_id);
				st.setStudent_name(student_name);
				st.setStudent_ssn(student_ssn);
				st.setCourse_count(course_count);
				st.setStudent_phone(student_phone);
				//result.add(st);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		// �뜝�럡�뎽占썩뫀踰딉옙六� result=id;
		return st;
		
		
	}
	// �뜝�럥�빢�뤆�룆踰→틦占� �슖�돦裕꾬옙�쟽�뜝�럩逾� > 2.�뜝�럡�뎽�뜝�럩�쓤�댖怨뚰�э옙�뤂 - �댖怨뚰�э옙�뤂 �뜝�럩�쓧 占썩뫁�닔占쎌젧 占쎈퉲占쎈츊占쎌졑
	public List<BasicInfo> studentCourseList(String st_id){
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			
			//占쎈�롥뜝占� �뜝�럥爰뽩뜝�럥裕� 占쎄턀�겫�뼔援�
			/*
			CREATE OR REPLACE VIEW st_oc_view
			AS
			SELECT oc.oc_id AS oc_id
			      , (SELECT course_name FROM course WHERE course_id = oc.course_id ) AS course_name
			      , TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') AS oc_begin
			      , TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			      , (SELECT room_name FROM room WHERE room_id = oc.room_id) AS room_name
			      , (SELECT COUNT(*) FROM open_subject WHERE oc_id = oc.oc_id ) AS os_count
			FROM open_course oc
			ORDER BY oc_id;
			 */
			

			String sql = "SELECT oc_id, course_name, oc_begin, oc_end, os_count, room_name FROM st_oc_view WHERE oc_id = (SELECT oc_id FROM student_history WHERE student_id = ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, st_id);
			
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				int os_count = rs.getInt("os_count");
				String room_name = rs.getString("room_name");
			

				

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setCourse_name(course_name);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setOs_count(os_count);
				info.setRoom_name(room_name);
				
				result.add(info);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} 
		
		
		return result;
		
	}
	// �뜝�럥�빢�뤆�룆踰→틦占� �슖�돦裕꾬옙�쟽�뜝�럩逾� > 2.�뜝�럡�뎽�뜝�럩�쓤�댖怨뚰�э옙�뤂 - �뜝�럩肉��뜝�럩�졑�뜝�럩�쐩 占썩뫁�닔占쎌젧 占쎈퉲占쎈츊占쎌졑
	public List<ScoreAndGrade> studentCourseList2(String search_oc_id){
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		
		

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			CREATE OR REPLACE VIEW st_oc_view
			AS
			SELECT oc.oc_id AS oc_id
			      , (SELECT course_name FROM course WHERE course_id = oc.course_id ) AS course_name
			      , TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') AS oc_begin
			      , TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			      , (SELECT room_name FROM room WHERE room_id = oc.room_id) AS room_name
			      , (SELECT COUNT(*) FROM open_subject WHERE oc_id = oc.oc_id ) AS os_count
			FROM open_course oc
			ORDER BY oc_id;
			 */
			
			String sql = "SELECT oc_id, course_name, oc_begin, oc_end  FROM st_oc_view WHERE oc_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search_oc_id);
			ResultSet rs = pstmt.executeQuery();

			
			while (rs.next()) {

				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				
			

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setOc_id(oc_id);
				sg.setCourse_name(course_name);
				sg.setOc_begin(oc_begin);
				sg.setOc_end(oc_end);
			
				result.add(sg);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} 
		
		
		
		
		
		return result;
		
	}
	// �뜝�럥�빢�뤆�룆踰→틦占� �슖�돦裕꾬옙�쟽�뜝�럩逾� > 2.�뜝�럡�뎽�뜝�럩�쓤�댖怨뚰�э옙�뤂 - �뜝�럩肉��뜝�럩�졑�뜝�럩�쐩 �뜝�럡�뎽�뜝�럩�쓤 占쎈퉲占쎈츊占쎌졑
	public List<ScoreAndGrade> studentScoreList(String search_oc_id, String st_id){
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		
		

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			  CREATE OR REPLACE  VIEW STUENT_G_VIEW
			  AS 
			  SELECT os.os_id
			    , (SELECT subject_name FROM subject s WHERE s.subject_id = os.subject_id) AS subject_name
			    , os_begin, os_end
			    , (SELECT textbook_name FROM text_book te WHERE te.textbook_id = os.textbook_id) AS textbook_name
			    , (SELECT teacher_name FROM teacher t WHERE t.teacher_id = os.teacher_id) AS teacher_name
			    , DECODE(drop_date, null, '�뜝�럥�빢占쎈쇀�뜝占�'||'('|| os_end ||')','繞벿살탮�뙴袁ъ삕繹먮맮�삕占쎈뎅''('|| drop_date ||')') AS date_
			    , (SELECT sc_attend FROM score sc WHERE sc.os_id = os.os_id) AS sc_attend
			    , (SELECT sc_written FROM score sc WHERE sc.os_id = os.os_id) AS sc_written
			    , (SELECT sc_practice FROM score sc WHERE sc.os_id = os.os_id) AS sc_practice
			    , grade_attend, grade_written, grade_practice
			    , (SELECT ex_date FROM score sc WHERE sc.os_id = os.os_id) AS ex_date
			    , (SELECT ex_qs FROM score sc WHERE sc.os_id = os.os_id) AS ex_qs
			    , os.oc_id
			    , sh.student_id
			    FROM grade g, student s, student_history sh, drop_out d, open_subject os
			    WHERE sh.student_id = d.student_id(+) AND sh.student_id = s.student_id AND s.student_id = g.student_id AND g.os_id = os.os_id
			    ORDER BY os.os_id;
			    */
			
			String sql = "SELECT os_id, subject_name, TO_CHAR(os_begin,'YYYY-MM-DD') AS os_begin, TO_CHAR(os_end,'YYYY-MM-DD') AS os_end, textbook_name, teacher_name, date_, sc_attend, sc_written, sc_practice, grade_attend, grade_written, grade_practice, TO_CHAR(ex_date,'YYYY-MM-DD') AS ex_date, ex_qs FROM stuent_g_view WHERE oc_id = ? AND student_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search_oc_id);
			pstmt.setString(2, st_id);
			ResultSet rs = pstmt.executeQuery();

			
			while (rs.next()) {

				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");
				String date_ = rs.getString("date_");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				int grade_attend = rs.getInt("grade_attend");
				int grade_written = rs.getInt("grade_written");
				int grade_practice = rs.getInt("grade_practice");
				String ex_date = rs.getString("ex_date");
				String ex_qs = rs.getString("ex_qs");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setOs_id(os_id);
				sg.setSubject_name(subject_name);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setTextbook_name(textbook_name);
				sg.setTeacher_name(teacher_name);
				sg.setDate_(date_);
				sg.setSc_attend(sc_attend);
				sg.setSc_written(sc_written);
				sg.setSc_practice(sc_practice);
				sg.setGrade_attend(grade_attend);
				sg.setGrade_written(grade_written);
				sg.setGrade_practice(grade_practice);
				sg.setEx_date(ex_date);
				sg.setEx_qs(ex_qs);
				
				
				
				result.add(sg);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} 
		
		
		
		
		
		return result;
		
	}
	
	
	// �닔媛뺤깮 -> 媛쒖씤�젙蹂댁닔�젙 -> �빖�뱶�룿踰덊샇 蹂�寃�
	public int stduentInfoUpdate(String id, String phone) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE student SET student_phone = ?  WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);

			// �뛾�룆�뾼占쎈데�뜝�럥�럠 占쎈쨨占쎈릮占�
			pstmt.setString(1, phone);
			pstmt.setString(2, id);

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
	
	
	// �닔媛뺤깮 -> 媛쒖씤�젙蹂댁닔�젙 -> 鍮꾨�踰덊샇 蹂�寃�
	public int studentpasswordupdate(String id, String pw, String newpw) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE student SET student_ssn =? WHERE student_id=? AND student_ssn=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newpw);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
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
	 
	public String textbookFilename(String textbook_name) {
		String result = "";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT textbook_id, textbook_file FROM text_book WHERE textbook_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, textbook_name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String textbook_id = rs.getString("textbook_id");
				String textbook_file = rs.getString("textbook_file");

				
				result = textbook_file;
			 
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
