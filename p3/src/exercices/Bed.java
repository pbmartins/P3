package exercices;

public class Bed extends Furniture {
    private double width;
    private double height;
    private boolean mattress;

    public Bed(String designation, int id, Material material, double width, double height, boolean mattress) {
        super(designation, id, material);
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Dimensões inválidas!");
        this.width = width;
        this.height = height;
        this.mattress = mattress;
    }

    public boolean haveMattress() {
        return mattress;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && ((Bed)o).getWidth() == this.width && ((Bed)o).getHeight() == this.height &&
                ((Bed)o).haveMattress() == this.mattress;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (mattress ? 1 : 0);
        return result;
    }

    public String toString() {
        return "Cama " + super.toString() + ", Comprimento: " + this.width + ", Largura: " + this.height +
                ", C/ Colchão: " + this.mattress;
    }
}
