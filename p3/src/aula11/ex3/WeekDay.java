package aula11.ex3;

import java.io.Serializable;

public enum WeekDay implements Serializable {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override public String toString() {
        return this.name().substring(0, 1) + (this.name().substring(1, this.name().length())).toLowerCase();
    }

    public static WeekDay rand() {
        return values()[(int) (Math.random() * values().length)];
    }
}
