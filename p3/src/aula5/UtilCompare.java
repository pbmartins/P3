package aula5;

import apple.laf.JRSUIUtils;

import java.util.*;

public class UtilCompare {
    public static <T> Comparable<T> findMax(Comparable<T>[] list) {
        if (list == null || list.length == 0)
            throw new IllegalArgumentException("Lista de figuras inválida.");
        Comparable<T> max = null;

        for (Comparable<T> f : list) {
            if (max == null || f.compareTo((T)max) == 1)
                max = f;
        }
        return max;
    }

    public static <T> void sortArray(Comparable[] list) {
        List<Comparable> sorted = new ArrayList<Comparable>();
        for (Comparable f : list)
            sorted.add(f);

        Collections.sort(sorted);
        list = sorted.toArray(new Comparable[sorted.size()]);
    }
}
