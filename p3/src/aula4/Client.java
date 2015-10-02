package aula4;
import aula1.Date;

public abstract class Client {
	private static int idCounter;
	
	static {
		idCounter = 0;
	}
	
	public abstract int getID();
	public abstract String getName();
	public abstract int getCC();
	public abstract Date getBornDate();
	public abstract Date getSignUpDate();
	public abstract int getAge();
	public abstract void addRentedVideo(Video v);
	public abstract Video[] getAllRentedVideos();	
	public abstract int getRentedVideosTotal();
	public abstract String toString();
	
	public int getIDCounter() {
		return idCounter++;
	}
}
