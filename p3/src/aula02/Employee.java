package aula02;
import aula01.ex2.Date;

public class Employee extends Client {
	private int nfunc, nif;
	
	public Employee(String name, int cc, Date bornDate, Date signupDate, int nfunc, int nif) {
		super(name, cc, bornDate, signupDate);
		assert nfunc > 0 && nif > 0;
		
		this.nfunc = nfunc;
		this.nif = nif;
	}
	
	public int getNFunc() {
		return this.nfunc;
	}
	
	public int getNIF() {
		return this.nif;
	}
	
	public String toString() {
		return super.toString() + "\nNIF:" + this.nif + "\nNFunc:" + this.nfunc;
	}

}
