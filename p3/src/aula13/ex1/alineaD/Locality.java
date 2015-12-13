package aula13.ex1.alineaD;

public abstract class Locality {
    private final String name;
    private int population;

    public Locality(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido!");

        this.name = name;
        this.population = 0;
    }

    public Locality(String name, int population) {
        this(name);
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
        return ((Locality)o).getName().equals(this.name) && ((Locality)o).getPopulation() == this.population;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + population;
        return result;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + ", População: " + this.population;
    }
}
