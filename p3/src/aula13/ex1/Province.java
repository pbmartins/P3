package aula13.ex1;

public class Province extends Region {
	private String governator;
	
	public Province(String name, int population, String governator) {
		super(name, population);
		if (governator == null || governator.length() == 0)
			throw new IllegalArgumentException("Governador inválido!");
		this.governator = governator;
	}
	
	public String getGovernator() {
		return this.governator;
	}
	
	public void setGovernator(String governator) {
		if (governator == null || governator.length() == 0)
			throw new IllegalArgumentException("Governador inválido!");
		this.governator = governator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((governator == null) ? 0 : governator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && ((Province)obj).getGovernator().equals(this.governator);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Governador: " + this.governator;
	}
}
