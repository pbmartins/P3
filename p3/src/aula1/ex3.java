package aula1;
import java.util.*;

public class ex3 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		HashMap<String, Circulo> circulos = new HashMap<String, Circulo>();
		HashMap<String, Quadrado> quadrados = new HashMap<String, Quadrado>();
		HashMap<String, Retangulo> retangulos = new HashMap<String, Retangulo>();
		String key = "";
		Circulo c1 = null, c2 = null;
		
		for (;;) {
			switch(showMenu()) {
				case 0:
					System.out.println("O programa vai encerrar.");
					System.exit(0);
					break;
				case 1:
					Circulo circulo = criarCirculo();
					System.out.print("Identificador (chave): ");
					key = sc.next();
					assert !circulos.containsKey(key);
					circulos.put(key, circulo);
					break;
				case 2:
					Quadrado quadrado = criarQuadrado();
					System.out.print("Identificador (chave): ");
					key = sc.next();
					assert !quadrados.containsKey(key);
					quadrados.put(key, quadrado);
					break;
				case 3:
					Retangulo retangulo = criarRetangulo();
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
					if (c1.igualA(c2)) 
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
	
	public static Ponto criarPonto() {
		double x = 0, y = 0;
		System.out.println("----- Ponto -----");
		System.out.print("Abcissa: ");
		x = sc.nextDouble();
		System.out.print("Ordenada: ");
		y = sc.nextDouble();
		
		return new Ponto(x, y);
	}
	
	public static Circulo criarCirculo() {
		Ponto centro = null;
		double raio = 0;
		
		System.out.println("---- Circulo ----");
		centro = criarPonto();
		System.out.print("Raio: ");
		raio = sc.nextDouble();
		
		return new Circulo(centro, raio);
	}
	
	public static Quadrado criarQuadrado() {
		Ponto centro = null;
		double lado = 0;
		
		System.out.println("---- Quadrado ----");
		centro = criarPonto();
		System.out.print("Lado: ");
		lado = sc.nextDouble();
		
		return new Quadrado(centro, lado);
	}
	
	public static Retangulo criarRetangulo() {
		Ponto centro = null;
		double comprimento = 0, largura = 0;
		
		System.out.println("---- Retângulo ----");
		centro = criarPonto();
		System.out.print("Comprimento: ");
		comprimento = sc.nextDouble();
		System.out.print("Largura: ");
		largura = sc.nextDouble();
		
		return new Retangulo(centro, comprimento, largura);
	}
	
	public static void printAll(HashMap<String, Circulo> circulos, HashMap<String, Quadrado> quadrados, HashMap<String, Retangulo> retangulos) {
		assert !(circulos.isEmpty() && quadrados.isEmpty() && retangulos.isEmpty());
		
		Iterator<Circulo> c_iterator = circulos.values().iterator();
		Iterator<Quadrado> q_iterator = quadrados.values().iterator();
		Iterator<Retangulo> r_iterator = retangulos.values().iterator();
		
		printIterator(c_iterator, "Circulos");
		printIterator(q_iterator, "Quadrados");
		printIterator(r_iterator, "Retângulos");
	}
	
	public static void printIterator(Iterator<?> iterator, String type) {
		System.out.println("----- " + type + " -----");
		while (iterator.hasNext())
			System.out.println(iterator.next().toString());
	}
	
	public static Circulo procurarCirculo(HashMap<String, Circulo> circulos) {
		assert !circulos.isEmpty();
		String key = "";
		Circulo c = null;
		
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
