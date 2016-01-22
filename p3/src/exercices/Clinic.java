package exercices;

import java.util.*;

public class Clinic {
    private String name;
    private Set<Furniture> list;

    public Clinic(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Nome inválido");
        this.name = name;
        this.list = new LinkedHashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Furniture> getList() {
        return list;
    }

    public Furniture addFurniture(Furniture f) {
        if (f == null)
            throw new IllegalArgumentException("Mobiliário inválido!");
        list.add(f);
        return f;
    }

    public void removeFurniture(Furniture f) {
        if (list.contains(f))
            list.remove(f);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clinic clinic = (Clinic) o;

        if (name != null ? !name.equals(clinic.name) : clinic.name != null) return false;
        return !(list != null ? !list.equals(clinic.list) : clinic.list != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }
}
