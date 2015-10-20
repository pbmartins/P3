package aula6;

public enum FishType {
    FRESH, FROZEN;

    @Override public String toString() {
        return this.name().substring(0, 1) + (this.name().substring(1, this.name().length())).toLowerCase();
    }
}
