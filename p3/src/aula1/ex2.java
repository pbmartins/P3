package aula1;
import java.util.*;

public class ex2 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		List lista = new List();
		int cc;
		Person p;
		
		for (;;) {
			switch(showMenu()) {
				case 0:
					System.out.println("O programa vai encerrar.");
					System.exit(0);
					break;
				case 1:
					lista.add(novaPessoa());
					break;
				case 2:
					System.out.print("Introduza o CC da pessoa: ");
					cc = sc.nextInt();
					p = lista.searchPerson(cc);
					if (p == null)
						System.out.println("Não existe nenhuma pessoa com esse CC.");
					else
						lista.remove(p);
					break;
				case 3:
					System.out.println(lista.toString());
					break;
				case 4:
					lista.sortByName();
					break;
				case 5:
					lista.sortByCC();
					break;
			}
		}
		
	}
	
	public static int showMenu() {
		int op = 0;
		System.out.println("------------------------------------------------");
		System.out.println("0 - Sair do programa.");
		System.out.println("1 - Adicionar pessoa à lista.");
		System.out.println("2 - Apagar pessoa da lista.");
		System.out.println("3 - Mostar lista completa.");
		System.out.println("4 - Ordenar lista por nome.");
		System.out.println("5 - Ordenar lista por CC.");
		System.out.println("------------------------------------------------");
		
		do {
			System.out.print("Opção -> ");
			op = sc.nextInt();
		} while (op < 0 && op > 5);
		
		return op;
	}
	
	public static Person novaPessoa() {
		String nome;
		int cc;
		Date dataNasc;
		
		System.out.println("----- PESSOA -----");
		System.out.print("Nome: ");
		sc.skip("\n");
		nome = sc.nextLine();
		//sc.nextLine();
		System.out.print("CC: ");
		cc = sc.nextInt();
		dataNasc = novaData();
		
		return new Person(nome, cc, dataNasc);
	}
	
	public static Date novaData() {
		int dia, mes, ano;
		
		System.out.println("----- DATA -----");
		System.out.print("Dia: ");
		dia = sc.nextInt();
		System.out.print("Mês: ");
		mes = sc.nextInt();
		System.out.print("Ano: ");
		ano = sc.nextInt();
		
		return new Date(dia, mes, ano);
	}

}
