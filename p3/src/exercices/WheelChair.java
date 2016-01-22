package exercices;


public class WheelChair extends Chair implements Transport {
    private int numWheels;
    private boolean electric;
    private TransportType type;

    public WheelChair(String designation, int id, Material material, ChairType type, int supports, double height,
                      int numWheels, boolean electric) {
        super(designation, id, material, type, supports, height);
        if (numWheels <= 0)
            throw new IllegalArgumentException("Número de rodas inválido!");
        this.numWheels = numWheels;
        this.electric = electric;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public boolean isElectric() {
        return electric;
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
        return super.equals(o) && ((WheelChair)o).getNumWheels() == this.numWheels
                && ((WheelChair)o).isElectric() == this.electric && ((WheelChair)o).getType().equals(this.type);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numWheels;
        result = 31 * result + (electric ? 1 : 0);
        result = type.hashCode();
        return result;
    }

    public String toString() {
        String[] to_return = super.toString().split(" ", 2);
        return "Cadeira de Rodas: " + to_return[1] + ", Número de Rodas: " + this.numWheels + ", Elétrica: " + this.electric;
    }
}
