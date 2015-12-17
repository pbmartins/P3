package aula13.ex1;

public class State extends Region {
	private Locality capital;
	
	public State(String name, int population, Locality capital) {
		super(name, population);
		if (capital == null || capital.getLocalityType() != LocalityType.CITY)
			throw new IllegalArgumentException("Capital inválida!");
		this.capital = capital;
	}

	public Locality getCapital() {
		return capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && ((State)obj).getCapital().equals(this.capital);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Capital: " + this.capital.toString();
	}
	
}
