package aula3;
import aula1.Date;
import aula1.Person;

import java.util.*;

public class Driver extends Person {
	private TreeSet<Category> categories;
	private int licenseNum;
	
	public Driver(String name, int cc, Date date, TreeSet<Category> categories, int licenseNum) {
		super(name, cc, date);
		if (super.getAge() < 16)
			throw new IllegalArgumentException("Idade ilegal.");
		if (licenseNum <= 0) 
			throw new IllegalArgumentException("Número da carta de condução inválido.");
		this.categories = categories;
		this.licenseNum = licenseNum;
	}
	
	public int licenseNum() {
		return this.licenseNum;
	}
	
	public TreeSet<Category> categories() {
		return this.categories;
	}
	
	public String categoriesToString() {
		String to_return = "";
		for (Category c : this.categories)
			to_return += " / " + c;
		return to_return.substring(3);
	}
	
	public boolean hasCategory(Category cat) {
		for (Category c : this.categories) {
			if (cat == c)
				return true;
		}
		return false;
	}
	
	public void addCategory(Category cat) {
		if (!(this.categories.contains(cat)))
			this.categories.add(cat);
		assert !this.categories.isEmpty();
	}
	
	@Override public String toString() {
		return super.toString() + "\nNúmero da carta: " + this.licenseNum + "\nCategorias: " + this.categoriesToString();
	}
	
	public boolean equals(Object c) {
		if (c == null)
			return false;
		if (c.getClass() != this.getClass())
			return false;
		return this.categories.equals( ((Driver)c).categories() ) && this.licenseNum == ((Driver)c).licenseNum();
	}

}
