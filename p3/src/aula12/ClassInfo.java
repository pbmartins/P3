package aula12;

import java.lang.reflect.*;
import java.util.*;

public class ClassInfo {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Class<?> cl = null;

        System.out.print("Class name: ");
        String className = sc.nextLine();
        if (className.length() == 0)
            System.exit(0);

        try {
            cl = Class.forName(className);
        } catch(Exception e) {
            throw new IllegalArgumentException("Class not found!");
        }

        System.out.println("****** " + cl.getSimpleName() + " implements:");
        for (Class<?> i : cl.getInterfaces())
            System.out.println("\t" + i.getClass().getName());

        System.out.println("****** " + cl.getSimpleName() + " extends:");
        for (Class<?> s : getAllSuperClasses(cl))
            System.out.println("\t" + s.getName());

        System.out.println("****** " + cl.getSimpleName() + " fields:");
        for (Field f : cl.getDeclaredFields())
            System.out.println("\t" + f);

        System.out.println("****** " + cl.getSimpleName() + " constructors:");
        printConstructors(cl);

        System.out.println("****** " + cl.getSimpleName() + " methods:");
        for (Method m : cl.getDeclaredMethods())
            System.out.println("\t" + m);

        System.out.println();
        int op;
        List<Object> objects = new LinkedList<>();

        while (true) {
            System.out.println("1 - Criar objeto");
            System.out.println("2 - Invocar método");
            System.out.println("3 - Sair");
            System.out.print("Opção -> ");
            op = sc.nextInt();

            if (op < 1 || op > 3)
                continue;

            if (op == 1) {
                Constructor<?>[] cons = cl.getConstructors();
                int c = -1;

                while (c < 0 || c > cons.length) {
                    System.out.print("\tConstrutor (index) -> ");
                    c = sc.nextInt();
                }
                Constructor<?> selectedConstructor = cons[c];
                Type[] types = selectedConstructor.getGenericParameterTypes();
                Object[] arguments = new Object[types.length];

                sc.skip("\n");
                for (int i = 0; i < types.length; i++) {
                    System.out.print(types[i].getTypeName() + " -> ");
                       // arguments[i] = Class.forName(primitiveToWrapper(types[i].getTypeName())).cast(sc.nextLine());
                    arguments[i] = primitiveToWrapper(types[i].getTypeName(), sc.nextLine());
                }

                Object obj = null;
                try {
                    obj = selectedConstructor.newInstance(arguments);
                    objects.add(obj);
                } catch(Exception e) {
                    throw new AssertionError("Cannot instanciate the object!");
                }

            } else if (op == 2) {
                Method[] methods = cl.getDeclaredMethods();
                int c = -1;

                while (c < 0 || c > methods.length) {
                    System.out.print("\tMethod (index) -> ");
                    c = sc.nextInt();
                }

                Method selectedMethod = methods[c];
                if (Modifier.isPrivate(selectedMethod.getModifiers()))
                    System.out.println("Private method cannot be runned!");
                else {
                    Type[] types = selectedMethod.getGenericParameterTypes();
                    Object[] arguments = new Object[types.length];

                    sc.skip("\n");
                    for (int i = 0; i < types.length; i++) {
                        System.out.print(types[i].getTypeName() + " -> ");
                        arguments[i] = primitiveToWrapper(types[i].getTypeName(), sc.nextLine());
                    }

                    for (Object obj : objects) {
                        try {
                            System.out.println(selectedMethod.invoke(obj, arguments));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (op == 3)
                System.exit(0);
        }

    }

    private static Class<?>[] getAllSuperClasses(Class<?> cl) {
        List<Class<?>> arrayOfClasses = new LinkedList<>();
        while (true) {
            cl = cl.getSuperclass();
            if (cl == null)
                break;
            arrayOfClasses.add(cl);
        }
        return arrayOfClasses.toArray(new Class<?>[arrayOfClasses.size()]);
    }

    private static void printConstructors(Class<?> cl) {
        for (Constructor<?> c : cl.getConstructors()) {
            System.out.println("\t" + c);
        }
    }

    private static Object primitiveToWrapper(String type, String value) {
        switch (type) {
            case "boolean":
                return Boolean.parseBoolean(value);
            case "char":
                return value.charAt(0);
            case "byte":
                return Byte.parseByte(value);
            case "short":
                return Short.parseShort(value);
            case "int":
                return Integer.parseInt(value);
            case "double":
                return Double.parseDouble(value);
            case "float":
                return Float.parseFloat(value);
            case "long":
                return Long.parseLong(value);
            default:
                throw new IllegalArgumentException("Cannot instanciate classes with non-primitive parameters on the constructors!");
        }
    }
}
