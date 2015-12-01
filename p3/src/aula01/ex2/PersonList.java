package aula01.ex2;

import java.util.ArrayList;

public class PersonList {
	ArrayList<Person> lista;
	
	public PersonList() {
		lista = new ArrayList<Person>();
	}
	
	private boolean existsCC(int cc) {
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).getCC() == cc)
				return true;
		
		return false;
	}
	
	public void add(Person p) {
		assert !existsCC(p.getCC());
		lista.add(p);
	}
	
	public Person searchPerson(int cc) {
		assert !lista.isEmpty();
		Person p = null;
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCC() == cc) {
				p = lista.get(i);
				break;
			}
		}
		
		return p;
	}
	
	public boolean remove(Person p) {
		assert !lista.isEmpty();
		assert p != null;
		
		return lista.remove(p);
	}
	
	public String toString() {
		assert !lista.isEmpty();
		String to_return = "";
		
		for (int i = 0; i < lista.size(); i++)
			to_return += lista.get(i).toString() + "\n";
		
		return to_return;
	}
	
	public void sortByName() {
    	assert !lista.isEmpty();
    	
    	ArrayList<Person> nova_lista = new ArrayList<Person>();
		String[] names = new String[lista.size()];
		
		for (int i = 0; i < names.length; i++)
			names[i] = lista.get(i).getName();
		
		Sort.sortArray(names);
		
		for (int j = 0; j < names.length; j++) {
			Person p = null;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getName().equals(names[j])) {
					p = lista.get(i);
					lista.remove(i);
					break;
				}
			}
			nova_lista.add(p);
		}
		
		this.lista = nova_lista;
    }
	
    public void sortByCC() {
    	assert !lista.isEmpty();
    	
    	ArrayList<Person> nova_lista = new ArrayList<Person>();
		int[] ccs = new int[lista.size()];
		
		for (int i = 0; i < ccs.length; i++)
			ccs[i] = lista.get(i).getCC();
		
		Sort.sortArray(ccs);
		
		for (int j = 0; j < ccs.length; j++) {
			Person p = null;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getCC() == ccs[j]) {
					p = lista.get(i);
					lista.remove(i);
					break;
				}
			}
			nova_lista.add(p);
		}
		
		this.lista = nova_lista;
    }
    
}
