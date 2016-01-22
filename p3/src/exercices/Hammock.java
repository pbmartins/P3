package exercices;

public class Hammock extends Marquise implements Transport {
    private int numGrills;
    private TransportType type;

    public Hammock(String designation, int id, Material material, double width, double height, boolean mattress,
                   int numGrills) {
        super(designation, id, material, width, height, mattress, false);
        if (numGrills < 0)
            throw new IllegalArgumentException("Número de grades inválido!");
        this.numGrills = numGrills;
    }

    public int getNumGrills() {
        return numGrills;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        if (type == null)
            throw new IllegalArgumentException("Tipo inválido!");
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && ((Hammock)o).getNumGrills() == this.numGrills && ((Hammock)o).getType().equals(this.type);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numGrills + type.hashCode();
        return result;
    }

    public String toString() {
        String[] to_return = super.toString().split(" ", 2);
        return "Maca: " + to_return[1] + ", Número de grades: " + this.numGrills + ", Tipo: " + this.type;
    }
}
