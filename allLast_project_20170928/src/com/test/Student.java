package com.test;

public class Student {

	private String student_id, student_name, student_phone,student_ssn, student_hiredate;
	private String oc_end, drop_date,complete_ck;
	private int grade_attend, grade_written, grade_practice, grade_total, course_count;
	private String date_, pass_or_drop; 
	
	
	// 수강생ID, 수강생명, 수강생전화번호,수강생주민번혼 수강생등록일
	// 수료날짜, 중도탈락날짜, 수료여부, 
	// 출결성적, 필기성적, 실기성적, 성적총점, 과정수강횟수
	// 탈락날짜, 수료or중도탈락 글씨출력 변수
	
	private String oc_id;
	private String course_name;
	
	
	//9.28 주석추가
	private String os_id, ex_qs, teacher_id; 
	private int sum;
	
	
	
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getOc_id() {
		return oc_id;
	}
	public void setOc_id(String oc_id) {
		this.oc_id = oc_id;
	}
	public String getPass_or_drop() {
		return pass_or_drop;
	}
	public void setPass_or_drop(String pass_or_drop) {
		this.pass_or_drop = pass_or_drop;
	}
	public String getDate_() {
		return date_;
	}
	public void setDate_(String date_) {
		this.date_ = date_;
	}
	public String getStudent_ssn() {
		return student_ssn;
	}
	public void setStudent_ssn(String student_ssn) {
		this.student_ssn = student_ssn;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_hiredate() {
		return student_hiredate;
	}
	public void setStudent_hiredate(String student_hiredate) {
		this.student_hiredate = student_hiredate;
	}
	public String getOc_end() {
		return oc_end;
	}
	public void setOc_end(String oc_end) {
		this.oc_end = oc_end;
	}
	public String getDrop_date() {
		return drop_date;
	}
	public void setDrop_date(String drop_date) {
		this.drop_date = drop_date;
	}
	public String getComplete_ck() {
		return complete_ck;
	}
	public void setComplete_ck(String complete_ck) {
		this.complete_ck = complete_ck;
	}
	public int getGrade_attend() {
		return grade_attend;
	}
	public void setGrade_attend(int grade_attend) {
		this.grade_attend = grade_attend;
	}
	public int getGrade_written() {
		return grade_written;
	}
	public void setGrade_written(int grade_written) {
		this.grade_written = grade_written;
	}
	public int getGrade_practice() {
		return grade_practice;
	}
	public void setGrade_practice(int grade_practice) {
		this.grade_practice = grade_practice;
	}
	public int getGrade_total() {
		return grade_total;
	}
	public void setGrade_total(int grade_total) {
		this.grade_total = grade_total;
	}
	public int getCourse_count() {
		return course_count;
	}
	public void setCourse_count(int course_count) {
		this.course_count = course_count;
	}
	public String getOs_id() {
		return os_id;
	}
	public void setOs_id(String os_id) {
		this.os_id = os_id;
	}
	public String getEx_qs() {
		return ex_qs;
	}
	public void setEx_qs(String ex_qs) {
		this.ex_qs = ex_qs;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
