package aula3;
import java.util.Calendar;

import aula1.*;

public class Student extends Person {
	private static int nmecCounter;
	private final int nmec;
	private Date signupDate;
	
	static {
		nmecCounter = 100;
	}
	
	public Student(String name, int cc, Date bornDate, Date signupDate) {
		super(name, cc, bornDate);
		if (signupDate == null)
			throw new IllegalArgumentException("A data de inscrição não é válida");
		this.nmec = nmecCounter;
		this.signupDate = signupDate;
		nmecCounter++;
	}
	
	public Student(String name, int cc, Date bornDate) {
		super(name, cc, bornDate);
		this.nmec = nmecCounter;
		Calendar todayDate = Calendar.getInstance();
		this.signupDate = new Date(todayDate.get(Calendar.DAY_OF_MONTH), todayDate.get(Calendar.MONTH), todayDate.get(Calendar.YEAR));
		nmecCounter++;
	}
	
	public final int getNMec() {
		return this.nmec;
	}
	
	public final Date getSignUpDate() {
		return this.signupDate;
	}
	
	public String toString() {
		return super.toString() + "\nNMec: " + this.nmec + "\nData de inscrição: " + this.signupDate.toString();
	}
	
}
