package aula07.ex1;

public class Flight implements Comparable<Flight> {
    private Time departure;
    private Time delay;
    private String id;
    private String origin;
    private Company company;
    private Delay delayString;
    private Delay obsString;

    public Flight(String id, String origin, Time departure) {
        if (id.length() == 0 || origin.length() == 0 || departure == null)
            throw new IllegalArgumentException("Campos inválidos");
        this.id = id;
        this.origin = origin;
        this.departure = departure;
        this.company = getCompany(id);
        delayString = (d) -> {
            if (d == null)
                return "";
            else
                return d.toString();
        };
        obsString = (d) -> {
            if (d == null)
                return "";
            else
                return "Previsto: " + Time.sumTime(this.departure, d).toString();
        };
    }

    public String id() {
        return this.id;
    }

    public String origin() {
        return this.origin;
    }

    public Time departure() {
        return this.departure;
    }

    public Time delay() {
        return this.delay;
    }

    public Company company() {
        return this.company;
    }

    public void setDelay(Time delay) {
        if (delay == null)
            throw new IllegalArgumentException("Atraso inválido");
        this.delay = delay;
        this.company.addDelay(delay);
    }

    public String toString() {
        return String.format("%-6s\t%-10s\t%-22s\t%-25s\t%-8s\t%-15s",
                this.departure, this.id, this.company, this.origin, delayString.func(this.delay), obsString.func(this.delay));
    }

    public boolean equals(Object f) {
        if (f == null)
            return false;
        if (f.getClass() != this.getClass())
            return false;
        return ((Flight)f).id().equals(this.id) && ((Flight)f).origin().equals(this.origin) && ((Flight)f).departure().equals(this.departure)
                && ((Flight)f).delay().equals(this.delay) && ((Flight)f).company().equals(this.company);
    }

    public int compareTo(Flight f) {
        return this.departure.compareTo(f.departure());
    }

    private Company getCompany(String id) {
        if (CompaniesList.size() == 0)
            throw new AssertionError("A lista de companhias aéreas está vazia.");
        if (id == null || id.length() == 0)
            throw new IllegalArgumentException("ID inválido");

        return CompaniesList.getCompany(id.substring(0, 2));
    }
}
