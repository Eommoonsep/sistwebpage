package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
 
	public LoginInfo loginAdmin(String id_, String pw ) {

		LoginInfo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			//grade �빆紐� 異붽�
			String sql = "SELECT admin_id, admin_pw FROM admin WHERE admin_id=? AND admin_pw=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id_);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String i = rs.getString("admin_id");
				String p = rs.getString("admin_pw");
				
				result = new LoginInfo();
				result.setId_(i);
				result.setPw(p);
				result.setGrade(0);
				
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


	public LoginInfo loginTeacher(String id_, String pw) {

		LoginInfo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			//grade �빆紐� 異붽�
			String sql = "SELECT teacher_id, teacher_ssn  FROM teacher WHERE teacher_id=? AND teacher_ssn=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id_);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String i = rs.getString("teacher_id");
				String p = rs.getString("teacher_ssn");
				
				result = new LoginInfo();
				result.setId_(i);
				result.setPw(p);
				result.setGrade(1);
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


	public LoginInfo loginStudent(String id_, String pw) {

		LoginInfo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			//grade �빆紐� 異붽�
			String sql = "SELECT student_id, student_ssn  FROM student WHERE student_id=? AND student_ssn=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id_);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String i = rs.getString("student_id");
				String p = rs.getString("student_ssn");
				
				result = new LoginInfo();
				result.setId_(i);
				result.setPw(p);
				result.setGrade(2);
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

}
