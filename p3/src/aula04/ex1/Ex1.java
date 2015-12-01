package aula04.ex1;
import aula03.ex1.Student;
import aula03.ex1.ScholarshipHolder;
import aula01.ex2.Date;

public class Ex1 {

	public static void main(String[] args) {
		Student est1 = new Student("Andreia", 9855678, new Date(18, 7, 1974));
		Student est2 = new Student("Monica", 75266454, new Date(11, 8, 1978)); 
		Student est3 = new Student("Jose", 85265426, new Date(15, 2, 1976)); 
		Student est4 = new Student("Manuel", 85153442, new Date(1, 3, 1973));
		
		ScholarshipHolder bls1 = new ScholarshipHolder("Maria", 8976543, new Date(12, 5, 1976)); 
		ScholarshipHolder bls2 = new ScholarshipHolder("Xico", 872356522, new Date(21, 4, 1975));
		ScholarshipHolder bls3 = new ScholarshipHolder("Duarte", 32423512, new Date(6, 1, 1976)); 
		bls1.setValue(745);
		bls2.setValue(845);
		bls3.setValue(745);
		
		Professor pf1 = new Professor("Jose Manuel", 11223344, new Date(11, 9, 1969));
		
		Lesson dis = new Lesson("P5", "Informatica", 6, pf1);
		dis.addStudent(est1);
		dis.addStudent(est2);
		dis.addStudent(bls1);

		if (dis.studentRegistred(est3.getNMec()))
			System.out.println("\n" + est3 + " \n\t-> ESTÁ inscrito na Disciplina");
		else
			System.out.println("\n" + est3 + " \n\t-> NÃO ESTÁ inscrito na Disciplina"); 
		
		System.out.println("\nNo de Alunos Inscritos: " + dis.numStudents());
		
		dis.addStudent(est3); 
		dis.addStudent(bls2);
		dis.addStudent(est4); 
		dis.addStudent(bls3);
		if (!dis.addStudent(bls3))
			System.out.println(bls3.getNMec() + ", " + bls3.getName() + " já está inscrito nesta disciplina!");
		if (dis.delStudent(bls2.getNMec())) 
			System.out.println(bls2.getName() + " Removido!");
		
		System.out.println("\nNo de Alunos Inscritos: " + dis.numStudents()); 
		
		System.out.println(dis + "\n");
		
		System.out.println("\n Listagem de Estudantes:"); 
		for (Student e : dis.getStudents())
			System.out.println(e);
		
		System.out.println("\n Listagem de Bolseiros:"); 
		for (Student e : dis.getStudents("ScholarshipHolder"))
			System.out.println(e);
	}

}
