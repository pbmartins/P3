package aula8.ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoughtsNCrosses extends JFrame {
    private JPanel panel;
    private Player currentPlayer;
    private JToggleButton[][] btns;
    private int numPlays = 0;
    private ActionListener al = new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
            if (!(e.getSource() instanceof JToggleButton))
                throw new IllegalArgumentException("Só são admitidos JToggleButtons.");

            ((JToggleButton)e.getSource()).setText(currentPlayer.toString());
            ((JToggleButton)e.getSource()).setFont(new Font("Arial", Font.PLAIN, 40));
            ((JToggleButton)e.getSource()).setEnabled(false);
            if (checkWinner(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Venceu o jogador " + currentPlayer);
                System.exit(0);
            } else if (++numPlays == 9) {
                JOptionPane.showMessageDialog(null, "O jogo terminou empatado!");
                System.exit(0);
            }

            if (currentPlayer == Player.X)
                currentPlayer = Player.O;
            else
                currentPlayer = Player.X;
        }
    };

    private boolean checkWinner(Player p) {
        for (int i = 0; i < btns.length; i++) {
            int j;
            for (j = 0; j < btns[0].length; j++) {
                if (!btns[i][j].getText().equals(p.toString()))
                    break;
            }
            if (j == 3)
                return true;
        }

        for (int i = 0; i < btns.length; i++) {
            int j;
            for (j = 0; j < btns[0].length; j++) {
                if (!btns[j][i].getText().equals(p.toString()))
                    break;
            }
            if (j == 3)
                return true;
        }

        int i, j;
        for (j = 0, i = 0; i < btns.length; i++, j++)
            if (!btns[i][j].getText().equals(p.toString()))
                break;

        if (i == 3)
            return true;

        for (j = 2, i = 0; i < btns.length; i++, j--)
            if (!btns[i][j].getText().equals(p.toString()))
                break;

        if (i == 3)
            return true;

        return false;
    }

    public NoughtsNCrosses(Player p) {
        this();
        if (p == null)
            throw new IllegalArgumentException("Jogador inválido.");
        currentPlayer = p;
    }

    public NoughtsNCrosses() {
        super("Jogo do Galo");
        currentPlayer = Player.X;
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(250, 250);
        super.setLocationRelativeTo(null);
        panel = new JPanel(new GridLayout(3, 3));
        btns = new JToggleButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JToggleButton btn = new JToggleButton();
                btn.addActionListener(al);
                btns[i][j] = btn;
                panel.add(btn);
            }
        }
        super.setContentPane(panel);
        super.setVisible(true);
    }

}
