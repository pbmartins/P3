package aula5;

public interface Formats {
    Contact[] readFile(String path);
    void saveFile(String path, Contact[] list);
}
