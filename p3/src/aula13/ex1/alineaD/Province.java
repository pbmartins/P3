package aula13.ex1.alineaD;

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
    public boolean equals(Object o) {
        return super.equals(o) && ((Province)o).getGovernator().equals(this.governator);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + governator.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + ", Governador: " + this.governator;
    }
}
