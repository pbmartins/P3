package aula05.ex2;

public enum Fuel {
    GASOLINE95 {
        public String toString() {
            return "Gasolina Sem Chumbo 95";
        }
    },
    GASOLINE98 {
        public String toString() {
            return "Gasolina Sem Chumbo 98";
        }
    },
    DIESEL {
        public String toString() {
            return "Gasóleo";
        }
    },
    MIX {
        public String toString() {
            return "Mistura";
        }
    }
}
