package aula13.ex1;

import java.util.*;

public class Ex1 {
	public static void main(String[] args) {
		Locality cid1 = new Locality("Szohod", 31212, LocalityType.CITY);
		Locality cid2 = new Locality("Wadesdah", 23423, LocalityType.CITY);
		Locality cid3 = new Locality("BedRock", 23423, LocalityType.TOWN);
		State est1 = new State("North Borduria", 223133, cid1); 
		State est2 = new State("South Borduria", 84321, cid2);
		
		Country p1 = new Country("Borduria", est1.getCapital());
		Country p2 = new Country("Khemed", cid2);
		Country p3 = new Country("Aurelia");
		Country p4 = new Country("Atlantis"); 
		p1.addRegion(est1);
		p1.addRegion(est2);
		p2.addRegion(new Province("Afrinia", 232475, "Aluko Pono"));
		p2.addRegion(new Province("Eriador", 100000, "Dumpgase Liru")); 
		p2.addRegion(new Province("Laurania", 30000, "Mukabamba Dabba"));
		
		List<Country> org = new ArrayList<>(); 
		org.add(p1);
		org.add(p2);
		org.add(p3);
		org.add(p4);
		
		System.out.println("----Iterar sobre o conjunto");
		Iterator<Country> itr = org.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println("-------Iterar sobre o conjunto - For each (java 8)"); 
		for (Country pais: org)
			System.out.println(pais);
		// ToDo:
		// adicionar, remover, ordenar, garantir elementos únicos
		
		
		System.out.println("-------Iterar sobre o conjunto - For each (java 8) - TreeSet"); 
		Set<Country> list = new TreeSet<>(new Comparator<Country>() {
			public int compare(Country c1, Country c2) {
				return c1.getPopulation() > c2.getPopulation() ? 1 : -1;
			}
		});
		
		// OR
		// Set<Country> list = new TreeSet<>((c1, c2) -> c1.getPopulation() > c2.getPopulation() ? 1 : -1);
		// Set<Country> list = new TreeSet<>(Comparator.comparing(Country::getPopulation));
		
		list.addAll(org);
		list.forEach(System.out::println);
	}

}
