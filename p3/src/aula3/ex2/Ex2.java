package aula3.ex2;

public class Ex2 {

	public static void main(String[] args) {
		Circle c1 = new Circle (2);
		Circle c2 = new Circle (1,3,2);
		Circle c3 = new Circle (c1);
		
		System.out.println(c1 + "tem area: " + c1.area() + " e perimetro: " + c1. perimeter());
		System.out.println(c3 + "tem area: " + c3.area() + " e perimetro: " + c3. perimeter());
		System.out.println("c1 equals to c3? -> " + c1.equals(c3)); // True
		
		Square q1 = new Square(2);
		Square q2 = new Square(3,4,2);
		Square q3 = new Square(q2);
		
		System.out.println(q1 + "tem area: " + q1.area() + " e perimetro: " + q1.perimeter());
		System.out.println(q3 + "tem area: " + q3.area() + " e perimetro: " + q3.perimeter());
		System.out.println("q1 equals to q3? -> " + q1.equals(q3)); // False
		
		Rectangle r1 = new Rectangle(2,3);
		Rectangle r2 = new Rectangle(3,4,2,3);
		System.out.println(r2);
		Rectangle r3 = new Rectangle(r2);
		
		System.out.println(r1 + "tem area: " + r1.area() + " e perimetro: " + r1. perimeter());
		System.out.println(r3 + "tem area: " + r3.area() + " e perimetro: " + r3. perimeter());
		System.out.println("r2 equals to r3? -> " + r2.equals(r3)); // True

	}

}
