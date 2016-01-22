package exercices;


public abstract class Furniture {
    private String designation;
    private int id;
    private Material material;

    protected Furniture(String designation, int id, Material material) {
        if (designation == null || designation.length() == 0)
            throw new IllegalArgumentException("Designação inválida!");
        if (id <= 0)
            throw new IllegalArgumentException("ID inválido!");
        if (material == null)
            throw new IllegalArgumentException("Material inválido!");
        this.designation = designation;
        this.id = id;
        this.material = material;
    }

    public String getDesignation() {
        return designation;
    }

    public int getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        return ((Furniture)o).getDesignation().equals(this.designation) && ((Furniture)o).getId() == this.id &&
                ((Furniture)o).getMaterial().equals(this.material);

    }

    @Override
    public int hashCode() {
        int result = designation != null ? designation.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    public String toString() {
        return this.designation + ", ID: " + this.id + ", Material: " + this.material;
    }
}
