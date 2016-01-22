package aula12.ex3;

public abstract class PluginManager {
    public static Formats load(String name) throws Exception {
        Class<?> c = Class.forName(name);
        return (Formats) c.newInstance(); }
}