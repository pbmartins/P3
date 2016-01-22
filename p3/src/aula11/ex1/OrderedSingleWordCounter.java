package aula11.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;

public class OrderedSingleWordCounter {
    private Map<String, Integer> words;

    public OrderedSingleWordCounter() {
        this.words = new TreeMap<>();
    }

    public void readFile(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido");
        Path p = Paths.get(path);

        try (BufferedReader bf = Files.newBufferedReader(p)) {
            String line = null;
            while ((line = bf.readLine()) != null) {
                String info[] = line.split(" ");
                for (String word : info) {
                    if (this.words.containsKey(word))
                        this.words.put(word, this.words.get(word) + 1);
                    else
                        this.words.put(word, 1);
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public String toString() {
        return this.words.entrySet().stream().map((Map.Entry entry) ->
                String.format("%-20s %d", entry.getKey(), (int)entry.getValue())).collect(Collectors.joining("\n"));
    }

    public static void main (String[] args) {
        OrderedSingleWordCounter wc = new OrderedSingleWordCounter();
        wc.readFile("gp10_files/file.txt");
        System.out.println(wc);
    }
}
