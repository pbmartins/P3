package aula9.ex1;

import java.io.*;

public class Ex1 {
    public static void main(String args[]) {
        ScannerAbeirense sc = new ScannerAbeirense(new File("gp5_files/file1.txt"));

        while(sc.hasNextLine()) {
            System.out.println("In Abeirense: " + sc.nextLine());
        }

        sc.close();

        sc = new ScannerAbeirense(System.in);

        while(sc.hasNextLine()) {
            System.out.println("In Abeirense: " + sc.nextLine());
        }
        sc.close();
    }
}
