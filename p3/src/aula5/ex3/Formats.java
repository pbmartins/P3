package aula5.ex3;

public interface Formats {
    Contact[] readFile(String path);
    void saveFile(String path, Contact[] list);
}
