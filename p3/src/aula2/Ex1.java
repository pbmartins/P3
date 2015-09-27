package aula2;
import aula1.Data;

import java.util.*;

public class Ex1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VideoCatalogue catalogue = new VideoCatalogue(3);
		ArrayList<Client> clients = new ArrayList<Client>();
		int op = 0, key = 0, id = 0, rating = 0;
		String title = "";
		Client c = null;
		Client[] allClients = null;
		
		for (;;) {
			switch(showMenu()) {
				case 0:
					System.out.println("O programa vai encerrar.");
					System.exit(0);
					break;
				case 1:
					do {
						System.out.println("\t 1 - Estudante");
						System.out.println("\t 2 - Funcionário");
						System.out.print("Opção -> ");
						op = sc.nextInt();
					} while (op < 1 || op > 2);
					if (op == 1) clients.add(newStudent());
					else if (op == 2) clients.add(newEmployee());
					break;
				case 2:
					if (!clients.remove(searchClient(clients)))
						System.out.println("Não há nenhum cliente associado ao CC indicado.");
					break;
				case 3:
					try {
						c = searchClient(clients);
						Video[] availableVideos = catalogue.availableVideos(c.getAge());
						
						for (Video video : availableVideos)
							System.out.println(video + "\n-------------------");
					} catch (NullPointerException e) {
						System.out.println("Não há nenhum cliente associado ao CC indicado.");
					}
					break;
				case 4:
					try {
						c = searchClient(clients);
						Video[] rentedVideos = c.getAllRentedVideos();
						
						for (Video video : rentedVideos)
							System.out.println(video + "\n-------------------");
					} catch (NullPointerException e) {
						System.out.println("Não há nenhum cliente associado ao CC indicado.");
					}
					break;
				case 5:
					newVideo(catalogue);
					break;
				case 6:
					System.out.print("Título: ");
					sc.skip("\n");
					title = sc.nextLine();
					
					key = catalogue.searchVideo(title);
					if (key != -1) catalogue.removeVideo(key);
					else System.out.println("Não há nenhum filme com o título indicado.");
					break;
				case 7:
					System.out.print("Título: ");
					sc.skip("\n");
					title = sc.nextLine();
					
					key = catalogue.searchVideo(title);
					if (key != -1) {
						if (catalogue.getVideo(key).rented())
							System.out.println("O filme com o ID " + key + " está alugado.");
						else
							System.out.println("O filme com o ID " + key + " está disponível.");
					} else
						System.out.println("Não há nenhum filme com o título indicado.");
					break;
				case 8:
					c = searchClient(clients);
					System.out.print("ID do filme: ");
					id = sc.nextInt();
					try {
						catalogue.rentVideo(id, c);
					} catch (AssertionError e) {
						System.out.println("Não há nenhum filme com o ID indicado e/ou cliente inexistente.");
					}
					break;
				case 9:
					System.out.print("ID do filme: ");
					id = sc.nextInt();
					System.out.print("Rating do filme (1 - 10): ");
					rating = sc.nextInt();
					
					try {
						catalogue.checkinVideo(id, rating);
					} catch (AssertionError e) {
						System.out.println("Não há nenhum filme com o ID indicado e/ou rating descontextualizado.");
					}
					break;
				case 10:
					System.out.print("ID do filme: ");
					id = sc.nextInt();
					
					try {
						allClients = catalogue.getVideo(id).getAllClients();
						for (Client client : allClients)
							System.out.println(client + "\n-------------------");
					} catch (AssertionError e) {
						System.out.println("Este filme ainda não fui alugado.");
					}
					break;
				case 11:
					try {
						for (Video video : catalogue.getVideosSortByRating())
							System.out.println(video + "\n-------------------");
					} catch (AssertionError e) {
						System.out.println("Não existem filmes no catálogo.");
					}
					break;
			}
		}
	}
	
	public static int showMenu() {
		int op = 0;
		System.out.println("------------------------------------------------");
		System.out.println("0 - Sair do programa.");
		System.out.println("1 - Adicionar cliente.");
		System.out.println("2 - Remover cliente.");
		System.out.println("3 - Listar filmes disponíveis para determinador cliente.");
		System.out.println("4 - Listar histórico de alugueres dum cliente.");
		System.out.println("5 - Adicionar filme.");
		System.out.println("6 - Remover filme.");
		System.out.println("7 - Verificar disponibilidade dum filme.");
		System.out.println("8 - Alugar filme.");
		System.out.println("9 - Devolver filme.");
		System.out.println("10 - Verificar todos os requisitantes dum filme.");
		System.out.println("11 - Listar videos ordenados por rating.");
		
		System.out.println("------------------------------------------------");
		
		do {
			System.out.print("Opção -> ");
			op = sc.nextInt();
		} while (op < 0 && op > 11);
		
		return op;
	}
	
	public static Data newDate() {
		int day = 1, month = 1, year = 1;
		
		System.out.print("Dia: ");
		day = sc.nextInt();
		System.out.print("Mês: ");
		month = sc.nextInt();
		System.out.print("Ano: ");
		year = sc.nextInt();
		
		return new Data(day, month, year);
	}
	
	public static Student newStudent() {
		String name = "", course = "";
		int cc = 0, nmec = 0;
		Data bornDate = null, signupDate = null;
		
		System.out.println("----- Estudante -----");
		System.out.print("Nome: ");
		sc.skip("\n");
		name = sc.nextLine();
		System.out.println("----- Data de nascimento -----");
		bornDate = newDate();
		Calendar todayDate = Calendar.getInstance();
		signupDate = new Data(todayDate.get(Calendar.DAY_OF_MONTH), todayDate.get(Calendar.MONTH), todayDate.get(Calendar.YEAR));
		System.out.print("CC: ");
		cc = sc.nextInt();
		System.out.print("Course: ");
		sc.skip("\n");
		course = sc.nextLine();
		System.out.print("NMec: ");
		nmec = sc.nextInt();
		
		
		return new Student(name, cc, bornDate, signupDate, nmec, course);
	}
	
	public static Employee newEmployee() {
		String name = "";
		int cc = 0, nfunc = 0, nif = 0;
		Data bornDate = null, signupDate = null;
		
		System.out.println("----- Funcionário -----");
		System.out.print("Nome: ");
		sc.skip("\n");
		name = sc.nextLine();
		System.out.println("----- Data de nascimento -----");
		bornDate = newDate();
		Calendar todayDate = Calendar.getInstance();
		signupDate = new Data(todayDate.get(Calendar.DAY_OF_MONTH), todayDate.get(Calendar.MONTH), todayDate.get(Calendar.YEAR));
		System.out.print("CC: ");
		cc = sc.nextInt();
		System.out.print("NFunc: ");
		nfunc = sc.nextInt();
		System.out.print("NIF: ");
		nif = sc.nextInt();
		
		
		return new Employee(name, cc, bornDate, signupDate, nfunc, nif);
	}
	
	public static Client searchClient(ArrayList<Client> clients) {
		int cc = 0;
		Client c = null;
		
		System.out.print("CC: ");
		cc = sc.nextInt();
		
		for (int i = 0; i < clients.size(); i++) {
			if (cc == clients.get(i).getCC()) {
				c = clients.get(i);
				break;
			}
		}
		
		return c;
	}
	
	public static void newVideo(VideoCatalogue catalogue) {
		String title = "", category = "", rate = "";
		
		System.out.println("----- Filme -----");
		System.out.print("Título: ");
		sc.skip("\n");
		title = sc.nextLine();
		System.out.print("Género: ");
		category = sc.next();
		System.out.print("Rate (ALL, M6, M12, M16, M18): ");
		rate = sc.next();
		
		catalogue.addVideo(title, category, rate);
	}


}
