package aula04.ex3;
import aula04.ex1.Student;

import java.util.*;

public class VideoCatalogue {
	Map<Integer, Video> catalogue;
	List<Integer> keys;
	int size;
	
	public VideoCatalogue(int maxVideo){
		Video.setMaxVideo(maxVideo);
		catalogue = new HashMap<Integer, Video>();
		keys = new ArrayList<Integer>();
		size = 0;
	}
	
	public void addVideo(String title, String category, String rate) {
		Video v = new Video(title, category, rate);
		catalogue.put(v.getID(), v);
		keys.add(v.getID());
		assert !catalogue.isEmpty();
	}
	
	public void removeVideo(int id) {
		assert !catalogue.isEmpty();
		if (!existsID(id)) 
			throw new IllegalArgumentException("Não há nenhum filme com o ID indicado.");
		keys.remove(id);
		catalogue.remove(id);
	}
	
	public int searchVideo(String title) {
		assert !catalogue.isEmpty();
		
		for (int i = 0; i < keys.size(); i++) {
			if (catalogue.get(keys.get(i)).getTitle().equals(title)) {
				return keys.get(i);
			}
		}
		
		return -1;
	}
	
	public Video getVideo(int id) {
		assert !catalogue.isEmpty();
		return catalogue.get(id);
	}
	
	public void rentVideo(int id, Client c) {
		if (!existsID(id)) 
			throw new IllegalArgumentException("Não há nenhum filme com o ID indicado.");
		if (c == null) 
			throw new IllegalArgumentException("Cliente inexistente.");
		catalogue.get(id).rent(c);
		if (c instanceof Student)
			((Student)c).addRentedVideo(catalogue.get(id));
		else
			((Employee)c).addRentedVideo(catalogue.get(id));
	}
	
	public void checkinVideo(int id, int rating) {
		if (!existsID(id)) 
			throw new IllegalArgumentException("Não há nenhum filme com o ID indicado.");
		if (rating < 1 || rating > 11) 
			throw new IllegalArgumentException("O rating tem de estar compreendido entre 1 e 10.");

		catalogue.get(id).checkin(rating);
		
	}
	
	public Video[] availableVideos(int age) {
		assert !catalogue.isEmpty();
		if (age < 0) 
			throw new IllegalArgumentException("A idade tem de ser positiva.");

		String[] rates = allowedRates(age);
		ArrayList<Video> videos = new ArrayList<Video>();
		
		for (int i = 0; i < keys.size(); i++) {
			String rate = catalogue.get(keys.get(i)).getRate();
			for (String r : rates) {
				if (r.equals(rate) && !catalogue.get(keys.get(i)).rented()) {
					videos.add(catalogue.get(keys.get(i)));
					break;
				}
			}
		}
		
		return videos.toArray(new Video[videos.size()]);
	}
	
	public Video[] getVideosSortByRating() {
		assert !catalogue.isEmpty();
		
		TreeMap<Double, ArrayList<Integer>> tm = new TreeMap<Double, ArrayList<Integer>>();
		ArrayList<Video> to_return = new ArrayList<Video>();
		
		for (int i = 0; i < this.keys.size(); i++) {
			if (tm.get(this.catalogue.get(this.keys.get(i)).getMediumRating()) != null) {
				tm.get(this.catalogue.get(this.keys.get(i)).getMediumRating()).add(this.keys.get(i));
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(this.keys.get(i));
				tm.put(this.catalogue.get(this.keys.get(i)).getMediumRating(), list);
			}
		}
		
		for(Double key : tm.descendingKeySet()) {
			for (int i = 0; i < tm.get(key).size(); i++) {
				to_return.add(this.catalogue.get(tm.get(key).get(i)));
			}
		}
		
		return to_return.toArray(new Video[to_return.size()]);
	}
	
	private String[] allowedRates(int age) {
		if (age < 0) 
			throw new IllegalArgumentException("A idade tem de ser positiva.");
		String[] allRates = Video.getRates();
		
		int maxIdx = 1;
		
		if (age < 12) maxIdx = 2;
		else if (age < 16) maxIdx = 3;
		else if (age < 18) maxIdx = 4;
		else maxIdx = 5;
		
		String[] allowedRates = new String[maxIdx];
		System.arraycopy(allRates, 0, allowedRates, 0, maxIdx);
		return allowedRates;
	}
	
	private boolean existsID(int id) {
		for (int i = 0; i < this.keys.size(); i++) {
			if (keys.get(i) == id)
				return true;
		}
		return false;
	}
}
