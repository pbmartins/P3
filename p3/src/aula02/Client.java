package aula02;
import aula01.ex2.Date;

import java.util.ArrayList;
import java.util.Calendar;

public class Client {
	private static int idCounter;
	private int id, cc;
	private Date bornDate, signupDate;
	private String name;
	private ArrayList<Video> rentedVideos, allRentedVideos;
	
	static {
		idCounter = 0;
	}
	
	public Client (String name, int cc, Date bornDate, Date signupDate) {
		assert name.length() > 0 && cc > 0;
		
		this.id = idCounter;
		this.name = name;
		this.cc = cc;
		this.bornDate = bornDate;
		this.signupDate = signupDate;
		this.rentedVideos = new ArrayList<Video>();
		this.allRentedVideos = new ArrayList<Video>();
		idCounter++;
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
		return "Nome: " + this.name + "\nCC:" + this.cc + "\nData de nascimento:" + this.bornDate.toString()  + "\nData de inscrição:" + this.signupDate.toString();
	}
}
