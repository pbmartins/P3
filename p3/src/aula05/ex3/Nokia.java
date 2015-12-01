package aula05.ex3;
import java.util.*;
import java.io.*;
import aula01.ex2.Date;

public class Nokia implements Formats {

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

        if (sf.hasNextLine() && !sf.nextLine().equals("Nokia"))
            throw new IllegalArgumentException("Ficheiro inválido.");

        while(sf.hasNextLine()) {
            String line = sf.nextLine();
            if (line.length() != 0) {
                // name = line
                int number = Integer.parseInt(sf.nextLine());
                String[] date = sf.nextLine().split("/");
                list.add(new Contact(line, number, new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]))));
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

        pw.println("Nokia");
        for (Contact c : list) {
            pw.println(c.getName());
            pw.println(c.getNumber());
            pw.println(c.getBornDate());
            pw.println();
        }

        pw.close();
    }
}
