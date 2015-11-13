package aula9.ex2;

public class Cup extends IceCreamDecorator {

    public Cup(IceCream iceCream) {
        super(iceCream);
    }

    public void base(int creamBalls) {
        super.base(creamBalls);
        System.out.print(" em copo");
    }
}
