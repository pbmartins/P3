package aula13.ex1.alineaD;

public abstract class Region {
    private final String name;
    private final int population;

    public Region(String name, int population) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido!");
        if (population < 0)
            throw new IllegalArgumentException("Valor da população inválido!");

        this.name = name;
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        return ((Region)o).getName().equals(this.name) && ((Region)o).getPopulation() == this.population;
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
