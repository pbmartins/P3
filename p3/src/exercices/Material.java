package exercices;

public enum Material {
    WOOD("Madeira"), PLASTIC("Plástico"), METAL("Metal"), SINTHETIC("Sintético");

    private String type;
    private Material(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type;
    }
}
