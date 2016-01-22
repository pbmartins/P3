package aula02;
import aula01.ex2.Date;

public class Student extends Client {
	private int nmec;
	private String course;
	
	public Student(String name, int cc, Date bornDate, Date signupDate, int nmec, String course) {
		super(name, cc, bornDate, signupDate);
		assert course.length() > 0 && nmec > 0;
		
		this.nmec = nmec;
		this.course = course;
	}
	
	public int getNMec() {
		return this.nmec;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public String toString() {
		return super.toString() + "\nNMec:" + this.nmec + "\nCourse:" + this.course;
	}

}
