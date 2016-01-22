package aula05.ex2;

import aula05.UtilCompare;

public class Ex2 {
    public static void main(String[] args) {
        Vehicle lista[] = {
                new Automobile(1994, "34-AB-76", "Branco", 1384, 90, 8, Fuel.DIESEL, 180, 5, 2000),
                new Bicycle(2011, "34-CD-76", "Preto", 1, 10),
                new PoliceBicycle(2011, "34-CD-76", "Preto", 1, 10, CarType.PJ, 3),
                new PoliceAutomobile(1994, "34-AB-76", "Branco", 2200, 90, 8, Fuel.DIESEL, 170, 5, 2000, CarType.GNR, 1),
                new Motorcycle(1980, "34-AB-76", "Branco", 500, 90, 8, Fuel.MIX, 180, 2, 500),
                new PoliceMotorcycle(1994, "34-AB-76", "Branco", 500, 90, 8, Fuel.GASOLINE95, 170, 2, 500, CarType.PSP, 2),
        };

        System.out.println("-----\n"+ UtilCompare.findMax(lista));

        UtilCompare.sortArray(lista);

        for(Comparable row : lista){
            System.out.println("-----\n"+row);
        }
    }
}
