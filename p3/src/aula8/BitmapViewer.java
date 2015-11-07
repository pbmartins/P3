package aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;
import java.io.*;

public class BitmapViewer extends JFrame {
    private JPanel panel;
    private PanelImage imagePanel;
    private JMenuBar menuBar;
    private JMenuItem openFile;
    private JMenuItem flipHorizontly;
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

        // Menu
        menuBar = new JMenuBar();
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Bitmap file", "bmp"));

        image = new Bitmap("/Users/pedromartins/Documents/UA/Ano_2/P3/p3/gp7_files/Figura.bmp");
        image.saveToAFourth("/Users/pedromartins/Documents/UA/Ano_2/P3/p3/gp8_files/Figura.bmp");
        imagePanel = new PanelImage(image.getRGB(), Math.abs(image.getBitmapInfoHeader().getWidth()),
                Math.abs(image.getBitmapInfoHeader().getHeight()), image.getBitmapInfoHeader().getBitCount() <= 16);
        super.setContentPane(imagePanel);



        openFile = new JMenuItem("Abrir ficheiro");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    image = new Bitmap(selectedFile.getAbsolutePath());
                    imagePanel = new PanelImage(image.getRGBQuad(), Math.abs(image.getBitmapInfoHeader().getWidth()),
                            Math.abs(image.getBitmapInfoHeader().getHeight()), image.getBitmapInfoHeader().getBitCount() <= 16);
                    setContentPane(imagePanel);
                }
            }
        });

        menuBar.add(openFile);

        super.setJMenuBar(menuBar);
        super.setVisible(true);
    }
}
