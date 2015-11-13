package aula7.ex1;

public class Ex1 {
    public static void main(String[] args) {
        CompaniesList.loadFromFile("gp7_files/companhias.txt");
        Airport ap = new Airport();
        ap.readFromFile("gp7_files/voos.txt");
        System.out.println(ap);
        ap.saveToFile();
        System.out.println(CompaniesList.getCompaniesByDelay());
        ap.saveOriginsToFile();
        ap.saveToBinaryFile();
        ap.readFromBinaryFile("gp7_files/Infopublico.bin");
        System.out.println(ap);
    }
}
