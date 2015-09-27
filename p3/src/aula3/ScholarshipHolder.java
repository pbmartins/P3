package aula3;

import aula1.Data;

public class ScholarshipHolder extends Student {
	private double value;
	
	public ScholarshipHolder(String name, int cc, Data bornDate, Data signupDate) {
		super(name, cc, bornDate, signupDate);
	}
	
	public ScholarshipHolder(String name, int cc, Data bornDate) {
		super(name, cc, bornDate);
	}
	
	public ScholarshipHolder(String name, int cc, Data bornDate, Data signupDate, double value) {
		super(name, cc, bornDate, signupDate);
		if (value <= 0) throw new AssertionError("O valor da bolsa deve ser positivo");
		this.value = value;
	}
	
	public ScholarshipHolder(String name, int cc, Data bornDate, double value) {
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
		return super.toString() + "\nValor da bolsa: " + this.value;
	}
	
}
