package com.test;

public class BasicInfo {
	
	
	
	// 과정ID, 과정명
	// 과목ID, 과목명
	// 개설과정ID, 과정시작, 과정종료
	// 개설과목ID, 과목시작, 과목종료
	// 강의실ID, 강의실명
	// 강의실 정원
	// 교재ID, 교재명, 출판사명
	// 수강인원
	// 강사명,강사ID
	// 수강생명, 수료날짜, 중도탈락날짜
	// 성적등록여부, 시험문제파일등록여부, 
	// 강의진행여부
	// 과목수
	// 강의가능과목
	// 강의진행여부
	
	
	
	private String course_id, course_name;
	private String subject_id, subject_name;
	private String oc_id, oc_begin, oc_end;
	private String os_id, os_begin, os_end;
	private String room_id, room_name;
	private int room_count;
	private String textbook_id, textbook_name, textbook_publisher;
	private int st_count;
	private String teacher_name,teacher_id;
	private String student_name,date_, drop_date;
	private String ex_qs_ck,score_regi_ck;
	private String teaching_ck;
	private int  os_count;
	private String ableSubject;
	private int progress; 
	
	//교재 파일이름 추가
	 //private String textbook_filename;;
	private String textbook_file;
	
	
	
	//9.28 추가주석 문제생길시 삭제
	//강사 자료형 추가생성
	private int sc_attend;
	private int sc_written;
	private int sc_practice;	
	private String ex_qs,ex_date;	
	private String able_subject;	
	
	
	

	public String getTextbook_file() {
		return textbook_file;
	}
	public void setTextbook_file(String textbook_file) {
		this.textbook_file = textbook_file;
	}
	private int noremovesubject=0;
	
	
	public int getNoremovesubject() {
		return noremovesubject;
	}
	public void setNoremovesubject(int noremovesubject) {
		this.noremovesubject = noremovesubject;
	}
	public String getTeaching_ck() {
		return teaching_ck;
	}
	public void setTeaching_ck(String teaching_ck) {
		this.teaching_ck = teaching_ck;
	}
	public String getDate_() {
		return date_;
	}
	public void setDate_(String date_) {
		this.date_ = date_;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getAbleSubject() {
		return ableSubject;
	}
	public void setAbleSubject(String ableSubject) {
		this.ableSubject = ableSubject;
	}
	public int getOs_count() {
		return os_count;
	}
	public void setOs_count(int os_count) {
		this.os_count = os_count;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getOc_id() {
		return oc_id;
	}
	public void setOc_id(String oc_id) {
		this.oc_id = oc_id;
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
	public String getOs_id() {
		return os_id;
	}
	public void setOs_id(String os_id) {
		this.os_id = os_id;
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
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getRoom_count() {
		return room_count;
	}
	public void setRoom_count(int room_count) {
		this.room_count = room_count;
	}
	public String getTextbook_id() {
		return textbook_id;
	}
	public void setTextbook_id(String textbook_id) {
		this.textbook_id = textbook_id;
	}
	public String getTextbook_name() {
		return textbook_name;
	}
	public void setTextbook_name(String textbook_name) {
		this.textbook_name = textbook_name;
	}
	public String getTextbook_publisher() {
		return textbook_publisher;
	}
	public void setTextbook_publisher(String textbook_publisher) {
		this.textbook_publisher = textbook_publisher;
	}
	public int getSt_count() {
		return st_count;
	}
	public void setSt_count(int st_count) {
		this.st_count = st_count;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
/*	public String getOc_date() {
		return oc_date;
	}
	public void setOc_date(String oc_date) {
		this.oc_date = oc_date;
	}*/
	public String getDrop_date() {
		return drop_date;
	}
	public void setDrop_date(String drop_date) {
		this.drop_date = drop_date;
	}
	/*public String getComplete_ck() {
		return complete_ck;
	}
	public void setComplete_ck(String complete_ck) {
		this.complete_ck = complete_ck;
	}*/
	
	
	public String getScore_regi_ck() {
		return score_regi_ck;
	}
	public void setScore_regi_ck(String score_regi_ck) {
		this.score_regi_ck = score_regi_ck;
	}
	
	public String getEx_qs_ck() {
		return ex_qs_ck;
	}
	public void setEx_qs_ck(String ex_qs_ck) {
		this.ex_qs_ck = ex_qs_ck;
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
	public String getEx_qs() {
		return ex_qs;
	}
	public void setEx_qs(String ex_qs) {
		this.ex_qs = ex_qs;
	}
	public String getEx_date() {
		return ex_date;
	}
	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}
	public String getAble_subject() {
		return able_subject;
	}
	public void setAble_subject(String able_subject) {
		this.able_subject = able_subject;
	}
	
	

	
	
	
	
	
	
}
