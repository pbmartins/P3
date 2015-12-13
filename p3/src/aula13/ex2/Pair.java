package aula13.ex2;

import java.util.*;
import java.util.stream.Collectors;

public class Pair {
    private String word;
    private Map<String, Integer> pairs;

    public Pair(String word) {
        if (word == null || word.length() < 3)
            throw new IllegalArgumentException("Palavra inválida!");
        this.word = word;
        this.pairs = new TreeMap<>();
    }

    public Pair(String word, String pair) {
        this(word);
        addPair(pair);
    }

    public Pair addPair(String pair) {
        if (pair == null || pair.length() < 3)
            throw new IllegalArgumentException("Palavra inválida!");
        if (this.pairs.containsKey(pair))
            this.pairs.put(pair, this.pairs.get(pair) + 1);
        else
            this.pairs.put(pair, 1);
        return this;
    }

    public String getWord() {
        return this.word;
    }

    public Map<String, Integer> getPairs() {
        return this.pairs;
    }

    public String toString() {
        return word + "={" + pairs.keySet().stream()
                .map(key -> key + "=" + pairs.get(key)).collect(Collectors.joining(", ")) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        return ((Pair)o).getWord().equals(this.word) && ((Pair)o).getPairs().equals(this.pairs);
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (pairs != null ? pairs.hashCode() : 0);
        return result;
    }
}
