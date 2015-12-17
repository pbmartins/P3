package aula13.ex1;

public enum LocalityType {
	CITY("Cidade"), TOWN("Vila"), VILLAGE("Aldeia");
	
	private String name;
	
	private LocalityType(String name) {
		if (name == null || name.length() == 0)
			throw new IllegalArgumentException("Nome inválido!");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
