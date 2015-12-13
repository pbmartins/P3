package aula13.ex1.alineaD;

public class State extends Region {
    private final City capital;

    public State(String name, int population, City capital) {
        super(name, population);
        if (capital == null)
            throw new IllegalArgumentException("Cidade inválida!");

        this.capital = capital;
    }

    public City getCapital() {
        return this.capital;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && ((State)o).getCapital().equals(this.capital);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + capital.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + ", City: " + this.capital.toString();
    }
}
