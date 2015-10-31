package aula7;


public class Time implements Comparable<Time> {
    private int hour;
    private int minutes;

    public Time(int hour, int minutes) {
        if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("Hora inválida");
        this.hour = hour;
        this.minutes = minutes;
    }

    public int hour() {
        return this.hour;
    }

    public int minutes() {
        return this.minutes;
    }

    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minutes);
    }

    public boolean equals(Object t) {
        if (t == null)
            return false;
        if (t.getClass() != this.getClass())
            return false;
        return this.hour == ((Time)t).hour() && this.minutes == ((Time)t).minutes;
    }

    public int compareTo(Time t) {
        if (this.hour < t.hour())
            return -1;
        else if (this.hour > t.hour())
            return 1;
        else {
            if (this.minutes < t.minutes())
                return -1;
            else if (this.minutes > t.minutes())
                return 1;
            else
                return 0;
        }
    }

    public static Time sumTime(Time t1, Time t2) {
        if (t1 == null || t2 == null)
            throw new IllegalArgumentException("Hora inválida");

        int hour = 0, minutes = 0;
        hour = t1.hour() + t2.hour();
        if (hour >= 24) hour -= 24;
        minutes = t1.minutes() + t2.minutes();
        if (minutes >= 60) minutes -= 60;
        return new Time(hour, minutes);
    }

}
