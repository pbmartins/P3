package aula1;

public class Circulo {
	private Ponto centro;
	private double raio;
	
	public Circulo(Ponto centro, double raio) {
		assert centro != null;
		assert raio > 0;
		
		this.centro = centro;
		this.raio = raio;
	}
	
	public Circulo(double x, double y, double raio) {
		assert raio > 0;
		
		this.centro = new Ponto(x, y);
		this.raio = raio;
	}
	
	public Ponto getCentro() {
		return this.centro;
	}
	
	public double getRaio() {
		return this.raio;
	}
	
	public double area() {
		return Math.PI * Math.pow(this.raio, 2);
	}
	
	public double perimetro() {
		return 2 * Math.PI * this.raio;
	}
	
	public String toString() {
		return "Centro: " + centro.toString() + " | Raio: " + this.raio + " | Área: " + area() + " | Perimetro: " + perimetro();
	}
	
	public boolean igualA(Circulo c) {
		if (this.raio == c.getRaio()) return true;
		else return false;
	}
	
	public boolean interseta(Circulo c) {
		double distanciaCentros = this.centro.distancia(c.getCentro());
		double somaRaios = this.raio + c.getRaio();
		if (distanciaCentros > somaRaios) return false;
		else return true;
	}
}
