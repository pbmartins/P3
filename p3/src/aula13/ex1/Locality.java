package aula13.ex1;

public class Locality {
    private final String name;
    private int population;
    private final LocalityType type;

    public Locality(String name, LocalityType type) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido!");
        if (type == null)
            throw new IllegalArgumentException("Tipo de localidade inválido!");

        this.name = name;
        this.type = type;
        this.population = 0;
    }

    public Locality(String name, int population, LocalityType type) {
        this(name, type);
        if (population < 0)
            throw new IllegalArgumentException("Valor da população inválido!");

        this.population = population;
    }

    public final String getName() {
        return name;
    }

    public final int getPopulation() {
        return population;
    }

    public final LocalityType getType() {
        return type;
    }

    public void setPopulation(int population) {
        if (population < 0)
            throw new IllegalArgumentException("Valor da população inválido!");
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        return ((Locality)o).getName().equals(this.name) && ((Locality)o).getPopulation() == this.population && ((Locality)o).getType().equals(this.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + population;
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + ", População: " + this.population + ", Tipo de localidade: " + this.type;
    }
}
