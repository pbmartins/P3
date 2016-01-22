package exercices;

public class ArticulatedBed extends Bed {
    private boolean electric;

    public ArticulatedBed(String designation, int id, Material material, double width, double height, boolean mattress,
                          boolean electric) {
        super(designation, id, material, width, height, mattress);
        this.electric = electric;
    }

    public boolean isElectric() {
        return electric;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && ((ArticulatedBed)o).isElectric() == this.electric;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (electric ? 1 : 0);
        return result;
    }

    public String toString() {
        String[] to_return = super.toString().split(" ", 2);
        return "Cama articulada: " + to_return[1] + ", Elétrica: " + this.electric;
    }
}
