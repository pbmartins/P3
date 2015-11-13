package aula4.ex1;

import java.util.Calendar;

import aula1.ex2.Date;
import aula1.ex2.Person;

public class Professor extends Person {
	private static int nfuncCounter;
	private final int nfunc;
	private Date signupDate;
	
	static {
		nfuncCounter = 1;
	}
	
	public Professor(String name, int cc, Date bornDate, Date signupDate) {
		super(name, cc, bornDate);
		if (signupDate == null)
			throw new IllegalArgumentException("A data de inscrição não é válida");
		this.nfunc = nfuncCounter;
		this.signupDate = signupDate;
		nfuncCounter++;
	}
	
	public Professor(String name, int cc, Date bornDate) {
		super(name, cc, bornDate);
		this.nfunc = nfuncCounter;
		Calendar todayDate = Calendar.getInstance();
		this.signupDate = new Date(todayDate.get(Calendar.DAY_OF_MONTH), todayDate.get(Calendar.MONTH), todayDate.get(Calendar.YEAR));
		nfuncCounter++;
	}
	
	public final int getNFunc() {
		return this.nfunc;
	}
	
	public final Date getSignUpDate() {
		return this.signupDate;
	}
	
	public String toString() {
		return super.toString() + "\nNFunc: " + this.nfunc + "\nData de inscrição: " + this.signupDate.toString();
	}
}