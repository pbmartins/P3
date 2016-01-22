package aula01.ex3;
import java.util.*;

public class Ex3 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		HashMap<String, Circle> circulos = new HashMap<String, Circle>();
		HashMap<String, Square> quadrados = new HashMap<String, Square>();
		HashMap<String, Rectangle> retangulos = new HashMap<String, Rectangle>();
		String key = "";
		Circle c1 = null, c2 = null;
		
		for (;;) {
			switch(showMenu()) {
				case 0:
					System.out.println("O programa vai encerrar.");
					System.exit(0);
					break;
				case 1:
					Circle circulo = criarCirculo();
					System.out.print("Identificador (chave): ");
					key = sc.next();
					assert !circulos.containsKey(key);
					circulos.put(key, circulo);
					break;
				case 2:
					Square quadrado = criarQuadrado();
					System.out.print("Identificador (chave): ");
					key = sc.next();
					assert !quadrados.containsKey(key);
					quadrados.put(key, quadrado);
					break;
				case 3:
					Rectangle retangulo = criarRetangulo();
					System.out.print("Identificador (chave): ");
					key = sc.next();
					assert !retangulos.containsKey(key);
					retangulos.put(key, retangulo);
					break;
				case 4:
					printAll(circulos, quadrados, retangulos);
					break;
				case 5:
					c1 = procurarCirculo(circulos);
					c2 = procurarCirculo(circulos);
					if (c1.equalsTo(c2)) 
						System.out.println("Os círculos são iguais.");
					else
						System.out.println("Os círculos são diferentes.");
					break;
				case 6:
					c1 = procurarCirculo(circulos);
					c2 = procurarCirculo(circulos);
					if (c1.interseta(c2)) 
						System.out.println("Os círculos intersetam-se.");
					else
						System.out.println("Os círculos não se intersetam.");
					break;
			}
		}
	}
	
	public static int showMenu() {
		int op = 0;
		System.out.println("------------------------------------------------");
		System.out.println("0 - Sair do programa.");
		System.out.println("1 - Criar circulo.");
		System.out.println("2 - Criar quadrado.");
		System.out.println("3 - Criar retângulo.");
		System.out.println("4 - Imprimir todas as figuras.");
		System.out.println("5 - Verificar se dois círculos são iguais.");
		System.out.println("6 - Verificar se dois círculos se intersetam.");
		System.out.println("------------------------------------------------");
		
		do {
			System.out.print("Opção -> ");
			op = sc.nextInt();
		} while (op < 0 && op > 6);
		
		return op;
	}
	
	public static Point criarPonto() {
		double x = 0, y = 0;
		System.out.println("----- Ponto -----");
		System.out.print("Abcissa: ");
		x = sc.nextDouble();
		System.out.print("Ordenada: ");
		y = sc.nextDouble();
		
		return new Point(x, y);
	}
	
	public static Circle criarCirculo() {
		Point centro = null;
		double raio = 0;
		
		System.out.println("---- Circulo ----");
		centro = criarPonto();
		System.out.print("Raio: ");
		raio = sc.nextDouble();
		
		return new Circle(centro, raio);
	}
	
	public static Square criarQuadrado() {
		Point centro = null;
		double lado = 0;
		
		System.out.println("---- Quadrado ----");
		centro = criarPonto();
		System.out.print("Lado: ");
		lado = sc.nextDouble();
		
		return new Square(centro, lado);
	}
	
	public static Rectangle criarRetangulo() {
		Point centro = null;
		double comprimento = 0, largura = 0;
		
		System.out.println("---- Retângulo ----");
		centro = criarPonto();
		System.out.print("Comprimento: ");
		comprimento = sc.nextDouble();
		System.out.print("Largura: ");
		largura = sc.nextDouble();
		
		return new Rectangle(centro, comprimento, largura);
	}
	
	public static void printAll(HashMap<String, Circle> circulos, HashMap<String, Square> quadrados, HashMap<String, Rectangle> retangulos) {
		assert !(circulos.isEmpty() && quadrados.isEmpty() && retangulos.isEmpty());
		
		Iterator<Circle> c_iterator = circulos.values().iterator();
		Iterator<Square> q_iterator = quadrados.values().iterator();
		Iterator<Rectangle> r_iterator = retangulos.values().iterator();
		
		printIterator(c_iterator, "Circulos");
		printIterator(q_iterator, "Quadrados");
		printIterator(r_iterator, "Retângulos");
	}
	
	public static void printIterator(Iterator<?> iterator, String type) {
		System.out.println("----- " + type + " -----");
		while (iterator.hasNext())
			System.out.println(iterator.next().toString());
	}
	
	public static Circle procurarCirculo(HashMap<String, Circle> circulos) {
		assert !circulos.isEmpty();
		String key = "";
		Circle c = null;
		
		System.out.print("Identificador (chave): ");
		key = sc.next();
		
		try {
			c = circulos.get(key);
		} catch (NullPointerException e) {
			System.err.println("Não existe nenhum círculo com a chave dada!");
		}
		return c;
	}

}
