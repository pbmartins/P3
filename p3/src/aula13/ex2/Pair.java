package aula13.ex2;

import java.util.*;
import java.util.stream.*;

public class Pair {
	private String word;
	private Map<String, Integer> pairs;
	
	public Pair(String word, String pair) {
		this(word);
		if (pair == null || pair.length() < 3)
			throw new IllegalArgumentException("Palavra inválida!");
		pairs.put(pair, 1);
	}
	
	public Pair(String word) {
		if (word == null || word.length() < 3)
			throw new IllegalArgumentException("Palavra inválida!");
		this.word = word;
		pairs = new TreeMap<>();
	}
	
	public String getWord() {
		return this.word;
	}
	
	public Map<String, Integer> getPairs() {
		return this.pairs;
	}
	
	public String getPairsString() {
		return this.pairs.keySet().stream().map(key -> key + "=" + this.pairs.get(key)).collect(Collectors.joining(", "));
	}
	
	public void addPair(String pair) {
		if (pair == null || pair.length() < 3)
			throw new IllegalArgumentException("Palavra inválida!");
		if (this.pairs.containsKey(pair))
			this.pairs.put(pair, this.pairs.get(pair) + 1);
		else
			this.pairs.put(pair, 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pairs == null) ? 0 : pairs.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return ((Pair)obj).getWord().equals(this.word) && ((Pair)obj).getPairs().equals(this.pairs);
	}
	
	@Override
	public String toString() {
		return this.word + "={" + getPairsString() + "}";
	}
}
