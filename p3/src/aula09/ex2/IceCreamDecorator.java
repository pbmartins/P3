package aula09.ex2;

public class IceCreamDecorator implements IceCream {
    private IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        if (iceCream == null)
            throw new IllegalArgumentException("Gelado inválido.");
        this.iceCream = iceCream;
    }

    public void base(int creamBalls) {
        this.iceCream.base(creamBalls);
    }
}
