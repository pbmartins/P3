package aula13.ex2;

public class Ex2 {
    public static void main(String[] args) {
        CountPairs cp = new CountPairs("gp13_files/Policarpo.txt");
        System.out.println(cp);
        CountPairs cp2 = new CountPairs("gp13_files/phrase.txt");
        System.out.println(cp2);
    }
}
