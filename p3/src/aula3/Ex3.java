package aula3;
import java.util.*;
import aula1.Date;
import aula1.Person;

public class Ex3 {

	public static void main(String[] args) {
		PassengerLightVehicle carro = new PassengerLightVehicle(100, 100, 5, 2000);
		TreeSet<Category> cat = new TreeSet<Category>();
		cat.add(Category.A);
		cat.add(Category.B);
		Driver c = new Driver("Pedro", 14948437, new Date(6, 7, 1996), cat, 1234);
		Driver c2 = new Driver("João", 14948232, new Date(6, 7, 1996), cat, 4568);
		Person p = new Person("Ana", 12344945, new Date(16, 1, 1999));
		System.out.println(c);
		carro.setDriver(c);
		carro.addPassenger(p);
		carro.addPassenger(c2);
		System.out.println(carro);
	}

}
