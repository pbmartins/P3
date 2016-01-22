package aula13.ex1;

public abstract class Region {
	private String name;
	private int population;
	
	public Region(String name, int population) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Nome inválido!");
		if (population < 0)
			throw new IllegalArgumentException("População inválida!");
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		if (population < 0)
			throw new IllegalArgumentException("População inválida!");
		this.population = population;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + population;
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
		return ((Region)obj).getName().equals(this.name) && ((Region)obj).getPopulation() == this.population;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.name + ", População: " + this.population;
	}
}
