package aula13.ex2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CountPairs {
    private Path path;
    private Map<String, Pair> pairs;

    public CountPairs(String p) {
        this(Paths.get(p));
    }

    public CountPairs(Path p) {
        if (p == null)
            throw new IllegalArgumentException("Caminho inválido!");
        this.path = p;
        readFilePairs();
        saveToFile();
    }

    private void readFilePairs() {
        if (path == null)
            throw new AssertionError("Caminho inválido!");

        pairs = new TreeMap<>();
        String word = null, pair = null, tmp = null;
        Scanner sf = null;

        try {
             sf = new Scanner(path);
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            if (sf.hasNext())
                word = sf.next().toLowerCase();
            while (sf.hasNext()) {
                if (word.split("\\p{Punct}").length > 1) {  // if there is any punctuation, skip the word
                    word = sf.next().toLowerCase();
                    continue;
                }
                word = word.replaceAll("[^\\p{L} ]", "");   // delete all non-characters
                if (word.length() < 3) {                    // check word length
                    word = sf.next().toLowerCase();
                    continue;
                }
                if (!sf.hasNext())
                    break;
                pair = sf.next().toLowerCase();
                tmp = pair;
                String[] pairSplit = pair.split("\\p{Punct}");
                if (pairSplit.length > 1)
                    pair = pairSplit[0];
                pair = pair.replaceAll("[^\\p{L} ]", "");
                if (pair.length() < 3)
                    continue;


                if (pairs.containsKey(word))
                    pairs.put(word, pairs.get(word).addPair(pair));
                else
                    pairs.put(word, new Pair(word, pair));
                word = tmp;                                // word = sf.next() = pair
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        if (pairs.size() == 0)
            throw new AssertionError("Coleção de pares vazia!");

        Path out = Paths.get(path.getParent().toString() + "/output_" + path.getFileName().toString());
        try (BufferedWriter bw = Files.newBufferedWriter(out)) {
            //this.pairs.keySet().stream().forEach(word -> bw.write(pairs.get(word).toString() + "\n"));
            for (String line : toString().split("\n"))
                bw.write(line + "\n");
        } catch(IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public String toString() {
        return this.pairs.keySet().stream().map(word -> pairs.get(word).toString()).collect(Collectors.joining("\n"));
    }
}
