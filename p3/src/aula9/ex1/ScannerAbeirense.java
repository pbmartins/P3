package aula9.ex1;

import java.io.*;
import java.util.*;

public class ScannerAbeirense implements Iterator<String>, Closeable {
    private Scanner sc;

    public ScannerAbeirense(Scanner sc) {
        if (sc == null)
            throw new IllegalArgumentException("Scanner inválida");
        this.sc = sc;
    }

    public ScannerAbeirense(InputStream is) {
        if (is == null)
            throw new IllegalArgumentException("Scanner inválida");
        this.sc = new Scanner(is);
    }

    public ScannerAbeirense(File f) {
        if (f == null)
            throw new IllegalArgumentException("Scanner inválida");
        try {
            this.sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public ScannerAbeirense(String s) {
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException("Scanner inválida");
        try {
            this.sc = new Scanner(new File(s));
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public boolean hasNext() {
        return sc.hasNext();
    }

    public boolean hasNextLine() {
        return sc.hasNextLine();
    }

    public String next() {
        if (hasNext())
            return changeLetters(sc.next());
        else
            throw new IndexOutOfBoundsException("Não existem mais elementos na String!");
    }

    public String nextLine() {
        if (hasNextLine()) {
            String to_return = "";
            String[] words = sc.nextLine().split(" ");
            for (String word: words)
                to_return += " " + changeLetters(word);
            return to_return.substring(1);
        } else
            throw new IndexOutOfBoundsException("Não existem mais linhas na String!");
    }

    public void remove() {
        throw new UnsupportedOperationException("Esta operação não é suportada");
    }


    public void close() {
        sc.close();
    }

    private String changeLetters(String s) {
        if (s == null)
            throw new IllegalArgumentException("String inválida");
        String to_return = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'v')
                c = 'b';
            else if (c == 'V')
                c = 'B';
            to_return += c;
        }
        return to_return;
    }
}
