package aula13.ex3;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        // Alinea A
        Employee emp1 = new Employee("Pedro Martins");
        Employee emp2 = new Employee("David Cabral");
        Employee emp3 = new Employee("João Santos");
        Employee emp4 = new Employee("João Rodrigues");

        List<Employee> funcs = new ArrayList<>();
        funcs.add(emp1);
        funcs.add(emp2);
        funcs.add(emp3);
        funcs.add(emp4);

        funcs.stream().forEach(System.out::println);

        // Alinea B
        Map<Employee, List<String>> funcToys = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            if (funcToys.containsKey(emp1))
                funcToys.get(emp1).add("Brinquedo " + i);
            else {
                List<String> list = new LinkedList<>();
                list.add("Brinquedo " + i);
                funcToys.put(emp1, list);
            }
        }

        System.out.println(funcToys.get(emp1));

        // Alinea C & D
        Map<String, Integer> funcNames = new HashMap<>();
        for (Employee emp : funcs) {
            if (funcNames.containsKey(emp.getFirstName()))
                funcNames.put(emp.getFirstName(), funcNames.get(emp.getFirstName()) + 1);
            else
                funcNames.put(emp.getFirstName(), 1);
        }

        funcNames.keySet().stream().map(key -> key + ": " + funcNames.get(key)).forEach(System.out::println);

        // Alinea E
        int numTickets = 2;
        int n = 0;
        Deque<Employee> withTickets = new LinkedList<>();
        Deque<Employee> withoutTickets = new LinkedList<>();

        for (Employee emp : funcs) {
            if (n++ < numTickets)
                withTickets.add(emp);
            else
                withoutTickets.add(emp);
        }

        withTickets.stream().map(Employee::getName).forEach(System.out::println);

        // Other week
        rotateTickets(withTickets, withoutTickets);
        // Other week
        rotateTickets(withTickets, withoutTickets);
        // Other week
        rotateTickets(withTickets, withoutTickets);
        // Other week
        rotateTickets(withTickets, withoutTickets);
    }

    public static void rotateTickets(Deque<Employee> withTickets, Deque<Employee> withoutTickets) {
        System.out.println("----------");
        Employee e1 = withTickets.removeLast();
        Employee e2 = withoutTickets.removeFirst();
        withTickets.addFirst(e2);
        withoutTickets.addLast(e1);
        withTickets.stream().map(Employee::getName).forEach(System.out::println);
    }
}
