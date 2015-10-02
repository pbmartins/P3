package aula4;
import aula3.Student;
import aula3.ScholarshipHolder;
import java.util.*;

public class Lesson {
	private String name, field;
	private int ects;
	private Professor conductor;
	private TreeMap<Integer, Student> students;
	
	public Lesson (String name, String area, int ects, Professor conductor) {
		if (name.length() <= 0 || area.length() <= 0)
			throw new IllegalArgumentException("O nome e/ou a área não podem estar vazios.");
		if (ects <= 0)
			throw new IllegalArgumentException("O número de ECTS tem de ser superior a 0.");
		if (conductor == null)
			throw new IllegalArgumentException("Regente da cadeira inválido.");
		
		this.name = name;
		this.field = area;
		this.ects = ects;
		this.conductor = conductor;
		students = new TreeMap<Integer, Student>();
	}
	
	public boolean addStudent(Student s) {
		if (s == null)
			throw new IllegalArgumentException("Estudante inválido.");
		if (students.containsKey(s.getNMec()))
			return false;
		students.put(s.getNMec(), s);
		assert !students.isEmpty();
		return true;
	}
	
	public boolean delStudent(int nMec) {
		if (studentRegistred(nMec)) {
			students.remove(nMec);
			return true;
		}
		return false;
	}
	
	public boolean studentRegistred(int nMec) {
		if (nMec < 100)
			throw new IllegalArgumentException("O número mecanográfico tem de ser superior ou igual a 100");
		return students.containsKey(nMec);
	}
	
	public int numStudents() {
		return students.size();
	}
	
	public String toString() {
		return "Nome: " + this.name + "\nÁrea científica: " + this.field + "\nECTS: " + this.ects + "\nResponsável: " + this.conductor;
	}
	
	public Student[] getStudents() {
		Student[] to_return = new Student[students.size()];
		int i = 0;
		
		for (Map.Entry<Integer, Student> entry : students.entrySet())
			to_return[i++] = entry.getValue();
			
		return to_return;
	}
	
	public Student[] getStudents(String type) {
		ArrayList<Student> to_return = new ArrayList<Student>();
		
		for (Map.Entry<Integer, Student> entry : students.entrySet()) {
			if ( (entry.getValue() instanceof ScholarshipHolder && type.equals("ScholarshipHolder")) 
				|| (entry.getValue() instanceof Student && type.equals("Student")) ) {
				to_return.add(entry.getValue());
			}
				
		}
		
		return to_return.toArray(new Student[to_return.size()]);
	}
	
}
