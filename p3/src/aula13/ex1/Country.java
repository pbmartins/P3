package aula13.ex1;

import java.util.*;

public class Country {
    private final String name;
    private final Locality capital;
    private List<Region> regions;

    public Country(String name, Locality capital) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido!");
        if (capital == null || capital.getType() != LocalityType.CITY)
            throw new IllegalArgumentException("Governador inválido!");

        this.name = name;
        this.capital = capital;
        this.regions = new LinkedList<>();
    }

    public Country(String name, Locality capital, List<Region> list) {
        this(name, capital);
        if (list == null)
            throw new IllegalArgumentException("Lista de regiões inválida!");

        this.regions = list;
    }

    public Country(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido!");

        this.name = name;
        this.capital = new Locality(name, LocalityType.CITY);
        this.regions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Locality getCapital() {
        return capital;
    }

    public Region[] getRegions() {
        return this.regions.toArray(new Region[this.regions.size()]);
    }

    public Iterator<? extends Region> getRegionsIterator() {
        return this.regions.iterator();
    }

    public void addRegion(Region r) {
        if (r == null)
            throw new IllegalArgumentException("Região inválida!");
        this.regions.add(r);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        return ((Country)o).getName().equals(this.name) && ((Country)o).getCapital().equals(this.capital)
                && Arrays.equals(((Country)o).getRegions(), this.getRegions());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (regions != null ? regions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pais: " + this.name + ", População: " + this.regions.stream().mapToInt(Region::getPopulation).sum()
                + " (City: " + this.capital.toString() + ")";
    }
}
