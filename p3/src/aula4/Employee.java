package aula4;
import java.util.ArrayList;
import java.util.Calendar;

import aula1.Date;

public class Employee extends Client {
	private int id, cc;
	private Date bornDate, signupDate;
	private String name;
	private ArrayList<Video> rentedVideos, allRentedVideos;
	private int nfunc, nif;
	
	public Employee(String name, int cc, Date bornDate, Date signupDate, int nfunc, int nif) {
		if (name.length() <= 0)
			throw new IllegalArgumentException("O nome e/ou curso não podem ser campos vazios.");
		if (cc <= 0 || nfunc <= 0 || nif <= 0)
			throw new IllegalArgumentException("O CC e/ou número de funcionário e/ou NIF têm de ser superiores a 0.");
		
		this.id = super.getIDCounter();
		this.name = name;
		this.cc = cc;
		this.bornDate = bornDate;
		this.signupDate = signupDate;
		this.rentedVideos = new ArrayList<Video>();
		this.allRentedVideos = new ArrayList<Video>();
		this.nfunc = nfunc;
		this.nif = nif;
	}
	
	public int getNFunc() {
		return this.nfunc;
	}
	
	public int getNIF() {
		return this.nif;
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
		return "Nome: " + this.name + "\nCC:" + this.cc + "\nData de nascimento:" + this.bornDate.toString()  + "\nData de inscrição:" + this.signupDate.toString() + "\nNIF:" + this.nif + "\nNFunc:" + this.nfunc;
	}
}
