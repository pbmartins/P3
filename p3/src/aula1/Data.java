package aula1;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int d, int m, int a) {
		assert validarData(d, m, a);
		this.dia = d;
		this.mes = m;
		this.ano = a;
	}
	
	private boolean validarData(int d, int m, int a) {
		boolean to_return = true;
		
		if (a < 0) to_return = false;
		else {
			if (m < 1 && m > 12) to_return = false;
			switch(m) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if (d < 1 || d > 31) to_return = false;
					break;
				case 2:
					if ( ((d < 1 || d > 28) && !anoBissexto(a)) || (((d < 1 || d > 29) && anoBissexto(a))) ) to_return = false;
					break;
				case 4: case 6: case 9: case 11:
					if (d < 1 || d > 30) to_return = false;
					break;
			}
		}
		return to_return;
	}
	
	private boolean anoBissexto(int a) {
		if ((a % 4 == 0 && !(a % 100 == 0)) || (a % 400 == 0)) return true;
		else return false;
	}
	
	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
	
	public int getDay() {
		return this.dia;
	}
	
	public int getMonth() {
		return this.mes;
	}
	
	public int getYear() {
		return this.ano;
	}
}
