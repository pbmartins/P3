package aula04.ex1;
import java.util.ArrayList;
import java.util.Calendar;

import aula01.ex2.Date;
import aula04.ex3.Client;
import aula04.ex3.Video;

public class Student extends Client {
	private int id, cc;
	private Date bornDate, signupDate;
	private String name;
	private ArrayList<Video> rentedVideos, allRentedVideos;
	private int nmec;
	private String course;
	
	public Student(String name, int cc, Date bornDate, Date signupDate, int nmec, String course) {
		if (name.length() <= 0 || course.length() <= 0)
			throw new IllegalArgumentException("O nome e/ou curso não podem ser campos vazios.");
		if (cc <= 0 || nmec <= 0)
			throw new IllegalArgumentException("O CC e/ou número mecanográfico têm de ser superiores a 0.");
		
		this.id = super.getIDCounter();
		this.name = name;
		this.cc = cc;
		this.bornDate = bornDate;
		this.signupDate = signupDate;
		this.rentedVideos = new ArrayList<Video>();
		this.allRentedVideos = new ArrayList<Video>();
		this.nmec = nmec;
		this.course = course;
	}
	
	public int getNMec() {
		return this.nmec;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCC() {
		return this.cc;
	}
	
	public Date getBornDate() {
		return this.bornDate;
	}
	
	public Date getSignUpDate() {
		return this.bornDate;
	}
	
	public int getAge(){
		Calendar todayDate = Calendar.getInstance();
		int age = todayDate.get(Calendar.YEAR) - this.bornDate.getYear();
	    if (this.bornDate.getMonth() > todayDate.get(Calendar.MONTH) + 1 || (this.bornDate.getMonth() == todayDate.get(Calendar.MONTH) + 1 && this.bornDate.getDay() > todayDate.get(Calendar.DAY_OF_MONTH))) {
	        age--;
	    }
	    return age;
	}
	
	public void addRentedVideo(Video v) {
		allRentedVideos.add(v);
	}
	
	public Video[] getAllRentedVideos() {
		if (allRentedVideos.isEmpty()) throw new AssertionError("Este cliente ainda não alugou nenhum filme");
		return this.allRentedVideos.toArray(new Video[allRentedVideos.size()]);
	}
	
	public int getRentedVideosTotal() {
		return rentedVideos.size();
	}
	
	public String toString() {
		return "Nome: " + this.name + "\nCC:" + this.cc + "\nData de nascimento:" + this.bornDate.toString()  + "\nData de inscrição:" + this.signupDate.toString() + "\nNMec:" + this.nmec + "\nCourse:" + this.course;
	}

}
