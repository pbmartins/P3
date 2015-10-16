package aula5;

import java.util.*;

public class ContactList {
	ArrayList<Contact> lista;

	public ContactList() {
		lista = new ArrayList<Contact>();
	}
	
	private boolean existsNumber(int number) {
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).getNumber() == number)
				return true;
		
		return false;
	}
	
	public void add(Contact p) {
		assert !existsNumber(p.getNumber());
		lista.add(p);
	}
	
	public Contact searchPerson(int number) {
		assert !lista.isEmpty();
		Contact p = null;
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNumber() == number) {
				p = lista.get(i);
				break;
			}
		}
		
		return p;
	}
	
	public boolean remove(Contact p) {
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
		UtilCompare.sortArray(this.lista.toArray(new Contact[this.lista.size()]));
    }

	public Contact[] toArray() {
		return this.lista.toArray(new Contact[this.lista.size()]);
	}
    
}
