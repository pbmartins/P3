package aula7;

import java.util.Comparator;

public class Company implements Comparable<Company>, Comparator<Company> {
    private String id;
    private String name;
    private double totalDelay;
    private int nDelay;

    public Company(String id, String name) {
        if (id.length() == 0 || name.length() == 0)
            throw new IllegalArgumentException("Campos inválidos");
        this.id = id;
        this.name = name;
        this.totalDelay = 0;
        this.nDelay = 0;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public double mediumDelay() {
        if (this.nDelay == 0)
            return 0;
        return this.totalDelay / this.nDelay;
    }

    public Time mediumDelayTime() {
        return new Time((int)mediumDelay() / 60, (int)mediumDelay() % 60);
    }

    public void addDelay(Time t) {
        if (t == null)
            throw new IllegalArgumentException("Hora inválida");
        totalDelay += t.hour() * 60 + t.minutes();
        nDelay++;
    }

    public boolean equals(Object c) {
        if (c == null)
            return false;
        if (c.getClass() != this.getClass())
            return false;
        return ((Company)c).id().equals(this.id) && ((Company)c).name().equals(this.name) && ((Company)c).mediumDelay() == this.mediumDelay();
    }

    public int compareTo(Company c) {
        if (c == null)
            throw new IllegalArgumentException("Companhia inválida");
        if (this.mediumDelay() < c.mediumDelay())
            return -1;
        if (this.mediumDelay() > c.mediumDelay())
            return 1;
        return 0;
    }

    public int compare(Company c1, Company c2) {
        if (c1 == null)
            throw new IllegalArgumentException("Companhia inválida");
        return c1.compareTo(c2);
    }
}
