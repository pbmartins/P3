package aula06;

import java.io.Serializable;

public enum FishType implements Serializable {
    FRESH, FROZEN;

    @Override public String toString() {
        return this.name().substring(0, 1) + (this.name().substring(1, this.name().length())).toLowerCase();
    }
}
