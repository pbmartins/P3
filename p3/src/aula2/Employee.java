package aula2;
import aula1.Data;

public class Employee extends Client {
	private int nfunc, nif;
	
	public Employee(String name, int cc, Data bornDate, Data signupDate, int nfunc, int nif) {
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
