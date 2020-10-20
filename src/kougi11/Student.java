package kougi11;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Student {

    //フィールド
    private int student_id;     //STUDENT_IDに対応
    private String fullname;    //FULLNAMEに対応
    private int gakubu_id;      //GAKUBU_IDに対応
    private int grade;          //GRADEに対応

    public Student(int student_id, String fullname, int gakubu_id, int grade) {
		this.student_id = student_id;
		this.fullname = fullname;
		this.gakubu_id = gakubu_id;
		this.grade = grade;
	}
	public Student() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//GetメソッドとSetメソッド
    public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getGakubu_id() {
		return gakubu_id;
	}
	public void setGakubu_id(int gakubu_id) {
		this.gakubu_id = gakubu_id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}


}
