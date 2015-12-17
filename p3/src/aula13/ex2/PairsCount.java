package aula13.ex2;

import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class PairsCount {
	private Path path;
	private Map<String, Pair> words;
	
	public PairsCount(String path) {
		if (path == null || path.length() == 0)
			throw new IllegalArgumentException("Caminho inválido!");
		this.path = Paths.get(path);
		this.words = new TreeMap<>();
		countPairs();
		saveToFile();
	}
	
	@Override
	public String toString() {
		return this.words.keySet().stream().map(key -> this.words.get(key).toString()).collect(Collectors.joining("\n"));
	}
	
	private void countPairs() {
		String line = null;
		String text = "";
		
		try(BufferedReader bf = Files.newBufferedReader(path)) {
			while((line = bf.readLine()) != null) 
				text = text + " " + line.toLowerCase();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String words[] = text.split("\\W+");
		List<String> wordList = Arrays.stream(words).filter(word -> word.length() >= 3).collect(Collectors.toList());
		for (int i = 0; i < wordList.size() - 1; i++)
			createPair(wordList.get(i), wordList.get(i + 1));
	}
	
	private void createPair(String word, String pair) {
		if (this.words.containsKey(word))
			words.get(word).addPair(pair);
		else
			words.put(word, new Pair(word, pair));
	}
	
	private void saveToFile() {
		Path p = Paths.get(this.path.getParent().toString() + "output_" + this.path.getFileName().toString());
		try (BufferedWriter bw = Files.newBufferedWriter(p)) {
			bw.write(toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
