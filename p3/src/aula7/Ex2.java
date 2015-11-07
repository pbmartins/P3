package aula7;

public class Ex2 {
    public static void main(String[] args) {
        Bitmap bm = new Bitmap("gp7_files/Figura.bmp");
        System.out.println(bm);
        bm.save("gp7_files/Figurav2.bmp");
        bm.saveToRAW("gp7_files/Figura.raw");
        bm.saveToAFourth("gp7_files/Figura4.bmp");
        bm.saveFlipped("gp7_files/FiguraHorizontal.bmp", 0);
        bm.saveFlipped("gp7_files/FiguraVertical.bmp", 1);
    }
}
