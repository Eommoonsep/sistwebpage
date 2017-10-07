package com.test;

public class ScoreAndGrade {
	
	private int sc_attend, sc_written, sc_practice; 
	private int grade_attend, grade_written, grade_practice;
	private String course_id, oc_id, course_name, oc_begin, oc_end;
	private String subject_id, os_id, subject_name, os_begin, os_end;
	private String room_name, textbook_name, teacher_name;
	private int st_count;	
	private String ex_date, ex_qs; 
	private int score_regisCount, totalStudent;
	private String ableSubject;
	private String grade_total;
	private String date_; 
	private String student_id, student_name; 
	   
	private String textbook_filename;
	
	// 異쒓껐諛곗젏, �븘湲곕같�젏, �떎湲곕같�젏
	// 異쒓껐�꽦�쟻, �븘湲곗꽦�쟻, �떎湲곗꽦�쟻
	// 怨쇱젙ID, 怨쇱젙紐�, 怨쇱젙�떆�옉, 怨쇱젙醫낅즺
	// 怨쇰ぉID, 媛쒖꽕怨쇰ぉID, 怨쇰ぉ紐�, 怨쇰ぉ�떆�옉, 怨쇰ぉ醫낅즺
	// 媛뺤쓽�떎紐�, 援먯옱紐�, �닔媛뺤씤�썝, 媛뺤궗紐�
	//�닔媛뺤씤�썝
	//�떆�뿕�궇吏�, �떆�뿕臾몄젣
	// �꽦�쟻�엯�젰�닔, �쟾泥댄븰�깮�닔
	// 媛뺤쓽媛��뒫怨쇰ぉ
	// �꽦�쟻珥앹젏
	//�닔猷뚮궇吏�
	//�닔媛뺤깮ID,�닔媛뺤깮紐�
	
	//9월28일 추가 주석
	//강사 자료형 추가생성
	private String able_subject;
	private int counts, count_, g_count;	
	
	
	
	
	
	
	public String getTextbook_filename() {
		return textbook_filename;
	}
	public void setTextbook_filename(String textbook_filename) {
		this.textbook_filename = textbook_filename;
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
	public int getSc_attend() {
		return sc_attend;
	}
	public void setSc_attend(int sc_attend) {
		this.sc_attend = sc_attend;
	}
	public int getSc_written() {
		return sc_written;
	}
	public void setSc_written(int sc_written) {
		this.sc_written = sc_written;
	}
	public int getSc_practice() {
		return sc_practice;
	}
	public void setSc_practice(int sc_practice) {
		this.sc_practice = sc_practice;
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
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getOc_id() {
		return oc_id;
	}
	public void setOc_id(String oc_id) {
		this.oc_id = oc_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getOc_begin() {
		return oc_begin;
	}
	public void setOc_begin(String oc_begin) {
		this.oc_begin = oc_begin;
	}
	public String getOc_end() {
		return oc_end;
	}
	public void setOc_end(String oc_end) {
		this.oc_end = oc_end;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getOs_id() {
		return os_id;
	}
	public void setOs_id(String os_id) {
		this.os_id = os_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getOs_begin() {
		return os_begin;
	}
	public void setOs_begin(String os_begin) {
		this.os_begin = os_begin;
	}
	public String getOs_end() {
		return os_end;
	}
	public void setOs_end(String os_end) {
		this.os_end = os_end;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getTextbook_name() {
		return textbook_name;
	}
	public void setTextbook_name(String textbook_name) {
		this.textbook_name = textbook_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getSt_count() {
		return st_count;
	}
	public void setSt_count(int st_count) {
		this.st_count = st_count;
	}
	public String getEx_date() {
		return ex_date;
	}
	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}
	public String getEx_qs() {
		return ex_qs;
	}
	public void setEx_qs(String ex_qs) {
		this.ex_qs = ex_qs;
	}
	public int getScore_regisCount() {
		return score_regisCount;
	}
	public void setScore_regisCount(int score_regisCount) {
		this.score_regisCount = score_regisCount;
	}
	public int getTotalStudent() {
		return totalStudent;
	}
	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}
	public String getAbleSubject() {
		return ableSubject;
	}
	public void setAbleSubject(String ableSubject) {
		this.ableSubject = ableSubject;
	}
	public String getGrade_total() {
		return grade_total;
	}
	public void setGrade_total(String grade_total) {
		this.grade_total = grade_total;
	}
	public String getDate_() {
		return date_;
	}
	public void setDate_(String date_) {
		this.date_ = date_;
	}
	public String getAble_subject() {
		return able_subject;
	}
	public void setAble_subject(String able_subject) {
		this.able_subject = able_subject;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getCount_() {
		return count_;
	}
	public void setCount_(int count_) {
		this.count_ = count_;
	}
	public int getG_count() {
		return g_count;
	}
	public void setG_count(int g_count) {
		this.g_count = g_count;
	}
	
	
	
	
	
	
	
	
}
