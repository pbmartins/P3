package aula10.ex1;

import aula09.ex3.Date;

import java.util.Calendar;

public class Person {
	private String name;
	private int cc;
	private Date bornDate;

	public Person (String name, int cc, Date bornDate) {
		assert name.length() != 0;
		assert bornDate != null;

		this.name = name;
		this.cc = cc;
		this.bornDate = bornDate;
	}

	public String toString() {
		return "Nome: " + this.name + "\nCC: " + this.cc + "\nData de nascimento: " + this.bornDate.toString();
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
		return this.name == ((aula09.ex3.Person)p).getName() && this.cc == ((aula09.ex3.Person)p).getCC() && ((aula09.ex3.Person)p).getBornDate().equals(this.bornDate);
	}
}
