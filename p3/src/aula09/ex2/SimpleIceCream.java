package aula09.ex2;

public class SimpleIceCream implements IceCream {
    String flavor;
    int creamBalls;

    public SimpleIceCream(String flavor) {
        if (flavor == null || flavor.length() == 0)
            throw new IllegalArgumentException("Sabor inválido.");
        this.flavor = flavor;
    }

    public void base(int creamBalls) {
        if (creamBalls <= 0)
            throw new IllegalArgumentException("Número de bolas de gelado inválidas");
        this.creamBalls = creamBalls;
        System.out.print("\n" + this.creamBalls + " bolas de gelado de " + this.flavor);
    }

}
