package aula12.ex3;

import aula01.ex2.Date;

import java.util.Calendar;

public class Contact implements Comparable<Contact> {
	private String name;
	private int number;
	private Date bornDate;
	
	public Contact(String name, int number, Date bornDate) {
		assert name.length() != 0;
		assert number >= 0;
		assert bornDate != null;
		
		this.name = name;
		this.number = number;
		this.bornDate = bornDate;
	}
	
	public String toString() {
		return "Nome: " + this.name + "\nContacto: " + this.number + "\nData de nascimento: " + this.bornDate.toString();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public Date getBornDate() {
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
	
	public boolean equals(Object p) {
		if (p == null)
			return false;
		if (p.getClass() != this.getClass())
			return false;
		return this.name == ((Contact)p).getName() && this.number == ((Contact)p).getNumber() && ((Contact)p).getBornDate().equals(this.bornDate);
	}

    public int compareTo(Contact c) {
        if (c == null)
            throw new IllegalArgumentException("Contacto inválido.");

        return this.name.compareTo(c.getName());
    }
}
