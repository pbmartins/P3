package aula13.ex1;

public class Locality {
	private String name;
	private int population;
	private LocalityType type;
	
	public Locality(String name, int population, LocalityType type) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Nome inválido!");
		if (population < 0)
			throw new IllegalArgumentException("População inválida!");
		if (type == null)
			throw new IllegalArgumentException("Tipo inválido!");
		this.name = name;
		this.population = population;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public LocalityType getLocalityType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + population;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		return ((Locality)obj).getName().equals(this.name) && ((Locality)obj).getPopulation() == this.population &&
				((Locality)obj).getLocalityType() == this.type;
	}
	
	@Override
	public String toString() {
		return this.type + " " + this.name + ", População: " + this.population;
	}
	
}
