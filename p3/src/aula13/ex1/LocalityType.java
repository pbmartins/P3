package aula13.ex1;

public enum LocalityType {
    CITY("Cidade"), TOWN("Vila"), VILLAGE("Aldeia");

    private final String ptType;
    private LocalityType(String type) {
        if (type == null || type.length() == 0)
            throw new IllegalArgumentException("Nome inválido");
        this.ptType = type;
    }

    public String getPtType() {
        return this.ptType;
    }

    public String toString() {
        return this.getPtType();
    }
}
