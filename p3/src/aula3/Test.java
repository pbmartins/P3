package aula3;
import aula1.Data;

public class Test {

	public static void main(String[] args) {
		Student est = new Student ("Andreia", 9855678, new Data(18, 7, 1974));
		ScholarshipHolder bls = new ScholarshipHolder ("Maria", 8976543, new Data(11, 5, 1976));
		bls.setValue(745);

		System.out.println("Estudante:" + est.getNome()); System.out.println(est);
		System.out.println("Bolseiro:" + bls.getNome() + ", NMec: " + bls.getNMec() +",Bolsa:"+ bls.getValue());
		System.out.println(bls);
	}

}
