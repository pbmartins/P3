package aula9.ex2;

public class Cone extends IceCreamDecorator {

    public Cone(IceCream iceCream) {
        super(iceCream);
    }

    public void base(int creamBalls) {
        super.base(creamBalls);
        System.out.print(" em cone");
    }
}
