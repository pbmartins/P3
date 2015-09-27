package aula1;

public class Retangulo {
	private Ponto centro;
	private double comprimento, largura;
	
	public Retangulo(Ponto centro, double comprimento, double largura) {
		assert centro != null;
		assert comprimento > 0 && largura > 0 && comprimento != largura;
		
		this.centro = centro;
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public Retangulo(double x, double y, double comprimento, double largura) {
		assert comprimento > 0 && largura > 0 && comprimento != largura;
		
		this.centro = new Ponto(x, y);
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public Ponto getCentro() {
		return this.centro;
	}
	
	public double getComprimento() {
		return this.comprimento;
	}
	
	public double getLargura() {
		return this.largura;
	}
	
	public double area() {
		return this.comprimento * this.largura;
	}
	
	public double perimetro() {
		return 2 * this.comprimento + 2 * this.largura;
	}
	
	public String toString() {
		return "Centro: " + centro.toString() + " | Comprimento: " + this.comprimento + " | Largura: " + this.largura + " | Área: " + area() + " | Perimetro: " + perimetro();
	}
}
