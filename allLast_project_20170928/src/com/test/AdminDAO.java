package com.test;

import java.sql.*;
import java.util.*;

public class AdminDAO {

	// 관리자 로그인
	public void adminLogin(String id_, String pw) {
		// TODO Auto-generated method stub

	}

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 1. 과정정보
	public List<BasicInfo> admin_1_1_1_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT course_id, course_name FROM course ORDER BY course_id";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");

				BasicInfo info = new BasicInfo();
				info.setCourse_id(course_id);
				info.setCourse_name(course_name);
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
		} // end try

		// 성공시 result=id;
		return result;

	}

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 1. 과정정보 > 과정추가
	public int admin_1_1_1_1_courseAdd(String name) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO course(course_id, course_name) VALUES ((SELECT CONCAT('cou_', LPAD(REPLACE(NVL(MAX(course_id), 'cou_001'), 'cou_') + 1, 3, '0')) AS newId FROM course),?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
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

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 2. 과목정보
	public List<BasicInfo> admin_1_1_1_2() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT subject_id, subject_name FROM subject ORDER BY subject_id";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String subject_id = rs.getString("subject_id");
				String subject_name = rs.getString("subject_name");

				BasicInfo info = new BasicInfo();
				info.setSubject_id(subject_id);
				info.setSubject_name(subject_name);
				result.add(info);
			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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

		// 성공시 result=id;
		return result;

	}

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 2. 과목정보 > 과목추가
	public int admin_1_1_1_2_subAdd(String name) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO subject(subject_id, subject_name) VALUES ((SELECT CONCAT('sub_', LPAD(REPLACE(NVL(MAX(subject_id), 'sub_001'), 'sub_') + 1, 3, '0')) AS newId FROM subject),?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
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

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 3. 강의실 정보
	public List<BasicInfo> admin_1_1_1_3() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT room_id, room_name, room_count FROM room ORDER BY room_id";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String room_id = rs.getString("room_id");
				String room_name = rs.getString("room_name");
				int room_count = rs.getInt("room_count");

				BasicInfo info = new BasicInfo();
				info.setRoom_id(room_id);
				info.setRoom_name(room_name);
				info.setRoom_count(room_count);
				result.add(info);
			}
			rs.close();
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

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 3. 강의실 정보 > 강의실추가
	public int admin_1_1_1_3_roomAdd(String name, int count) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO room(room_id,room_name,room_count) VALUES ((SELECT CONCAT('room_', LPAD(REPLACE(NVL(MAX(room_id), 'room_001'), 'room_') + 1, 3, '0')) AS newId FROM room),?,?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
			pstmt.setInt(2, count);

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

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 4. 교재 정보
	public List<BasicInfo> admin_1_1_1_4() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT textbook_id, textbook_name, textbook_publisher FROM text_book ORDER BY textbook_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String textbook_id = rs.getString("textbook_id");
				String textbook_name = rs.getString("textbook_name");
				String textbook_publisher = rs.getString("textbook_publisher");

				BasicInfo info = new BasicInfo();
				info.setTextbook_id(textbook_id);
				info.setTextbook_name(textbook_name);
				info.setTextbook_publisher(textbook_publisher);
				result.add(info);
			}
			rs.close();
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

	// 관리자 로그인> 1. 기본 정보 관리> 1. 조회 / 입력> 4. 교재 정보 > 교재추가
	public int admin_1_1_1_4_bookAdd(String name, String publisher) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO text_book(textbook_id,textbook_name,textbook_publisher) VALUES ((SELECT CONCAT('textbook_', LPAD(REPLACE(NVL(MAX(textbook_id), 'textbook_001'), 'textbook_') + 1, 3, '0')) AS newId FROM text_book),?,?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
			pstmt.setString(2, publisher);

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

	// 관리자 로그인> 1. 기본 정보 관리 > 2.삭제 > 1.과정 정보
	public int admin_1_1_2_1_corseRemove(String id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM course WHERE course_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, id);

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

	// 관리자 로그인> 1. 기본 정보 관리> 2. 삭제 > 2. 과목 정보
	public int admin_1_1_2_2_subjectRemove(String id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM subject WHERE subject_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, id);

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

	// 관리자 로그인> 1. 기본 정보 관리> 2.삭제 > 3. 강의실 정보
	public int admin_1_1_2_3_roomRemove(String id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM room WHERE room_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, id);

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

	// 관리자 로그인> 1. 기본 정보 관리> 2.삭제 > 3.교재 정보
	public int admin_1_1_2_4_textbookRemove(String id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM text_book WHERE textbook_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, id);

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

	// 관리자 로그인> 1. 기본 정보 관리> 3. 수정> 1. 과정 정보
	public int admin_1_1_3_1_courseUpdate(String id, String name) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE course SET course_name = ?  WHERE course_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
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

	// 관리자 로그인> 1. 기본 정보 관리> 3. 수정> 2. 과목 정보
	public int admin_1_1_3_2_subjectUpdate(String id, String name) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE subject SET subject_name = ?  WHERE subject_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
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

	// 관리자 로그인> 1. 기본 정보 관리> 3. 수정 > 3. 강의실 정보
	public int admin_1_1_3_3_roomUpdate(String id, String name, int count) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE room SET room_name = ? AND room_count = ? WHERE room_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
			pstmt.setInt(2, count);
			pstmt.setString(3, id);

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

	// 관리자 로그인> 1. 기본 정보 관리> 3. 수정 > 4. 교재 정보
	public int admin_1_1_3_4_textbookUpdate(String id, String name, String publisher) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE text_book SET textbook_name = ? AND textbook_publisher=? WHERE textbook_id = ?";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 구문
			pstmt.setString(1, name);
			pstmt.setString(2, publisher);
			pstmt.setString(3, id);

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

	// 공통 메소드 : 과목아이디, 과목명 출력
	public List<BasicInfo> admin_1_2_1_2() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT subject_id, subject_name FROM subject ORDER BY subject_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String subject_id = rs.getString("subject_id");
				String subject_name = rs.getString("subject_name");

				BasicInfo info = new BasicInfo();
				info.setSubject_id(subject_id);
				info.setSubject_name(subject_name);
				result.add(info);
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

	//////////////////////////////////////////////////////////////////////
	////////////////////////// ( 트랜잭션 처리 ) /////////////////////////
	//////////////////////////////////////////////////////////////////////
	// 관리자 로그인> 2. 강사 계정 관리> 강사테이블 + 강의과목테이블 추가하기
	public String admin_1_2_1_0(Teacher t, int arrayAbleSubjectSize) {
		String temp = "101";// 강사 입력 실패

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		try {
			conn = DBConnection.connect();

			// 트랜잭션 처리를 위한 설정 추가 -> autocommit false 설정
			conn.setAutoCommit(false);

			String sql1 = "SELECT CONCAT('tea_', LPAD(REPLACE(NVL(MAX(teacher_id), 'tea_001'), 'tea_') + 1, 3, '0')) AS newteacher_id FROM teacher";
			System.out.println(sql1);

			pstmt1 = conn.prepareStatement(sql1);
			ResultSet rs = pstmt1.executeQuery();
			String teacher_id = "";
			while (rs.next()) {
				teacher_id = rs.getString("newteacher_id");
			}
			rs.close();

			String sql2 = "INSERT INTO teacher(teacher_id, teacher_name, teacher_ssn, teacher_phone, teacher_hiredate) VALUES( ?, ?, ?, ?, SYSDATE) ";
			System.out.println(sql2);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, teacher_id);
			pstmt2.setString(2, t.getTeacher_name());
			pstmt2.setString(3, t.getTeacher_ssn());
			pstmt2.setString(4, t.getTeacher_phone());
			pstmt2.executeUpdate();

			int circle = 0;

			if (arrayAbleSubjectSize != 0) {
				for (int i = 0; i < arrayAbleSubjectSize; i++) {

					String sql3 = "INSERT INTO able_subject(teacher_id, subject_id) VALUES (?, ?)";

					System.out.println(sql3);
					pstmt3 = conn.prepareStatement(sql3);
					pstmt3.setString(1, teacher_id);
					pstmt3.setString(2, t.getArrayAbleSubject()[circle].toString());
					pstmt3.executeUpdate();
					circle++;
				}

			}

			// 트랜잭션 처리를 위한 설정 추가 -> 커밋
			conn.commit();
			temp = "100"; // 글쓰기 성공

		} catch (ClassNotFoundException | SQLException e) {

			// 트랜잭션 처리를 위한 설정 추가 -> 롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			temp = "101"; // 글쓰기 실패
		} finally {
			try {
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (pstmt3 != null)
					pstmt3.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return temp;
	}

	/*
	 * 
	 * 
	 * // 관리자 로그인> 2. 강사 계정 관리> 1. 입력 public int admin_1_2_1_1(Teacher t) { int
	 * result = 0;
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBConnection.connect();
	 * 
	 * String sql =
	 * "INSERT INTO teacher(teacher_id, teacher_name, teacher_ssn, teacher_phone, teacher_hiredate) VALUES((SELECT CONCAT('tea_', LPAD(REPLACE(NVL(MAX(teacher_id), 'tea_001'), 'tea_') + 1, 3, '0')) AS newteacher_id FROM teacher), ?, ?, ?, SYSDATE)"
	 * ; pstmt = conn.prepareStatement(sql); pstmt.setString(1,
	 * t.getTeacher_name()); pstmt.setString(2, t.getTeacher_ssn());
	 * pstmt.setString(3, t.getTeacher_phone()); result = pstmt.executeUpdate();
	 * 
	 * } catch (ClassNotFoundException | SQLException e) {
	 * System.out.println(e.getMessage()); } finally {
	 * 
	 * try { if (pstmt != null) pstmt.close(); } catch (SQLException se2) { } try {
	 * DBConnection.close(); } catch (SQLException se) { se.printStackTrace(); } }
	 * return result; }
	 */

	/*
	 * // 관리자 로그인> 2. 강사 계정 관리> 1. 입력 > 강의 가능 과목 추가 public int admin_1_2_1_3(String
	 * subject_id) { int result = 0;
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBConnection.connect();
	 * 
	 * String sql =
	 * "INSERT INTO able_subject(teacher_id, subject_id) VALUES ((SELECT MAX(teacher_id) FROM teacher), ?)"
	 * ; pstmt = conn.prepareStatement(sql); pstmt.setString(1, subject_id); result
	 * = pstmt.executeUpdate();
	 * 
	 * } catch (ClassNotFoundException | SQLException e) {
	 * System.out.println(e.getMessage()); } finally {
	 * 
	 * try { if (pstmt != null) pstmt.close(); } catch (SQLException se2) { } try {
	 * DBConnection.close(); } catch (SQLException se) { se.printStackTrace(); } }
	 * return result; }
	 */

	// 관리자 로그인> 2. 강사 계정 관리> 2. 조회 > 강사 정보
	public List<Teacher> admin_1_2_2_1() {
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
			 * te.teacher_id) AS able_subject FROM teacher te;
			 */

			String sql = "SELECT teacher_id, teacher_name, teacher_ssn, teacher_phone, able_subject FROM admin_teacher_view ORDER BY teacher_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");
				String teacher_ssn = rs.getString("teacher_ssn");
				String teacher_phone = rs.getString("teacher_phone");
				String able_subject = rs.getString("able_subject");

				Teacher t = new Teacher();
				t.setTeacher_id(teacher_id);
				t.setTeacher_name(teacher_name);
				t.setTeacher_ssn(teacher_ssn);
				t.setTeacher_phone(teacher_phone);
				t.setAbleSubject(able_subject);
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

	// 관리자 로그인> 2. 강사 계정 관리> 2. 조회 > 특정 강사의 기초 정보
	public Teacher admin_1_2_2_2(String tea_id) {
		Teacher result = new Teacher();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_teacher_view AS SELECT teacher_id, teacher_name,
			 * teacher_ssn, teacher_phone ,(SELECT LISTAGG(CAST(subject_name AS
			 * VARCHAR2(30)), '/') WITHIN GROUP(ORDER BY subject_name) FROM subject sj,
			 * able_subject asj WHERE sj.subject_id = asj.subject_id AND teacher_id =
			 * te.teacher_id) AS able_subject FROM teacher te;
			 */

			String sql = "SELECT teacher_id, teacher_name, able_subject FROM admin_teacher_view WHERE teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tea_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");
				String able_subject = rs.getString("able_subject");

				result.setTeacher_id(teacher_id);
				result.setTeacher_name(teacher_name);
				result.setAbleSubject(able_subject);
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

	// 관리자 로그인> 2. 강사 계정 관리> 2. 조회 > 특정 강사의 과목 정보
	public List<BasicInfo> admin_1_2_2_3(String tea_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT subject_name ,os_begin,os_end,course_name,oc_begin,oc_end,textbook_name,room_name, progress FROM admin_os_view WHERE teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tea_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String textbook_name = rs.getString("textbook_name");
				String room_name = rs.getString("room_name");
				int progress = rs.getInt("progress");

				BasicInfo info = new BasicInfo();
				info.setSubject_name(subject_name);
				info.setOs_begin(os_begin);
				info.setOs_end(os_end);
				info.setCourse_name(course_name);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setTextbook_name(textbook_name);
				info.setRoom_name(room_name);
				info.setProgress(progress);
				result.add(info);
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

	/////////////////// 추가//////////
	public List<BasicInfo> ablesubjectcheck(String teacher_id) {
		List<BasicInfo> list = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "select subject_id  from able_subject where teacher_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String subject_id = rs.getString("subject_id");

				BasicInfo info = new BasicInfo();
				info.setSubject_id(subject_id);
				list.add(info);
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

		return list;
	}

	// 관리자 로그인> 2. 강사 계정 관리> 3. 삭제 > 강의가능과목 삭제
	public int admin_1_2_3_1(String teacher_id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM able_subject WHERE teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
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

	// 관리자 로그인> 2. 강사 계정 관리> 3. 삭제 > 강사 삭제
	public int admin_1_2_3_2(String teacher_id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM teacher WHERE teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher_id);
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

	// 관리자 로그인> 2. 강사 계정 관리> 4. 수정 > 강사정보
	public List<Teacher> admin_1_2_4_1() {
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
			 * te.teacher_id) AS able_subject FROM teacher te;
			 */

			String sql = "SELECT teacher_id, teacher_name, teacher_ssn, teacher_phone, able_subject FROM admin_teacher_view ORDER BY teacher_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");
				String teacher_ssn = rs.getString("teacher_ssn");
				String teacher_phone = rs.getString("teacher_phone");
				String able_subject = rs.getString("able_subject");

				Teacher t = new Teacher();
				t.setTeacher_id(teacher_id);
				t.setTeacher_name(teacher_name);
				t.setTeacher_ssn(teacher_ssn);
				t.setTeacher_phone(teacher_phone);
				t.setAbleSubject(able_subject);
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

	/////////////////////////// 트랜잭션2////////////////////////////////////
	// 강사수정
	public String admin_1_2_4_2(Teacher t, String[] subjects) {
		String temp = "101"; // 글쓰기 실패

		Connection conn = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;

		try {
			conn = DBConnection.connect();

			// 트랜잭션 처리를 위한 설정 추가 -> autocommit false 설정
			conn.setAutoCommit(false);

			String sql2 = "update teacher set teacher_name=?, teacher_ssn=?, teacher_phone=? where teacher_id=?";
			System.out.println(sql2);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, t.getTeacher_name());
			pstmt2.setString(2, t.getTeacher_ssn());
			pstmt2.setString(3, t.getTeacher_phone());
			pstmt2.setString(4, t.getTeacher_id());
			pstmt2.executeUpdate();

			/*
			 * int teachersize= 0; //원래 체크되어잇는값 개수 open_course String sql4 =
			 * "select count(teacher_id) AS teachersize from able_subject where teacher_id=?"
			 * ; System.out.println(sql4); pstmt4 = conn.prepareStatement(sql4);
			 * pstmt4.setString(1, t.getTeacher_id());
			 * 
			 * ResultSet rs = pstmt4.executeQuery();
			 * 
			 * while (rs.next()) { teachersize = rs.getInt("teachersize");
			 * 
			 * 
			 * System.out.println("몇개잇는지(able_subject) : " + teachersize); }
			 * 
			 * rs.close();
			 */

			String sql5 = "DELETE FROM able_subject WHERE teacher_id = ? AND\r\n"
					+ "subject_id NOT IN (SELECT subject_id FROM open_subject WHERE teacher_id = ? )";
			/* String sql5 = "DELETE FROM able_subject WHERE teacher_id = ?"; */
			System.out.println(sql5);
			pstmt5 = conn.prepareStatement(sql5);
			pstmt5.setString(1, t.getTeacher_id());
			pstmt5.setString(2, t.getTeacher_id());
			pstmt5.executeUpdate();

			///////////////////////////////////
			/*
			 * List<String> test2 = new ArrayList<String>(); List<String> test3 = new
			 * ArrayList<String>(); String teacher_id = t.getTeacher_id(); test2 =
			 * this.test(teacher_id, conn); //open_sub에 있는 강사의 과목 목록이 들어가있다. (비활성화)
			 * 
			 * 
			 * for(int i=0; i<t.getArrayAbleSubject().length; i++) {
			 * test3.add(t.getArrayAbleSubject()[i]); }
			 * 
			 * for(int i=0; i<test3.size(); i++ ) {
			 * 
			 * for(int j=0; j<test2.size(); j++) { if(test3.get(i).equals(test2.get(j))) {
			 * test3.remove(i);
			 * 
			 * } }
			 * 
			 * }
			 */
			//////////////////////////////////

			if (subjects != null) {

				String sql3 = "insert into able_subject(teacher_id, subject_id) values(?,?)";
				pstmt3 = conn.prepareStatement(sql3);

				for (int i = 0; i < subjects.length; i++) {

					pstmt3.setString(1, t.getTeacher_id());
					pstmt3.setString(2, subjects[i]);
					pstmt3.executeUpdate();
					pstmt3.clearParameters();

				}
			}

			/*
			 * for(int i=0; i<test3.size(); i++) { pstmt3.setString(1,t.getTeacher_id());
			 * pstmt3.setString(2, test3.get(i)); pstmt3.executeUpdate();
			 * pstmt3.clearParameters();
			 * 
			 * }
			 */

			// 트랜잭션 처리를 위한 설정 추가 -> 커밋
			conn.commit();

			temp = "100"; // 글쓰기 성공

		} catch (ClassNotFoundException | SQLException e) {

			// 트랜잭션 처리를 위한 설정 추가 -> 롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			temp = "101"; // 글쓰기 실패
		} finally {
			try {

				if (pstmt2 != null)
					pstmt2.close();
				if (pstmt4 != null)
					pstmt4.close();
				if (pstmt3 != null)
					pstmt3.close();
				if (pstmt5 != null)
					pstmt5.close();
			} catch (SQLException se2) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return temp;
	}

	////////////////// 개설과목에 있는 강사의 subject_id 반환///////////
	public List<BasicInfo> test(String teacher_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "select subject_id from open_subject where teacher_id=? group by subject_id";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, teacher_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String subject_id = rs.getString("subject_id");

				BasicInfo info = new BasicInfo();
				info.setSubject_id(subject_id);
				info.setTeacher_id(teacher_id);
				result.add(info);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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

		// 성공시 result=id;
		return result;

	}
	/////////////////////////////

	/*
	 * // 관리자 로그인> 2. 강사 계정 관리> 4. 수정 > 특정 강사의 이름,주민번호,전화번호 수정 public int
	 * admin_1_2_4_2(int num, String value, String teacher_id) { int result = 0;
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBConnection.connect();
	 * 
	 * String sql = ""; switch (num) { case 1: sql =
	 * "UPDATE teacher SET teacher_name = ? WHERE teacher_id = ?"; break; case 2:
	 * sql = "UPDATE teacher SET teacher_ssn = ? WHERE teacher_id = ?"; break; case
	 * 3: sql = "UPDATE teacher SET teacher_phone = ? WHERE teacher_id = ?"; break;
	 * 
	 * default: System.out.println("잘못된선택입니다."); break; }
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, value);
	 * pstmt.setString(2, teacher_id); result = pstmt.executeUpdate();
	 * 
	 * } catch (ClassNotFoundException | SQLException e) {
	 * System.out.println(e.getMessage()); } finally {
	 * 
	 * try { if (pstmt != null) pstmt.close(); } catch (SQLException se2) { } try {
	 * DBConnection.close(); } catch (SQLException se) { se.printStackTrace(); } }
	 * return result; }
	 */

	// 관리자 로그인> 2. 강사 계정 관리> 4. 수정 > 특정 강사의 강의 가능 과목 수정
	public int admin_1_2_4_3(String value, String teacher_id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE able_subject SET subject_id = ? WHERE teacher_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setString(2, teacher_id);
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

	// 관리자 로그인> 2. 강사 계정 관리> 4. 수정 > 특정 강사의 정보
	public List<Teacher> admin_1_2_4_4(String tea_id) {
		List<Teacher> result = new ArrayList<Teacher>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT teacher_id, teacher_name FROM teacher Where teacher_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tea_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");

				Teacher t = new Teacher();
				t.setTeacher_id(teacher_id);
				t.setTeacher_name(teacher_name);
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

	// 관리자로그인> 3. 개설 과정 관리> 1. 입력
	public List<BasicInfo> admin_1_3_1_1DAO(BasicInfo b) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO open_course(oc_id, room_id, oc_begin, oc_end, course_id) VALUES ((SELECT CONCAT('oc_', LPAD(REPLACE(NVL(MAX(oc_id), 'oc_001'), 'oc_') + 1, 3, '0')) AS newId FROM open_course), ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getRoom_id());
			pstmt.setString(2, b.getOc_begin());
			pstmt.setString(3, b.getOc_end());
			pstmt.setString(4, b.getCourse_id());
			pstmt.executeUpdate();

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

	// 관리자로그인> 3. 개설 과정 관리> 1. 입력 > 기본 강의실 정보
	public List<BasicInfo> admin_1_3_1_2DAO() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "SELECT room_id, room_name, room_count FROM room ORDER BY room_id";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String room_id = rs.getString("room_id");
				String room_name = rs.getString("room_name");
				int room_count = rs.getInt("room_count");

				BasicInfo info = new BasicInfo();
				info.setRoom_id(room_id);
				info.setRoom_name(room_name);
				info.setRoom_count(room_count);

				result.add(info);
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

	// 관리자로그인> 3. 개설 과정 관리> 1. 입력 > 기본 과정 정보
	public List<BasicInfo> admin_1_3_1_3DAO() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT course_id, course_name FROM course ORDER BY course_id";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");

				BasicInfo b = new BasicInfo();
				b.setCourse_id(course_id);
				b.setCourse_name(course_name);

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

	// 관리자로그인> 3. 개설 과정 관리> 1. 입력 > 입력한 과정 정보
	public List<BasicInfo> admin_1_3_1_4(String value) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT course_id, course_name FROM course WHERE course_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");

				BasicInfo b = new BasicInfo();
				b.setCourse_id(course_id);
				b.setCourse_name(course_name);
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

	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 검색 전 정보
	public List<BasicInfo> subMethod_1_3_2_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name, os_count, st_count FROM admin_oc_view ORDER BY oc_id";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				int os_count = rs.getInt("os_count");
				int st_count = rs.getInt("st_count");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setOs_count(os_count);
				info.setSt_count(st_count);

				result.add(info);
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

	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 검색한 과정 정보
	public List<BasicInfo> subMethod_1_3_2_2(String abc) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, course_name, oc_begin, oc_end FROM admin_oc_view WHERE oc_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, abc);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setCourse_name(course_name);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);

				result.add(info);
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

	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 검색한 개설 과정에 포함된 개설 과목정보
	public List<BasicInfo> subMethod_1_3_2_3(String abc) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT (SELECT os_id FROM open_subject WHERE os_id = sub.os_id) AS os_id ,(SELECT subject_name FROM subject WHERE subject_id = sub.subject_id) AS subject_name , TO_CHAR(sub.os_begin, 'YYYY-MM-DD') AS sub_os_begin , TO_CHAR(sub.os_end, 'YYYY-MM-DD') AS sub_os_end , (SELECT textbook_name FROM text_book WHERE textbook_id = sub.textbook_id) AS textbook_name , (SELECT teacher_name FROM teacher WHERE teacher_id = sub.teacher_id) AS teacher_name FROM admin_oc_view aov, open_subject sub WHERE aov.oc_id = sub.oc_id AND aov.oc_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, abc);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String sub_os_begin = rs.getString("sub_os_begin");
				String sub_os_end = rs.getString("sub_os_end");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");

				BasicInfo info = new BasicInfo();
				info.setOs_id(os_id);
				info.setSubject_name(subject_name);
				info.setOs_begin(sub_os_begin);
				info.setOs_end(sub_os_end);
				info.setTextbook_name(textbook_name);
				info.setTeacher_name(teacher_name);

				result.add(info);
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

	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 검색 한 과목의 수강생 정보
	public List<Student> subMethod_1_3_2_4(String abc) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_st_view_test AS SELECT st.student_id AS
			 * student_id , st.student_name AS student_name , st.student_ssn AS student_ssn
			 * , st.student_phone AS student_phone , TO_CHAR(st.student_hiredate,
			 * 'YYYY-MM-DD') AS student_hiredate , DECODE(drop_date, null, '수료','중도탈락') AS
			 * pass_or_drop , oc.oc_id AS oc_id , DECODE(drop_date, null, oc_end, drop_date)
			 * AS date_ FROM student st, open_course oc, drop_out do, student_history h
			 * WHERE st.student_id(+) = h.student_id AND h.oc_id = oc.oc_id(+) AND
			 * do.oc_id(+) = h.oc_id AND do.student_id(+) = h.student_id;
			 */

			String sql = "SELECT student_id, student_name, student_phone, student_hiredate, pass_or_drop, TO_CHAR(date_,'YYYY-MM-DD') AS date_ FROM admin_st_view_test WHERE oc_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, abc);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");
				String pass_or_drop = rs.getString("pass_or_drop");
				String date_ = rs.getString("date_");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);
				s.setPass_or_drop(pass_or_drop);
				s.setDate_(date_);
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

	// 관리자 로그인> 3. 개설 과정 관리> 4. 수정 > 수정 전 개설과정 정보
	public List<BasicInfo> admin_1_3_4_oc() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name FROM admin_oc_view ORDER BY oc_id";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
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
		} // end try

		// 성공시 result=id;
		return result;

	}

	// 관리자 로그인> 3. 개설 과정 관리> 4. 수정 > 검색 한 개설과정ID 정보
	public List<BasicInfo> admin_1_3_4_oc(String id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name, subject_name FROM admin_os_view WHERE oc_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				String subject_name = rs.getString("subject_name");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setSubject_name(subject_name);
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
		} // end try

		// 성공시 result=id;
		return result;

	}

	// 관리자 로그인> 4. 개설 과목 관리> 1. 입력/조회 > 개설 과정 정보
	public List<BasicInfo> admin_1_4_1_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name, os_count, st_count FROM admin_oc_view ORDER BY oc_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				int os_count = rs.getInt("os_count");
				int st_count = rs.getInt("st_count");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setOs_count(os_count);
				info.setSt_count(st_count);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 1. 입력/조회 > 검색한 개설 과정 정보
	public List<BasicInfo> admin_1_4_1_2(String value) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name FROM admin_oc_view WHERE oc_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 1. 입력/조회 > 검색한 과정의 개설 과목 정보
	public List<BasicInfo> admin_1_4_1_3(String value) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT os_id, os_begin, os_end, room_name, course_name, subject_name, textbook_name, teacher_name FROM admin_os_view WHERE oc_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				String subject_name = rs.getString("subject_name");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");

				BasicInfo info = new BasicInfo();
				info.setOs_id(os_id);
				info.setOs_begin(os_begin);
				info.setOs_end(os_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setSubject_name(subject_name);
				info.setTextbook_name(textbook_name);
				info.setTeacher_name(teacher_name);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 1. 입력 > 교재 정보
	public List<BasicInfo> admin_1_4_1_4() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT textbook_id, textbook_name, textbook_publisher FROM text_book ORDER BY textbook_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String textbook_id = rs.getString("textbook_id");
				String textbook_name = rs.getString("textbook_name");
				String textbook_publisher = rs.getString("textbook_publisher");

				BasicInfo info = new BasicInfo();
				info.setTextbook_id(textbook_id);
				info.setTextbook_name(textbook_name);
				info.setTextbook_publisher(textbook_publisher);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 1. 입력 > 개설과목 테이블에 개설 과목 정보 추가
	public int admin_1_4_1_5(BasicInfo b) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO open_subject(os_id, subject_id, os_begin, os_end, textbook_id, teacher_id, oc_id) VALUES ((SELECT CONCAT('os_', LPAD(REPLACE(NVL(MAX(os_id), 'os_001'), 'os_') + 1, 3, '0')) AS newId FROM open_subject), ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getSubject_id());
			pstmt.setString(2, b.getOs_begin());
			pstmt.setString(3, b.getOs_end());
			pstmt.setString(4, b.getTextbook_id());
			pstmt.setString(5, b.getTeacher_id());
			pstmt.setString(6, b.getOc_id());
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

	// 관리자 로그인> 4. 개설 과목 관리> 3. 삭제 > 개설 과목,과정 정보
	public List<BasicInfo> admin_1_4_3_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT os_id, subject_name, os_begin, os_end, room_name, course_name FROM admin_os_view ORDER BY os_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setSubject_name(subject_name);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setRoom_name(room_name);
				b.setCourse_name(course_name);
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

	// 관리자 로그인> 4. 개설 과목 관리> 3. 삭제 > 검색한 과목 정보
	public List<BasicInfo> admin_1_4_3_2(String value) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT os_id, subject_name, os_begin, os_end, room_name, course_name FROM admin_os_view WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setSubject_name(subject_name);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setRoom_name(room_name);
				b.setCourse_name(course_name);
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

	// 관리자 로그인> 4. 개설 과목 관리> 3. 삭제
	public int admin_1_4_3_3(String value) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM open_subject WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
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

	// 관리자 로그인> 4. 개설 과목 관리> 4. 수정 > 개설 과목,과정 정보
	public List<BasicInfo> admin_1_4_4_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT os_id, os_begin, os_end, room_name, course_name, subject_name, textbook_name, teacher_name FROM admin_os_view ORDER BY os_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				String subject_name = rs.getString("subject_name");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");

				BasicInfo info = new BasicInfo();
				info.setOs_id(os_id);
				info.setOs_begin(os_begin);
				info.setOs_end(os_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setSubject_name(subject_name);
				info.setTextbook_name(textbook_name);
				info.setTeacher_name(teacher_name);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 4. 수정 > 검색한 과목 정보
	public List<BasicInfo> admin_1_4_4_2(String value) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_os_view AS SELECT os.os_id AS os_id ,(SELECT
			 * subject_name FROM subject WHERE subject_id = os.subject_id) AS subject_name
			 * ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_begin ,TO_CHAR(os.os_end,
			 * 'YYYY-MM-DD') AS os_end ,(SELECT course_name FROM course WHERE course_id =
			 * oc.course_id) AS course_name ,(SELECT teacher_name FROM teacher WHERE
			 * teacher_id = os.teacher_id) AS teacher_name ,TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') AS oc_begin ,TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end
			 * ,(SELECT textbook_name FROM text_book WHERE textbook_id = os.textbook_id) AS
			 * textbook_name ,(SELECT room_name FROM room WHERE room_id = oc.room_id) AS
			 * room_name , CASE WHEN TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') < TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') AND TO_CHAR(oc.oc_end, 'YYYY-MM-DD') > TO_CHAR(SYSDATE,
			 * 'YYYY-MM-DD') THEN 1 --강의 진행중 WHEN TO_CHAR(oc.oc_end, 'YYYY-MM-DD') <
			 * TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 0 --강의종료 WHEN TO_CHAR(oc.oc_begin,
			 * 'YYYY-MM-DD') > TO_CHAR(SYSDATE, 'YYYY-MM-DD') THEN 2 --강의예정 END AS progress
			 * , os.teacher_id AS teacher_id , oc.oc_id AS oc_id FROM open_subject os,
			 * open_course oc WHERE os.oc_id(+) = oc.oc_id;
			 */

			String sql = "SELECT os_id, os_begin, os_end, room_name, course_name, subject_name, textbook_name, teacher_name FROM admin_os_view WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				String subject_name = rs.getString("subject_name");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");

				BasicInfo info = new BasicInfo();
				info.setOs_id(os_id);
				info.setOs_begin(os_begin);
				info.setOs_end(os_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setSubject_name(subject_name);
				info.setTextbook_name(textbook_name);
				info.setTeacher_name(teacher_name);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 4. 수정
	public int admin_1_4_4_3(int num, String value1, String value2) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			String sql = "";
			switch (num) {
			case 1:
				sql = "UPDATE open_subject SET subject_id = ? WHERE os_id = ?";
				break;
			case 2:
				sql = "UPDATE open_subject SET os_begin = ? WHERE os_id = ?";
				break;
			case 3:
				sql = "UPDATE open_subject SET os_end = ? WHERE os_id = ?";
				break;
			case 4:
				sql = "UPDATE open_subject SET textbook_id = ? WHERE os_id = ?";
				break;
			case 5:
				sql = "UPDATE open_subject SET teacher_id = ? WHERE os_id = ?";
				break;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value1);
			pstmt.setString(2, value2);
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

	// 관리자 로그인> 4. 개설 과목 관리> 4. 수정 > 교재 정보
	public List<BasicInfo> admin_1_4_4_4() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT textbook_id, textbook_name, textbook_publisher FROM text_book ORDER BY textbook_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String textbook_id = rs.getString("textbook_id");
				String textbook_name = rs.getString("textbook_name");
				String textbook_publisher = rs.getString("textbook_publisher");

				BasicInfo info = new BasicInfo();
				info.setTextbook_id(textbook_id);
				info.setTextbook_name(textbook_name);
				info.setTextbook_publisher(textbook_publisher);
				result.add(info);
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

	// 관리자 로그인> 4. 개설 과목 관리> 4. 수정 > 강사 정보
	public List<Teacher> admin_1_4_4_5() {
		List<Teacher> result = new ArrayList<Teacher>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT teacher_id, teacher_name, teacher_ssn, teacher_phone, TOCHAR(teacher_hiredate,'YYYY-MM-DD') AS teacher_hiredate FROM teacher ORDER BY teacher_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");
				String teacher_ssn = rs.getString("teacher_ssn");
				String teacher_phone = rs.getString("teacher_phone");
				String teacher_hiredate = rs.getString("teacher_hiredate");

				Teacher info = new Teacher();
				info.setTeacher_id(teacher_id);
				info.setTeacher_name(teacher_name);
				info.setTeacher_ssn(teacher_ssn);
				info.setTeacher_phone(teacher_phone);
				info.setTeacher_hiredate(teacher_hiredate);

				result.add(info);
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

	// 관리자 로그인> 5. 수강생 관리 > 1. 입력
	public int admin_1_5_1_1(Student s) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "INSERT INTO student(student_id, student_name, student_phone, student_ssn, student_hiredate)  VALUES((SELECT CONCAT('st_', LPAD(REPLACE(NVL(MAX(student_id), 'st_001'), 'st_') + 1, 3, '0')) AS newstudent_id FROM student),?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_name());
			pstmt.setString(2, s.getStudent_phone());
			pstmt.setString(3, s.getStudent_ssn());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {

			}
		}
		try {
			DBConnection.close();
		} catch (SQLException se) {
			se.printStackTrace();

		}

		return result;
	}

	// 개설예정인 과정을 얻어오는 메소드
	public List<BasicInfo> admin_1_5_1_2() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name, os_count, st_count FROM admin_oc_view WHERE oc_endbegin = '강의예정' ORDER BY oc_id";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				int os_count = rs.getInt("os_count");
				int st_count = rs.getInt("st_count");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setOs_count(os_count);
				info.setSt_count(st_count);
				result.add(info);
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

	// 수강생 아이디와 개설과정의 입력을 하는 메소드
	public List<BasicInfo> admin_1_5_1_2(String id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_view AS SELECT cou.oc_id AS oc_id ,
			 * TO_CHAR(cou.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(cou.oc_end,
			 * 'YYYY-MM-DD') AS oc_end , (SELECT room_name FROM room WHERE room_id =
			 * cou.room_id) AS room_name , (SELECT course_name FROM course WHERE course_id =
			 * cou.course_id) AS course_name , (SELECT COUNT(*) FROM open_subject WHERE
			 * oc_id = cou.oc_id) AS os_count , (SELECT COUNT(*) FROM student_history WHERE
			 * oc_id = cou.oc_id) AS room_total ,CASE WHEN (SYSDATE > oc_end ) THEN '강의종료'
			 * WHEN (SYSDATE < oc_begin) THEN '강의예정' else '강의중' END AS oc_endbegin FROM
			 * open_course cou;
			 */

			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name, st_count FROM admin_oc_view WHERE oc_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				int st_count = rs.getInt("st_count");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setCourse_name(course_name);
				info.setSt_count(st_count);
				result.add(info);
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

	// 개설과정아이디로 수강생 정보입력을 연결하는 메소드
	public int admin_1_5_1_3(String oc_id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			String sql = "INSERT INTO student_history(student_id, oc_id) VALUES((SELECT CONCAT('st_', LPAD(REPLACE(NVL(MAX(student_id), 'st_001'), 'st_') + 1, 3, '0')) AS newId FROM student_history) ,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oc_id);
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

	// 관리자 로그인> 5. 수강생 관리> 2. 조회
	public List<Student> admin_1_5_2_1(String name) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT st.student_id, st.student_name, st.student_phone "
					+ ", (SELECT COUNT(oc_id) FROM student_history WHERE student_id = st.student_id) "
					+ "AS course_count, TO_CHAR(st.student_hiredate, 'YYYY-MM-DD') AS student_hiredate "
					+ "FROM student st WHERE st.student_name= ? ORDER BY student_id";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				int course_count = rs.getInt("course_count");
				String student_hiredate = rs.getString("student_hiredate");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setCourse_count(course_count);
				s.setStudent_hiredate(student_hiredate);
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

	// 수강생 아이디를 통해 수강생의 정보를 얻어오는 메소드
	public List<Student> admin_1_5_2_2(String soo) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * SELECT student_id, student_name, TO_CHAR(student_hiredate, 'YYYY-MM-DD') AS
			 * student_hiredate FROM student WHERE student_id ='st_001';
			 */
			String sql = "SELECT student_id, student_name, TO_CHAR(student_hiredate, 'YYYY-MM-DD') "
					+ "AS student_hiredate FROM student WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, soo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_hiredate = rs.getString("student_hiredate");

				Student st = new Student();

				st.setStudent_id(student_id);
				st.setStudent_name(student_name);
				st.setStudent_hiredate(student_hiredate);

				result.add(st);

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

	// 수강생 아이디와 admin_drop_out_view1의 연결을 통해 특정수강생의 과정정보를 얻어오는 메소드
	public List<BasicInfo> subMethod_1_5_2_3(String soo) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_drop_out_view1 AS SELECT (SELECT course_name
			 * FROM course WHERE course_id = oc.course_id) AS course_name
			 * ,TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') AS oc_oc_begin ,TO_CHAR(oc.oc_end,
			 * 'YYYY-MM-DD') AS oc_oc_end ,TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS os_os_begin
			 * ,TO_CHAR(os.os_end, 'YYYY-MM-DD') AS os_os_end ,(SELECT room_name FROM room
			 * WHERE room_id = oc.room_id) AS room_name , DECODE(drop_date, null,
			 * '수료','중도탈락') AS date_ , d.drop_date AS drop_date , st.student_id AS
			 * student_id , oc. oc_id AS oc_id , os.os_id AS os_id FROM student st,
			 * student_history his, drop_out d, open_course oc, open_subject os WHERE
			 * st.student_id = his.student_id AND oc.oc_id = his.oc_id AND his.student_id =
			 * d.student_id(+) AND his.oc_id = d.oc_id(+) AND oc.oc_id = os.oc_id(+);
			 */

			String sql = "SELECT oc_id, course_name, oc_oc_begin, oc_oc_end, os_id, os_os_begin"
					+ ", os_os_end, room_name, date_, drop_date FROM admin_drop_out_view1 WHERE student_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, soo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_oc_begin");
				String oc_end = rs.getString("oc_oc_end");
				String os_id = rs.getString("os_id");
				String os_begin = rs.getString("os_os_begin");
				String os_end = rs.getString("os_os_end");
				String room_name = rs.getString("room_name");
				String date_ = rs.getString("date_");
				String drop_date = rs.getString("drop_date");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setCourse_name(course_name);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setOs_id(os_id);
				info.setOs_begin(os_begin);
				info.setOs_end(os_end);
				info.setRoom_name(room_name);
				info.setDate_(date_);
				info.setDrop_date(drop_date);
				result.add(info);
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

	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 과정 기본정보 리스트
	public List<BasicInfo> admin_1_6_1_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "SELECT course_id, course_name FROM course";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");

				BasicInfo t = new BasicInfo();
				t.setCourse_id(course_id);
				t.setCourse_name(course_name);
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

	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 선택과정과 동일한 이름의 개설과정 리스트
	public List<BasicInfo> admin_1_6_1_2(String couId) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			// ? = 과정id
			String sql = "SELECT oc_id, oc_begin, oc_end, room_name, course_name, os_count, room_total FROM admin_oc_view WHERE oc_id = REPLACE( ?,'cou_','oc_')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, couId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String course_name = rs.getString("course_name");
				int os_count = rs.getInt("os_count");
				int st_count = rs.getInt("room_total");

				BasicInfo b = new BasicInfo();
				b.setOc_id(oc_id);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				b.setRoom_name(room_name);
				b.setCourse_name(course_name);
				b.setOs_count(os_count);
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

	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 선택한 개설과정의 개설과목 리스트
	public List<BasicInfo> admin_1_6_1_3(String couId) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			String sql = "SELECT os_id, subject_name, os_begin, os_end, course_name, oc_begin, oc_end, room_name, textbook_name, teacher_name"
					+ ", grade_ox, ex_qs FROM admin_grade_view1 WHERE oc_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, couId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");
				String score_regi_ck = rs.getString("grade_ox");
				String ex_qs_ck = rs.getString("ex_qs");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setSubject_name(subject_name);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setCourse_name(course_name);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				b.setRoom_name(room_name);
				b.setTextbook_name(textbook_name);
				b.setTeacher_name(teacher_name);
				b.setScore_regi_ck(score_regi_ck);
				b.setEx_qs_ck(ex_qs_ck);

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

	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 선택 과목의 학생별 성적 리스트 과목정보
	public List<ScoreAndGrade> admin_1_6_1_4(String sub) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			String sql = "SELECT os_id, subject_name, os_begin, os_end, sc_attend, sc_written, sc_practice FROM admin_grade_view3 WHERE os_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				if (count == 1) {
					break;
				}
				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");

				ScoreAndGrade b = new ScoreAndGrade();
				b.setOs_id(os_id);
				b.setSubject_name(subject_name);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setSc_attend(sc_attend);
				b.setSc_written(sc_written);
				b.setSc_practice(sc_practice);
				result.add(b);
				++count;
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

	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 선택한 과목 수강생 정보 및 성적 리스트
	public List<Student> admin_1_6_1_5(String sub) {
		List<Student> result = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			// os_id
			String sql = "SELECT st.student_id, st.student_name, st.student_phone, g.grade_attend, g.grade_written, g.grade_practice, "
					+ "g.grade_attend + g.grade_written + g.grade_practice AS gradeSum FROM student st, student_history h, grade g, open_subject os"
					+ " WHERE st.student_id = h.student_id(+) AND os.os_id = g.os_id(+) AND h.student_id = g.student_id AND os.os_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				int grade_attend = rs.getInt("grade_attend");
				int grade_written = rs.getInt("grade_written");
				int grade_practice = rs.getInt("grade_practice");
				int grade_total = rs.getInt("gradeSum");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
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

	// 관리자 로그인> 6.성적조회 > 2. 개인 성적 조회 > 입력한 수강생 동명이인 리스트
	public List<Student> admin_1_6_2_1(String stName) {
		List<Student> result = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			// os_id
			String sql = "SELECT student_id, student_name , student_phone,"
					+ "(SELECT COUNT(oc_id) FROM student_history WHERE student_id = st.student_id) AS student_history"
					+ ", TO_CHAR(student_hiredate,'YYYY-MM-DD') AS student_hiredate FROM student st WHERE student_name = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, stName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				int course_count = rs.getInt("student_history");
				String student_hiredate = rs.getString("student_hiredate");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setCourse_count(course_count);
				s.setStudent_hiredate(student_hiredate);
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

	// 관리자 로그인> 6.성적조회 > 2. 개인 성적 조회 > 조회한 수강색 수강목록 리스트
	public List<BasicInfo> admin_1_6_2_2(String stId) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			// 학생 아이디로 찾아야 함.
			String sql = "SELECT oc_id, course_name, oc_begin, oc_end, room_name"
					+ " FROM admin_st_view2 WHERE student_id = ? ORDER BY student_id ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");

				BasicInfo s = new BasicInfo();
				s.setOc_id(oc_id);
				s.setCourse_name(course_name);
				s.setOc_begin(oc_begin);
				s.setOc_end(oc_end);
				s.setRoom_name(room_name);

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

	// 관리자 로그인> 6.성적조회 > 2. 개인 성적 조회 > 조회한 수강생의 과정당 과목 배점 및 성적 리스트
	public List<ScoreAndGrade> admin_1_6_2_3(String stId) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			// 학생ID
			String sql = "SELECT student_id, student_name, oc_id, course_name ,oc_begin, oc_end, room_name"
					+ " FROM admin_grade_view4 WHERE student_id = ? ORDER BY student_id ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String course_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");
				ScoreAndGrade s = new ScoreAndGrade();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setCourse_id(course_id);
				s.setCourse_name(course_name);
				s.setOc_begin(oc_begin);
				s.setOc_end(oc_end);
				s.setRoom_name(room_name);
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

	// 관리자 로그인> 6.성적조회 > 2. 개인 성적 조회 > 수강생의 과목 점수 정보 리스트
	public List<ScoreAndGrade> admin_1_6_2_4(String stId, String ocId) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			// 과정id, 학생id
			String sql = "SELECT os_id, subject_name, TO_CHAR(os_begin, 'YYYY-MM-DD') AS os_begin, "
					+ "TO_CHAR(os_end, 'YYYY-MM-DD') AS os_end, teacher_name, sc_attend, sc_written"
					+ ", sc_practice, grade_attend, grade_written, grade_practice"
					+ ",(grade_attend+grade_written+grade_practice) AS grade_total FROM stuent_g_view"
					+ " WHERE oc_id = ? AND student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ocId);
			pstmt.setString(2, stId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String subject_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String teacher_name = rs.getString("teacher_name");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				int grade_attend = rs.getInt("grade_attend");
				int grade_written = rs.getInt("grade_written");
				int grade_practice = rs.getInt("grade_practice");
				String grade_total = rs.getString("grade_total");
				ScoreAndGrade s = new ScoreAndGrade();
				s.setSubject_id(subject_id);
				s.setSubject_name(subject_name);
				s.setOs_begin(os_begin);
				s.setOs_end(os_end);
				s.setTeacher_name(teacher_name);
				s.setSc_attend(sc_attend);
				s.setSc_written(sc_written);
				s.setSc_practice(sc_practice);
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

	///////////////////////////////////////////////////////// 20170925
	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 과목 정보 (+)
	public List<BasicInfo> subMethod_1_3_4_1() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "SELECT subject_id, subject_name FROM subject";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String subject_id = rs.getString("subject_id");
				String subject_name = rs.getString("subject_name");

				BasicInfo s = new BasicInfo();
				s.setSubject_id(subject_id);
				s.setSubject_name(subject_name);
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

	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 교재 정보 (+)
	public List<BasicInfo> subMethod_1_3_4_2() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "SELECT textbook_id, textbook_name, textbook_publisher FROM text_book ORDER BY textbook_id";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String textbook_id = rs.getString("textbook_id");
				String textbook_name = rs.getString("textbook_name");
				String textbook_publisher = rs.getString("textbook_publisher");

				BasicInfo b = new BasicInfo();
				b.setTextbook_id(textbook_id);
				b.setTextbook_name(textbook_name);
				b.setTextbook_publisher(textbook_publisher);
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

	// 관리자 로그인> 3. 개설 과정 관리 2. 조회 > 강사 정보(+)
	public List<BasicInfo> subMethod_1_3_4_3() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "SELECT teacher_id, teacher_name, teacher_ssn, teacher_phone, able_subject FROM admin_teacher_view ORDER BY teacher_id";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String teacher_id = rs.getString("teacher_id");
				String teacher_name = rs.getString("teacher_name");
				/*
				 * String teacher_ssn = rs.getString("teacher_ssn"); String teacher_phone =
				 * rs.getString("teacher_phone");
				 */
				String able_subject = rs.getString("able_subject");

				BasicInfo b = new BasicInfo();
				b.setTeacher_id(teacher_id);
				b.setTeacher_name(teacher_name);
				b.setAbleSubject(able_subject);
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

	// 개설과목 수정 정보 출력
	public List<BasicInfo> admin_1_5_6_2DAO(String os_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT subject_name, os_begin, os_end, textbook_name, teacher_name FROM admin_os_view WHERE os_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");

				BasicInfo b = new BasicInfo();
				b.setSubject_name(subject_name);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setTextbook_name(textbook_name);
				b.setTeacher_name(teacher_name);

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

	// 관리자로그인> 3. 개설 과목 관리> 1. 입력
	public List<BasicInfo> admin_1_3_4_4DAO(BasicInfo b) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO open_subject(os_id, subject_id, os_begin, os_end, textbook_id, teacher_id, oc_id) VALUES ((SELECT CONCAT('os_', LPAD(REPLACE(NVL(MAX(os_id), 'os_001'), 'os_') + 1, 3, '0')) AS newId FROM open_subject), ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getSubject_id());
			pstmt.setString(2, b.getOs_begin());
			pstmt.setString(3, b.getOs_end());
			pstmt.setString(4, b.getTextbook_id());
			pstmt.setString(5, b.getTeacher_id());
			pstmt.setString(6, b.getOc_id());
			pstmt.executeUpdate();

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

	// 관리자 로그인> 4. 개설 과목 관리> 4. 수정
	public List<BasicInfo> admin_1_3_4_5DAO(BasicInfo b) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			String sql = "UPDATE open_subject SET subject_id = ?, os_begin = ?, os_end = ?, textbook_id = ?, teacher_id = ? WHERE os_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getSubject_id());
			pstmt.setString(2, b.getOs_begin());
			pstmt.setString(3, b.getOs_end());
			pstmt.setString(4, b.getTextbook_id());
			pstmt.setString(5, b.getTeacher_id());
			pstmt.setString(6, b.getOs_id());
			pstmt.executeUpdate();

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

	// 관리자 로그인> 4. 개설 과목 관리> 3. 삭제
	public List<BasicInfo> admin_1_3_4_6DAO(String os_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM open_subject WHERE os_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os_id);
			pstmt.executeUpdate();

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

	// 개설과정 수정 정보 출력
	public List<BasicInfo> admin_1_5_6_1DAO(String oc_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT course_name, oc_begin, oc_end, room_name FROM admin_oc_view WHERE oc_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oc_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String course_name = rs.getString("course_name");
				String room_name = rs.getString("room_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");

				BasicInfo b = new BasicInfo();
				b.setRoom_name(room_name);
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
			} catch (SQLException se) {
				se.printStackTrace();

			}

		}

		return result;

	}

	// 관리자로그인> 3. 개설 과정 관리> 3. 수정
	public List<BasicInfo> admin_1_3_3_1DAO(BasicInfo b) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "UPDATE open_course SET course_id = ? , room_id = ?, oc_begin=?, oc_end=?  WHERE oc_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getCourse_id());
			pstmt.setString(2, b.getRoom_id());
			pstmt.setString(3, b.getOc_begin());
			pstmt.setString(4, b.getOc_end());
			pstmt.setString(5, b.getOc_id());
			pstmt.executeUpdate();

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

	// 관리자 로그인> 3. 개설 과정 관리> 4. 삭제
	public List<BasicInfo> admin_1_3_3_2DAO(String oc_id) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM open_course WHERE oc_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oc_id);
			pstmt.executeUpdate();

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

	// 관리자 로그인> 5. 수강생 관리> 2. 조회
	public List<Student> admin_1_5_2_1(String key, String value) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			String sql = "SELECT student_id, student_name, student_phone , (SELECT COUNT(oc_id) FROM student_history WHERE student_id = st.student_id) AS course_count, TO_CHAR(st.student_hiredate, 'YYYY-MM-DD') AS student_hiredate FROM student st ";

			switch (key) {
			case "all":
				break;
			case "student_id":
				sql += " WHERE INSTR(student_id, ?) > 0"; // 번호 기준
				break;
			case "student_name":
				sql += " WHERE INSTR(student_name, ?) > 0"; // 이름 기준
				break;
			case "student_phone":
				sql += " WHERE INSTR(student_phone, ?) > 0"; // 전화번호 기준
				break;

			}
			sql += " ORDER BY student_id";

			pstmt = conn.prepareStatement(sql);

			switch (key) {
			case "all":
				break;
			case "student_id":
			case "student_name":
			case "student_phone":
				pstmt.setString(1, value);
				break;
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				int course_count = rs.getInt("course_count");
				String student_hiredate = rs.getString("student_hiredate");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setCourse_count(course_count);
				s.setStudent_hiredate(student_hiredate);
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

	public List<BasicInfo> admin_1_5_5_3DAO() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT oc_id, course_name, oc_begin, oc_end FROM admin_oc_view";

			pstmt = conn.prepareStatement(sql);
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
			} catch (SQLException se) {
				se.printStackTrace();

			}

		}

		return result;

	}

	// 수강생 중도탈락
	public List<Student> admin_1_5_5_4DAO(Student s) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO drop_out(student_id, oc_id, drop_date) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_id());
			pstmt.setString(2, s.getOc_id());
			pstmt.setString(3, s.getDrop_date());
			pstmt.executeUpdate();

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

	// 관리자 로그인> 5. 수강생 관리 > 3. 수정
	public List<Student> admin_1_5_3_1DAO(Student s) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();
			String sql = "UPDATE student SET student_name = ?, student_phone = ?, student_hiredate = ? WHERE student_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_name());
			pstmt.setString(2, s.getStudent_phone());
			pstmt.setString(3, s.getStudent_hiredate());
			pstmt.setString(4, s.getStudent_id());
			pstmt.executeUpdate();

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

	// 관리자 로그인> 5. 수강생 관리 > 4. 삭제
	public List<Student> admin_1_5_4_1DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM student WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.executeUpdate();

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

	// 관리자 로그인> 5. 수강생 관리 > 5. 수강생 정보
	public List<Student> admin_1_5_5_1DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			String sql = "SELECT student_id, student_name  FROM student WHERE student_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_name = rs.getString("student_name");
				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
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

	// 수강생 아이디와 admin_drop_out_view1의 연결을 통해 특정수강생의 과정정보를 얻어오는 메소드
	public List<BasicInfo> subMethod_1_5_5_2(String soo) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "SELECT DISTINCT oc_id, course_name, oc_oc_begin, oc_oc_end"
					+ ", room_name, date_, TO_CHAR(drop_date,'YYYY-MM-DD') AS drop_date FROM admin_drop_out_view1 WHERE student_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, soo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_oc_begin");
				String oc_end = rs.getString("oc_oc_end");
				String room_name = rs.getString("room_name");
				String date_ = rs.getString("date_");
				String drop_date = rs.getString("drop_date");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setCourse_name(course_name);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				info.setRoom_name(room_name);
				info.setDate_(date_);
				info.setDrop_date(drop_date);
				result.add(info);
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

	// 수강생 과정추가
	public List<Student> admin_1_5_5_5DAO(Student s) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "INSERT INTO student_history(student_id, oc_id) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_id());
			pstmt.setString(2, s.getOc_id());
			pstmt.executeUpdate();

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

	// 수강생 과정취소
	public List<Student> admin_1_5_5_6DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			String sql = "DELETE FROM student_history WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.executeUpdate();

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

	// 수강생 관리 수정 정보 출력
	public List<Student> admin_1_5_6_3DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT student_name, student_phone, TO_CHAR(student_hiredate,'YYYY-MM-DD') AS student_hiredate FROM student WHERE student_id =?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				String student_hiredate = rs.getString("student_hiredate");

				Student s = new Student();
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				s.setStudent_hiredate(student_hiredate);

				result.add(s);

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

	// 수강생 관리 과정추가 정보 출력
	public List<Student> admin_1_5_6_5DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT student_id, student_name, student_ssn, student_phone FROM student WHERE student_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String student_name = rs.getString("student_name");
				String student_ssn = rs.getString("student_ssn");
				String student_phone = rs.getString("student_phone");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_ssn(student_ssn);
				s.setStudent_phone(student_phone);

				result.add(s);

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

	// 수강생 관리 과정취소 정보 출력
	public List<Student> admin_1_5_6_6DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT student_id, student_name, (SELECT course_name FROM course c, open_course oc WHERE a.oc_id = oc.oc_id AND c.course_id = oc.course_id) AS course_name FROM admin_st_view a WHERE student_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String student_name = rs.getString("student_name");
				String course_name = rs.getString("course_name");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setCourse_name(course_name);

				result.add(s);

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

	// 수강생 관리 탈락 정보 출력
	public List<Student> admin_1_5_6_4DAO(String student_id) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBConnection.connect();

			String sql = "SELECT student_id, student_name, (SELECT course_name FROM course c, open_course oc WHERE a.oc_id = oc.oc_id AND c.course_id = oc.course_id) AS course_name, drop_date FROM admin_st_view a WHERE student_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String student_name = rs.getString("student_name");
				String course_name = rs.getString("course_name");
				String drop_date = rs.getString("drop_date");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setCourse_name(course_name);
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

	// ok
	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 과정 기본정보 리스트
	// 관리자 로그인> 1. 성적조회> 조회 전 과정 출력
	public List<BasicInfo> admin_gpasearch() {
		List<BasicInfo> result = new ArrayList<BasicInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_Info1 AS SELECT oc.oc_id AS oc_id ,
			 * c.course_name AS course_name , TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') AS oc_begin
			 * , TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end , (SELECT COUNT(*) FROM
			 * open_subject WHERE oc_id = oc.oc_id ) AS os_count , r.room_name AS room_name
			 * , (SELECT COUNT(student_id) FROM student_history WHERE oc_id = oc.oc_id) AS
			 * st_count FROM open_course oc, room r, course c WHERE r.room_id = oc.room_id
			 * AND c.course_id = oc.course_id; SELECT oc_id, course_name, oc_begin, oc_end,
			 * os_count, room_name, st_count FROM admin_oc_Info1 ORDER BY oc_id
			 */

			String sql = "SELECT oc_id, course_name, oc_begin, oc_end, os_count, room_name, st_count FROM admin_oc_Info1 ORDER BY oc_id";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				int os_count = rs.getInt("os_count");
				String room_name = rs.getString("room_name");
				int st_count = rs.getInt("st_count");

				BasicInfo b = new BasicInfo();
				b.setOc_id(oc_id);
				b.setCourse_name(course_name);
				b.setOc_begin(oc_begin);
				b.setOc_end(oc_end);
				b.setOs_count(os_count);
				b.setRoom_name(room_name);
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

	// ok
	// 공통 메소드: 과정 ID, 과정명, 과정시작기간, 과정종료기간
	public List<BasicInfo> adminoc_top(String soo) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_Info1 AS SELECT oc.oc_id AS oc_id ,
			 * c.course_name AS course_name , TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') AS oc_begin
			 * , TO_CHAR(oc.oc_end, 'YYYY-MM-DD') AS oc_end , (SELECT COUNT(*) FROM
			 * open_subject WHERE oc_id = oc.oc_id ) AS os_count , r.room_name AS room_name
			 * , (SELECT COUNT(student_id) FROM student_history WHERE oc_id = oc.oc_id) AS
			 * st_count FROM open_course oc, room r, course c WHERE r.room_id = oc.room_id
			 * AND c.course_id = oc.course_id;
			 * 
			 * 
			 * SELECT oc_id, course_name, oc_begin, oc_end FROM admin_oc_Info1 WHERE
			 * oc_id='oc_001';
			 */

			String sql = "SELECT oc_id, course_name, oc_begin, oc_end FROM admin_oc_Info1 WHERE oc_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, soo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");

				BasicInfo info = new BasicInfo();
				info.setOc_id(oc_id);
				info.setCourse_name(course_name);
				info.setOc_begin(oc_begin);
				info.setOc_end(oc_end);
				result.add(info);
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
	// 관리자 로그인> 6.성적조회 > 1. 과정 정보 조회 > 조회버튼 누른 과정정보
	public List<BasicInfo> admin_ocgpa_Info(String soo) {
		List<BasicInfo> result = new ArrayList<BasicInfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_oc_Info2 AS SELECT os.oc_id AS oc_id, os.os_id
			 * AS os_id, os_begin, os_end, subject_name , textbook_name, TEACHER_NAME,
			 * room_name , (SELECT COUNT(grade_written) AS count_ FROM grade WHERE
			 * os_id=os.os_id) AS ex_qs_ck , (SELECT COUNT(ex_qs) AS count_ FROM score WHERE
			 * os_id=os.os_id) AS score_regi_ck FROM open_subject os, subject sub, text_book
			 * tb, teacher tea, open_course oc, room ro WHERE os.subject_id = sub.subject_id
			 * AND os.TEXTBOOK_ID = tb.TEXTBOOK_ID AND os.TEACHER_ID = tea.TEACHER_ID AND
			 * os.oc_id = oc.oc_id AND oc.room_id = ro.room_id;
			 */
			String sql = "SELECT oc_id, os_id, os_begin, os_end, subject_name , textbook_name, teacher_name, room_name, ex_qs_ck, score_regi_ck  FROM admin_oc_Info2  WHERE oc_id=? ORDER BY os_id";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, soo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String os_id = rs.getString("os_id");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String subject_name = rs.getString("subject_name");
				String textbook_name = rs.getString("textbook_name");
				String teacher_name = rs.getString("teacher_name");
				String room_name = rs.getString("room_name");
				String ex_qs_ck = rs.getString("ex_qs_ck");
				String score_regi_ck = rs.getString("score_regi_ck");

				BasicInfo b = new BasicInfo();
				b.setOs_id(os_id);
				b.setOs_begin(os_begin);
				b.setOs_end(os_end);
				b.setSubject_name(subject_name);
				b.setTextbook_name(textbook_name);
				b.setTeacher_name(teacher_name);
				b.setRoom_name(room_name);
				b.setEx_qs_ck(ex_qs_ck);
				b.setScore_regi_ck(score_regi_ck);

				result.add(b);
			}

			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
			}

		}

		return result;
	}

	// ok
	// 공통 메소드: 과목 ID, 과목명, 과목시작기간, 과목종료기간, 출결배점, 필기배점, 실기배점
	public List<ScoreAndGrade> admin_gpabasictop(String os) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW amin_grade_basicview1 AS SELECT oc.oc_id AS oc_id,
			 * os.os_id AS os_id , (SELECT subject_name FROM subject WHERE subject_id =
			 * os.subject_id) AS subject_name , TO_CHAR(os.os_begin, 'YYYY-MM-DD') AS
			 * os_begin , TO_CHAR(os.os_end, 'YYYY-MM-DD') AS os_end , s.sc_attend AS
			 * sc_attend, s.sc_written AS sc_written , s.sc_practice AS sc_practice FROM
			 * open_subject os, score s, open_course oc WHERE oc.oc_id = os.oc_id AND
			 * s.os_id = os.os_id;
			 * 
			 * SELECT os_id, subject_name, os_begin, os_end, sc_attend, sc_written,
			 * sc_practice FROM amin_grade_basicview1 WHERE os_id='os_001';
			 * 
			 */

			String sql = "SELECT os_id, subject_name, os_begin, os_end, sc_attend, sc_written, sc_practice FROM amin_grade_basicview1 WHERE os_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");

				ScoreAndGrade s = new ScoreAndGrade();
				s.setOs_id(os_id);
				s.setSubject_name(subject_name);
				s.setOs_begin(os_begin);
				s.setOs_end(os_end);
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
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();

			}

		}

		return result;

	}

	// ok
	// 관리자 로그인> 6.성적조회 > 1. 과목 정보 조회 > 조회버튼 누른 수강생 정보
	public List<Student> admin_studentgpa_Info(String os) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW amin_grade_view10 AS SELECT os.oc_id AS oc_id, g.os_id
			 * AS os_id, s.student_id AS student_id , s.student_name AS student_name ,
			 * s.student_phone AS student_phone , g.grade_attend AS grade_attend ,
			 * g.grade_written AS grade_written , g.grade_practice AS grade_practice ,
			 * g.grade_attend + g.grade_written + g.grade_practice AS grade_total FROM
			 * student s, grade g, open_subject os WHERE s.student_id = g.student_id AND
			 * os.os_id = g.os_id;
			 * 
			 * SELECT student_id, student_name, student_phone, grade_attend, grade_written,
			 * grade_practice, grade_total FROM amin_grade_view10 WHERE os_id = 'os_001'
			 * ORDER BY student_id;
			 */
			String sql = "SELECT os_id, student_id, student_name, student_phone, grade_attend, grade_written, grade_practice, grade_total FROM amin_grade_view10 WHERE os_id = ? ORDER BY student_id";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// ScoreAndGrade 자료형 클래스에서 os_id를 setAttribute로 받아온다.
				// String os_id = rs.getString("os_id");
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				int grade_attend = rs.getInt("grade_attend");
				int grade_written = rs.getInt("grade_written");
				int grade_practice = rs.getInt("grade_practice");
				int grade_total = rs.getInt("grade_total");

				Student s = new Student();
				// s.setOs_id(os_id);
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
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

	// ok
	// 관리자 로그인> 6.성적조회 > 2. 과정 정보 조회 > 개인성적조회
	// 검색 출력
	public List<Student> admin_personal_gpa(String key, String value) {
		List<Student> result = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			/*
			 * CREATE OR REPLACE VIEW admin_grade_view8 AS SELECT student_id, student_name,
			 * student_phone , (SELECT COUNT(oc_id) FROM student_history WHERE student_id =
			 * st.student_id) AS st_count , TO_CHAR(st.student_hiredate, 'YYYY-MM-DD') AS
			 * student_hiredate FROM student st;
			 */

			String sql = "SELECT student_id, student_name, student_phone, st_count, student_hiredate FROM admin_grade_view8";
			// 수강생 ID, 수강생명, 수강생 전화번호 기준 검색
			switch (key) {
			case "all":
				break;
			case "student_id":
				sql += " WHERE INSTR(student_id, ?) > 0";
				break;
			case "student_name":
				sql += " WHERE INSTR(student_name, ?) > 0";
				break;
			case "student_phone":
				sql += " WHERE INSTR(student_phone, ?) > 0";
				break;
			}

			sql += " ORDER BY student_id";

			conn = DBConnection.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();

			// ScoreAndGrade 자료형 클래스에서 st_count를 setAttribute로 받아온다.
			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				//int st_count = rs.getInt("st_count");
				String student_hiredate = rs.getString("student_hiredate");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				s.setStudent_phone(student_phone);
				//s.setSt_count(st_count);
				s.setStudent_hiredate(student_hiredate);

				result.add(s);

			}
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			try {
				DBConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// ok
	// 공통 메소드: 수강생ID, 수강생명
	public List<Student> admin_gpastudentInfo(String st) {
		List<Student> result = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * SELECT student_id, student_name FROM student WHERE student_id='st_001';
			 */

			String sql = "SELECT student_id, student_name FROM student WHERE student_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, st);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);

			while (rs.next()) {

				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");

				Student s = new Student();
				s.setStudent_id(student_id);
				s.setStudent_name(student_name);
				System.out.println(student_name);
				result.add(s);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();

			}

		}

		return result;

	}

	// ok
	// 관리자 개인성적조회>과정조회 버튼 누른 후
	public List<ScoreAndGrade> admin_student_gpa(String oc) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		System.out.println("oc : " + oc + " 입니다.");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_student_Info AS SELECT sh.student_id AS
			 * student_id, oc.oc_id AS oc_id , (SELECT course_name FROM course WHERE
			 * course_id = oc.course_id) AS course_name , TO_CHAR(oc_begin, 'YYYY-MM-DD') AS
			 * oc_begin , TO_CHAR(oc_end, 'YYYY-MM-DD')oc_end, room_name FROM open_course
			 * oc, room r, student_history sh, student s WHERE r.room_id = oc.room_id AND
			 * sh.oc_id = oc.oc_id and sh.student_id = s.student_id;
			 */
			String sql = "SELECT student_id, oc_id, course_name, oc_begin, oc_end, room_name FROM admin_student_Info WHERE student_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oc);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");
				String room_name = rs.getString("room_name");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setStudent_id(student_id);
				sg.setOc_id(oc_id);
				sg.setCourse_name(course_name);
				sg.setOc_begin(oc_begin);
				sg.setOc_end(oc_end);

				sg.setRoom_name(room_name);
				System.out.println("room:" + room_name + ".");
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

	// 공통메소드: 수강생ID, 수강생명, 과정ID, 과정명, (과정시작, 과정종료)
	public ScoreAndGrade admin_details_of_student(String os) {
		ScoreAndGrade result = new ScoreAndGrade();
		System.out.println("os : " + os + " 입니다.");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_student_Info1 AS SELECT s.student_id AS
			 * student_id, s.student_name AS student_name , oc.oc_id AS oc_id , (SELECT
			 * course_name FROM course WHERE course_id = oc.course_id) AS course_name ,
			 * TO_CHAR(oc.oc_begin, 'YYYY-MM-DD') AS oc_begin , TO_CHAR(oc.oc_end,
			 * 'YYYY-MM-DD') AS oc_end FROM student s, student_history sh, open_course oc
			 * WHERE s.student_id = sh.student_id AND sh.oc_id = oc.oc_id;
			 * 
			 * SELECT student_id, student_name, oc_id, course_name, oc_begin, oc_end FROM
			 * admin_student_Info1 WHERE student_id = 'st_001'; SELECT student_id,
			 * student_name, oc_id, course_name, oc_begin, oc_end FROM admin_student_Info1
			 * WHERE os_id = 'os_001';
			 */

			String sql = "SELECT student_id, student_name, oc_id, course_name, oc_begin, oc_end FROM admin_student_Info1 WHERE student_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);

			while (rs.next()) {

				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String oc_id = rs.getString("oc_id");
				String course_name = rs.getString("course_name");
				String oc_begin = rs.getString("oc_begin");
				String oc_end = rs.getString("oc_end");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setStudent_id(student_id);
				sg.setStudent_name(student_name);
				sg.setOc_id(oc_id);
				sg.setCourse_name(course_name);
				sg.setOc_begin(oc_begin);
				sg.setOc_end(oc_end);
				System.out.println(student_id);
				result = sg;

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();

			}

		}

		return result;

	}

	// 관리자 개인성적조회>과정조회>성적조회 버튼 누른 후
	public List<ScoreAndGrade> admin_full_details_of_st(String st_id, String oc_id_) {
		List<ScoreAndGrade> result = new ArrayList<ScoreAndGrade>();
		System.out.println("st_id : " + st_id + " 입니다.");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.connect();

			/*
			 * CREATE OR REPLACE VIEW admin_student_gpa_Info AS SELECT g.student_id AS
			 * student_id ,os.os_id AS os_id , (SELECT subject_name FROM subject WHERE
			 * subject_id = os.subject_id) AS subject_name , TO_CHAR(os.os_begin,
			 * 'YYYY-MM-DD') AS os_begin , TO_CHAR(os.os_end, 'YYYY-MM-DD') AS os_end ,
			 * (SELECT teacher_name FROM teacher WHERE teacher_id = os.teacher_id) AS
			 * teacher_name , sc.sc_attend AS sc_attend , sc.sc_written AS sc_written ,
			 * sc.sc_practice AS sc_practice , g.grade_attend AS grade_attend ,
			 * g.grade_written AS grade_written , g.grade_practice AS grade_practice ,
			 * g.grade_attend + g.grade_written + g.grade_practice AS grade_total FROM score
			 * sc, open_subject os, grade g WHERE g.os_id = os.os_id AND os.os_id =
			 * sc.os_id;
			 * 
			 * SELECT student_id, os_id, subject_name, os_begin, os_end, teacher_name,
			 * sc_attend, sc_written, sc_practice, grade_attend, grade_practice,
			 * grade_written, grade_total FROM admin_student_gpa_Info WHERE student_id =
			 * 'st_001';
			 */
			String sql = "SELECT os_id, subject_name, os_begin, os_end, teacher_name, sc_attend, sc_written, sc_practice, grade_attend, grade_written, grade_practice, grade_total  FROM admin_student_gpa_Info WHERE student_id=? and oc_id= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, st_id);
			pstmt.setString(2, oc_id_);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);

			while (rs.next()) {

				String os_id = rs.getString("os_id");
				String subject_name = rs.getString("subject_name");
				String os_begin = rs.getString("os_begin");
				String os_end = rs.getString("os_end");
				String teacher_name = rs.getString("teacher_name");
				int sc_attend = rs.getInt("sc_attend");
				int sc_written = rs.getInt("sc_written");
				int sc_practice = rs.getInt("sc_practice");
				int grade_attend = rs.getInt("grade_attend");
				int grade_practice = rs.getInt("grade_practice");
				int grade_written = rs.getInt("grade_written");
				String grade_total = rs.getString("grade_total");

				ScoreAndGrade sg = new ScoreAndGrade();
				sg.setOs_id(os_id);
				sg.setSubject_name(subject_name);
				sg.setOs_begin(os_begin);
				sg.setOs_end(os_end);
				sg.setTeacher_name(teacher_name);
				sg.setSc_attend(sc_attend);
				sg.setSc_written(sc_written);
				sg.setSc_practice(sc_practice);
				sg.setGrade_attend(grade_attend);
				sg.setGrade_written(grade_written);
				sg.setGrade_practice(grade_practice);
				sg.setGrade_total(grade_total);
				System.out.println(os_id);
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
	
	
	
	
	// 교재 출력
	public List<BasicInfo> admin_1_5_6_7DAO(String textbook_name) {
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
