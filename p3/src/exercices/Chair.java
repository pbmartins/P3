package exercices;

public class Chair extends Furniture {
    private ChairType type;
    private int supports;
    private double height;

    public Chair(String designation, int id, Material material, ChairType type, int supports, double height) {
        super(designation, id, material);
        if (type == null)
            throw new IllegalArgumentException("Tipo de cadeira inválido!");
        if (supports < 0)
            throw new IllegalArgumentException("Número de suportes inválido!");
        if (height <= 0)
            throw new IllegalArgumentException("Altura inválida!");
        this.type = type;
        this.supports = supports;
        this.height = height;
    }

    public ChairType getChairType() {
        return type;
    }

    public int getSupports() {
        return supports;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && ((Chair)o).getChairType().equals(this.type) && ((Chair)o).getSupports() == this.supports &&
                ((Chair)o).getHeight() == this.height;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + supports;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString() {
        return "Cadeira " + super.toString() + ", Tipo: " + this.type + ", Suportes: " + this.supports + ", Altura: " + this.height;
    }

    public enum ChairType {
        OFFICE("Escritório"), WAITING("Espera"), ATTENDENCE("Atendimento");

        private String type;
        private ChairType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public String toString() {
            return this.type;
        }
    }
}
