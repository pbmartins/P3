package aula08.ex3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;
import java.io.*;

public class BitmapViewer extends JFrame {
    private JPanel panel;
    private PanelImage imagePanel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu transformMenu;
    private JMenuItem openFile;
    private JMenuItem saveFile;
    private JMenuItem closeFile;
    private JMenuItem flipHorizontaly;
    private JMenuItem flipVerticaly;
    private JMenuItem resize;
    private JFileChooser fileChooser;
    private Bitmap image;

    public BitmapViewer() {
        super("Editor de Bitmap");
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(700, 700);
        super.setLocationRelativeTo(null);
        super.setResizable(false);

        panel = new JPanel();

        // Menu
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Ficheiro");
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Bitmap file", "bmp"));

        openFile = new JMenuItem("Abrir ficheiro");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Abrir ficheiro");
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    showOpenedImage(selectedFile.getAbsolutePath());
                }
            }
        });

        saveFile = new JMenuItem("Salvar como...");
        saveFile.setEnabled(false);
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Guardar ficheiro");
                int returnValue = fileChooser.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    saveSelectedFile(selectedFile.getAbsolutePath());
                }
            }
        });

        closeFile = new JMenuItem("Fechar ficheiro");
        closeFile.setEnabled(false);
        closeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeOpenedFile();
            }
        });

        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(closeFile);
        menuBar.add(fileMenu);

        transformMenu = new JMenu("Transformar");
        flipHorizontaly = new JMenuItem("Espelhar horizontalmente");
        flipHorizontaly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipImage(0);
            }
        });

        flipVerticaly = new JMenuItem("Espelhar verticalmente");
        flipVerticaly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipImage(1);
            }
        });

        resize = new JMenuItem("Reduzir para 1/4 do tamanho");
        resize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resizeImage();
            }
        });

        transformMenu.add(flipHorizontaly);
        transformMenu.add(flipVerticaly);
        transformMenu.add(resize);
        transformMenu.setEnabled(false);
        menuBar.add(transformMenu);

        super.setJMenuBar(menuBar);
        super.setContentPane(panel);
        super.setVisible(true);
    }

    private void showOpenedImage(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");

        image = new Bitmap(path);
        imagePanel = new PanelImage(image.getData(), Math.abs(image.getBitmapInfoHeader().getWidth()),
                Math.abs(image.getBitmapInfoHeader().getHeight()), image.getBitmapInfoHeader().getBitCount() == 32);
        panel.add(imagePanel);
        panel.revalidate();
        saveFile.setEnabled(true);
        closeFile.setEnabled(true);
        transformMenu.setEnabled(true);
    }

    private void saveSelectedFile(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");

        image.save(path);
    }

    private void closeOpenedFile() {
        if (panel.getComponentCount() == 0)
            throw new AssertionError("Não está aberta nenhuma imagem");

        panel.remove(imagePanel);
        panel.revalidate();
        saveFile.setEnabled(false);
        closeFile.setEnabled(false);
        transformMenu.setEnabled(false);
    }

    private void flipImage(int type) {
        panel.remove(imagePanel);
        panel.revalidate();
        image = image.transformFlipped(type);
        imagePanel = new PanelImage(image.getData(), Math.abs(image.getBitmapInfoHeader().getWidth()),
                Math.abs(image.getBitmapInfoHeader().getHeight()), image.getBitmapInfoHeader().getBitCount() == 32);
        panel.add(imagePanel);
        panel.revalidate();
    }

    private void resizeImage() {
        panel.remove(imagePanel);
        panel.revalidate();
        image = image.transformToAFourth();
        imagePanel = new PanelImage(image.getData(), Math.abs(image.getBitmapInfoHeader().getWidth()),
                Math.abs(image.getBitmapInfoHeader().getHeight()), image.getBitmapInfoHeader().getBitCount() == 32);
        panel.add(imagePanel);
        panel.revalidate();
    }
}
