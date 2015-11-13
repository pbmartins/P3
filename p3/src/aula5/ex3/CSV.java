package aula5.ex3;
import java.util.*;
import java.io.*;
import aula1.ex2.Date;

public class CSV implements Formats {

    public Contact[] readFile(String path) {
        File f = new File(path);
        Scanner sf;
        boolean valid = false;
        List<Contact> list = new ArrayList<Contact>();

        try {
            sf = new Scanner(f);
        } catch(FileNotFoundException e) {
            throw new AssertionError("O ficheiro não foi encontrado.");
        }

        if (sf.hasNextLine() && !sf.nextLine().equals("CSV"))
            throw new IllegalArgumentException("Ficheiro inválido.");

        while(sf.hasNextLine()) {
            String line = sf.nextLine();
            if (line.length() != 0) {
                String[] info = line.split("\t");
                int number = Integer.parseInt(info[1]);
                String[] date = info[2].split("/");
                list.add(new Contact(info[0], number, new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]))));
            }
        }
        sf.close();

        return list.toArray(new Contact[list.size()]);
    }

    public void saveFile(String path, Contact[] list) {
        File f = new File(path);
        PrintWriter pw;
        try {
            pw = new PrintWriter(f);
        } catch(FileNotFoundException e) {
            throw new AssertionError("Ficheiro não válido.");
        }

        pw.println("CSV");
        for (Contact c : list)
            pw.println("\t" + c.getName() + "\t" + c.getNumber() + "\t" + c.getBornDate());

        pw.close();
    }
}
