package aula12.ex3;

import aula01.ex2.Date;

import java.io.*;
import java.util.*;
import aula12.ex3.plugins.*;

public class Ex3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ContactList lista = new ContactList();
		int number;
		Contact p;
        String path, type;
        File f;
        Scanner sf;

        // Read Plugins
        File proxyList = new File("src/aula12/ex3/plugins");
        ArrayList<Formats> plgs = new ArrayList<>();
        for (String fName : proxyList.list()) {
            try {
                plgs.add(PluginManager.load("aula12.ex3.plugins." + fName.substring(0, fName.lastIndexOf('.'))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Nokia nokia = null;
        CSV csv = null;
        vCard vcard = null;
        for (Formats format : plgs) {
            if (format instanceof Nokia)
                nokia = (Nokia)format;
            else if (format instanceof CSV)
                csv = (CSV)format;
            else if (format instanceof vCard)
                vcard = (vCard)format;
            else
                throw new IllegalArgumentException("Plugin not supported");
        }
        // End reading plugins


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
					System.out.print("Introduza o contacto da pessoa: ");
					number = sc.nextInt();
					p = lista.searchPerson(number);
					if (p == null)
						System.out.println("Não existe nenhuma pessoa com esse número.");
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
                    path = getPath();
                    f = new File(path);
                    type = "";

                    try {
                        sf = new Scanner(f);
                        if (sf.hasNextLine())
                            type = sf.nextLine();
                        sf.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("Ficheiro não encontrado.");
                    }
                    switch(type) {
                        case "Nokia":
                            for (Contact c : nokia.readFile(path))
                                lista.add(c);
                            break;
                        case "vCard":
                            for (Contact c : vcard.readFile(path))
                                lista.add(c);
                            break;
                        case "CSV":
                            for (Contact c : csv.readFile(path))
                                lista.add(c);
                            break;
                        default:
                            throw new AssertionError("Formato inválido");
                    }
                    break;
                case 6:
                    path = getPath();
                    switch(chooseFileType()) {
                        case 0:
                            nokia.saveFile(path, lista.toArray());
                            break;
                        case 1:
                            vcard.saveFile(path, lista.toArray());
                            break;
                        case 2:
                            csv.saveFile(path, lista.toArray());
                            break;
                    }
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
		System.out.println("5 - Ler dados de um ficheiro de texto.");
        System.out.println("6 - Guardar dados num ficheiro de texto.");
		System.out.println("------------------------------------------------");

		do {
			System.out.print("Opção -> ");
			op = sc.nextInt();
		} while (op < 0 && op > 6);

		return op;
	}

	public static Contact novaPessoa() {
		String nome;
		int number;
		Date dataNasc;

		System.out.println("----- PESSOA -----");
		System.out.print("Nome: ");
		sc.skip("\n");
		nome = sc.nextLine();
		System.out.print("Contacto: ");
		number = sc.nextInt();
		dataNasc = novaData();

		return new Contact(nome, number, dataNasc);
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

    public static String getPath() {
        System.out.println("---- CAMINHO do FICHEIRO ----");
        System.out.print("-> ");
        sc.skip("\n");
        return sc.nextLine();
    }

    public static int chooseFileType() {
        int op = 0;
        System.out.println("------------------------------------------------");
        System.out.println("\t0 - Nokia.");
        System.out.println("\t1 - vCard.");
        System.out.println("\t2 - CSV.");
        System.out.println("------------------------------------------------");

        do {
            System.out.print("Opção -> ");
            op = sc.nextInt();
        } while (op < 0 && op > 2);

        return op;
    }

}
