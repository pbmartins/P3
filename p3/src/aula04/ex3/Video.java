package aula04.ex3;
import java.util.*;

public class Video {
	private static int idCounter = 0, maxVideo;
	private static String[] rates = {"ALL", "M6", "M12", "M16", "M18"};
	private int id, totalRating;
	private String title, category, rate;
	private Client client;
	private ArrayList<Client> allClients;

	public static String[] getRates() {
		return rates;
	}
	
	public static void setMaxVideo(int max) {
		assert max > 1;
		maxVideo = max;
	}
	
	public Video(String title, String category, String rate) {
		assert title.length() > 0 && verifyRate(rate);
		
		this.id = idCounter;
		this.title = title;
		this.category = category;
		this.rate = rate;
		this.client = null;
		this.allClients = new ArrayList<Client>();
		idCounter++;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getRate() {
		return this.rate;
	}
	
	public int getTotalRating() {
		assert !allClients.isEmpty();
		return this.totalRating;
	}
	
	public double getMediumRating() {
		if (allClients.isEmpty())
			return 0;
		return (this.totalRating * 1.0) / allClients.size();
	}
	
	public void rent(Client c) {
		assert !rented();
		if (c.getRentedVideosTotal() >= maxVideo)
			throw new AssertionError("Limite máximo de alugueres atingido");
		this.client = c;
		allClients.add(c);
	}
	
	public void checkin(int rating) {
		assert rented();
		if (rating < 1 || rating > 11) 
			throw new IllegalArgumentException("O rating tem de estar compreendido entre 1 e 10.");
		this.totalRating = rating;
		this.client = null;
	}
	
	public boolean rented() {
		return this.client != null;
	}
	
	public Client[] getAllClients() {
		assert !this.allClients.isEmpty();
		return this.allClients.toArray(new Client[allClients.size()]);
	}
	
	public String toString() {
		return "Título: " + this.title + "\nCategory:" + this.category + "\nRate:" + this.rate + "\nRating:" + getMediumRating();
	}
	
	private boolean verifyRate(String rate) {
		for (String r : rates) {
			if (r.equals(rate))
				return true;
		}
		return false;
	}
}
