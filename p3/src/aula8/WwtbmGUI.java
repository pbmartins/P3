package aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WwtbmGUI extends JFrame {
    private JPanel panel;
    private JLabel imageLabel;
    private JTextArea questionValueField;
    private JTextArea questionArea;
    private ButtonGroup answersGroup;
    private JRadioButton[] answersBtn;
    private JButton btnNext;
    private JButton btnGiveUp;
    private JButton btnHalfHelp;
    private JButton btnCallHelp;
    private JButton btnViewersHelp;
    private Question question;
    private WhoWantsToBeMillionaire game;

    public WwtbmGUI() {
        super("Quem Quer Ser Milionário");
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(650, 550);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        panel = new JPanel(new FlowLayout());

        // Start game
        game = new WhoWantsToBeMillionaire();
        question = game.getQuestion();
        questionValueField = new JTextArea("Para " + question.getValue() + "€");
        panel.add(questionValueField);

        btnHalfHelp = new JButton("50/50");
        btnHalfHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fiftyFifty();
                btnHalfHelp.setEnabled(false);
            }
        });

        btnCallHelp = new JButton("Telefonar");
        btnCallHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                callHelp();
                btnCallHelp.setEnabled(false);
            }
        });

        btnViewersHelp = new JButton("Ajuda do público");
        btnViewersHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewersHelp();
                btnViewersHelp.setEnabled(false);
            }
        });

        panel.add(btnHalfHelp);
        panel.add(btnCallHelp);
        panel.add(btnViewersHelp);

        ImageIcon image = new ImageIcon("gp8_files/QQSM/" + question.getImage().toString());
        imageLabel = new JLabel(image);
        panel.add(imageLabel);

        questionArea = new JTextArea(question.getQuestion(), 3, 45);
        questionArea.setFont(new Font("Arial", Font.PLAIN, 17));
        panel.add(questionArea);

        answersGroup = new ButtonGroup();
        answersBtn = new JRadioButton[4];
        for (int j = 0; j < 4; j++) {
            answersBtn[j] = new JRadioButton(question.getAnswers()[j]);
            answersBtn[j].setActionCommand(question.getAnswers()[j]);
            answersGroup.add(answersBtn[j]);
            panel.add(answersBtn[j]);

        }

        btnGiveUp = new JButton("Desistir");
        btnGiveUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (game.getQuestionNumber() > 0)
                    JOptionPane.showMessageDialog(null, "Desistiu: ganhou " + game.getPrize() + "euros.");
                else
                    JOptionPane.showMessageDialog(null, "Desistiu: não ganhou nada.");
                System.exit(0);
            }
        });

        btnNext = new JButton("Confirmar");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String answered = answersGroup.getSelection().getActionCommand();
                if (game.checkAnswer(answered)) {
                    if (game.getQuestionNumber() >= 14) {
                        JOptionPane.showMessageDialog(null, "Parabéns! Venceu o Quem Quer Ser Milionário!\nGanhou " + game.getPrize() * 2 + " euros!");
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Acertou!");
                    updateElements();
                } else {
                    if (game.getQuestionNumber() > 0)
                        JOptionPane.showMessageDialog(null, "Resposta errada: ganhou " + game.getPrize() + " euros.");
                    else
                        JOptionPane.showMessageDialog(null, "Resposta errada: não ganhou nada.");
                    System.exit(0);
                }
            }
        });

        panel.add(btnGiveUp);
        panel.add(btnNext);
        super.setContentPane(panel);
        super.setVisible(true);
    }


    private void updateElements() {
        question = game.getQuestion();
        questionValueField.setText("Para " + question.getValue() + "€");

        ImageIcon image = new ImageIcon("gp8_files/QQSM/" + question.getImage().toString());
        imageLabel = new JLabel(image);

        questionArea.setText(question.getQuestion());

        for (int j = 0; j < 4; j++) {
            answersBtn[j].setText(question.getAnswers()[j]);
            answersBtn[j].setActionCommand(question.getAnswers()[j]);
            answersBtn[j].setVisible(true);
        }
    }

    private void fiftyFifty() {
        int[] n = game.useFiftyFifty();
        Enumeration<AbstractButton> en = answersGroup.getElements();
        int j = 0;
        AbstractButton btn = null;
        while (en.hasMoreElements()) {
            btn = en.nextElement();
            if (j == n[0] || j == n[1])
                btn.setVisible(true);
            else
                btn.setVisible(false);
            j++;
        }
    }

    private void callHelp() {
        int[][] info = game.useCallHelp();
        String text = "";
        for (int j = 0; j < info.length; j++)
            text += String.format("%-20s\t\t%-2d\n", question.getAnswers()[info[j][0]], info[j][1]);

        JOptionPane.showMessageDialog(null, text);
    }

    private void viewersHelp() {
        int[] info = game.useViewersHelp();
        String text = "";
        for (int j = 0; j < info.length; j++)
            text += String.format("%-20s\t\t%-2d\n", question.getAnswers()[j], info[j]);

        JOptionPane.showMessageDialog(null, text);
    }
}
