package aula13.ex1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class Country {
	private String name;
	private Locality capital;
	private List<Region> regions;
	
	public Country(String name) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Nome inválido!");
		this.name = name;
		this.capital = null;
		this.regions = new LinkedList<>();
	}
	
	public Country(String name, Locality capital) {
		this(name);
		if (capital == null || capital.getLocalityType() != LocalityType.CITY)
			throw new IllegalArgumentException("Capital inválida!");
		this.capital = capital;
	}

	public String getName() {
		return name;
	}

	public Locality getCapital() {
		return capital;
	}

	public List<Region> getRegions() {
		return regions;
	}
	
	public int getPopulation() {
		return this.regions.stream().collect(Collectors.summingInt(Region::getPopulation));
		// OR
		// this.regions.stream().mapToDouble(Region::getPopulation).sum();
	}
	
	public void addRegion(Region r) {
		if (r == null)
			throw new IllegalArgumentException("Região inválida!");
		this.regions.add(r);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regions == null) ? 0 : regions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return ((Country)obj).getName().equals(this.name) && ((Country)obj).getCapital().equals(this.capital) &&
				((Country)obj).getRegions().equals(this.regions);
	}
	
	@Override
	public String toString() {
		return "Pais: " + this.name + ", População: " + this.getPopulation() + "(Capital: " + returnCapital(capital -> capital != null) + ")";
	}
	
	
	private String returnCapital(Predicate<Locality> func) {
		if (func.test(capital))
			return this.capital.toString();
		else
			return "*Indefinida*";
	}
}
