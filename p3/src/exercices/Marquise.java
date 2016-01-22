package exercices;

public class Marquise extends Bed {
    private boolean inclination;

    public Marquise(String designation, int id, Material material, double width, double height, boolean mattress,
                          boolean inclination) {
        super(designation, id, material, width, height, mattress);
        this.inclination = inclination;
    }

    public boolean isInclinated() {
        return inclination;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && ((Marquise)o).isInclinated() == this.inclination;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (inclination ? 1 : 0);
        return result;
    }

    public String toString() {
        String[] to_return = super.toString().split(" ", 2);
        return "Marquise: " + to_return[1] + ", Inclinada: " + this.inclination;
    }

}
