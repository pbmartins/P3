package exercices;
import java.util.Iterator;
import java.util.Set;


public class Main {
	public static void main(String[] args){
		Chair cd1 = new Chair("Elite-2", 2034, Material.SINTHETIC, Chair.ChairType.OFFICE, 2, 3.1);
		
		WheelChair cd2 = new WheelChair("Mobileplus", 3211, Material.METAL, Chair.ChairType.OFFICE, 4, 0.4, 4, false);
		
		cd2.setType(TransportType.REDUCED);
		
		Bed c1 = new Bed("Fofinha", 4323, Material.WOOD, 1.90, 1.10, true);
		ArticulatedBed  ca1 = new ArticulatedBed("MaxFlex2000", 4124, Material.METAL, 1.90, 1.20, true, true);
		
		Marquise m1 = new Marquise("Tx20", 1234, Material.METAL, 1.80, 0.9, true, false);
		Hammock ma1 = new Hammock("SpeedX2", 9232, Material.METAL, 2.00, 0.8, false, 2);
		ma1.setType(TransportType.URGENT);
		
		Clinic cl = new Clinic("Boa Saude");
		
		System.out.println("\n------ INSERCAO MOBILIARIO ------");
		System.out.println(cl.addFurniture(cd1) + ", ");
		System.out.println(cl.addFurniture(cd1) + ", ");
		System.out.println(cl.addFurniture(cd2) + ", ");
		System.out.println(cl.addFurniture(c1) + ", ");
		System.out.println(cl.addFurniture(ca1) + ", ");
		System.out.println(cl.addFurniture(m1) + ", ");
		System.out.println(cl.addFurniture(ma1) + ", ");
		
		
		System.out.println("\n----------- LISTAGEM DE TODO O MOBILIARIO ---------");
		
		Set<Furniture>  mob = cl.getList();
		Iterator itr = mob.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		cl.removeFurniture(cd1);
		
		System.out.println("\n----------- LISTA DAS DUAS PRIMEIRAS PEÇAS DE MOBILIARIO ---------");
		
		Set<Furniture>  mobc = cl.getList();
		Iterator itr2 = mobc.iterator();
		int counter = 0;
		while(itr2.hasNext() && counter<2){
			System.out.println(itr2.next());
			counter++;
		}
		
		System.out.println("\n----------- LISTAGEM DE MOBILIARIO DE TRANSPORTE ---------");

		
	}
}
