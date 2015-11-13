package aula9.ex2;

public class Topping extends IceCreamDecorator {
    private String toppingFlavor;

    public Topping(IceCream iceCream, String toppingFlavor) {
        super(iceCream);
        this.toppingFlavor = toppingFlavor;
    }

    public void base(int creamBalls) {
        super.base(creamBalls);
        System.out.print(" com " + this.toppingFlavor);
    }
}
