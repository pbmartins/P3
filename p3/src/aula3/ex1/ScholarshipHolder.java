package aula3.ex1;

import aula1.ex2.Date;

public class ScholarshipHolder extends Student {
	private double value;
	
	public ScholarshipHolder(String name, int cc, Date bornDate, Date signupDate) {
		super(name, cc, bornDate, signupDate);
	}
	
	public ScholarshipHolder(String name, int cc, Date bornDate) {
		super(name, cc, bornDate);
	}
	
	public ScholarshipHolder(String name, int cc, Date bornDate, Date signupDate, double value) {
		super(name, cc, bornDate, signupDate);
		if (value <= 0) throw new AssertionError("O valor da bolsa deve ser positivo");
		this.value = value;
	}
	
	public ScholarshipHolder(String name, int cc, Date bornDate, double value) {
		super(name, cc, bornDate);
		if (value <= 0) throw new AssertionError("O valor da bolsa deve ser positivo");
		this.value = value;
	}
	
	public final double getValue() {
		return this.value;
	}
	
	public final void setValue(double value) {
		if (value <= 0) throw new AssertionError("O valor da bolsa deve ser positivo");
		this.value = value;
	}
	
	public final String toString() {
		return super.toString() + "\nValor da bolsa: " + this.value + " euros";
	}
	
}
