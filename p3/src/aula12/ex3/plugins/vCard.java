package aula12.ex3.plugins;

import aula01.ex2.Date;
import aula12.ex3.Contact;
import aula12.ex3.Formats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vCard implements Formats {

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

        if (sf.hasNextLine() && !sf.nextLine().equals("vCard"))
            throw new IllegalArgumentException("Ficheiro inválido.");

        while(sf.hasNextLine()) {
            String line = sf.nextLine();
            if (line.length() != 0) {
                String[] info = line.split("#");
                int number = Integer.parseInt(info[2]);
                String[] date = info[3].split("/");
                list.add(new Contact(info[1], number, new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]))));
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

        pw.println("vCard");
        for (Contact c : list)
            pw.println("#" + c.getName() + "#" + c.getNumber() + "#" + c.getBornDate());

        pw.close();
    }
}
