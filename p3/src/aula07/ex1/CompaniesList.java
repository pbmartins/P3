package aula07.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class CompaniesList {
    private static Map<String, Company> companiesList;

    static {
        companiesList = new TreeMap<String, Company>();
    }

    public static final void loadFromFile(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido");
        Path p = Paths.get(path);
        try (BufferedReader bf = Files.newBufferedReader(p)) {
            String line;
            while ((line = bf.readLine()) != null) {
                String info[] = line.split("\t");
                if (!info[0].equals("Sigla")) {
                    companiesList.put(info[0], new Company(info[0], info[1]));
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }

    public static final Company getCompany(String id) {
        if (id == null)
            throw new IllegalArgumentException("ID inválido");
        if (companiesList.get(id) == null)
            companiesList.put(id, new Company(id, "Desconhecido"));

        return companiesList.get(id);
    }

    public static final int size() {
        return companiesList.size();
    }

    public static String getCompaniesByDelay() {
        String to_return = String.format("%-20s\t%-20s", "Origem", "Atraso médio");
        TreeMap<Double, List<String>> sorted = new TreeMap<Double, List<String>>();

        for (String name : companiesList.keySet()) {
            List<String> list = sorted.get(companiesList.get(name).mediumDelay());
            if (list == null) {
                List<String> l = new ArrayList<String>();
                l.add(name);
                sorted.put(companiesList.get(name).mediumDelay(), l);
            } else
                list.add(name);
        }

        for (double num : sorted.descendingKeySet()) {
            for (String name : sorted.get(num))
                to_return += String.format("\n%-20s\t%-5s", companiesList.get(name).name(), companiesList.get(name).mediumDelayTime());
        }

        return to_return;
    }
}
