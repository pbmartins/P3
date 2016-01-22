package aula06;

public class Ex1 {
    public static void main(String[] args) {
        Menu ementa = new Menu("Especial Caloiro", "Snack da UA");
        Plate[] pratos = new Plate[10];
        for (int i=0; i < pratos.length; i++){
            pratos[i] = randPrato(i);
            int cnt=0;

            while (cnt <2){
                // Adicionar 2 Ingredientes a cada Prato Alimento aux = randAlimento();
                Food aux = randAlimento();
                if (pratos[i].addIngredient(aux))
                    cnt++;
                else
                    System.out.println("ERRO: Não é possivel adicionar '" + aux + "' ao -> " + pratos[i]);
            }
            ementa.addPlate(pratos[i], WeekDay.rand());

        }
        System.out.println("\n" + ementa);
    }

    public static Food randAlimento() {
        switch ((int) (Math.random() * 4)) {
            default:
            case 0:
                return new Meat(MeatVariety.CHICKEN, 22.3, 345.3, 300);
            case 1:
                return new Fish(FishType.FROZEN, 31.3, 25.3, 200);
            case 2:
                return new Vegetable("Couve Flor", 21.3, 22.4, 150);
            case 3:
                return new Cereal("Milho", 19.3, 32.4, 110);
        }
    }

    public static Plate randPrato(int i) {
        switch ((int) (Math.random() * 3)) { default:
            case 0:
                return new Plate("Prato N." + i);
            case 1:
                return new VegetarianPlate("Prato N." + i + " (Vegetariano)");
            case 2:
                return new DietPlate("Prato N." + i + " (Dieta)", 90.8);
        }
    }
}
