package aula11.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class WordCounter {
    private Set<String> words;
    private int totalWords;

    public WordCounter() {
       this.words = new HashSet<>();
        totalWords = 0;
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
                    this.words.add(word);
                    totalWords++;
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public String toString() {
        return "Número Total de Palavras: " + this.totalWords + "\nNúmero de Diferentes Palavras: " + this.words.size();
    }

    public static void main (String[] args) {
        WordCounter wc = new WordCounter();
        wc.readFile("gp10_files/file.txt");
        System.out.println(wc);
    }
}
