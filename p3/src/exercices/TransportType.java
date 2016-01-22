package exercices;

public enum TransportType {
    URGENT("Urgente"), REDUCED("Mobilidade Reduzida");

    private String type;
    private TransportType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type;
    }
}
