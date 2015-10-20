package aula6;

public enum MeatVariety {
    COW, PIG, TURKEY, CHICKEN, WEAL, RABBIT;

    @Override public String toString() {
        return this.name().substring(0, 1) + (this.name().substring(1, this.name().length())).toLowerCase();
    }
}