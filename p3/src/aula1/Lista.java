package aula1;

import java.util.ArrayList;

public class Lista {
	ArrayList<Pessoa> lista;
	
	public Lista() {
		lista = new ArrayList<Pessoa>();
	}
	
	private boolean existsCC(int cc) {
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).getCC() == cc)
				return true;
		
		return false;
	}
	
	public void add(Pessoa p) {
		assert !existsCC(p.getCC());
		lista.add(p);
	}
	
	public Pessoa searchPerson(int cc) {
		assert !lista.isEmpty();
		Pessoa p = null;
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCC() == cc) {
				p = lista.get(i);
				break;
			}
		}
		
		return p;
	}
	
	public boolean remove(Pessoa p) {
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
    	
    	ArrayList<Pessoa> nova_lista = new ArrayList<Pessoa>();
		String[] names = new String[lista.size()];
		
		for (int i = 0; i < names.length; i++)
			names[i] = lista.get(i).getNome();
		
		Sort.sortArray(names);
		
		for (int j = 0; j < names.length; j++) {
			Pessoa p = null;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNome().equals(names[j])) {
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
    	
    	ArrayList<Pessoa> nova_lista = new ArrayList<Pessoa>();
		int[] ccs = new int[lista.size()];
		
		for (int i = 0; i < ccs.length; i++)
			ccs[i] = lista.get(i).getCC();
		
		Sort.sortArray(ccs);
		
		for (int j = 0; j < ccs.length; j++) {
			Pessoa p = null;
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
