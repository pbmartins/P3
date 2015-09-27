package aula1;

public class Quadrado {
	private Ponto centro;
	private double lado;
	
	public Quadrado(Ponto centro, double lado) {
		assert centro != null;
		assert lado > 0;
		
		this.centro = centro;
		this.lado = lado;
	}
	
	public Quadrado(double x, double y, double lado) {
		assert lado > 0;
		
		this.centro = new Ponto(x, y);
		this.lado = lado;
	}
	
	public Ponto getCentro() {
		return this.centro;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double area() {
		return Math.pow(lado, 2);
	}
	
	public double perimetro() {
		return 4 * lado;
	}
	
	public String toString() {
		return "Centro: " + centro.toString() + " | Lado: " + this.lado + " | Área: " + area() + " | Perimetro: " + perimetro();
	}
}
