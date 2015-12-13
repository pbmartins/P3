package aula13.ex1;

public class State extends Region {
    private final Locality capital;

    public State(String name, int population, Locality capital) {
        super(name, population);
        if (capital == null || capital.getType() != LocalityType.CITY)
            throw new IllegalArgumentException("City inválido!");

        this.capital = capital;
    }

    public Locality getCapital() {
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
