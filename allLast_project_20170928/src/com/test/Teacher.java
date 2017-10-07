package com.test;

public class Teacher {
	
	private String teacher_id, teacher_name, teacher_ssn, teacher_phone, teacher_hiredate;
	private String ableSubject;
	
	private String[] arrayAbleSubject;	//20170920 추가, <강사등록버튼클릭시> 강사가 강의과목테이블 설정할때
	
	// ����ID, �����, �����ֹε��ڸ�, ������ȭ��ȣ, ��������
	// ���簭�ǰ��ɰ���
	 
	int noremovebutton = 0;
 

	public int getNoremovebutton() {
		return noremovebutton;
	}

	public void setNoremovebutton(int noremovebutton) {
		this.noremovebutton = noremovebutton;
	}

	public String getTeacher_id() {
		return teacher_id;
	}
 
	public String[] getArrayAbleSubject() {
		return arrayAbleSubject;
	}

	public void setArrayAbleSubject(String[] arrayAbleSubject) {
		this.arrayAbleSubject = arrayAbleSubject;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_ssn() {
		return teacher_ssn;
	}
	public void setTeacher_ssn(String teacher_ssn) {
		this.teacher_ssn = teacher_ssn;
	}
	public String getTeacher_phone() {
		return teacher_phone;
	}
	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}
	public String getTeacher_hiredate() {
		return teacher_hiredate;
	}
	public void setTeacher_hiredate(String teacher_hiredate) {
		this.teacher_hiredate = teacher_hiredate;
	}
	public String getAbleSubject() {
		return ableSubject;
	}
	public void setAbleSubject(String ableSubject) {
		this.ableSubject = ableSubject;
	}
	
	
	
	
}
