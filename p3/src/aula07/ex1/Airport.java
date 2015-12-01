package aula07.ex1;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Airport {
    private Map<String, List<Flight>> flights;

    public Airport() {
        this.flights = new HashMap<String, List<Flight>>();
    }

    public Map<String, List<Flight>> flights() {
        return this.flights;
    }

    public void readFromFile(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido");

        Path p = Paths.get(path);
        try (BufferedReader bf = Files.newBufferedReader(p)) {
            this.flights = new HashMap<String, List<Flight>>();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] info = line.split("\t");

                if (!info[0].equals("Hora")) {
                    Time dep = new Time(Integer.parseInt(info[0].split(":")[0]), Integer.parseInt(info[0].split(":")[1]));
                    Flight f = new Flight(info[1], info[2], dep);
                    if (info.length == 4) {
                        Time del = new Time(Integer.parseInt(info[3].split(":")[0]), Integer.parseInt(info[3].split(":")[1]));
                        f.setDelay(del);
                        if (this.flights.get(info[2]) == null) {
                            List<Flight> lf = new ArrayList<Flight>();
                            lf.add(f);
                            this.flights.put(info[2], lf);
                        } else
                            this.flights.get(info[2]).add(f);

                    } else if (info.length == 3) {
                        if (this.flights.get(info[2]) == null) {
                            List<Flight> lf = new ArrayList<Flight>();
                            lf.add(f);
                            this.flights.put(info[2], lf);
                        } else
                            this.flights.get(info[2]).add(f);
                    } else
                        throw new AssertionError("Ficheiro inválido");
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void readFromBinaryFile(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido");

        RandomAccessFile file;
        try {
            file = new RandomAccessFile(path, "rw");
            byte[] arr = new byte[(int)file.length()];
            file.read(arr);
            file.close();
            this.flights = new HashMap<String, List<Flight>>();
            String all = new String(arr);
            String[] lines = all.split("\n");
            for (String line : lines) {
                String[] info = line.split("\\s{2,}");

                if (!info[0].equals("Hora")) {
                    Time dep = new Time(Integer.parseInt(info[0].split(":")[0]), Integer.parseInt(info[0].split(":")[1]));
                    Flight f = new Flight(info[1], info[3], dep);
                    if (info.length == 6) {
                        Time del = new Time(Integer.parseInt(info[4].split(":")[0]), Integer.parseInt(info[4].split(":")[1]));
                        f.setDelay(del);
                        if (this.flights.get(info[3]) == null) {
                            List<Flight> lf = new ArrayList<Flight>();
                            lf.add(f);
                            this.flights.put(info[3], lf);
                        } else
                            this.flights.get(info[3]).add(f);

                    } else if (info.length == 4) {
                        if (this.flights.get(info[3]) == null) {
                            List<Flight> lf = new ArrayList<Flight>();
                            lf.add(f);
                            this.flights.put(info[3], lf);
                        } else
                            this.flights.get(info[3]).add(f);
                    } else
                        throw new AssertionError("Ficheiro inválido");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s\n", e);
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void saveToFile() {
        Path p = Paths.get("gp7_files/Infopublico.txt");

        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            bw.write(this.toString());
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void saveToBinaryFile() {
        RandomAccessFile file;
        try {
            file = new RandomAccessFile("gp7_files/Infopublico.bin", "rw");
            file.write(this.toString().getBytes());
            file.close();
        } catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s\n", e);
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void saveOriginsToFile() {
        Path p = Paths.get("gp7_files/cidades.txt");

        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            bw.write(this.originsToString());
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public boolean equals(Object a) {
        if (a == null)
            return false;
        if (a.getClass() != this.getClass())
            return false;
        return ((Airport)a).flights().equals(this.flights);
    }

    public String toString() {
        String to_return = String.format("%-6s\t%-10s\t%-22s\t%-25s\t%-8s\t%-15s",
                "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
        for (String origin : this.flights.keySet()) {
            for (Flight f : this.flights.get(origin))
                to_return += "\n" + f.toString();
        }

        return to_return;
    }

    private String originsToString() {
        String to_return = String.format("%-8s\t%-20s", "Origem", "Voos");
        TreeMap<Integer, List<String>> sorted = new TreeMap<Integer, List<String>>();

        for (String city : this.flights.keySet()) {
            List<String> list = sorted.get(this.flights.get(city).size());
            if (list == null) {
                List<String> l = new ArrayList<String>();
                l.add(city);
                sorted.put(this.flights.get(city).size(), l);
            } else
                list.add(city);
        }

        for (int num : sorted.descendingKeySet()) {
            for (String city : sorted.get(num))
                to_return += String.format("\n%-8s\t%-20s", num, city);
        }

        return to_return;
    }

}
