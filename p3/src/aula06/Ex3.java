package aula06;
import java.io.IOException;
import java.util.*;

public class Ex3 {
    private static Scanner sc = new Scanner(System.in);
    private static Carte menu = new Carte("Snack da UA", "UA");

    public static void main(String[] args) throws IOException {
        String path = "";

        for (;;) {
            switch(showMenu()) {
                case 0:
                    System.out.println("O programa vai encerrar");
                    System.exit(0);
                    break;
                case 1:
                    addMeat();
                    break;
                case 2:
                    addFish();
                    break;
                case 3:
                    addVegetarian(0);
                    break;
                case 4:
                    addVegetarian(1);
                    break;
                case 5:
                    newDish();
                    break;
                case 6:
                    removeDish();
                    break;
                case 7:
                    selectDish();
                    break;
                case 8:
                    addDishToMenu();
                    break;
                case 9:
                    removeDishFromMenu();
                    break;
                case 10:
                    System.out.println(menu);
                    break;
                case 11:
                    System.out.print("Caminho para o ficheiro: ");
                    sc.skip("\n");
                    path = sc.nextLine();
                    menu.saveOnFile(path);
                    break;
                case 12:
                    System.out.print("Caminho para o ficheiro: ");
                    sc.skip("\n");
                    path = sc.nextLine();
                    menu.readFromFile(path);
                    break;
            }
        }
    }

    private static int showMenu() {
        int op = -1;

        System.out.println("--Menu--");
        System.out.println("0. Sair");
        System.out.println("..Ingrediente..");
        System.out.println("1. Adicionar Carne");
        System.out.println("2. Adicionar Peixe");
        System.out.println("3. Adicionar Cereal");
        System.out.println("4. Adicionar Legume");
        System.out.println("..Prato..");
        System.out.println("5. Cria prato");
        System.out.println("6. Apaga prato");
        System.out.println("7. Seleciona prato");
        System.out.println("..Ementa..");
        System.out.println("8. Adiciona prato");
        System.out.println("9. Remove prato");
        System.out.println("10. Imprime ementa");
        System.out.println("..Ficheiro..");
        System.out.println("11. Guardar ementa num ficheiro");
        System.out.println("12. Carregar ementa de um ficheiro");

        while (op < 0 || op > 12) {
            System.out.print("Opção -> ");
            op = sc.nextInt();
        }
        return op;
    }

    private static void addMeat() {
        double proteins = 0, calories = 0, weight = 0;
        String type = "";
        MeatVariety mv = null;
        System.out.print("Tipo (COW, PIG, TURKEY, CHICKEN, WEAL, RABBIT): ");
        sc.skip("\n");
        type = sc.nextLine();
        try {
            mv = MeatVariety.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.err.println("Tipo inválido");
            System.exit(1);
        }
        System.out.print("Proteinas: ");
        proteins = sc.nextDouble();
        System.out.print("Calorias: ");
        calories = sc.nextDouble();
        System.out.print("Peso: ");
        weight = sc.nextDouble();
        menu.addMeat(mv, proteins, calories, weight);
    }

    private static void addFish() {
        double proteins = 0, calories = 0, weight = 0;
        String type = "";
        FishType ft = null;
        System.out.print("Tipo (FROZEN, FRESH): ");
        sc.skip("\n");
        type = sc.nextLine();
        try {
            ft = FishType.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.err.println("Tipo inválido");
            System.exit(1);
        }
        System.out.print("Proteinas: ");
        proteins = sc.nextDouble();
        System.out.print("Calorias: ");
        calories = sc.nextDouble();
        System.out.print("Peso: ");
        weight = sc.nextDouble();
        menu.addFish(ft, proteins, calories, weight);
    }

    private static void addVegetarian(int type) {
        double proteins = 0, calories = 0, weight = 0;
        String name = "";
        System.out.print("Nome: ");
        sc.skip("\n");
        name = sc.nextLine();
        System.out.print("Proteinas: ");
        proteins = sc.nextDouble();
        System.out.print("Calorias: ");
        calories = sc.nextDouble();
        System.out.print("Peso: ");
        weight = sc.nextDouble();
        if (type == 0)
            menu.addCereal(name, proteins, calories, weight);
        else if (type == 1)
            menu.addVegetable(name, proteins, calories, weight);
        else
            throw new IllegalArgumentException("Wrong parameter");
    }

    private static void newDish() {
        String name = "";
        System.out.print("Nome: ");
        sc.skip("\n");
        name = sc.nextLine();
        menu.newPlate(name);
    }

    private static void removeDish() {
        String name = "";
        System.out.print("Nome: ");
        sc.skip("\n");
        name = sc.nextLine();
        menu.removePlate(name);
    }

    private static void selectDish() {
        String name = "";
        int op = 0, id = 0;

        System.out.println();
        System.out.println(menu.platesToString());
        System.out.println();

        System.out.print("Nome: ");
        sc.skip("\n");
        name = sc.nextLine();

        Plate dish = menu.selectPlate(name);

        System.out.println("\t1. Adiciona ingrediente");
        System.out.println("\t2. Remove ingrediente");

        while (op < 1 || op > 2) {
            System.out.print("\tOpção -> ");
            op = sc.nextInt();
        }

        System.out.println();
        System.out.println(menu.ingredientsToString());
        System.out.println();

        System.out.print("ID -> ");
        id = sc.nextInt();
        Food ingredient = menu.getIngredient(id);

        if (op == 1)
            menu.addIngredientToPlate(dish.name(), ingredient);
        else if (op == 2)
            menu.removeIngredientFromPlate(dish.name(), ingredient);
    }

    private static void addDishToMenu() {
        String name = "", day = "";
        WeekDay weekDay = null;
        System.out.println();
        System.out.println(menu.platesToString());
        System.out.println();

        System.out.print("Nome do prato -> ");
        sc.skip("\n");
        name = sc.nextLine();
        Plate dish = menu.selectPlate(name);

        System.out.print("Dia da semana -> ");
        day = sc.nextLine();

        try {
            weekDay = WeekDay.valueOf(day);
        } catch (IllegalArgumentException e) {
            System.err.println("Tipo inválido");
            System.exit(1);
        }

        menu.addPlateToMenu(dish, weekDay);
    }

    private static void removeDishFromMenu() {
        String name = "", day = "";
        WeekDay weekDay = null;
        System.out.print("Nome do prato -> ");
        sc.skip("\n");
        name = sc.nextLine();
        Plate dish = menu.selectPlate(name);

        System.out.print("Dia da semana -> ");
        day = sc.nextLine();

        try {
            weekDay = WeekDay.valueOf(day);
        } catch (IllegalArgumentException e) {
            System.err.println("Tipo inválido");
            System.exit(1);
        }

        if (menu.removePlateFromMenu(dish, weekDay))
            System.out.println("Removido com sucesso");
        else
            System.err.println("Ocorreu um erro.");
    }
}
